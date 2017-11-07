package com.dgut.main.action.main;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.dgut.common.page.SimplePage.cpn;
import com.dgut.common.page.Pagination;
import com.dgut.common.web.CookieUtils;
import com.dgut.common.web.ResponseUtils;
import com.dgut.main.entity.Chapter;
import com.dgut.main.entity.Section;
import com.dgut.main.manager.AdminLogMng;
import com.dgut.main.manager.ChapterMng;
import com.dgut.main.manager.SectionMng;
import com.dgut.main.web.WebErrors;

@Controller
@RequestMapping("chapter/section")
public class SectionAct {
    
	private static final Logger log = LoggerFactory.getLogger(SectionAct.class);
	
	@RequestMapping("v_list.do")
	public String getPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,Integer pageNo,String querySectionName,String chapterId){
		WebErrors errors = validateId(chapterId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Pagination pagination = sectionMng.getPage(querySectionName, cpn(pageNo), CookieUtils.getPageSize(request),Integer.parseInt(chapterId));
		model.addAttribute("chapterId", chapterId);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("querySectionName", querySectionName);
		model.addAttribute("pagination", pagination);
		return "section/list";
	}
	
	@RequestMapping("v_add.do")
	public String sectionAdd(HttpServletRequest request,HttpServletResponse response,ModelMap model,String chapterId){
		WebErrors errors = validateId(chapterId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		model.addAttribute("chapterId", chapterId);
		return "section/add";
	}
	
	@RequestMapping("/v_checkSectionName.do")
	public void checkSectionName(HttpServletRequest request,HttpServletResponse response){
		String sectionName = request.getParameter("sectionName");
		Section section = sectionMng.findBySectionName(sectionName);
		boolean pass = section == null;
		ResponseUtils.renderText(response, pass? "true" : "false");
	}
	
	@RequestMapping("o_save.do")
	public String sectionSave(HttpServletRequest request,HttpServletResponse reponse,ModelMap model,Section section){
		String chapterId = request.getParameter("chapterId");
		WebErrors errors = validateId(chapterId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Chapter chapter = chapterMng.findById(Integer.parseInt(chapterId));
		section.setChapter(chapter);
		section.setRegister_time(new Date());
		section.setLastUpdate_time(new Date());
		sectionMng.save(section);
		log.info("cms.section.save");
		adminLogMng.operating(request, "cms.section.save", "save.section.name=" +section.getName());
		return "redirect:v_list.do?chapterId="+chapterId;
	}
	
	@RequestMapping("v_edit.do")
	public String sectionEdit(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id){
		WebErrors errors = validateSectionId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
	    Section section = sectionMng.findById(Integer.parseInt(id));
	    model.addAttribute("section", section);
	    return "section/edit";
	}
	
	@RequestMapping("o_update.do")
	public String sectionUpdate(HttpServletRequest request,HttpServletResponse response,ModelMap model, Section section){
		String chapterId = request.getParameter("chapterId");
		WebErrors errors = validateId(chapterId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Chapter chapter  = chapterMng.findById(Integer.parseInt(chapterId));
		section.setChapter(chapter);
		section.setLastUpdate_time(new Date());
		sectionMng.update(section);
		adminLogMng.operating(request, "cms.section.update", "update.section.id="+section.getId());
		return "redirect:v_list.do?chapterId="+chapterId;
	}
	
	@RequestMapping("o_delete.do")
	public String sectionDelete(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id,String chapterId){
		WebErrors errors = validateSectionId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		errors = validateId(chapterId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		sectionMng.deleteById(Integer.parseInt(id));
		log.info("cms.section.delete");
		adminLogMng.operating(request, "cms.section.delete", "delete.section.id="+id);
		return "redirect:v_list.do?chapterId="+chapterId;
	}
	
	@RequestMapping("o_info.do")
	public String sectionInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id){
		WebErrors errors = validateSectionId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Section section = sectionMng.findById(Integer.parseInt(id));
		model.addAttribute("section", section);
		return "section/info";
	}
	
	private WebErrors validateSectionId(String id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(id)){
			errors.addErrorCode("error.required", "节id");
			return errors;
		}
		return errors;
	}

	private WebErrors validateId(String chapterId, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(chapterId)){
			errors.addErrorCode("error.required", "章id");
			return errors;
		}
		return errors;
	}

	@Autowired
	private SectionMng sectionMng;
	
	@Autowired
	private ChapterMng chapterMng;
	
	@Autowired
	private AdminLogMng adminLogMng;
}
