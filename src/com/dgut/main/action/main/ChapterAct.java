package com.dgut.main.action.main;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.dgut.common.page.SimplePage.cpn;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgut.common.page.Pagination;
import com.dgut.common.web.CookieUtils;
import com.dgut.common.web.ResponseUtils;
import com.dgut.main.entity.Chapter;
import com.dgut.main.manager.AdminLogMng;
import com.dgut.main.manager.ChapterMng;
import com.dgut.main.web.WebErrors;


@Controller
@RequestMapping("chapter")
public class ChapterAct {
	
	private static final Logger log = LoggerFactory.getLogger(ChapterAct.class);
	
	@RequestMapping("v_list.do")
	public String getPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,Integer pageNo,String queryChapterName){
		Pagination pagination = chapterMng.getPage(queryChapterName, cpn(pageNo), CookieUtils.getPageSize(request));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("queryChapterName", queryChapterName);
		model.addAttribute("pagination", pagination);
		return "chapter/list";
	}
	
	@RequestMapping("o_info.do")
	public String chapterInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id){
		WebErrors errors = validateId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Chapter chapter = chapterMng.findById(Integer.parseInt(id));
		model.addAttribute("chapter", chapter);
		return "chapter/info";
	}
	
	@RequestMapping("v_add.do")
	public String chapterAdd(HttpServletRequest request,HttpServletResponse reponse,ModelMap model){
		return "chapter/add";
	}
	
	@RequestMapping("/v_checkChapterName.do")
	public void checkChapterName(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String chapterName = request.getParameter("chapterName");
		Chapter chapter = chapterMng.findByChapterName(chapterName);
		boolean pass = chapter == null;
		ResponseUtils.renderText(response, pass?"true":"false");
	}
	
	@RequestMapping("o_save.do")
	public String chapterSave(HttpServletRequest request,HttpServletResponse response,ModelMap model,Chapter chapter){
		chapter.setRegister_time(new Date());
		chapter.setLastUpdate_time(new Date());
		chapterMng.save(chapter);
		log.info("cms.chapter.save");
		adminLogMng.operating(request, "cms.chapter.save", "save.chapter.name="+chapter.getName());
		return "redirect:v_list.do";
	}
	
	@RequestMapping("v_edit.do")
	public String chapterEdit(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id){
		WebErrors errors = validateId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Chapter chapter = chapterMng.findById(Integer.parseInt(id));
		model.addAttribute("chapter", chapter);
		return "chapter/edit";
	}
	
	@RequestMapping("o_update.do")
	public String chapterUpdate(HttpServletRequest request,HttpServletResponse response,ModelMap model,Chapter chapter){
		chapter.setLastUpdate_time(new Date());
		chapterMng.update(chapter);
		adminLogMng.operating(request, "cms.chapter.update", "update.chapter.id="+chapter.getId());
		return "redirect:v_list.do";
	}
	
	@RequestMapping("o_delete.do")
	public String chapterDelete(HttpServletRequest request,HttpServletResponse response,ModelMap model , String id){
		WebErrors errors = validateId(id,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		chapterMng.deleteById(Integer.parseInt(id));
		adminLogMng.operating(request, "cms.chapter.delete", "delete.chapter.id="+id);
		return "redirect:v_list.do";
	}
	
	private WebErrors validateId(String id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(id)){
			errors.addErrorCode("error.required", "章id");
			return errors;
		}
		return errors;
	}


	@Autowired
	private ChapterMng chapterMng;
	
	@Autowired
	private AdminLogMng adminLogMng;
}
