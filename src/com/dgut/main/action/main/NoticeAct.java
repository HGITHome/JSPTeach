package com.dgut.main.action.main;

import static com.dgut.common.page.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dgut.common.page.Pagination;
import com.dgut.common.util.FileUtils;
import com.dgut.common.web.CookieUtils;
import com.dgut.main.entity.Notice;
import com.dgut.main.manager.NoticeMng;
import com.dgut.main.web.WebErrors;


@Controller
@RequestMapping("notice")
public class NoticeAct {
	
	private static final Logger log = LoggerFactory.getLogger(NoticeAct.class);
	
	@RequestMapping("v_list.do")
	public String getPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,String queryTitle,Integer pageNo){
		Pagination pagination = noticeMng.getPage(queryTitle, cpn(pageNo), CookieUtils.getPageSize(request));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("queryTitle", queryTitle);
		model.addAttribute("pagination", pagination);
		return "notice/list";
	}
	
	@RequestMapping("v_add.do")
	public String noticeAdd(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "notice/add";
	}
	
	@RequestMapping("o_save.do")
	public String noticeSave(HttpServletRequest request,HttpServletResponse response,ModelMap model,String queryTitle){
		String content = request.getParameter("content");
		noticeMng.save(queryTitle,content,request);
		log.info("cms.notice.save");
		return "redirect:v_list.do";
	}
	
	@RequestMapping("o_info.do")
	public String noticeInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,String noticeId){
		WebErrors errors = validateId(noticeId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Notice notice  = noticeMng.findById(Integer.parseInt(noticeId));
		String content = FileUtils.readFile(notice.getFilePath());
		model.addAttribute("notice", notice);
		model.addAttribute("content", content);
		return "notice/info";
	}
	
	@RequestMapping("v_edit.do")
	public String noticeEdit(HttpServletRequest request,HttpServletResponse response,ModelMap model,String noticeId){
		WebErrors errors = validateId(noticeId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Notice notice  = noticeMng.findById(Integer.parseInt(noticeId));
		String content = FileUtils.readFile(notice.getFilePath());
		model.addAttribute("notice", notice);
		model.addAttribute("content", content);
		return "notice/edit";
	}
	
	@RequestMapping("o_update.do")
	public String noticeUpdate(HttpServletRequest request,HttpServletResponse response,ModelMap model,Notice notice){
		WebErrors errors = WebErrors.create(request);
		String content  = request.getParameter("content");
		try{
		   noticeMng.update(notice,content);
		}catch(Exception e){
			errors.addErrorString("更新失败!");
			return errors.showErrorPage(model);
		}
		log.info("cms.notice.update");
		return "redirect:v_list.do";
	}
	
	@RequestMapping("o_delete.do")
	public String noticeDelete(HttpServletRequest request,HttpServletResponse response,ModelMap model,String noticeId){
		WebErrors errors = validateId(noticeId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Notice notice = noticeMng.deleteNotice(noticeId);
		if(notice == null){
			errors.addErrorString("删除失败!");
		}
		return "redirect:v_list.do";
	}
	private WebErrors validateId(String noticeId, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(noticeId)){
			errors.addErrorCode("error.required", "公告id");
			return errors;
		}
		return errors;
	}

	@Autowired
	private NoticeMng noticeMng;
}
