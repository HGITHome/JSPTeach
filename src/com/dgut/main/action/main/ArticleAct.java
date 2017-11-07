package com.dgut.main.action.main;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.dgut.common.page.SimplePage.cpn;

import net.sf.json.JSONArray;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dgut.common.page.Pagination;
import com.dgut.common.web.CookieUtils;
import com.dgut.common.web.ResponseUtils;
import com.dgut.main.entity.Article;
import com.dgut.main.entity.Chapter;
import com.dgut.main.entity.Section;
import com.dgut.main.manager.ArticleMng;
import com.dgut.main.manager.ChapterMng;
import com.dgut.main.manager.SectionMng;
import com.dgut.main.web.WebErrors;


@Controller
@RequestMapping("article")
public class ArticleAct {
	
	private final static Logger log = LoggerFactory.getLogger(ArticleAct.class);
	
	@RequestMapping("v_list.do")
	public String getPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,
			String queryChapterName,String querySectionName,String queryLabel,String queryTitle,Integer pageNo){
		Pagination pagination = articleMng.getPage(queryChapterName, querySectionName, queryLabel, queryTitle, cpn(pageNo), CookieUtils.getPageSize(request));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("queryChapterName", queryChapterName);
		model.addAttribute("querySectionName", querySectionName);
		model.addAttribute("queryLabel", queryLabel);
		model.addAttribute("queryTitle", queryTitle);
		model.addAttribute("pagination", pagination);
		return "article/list";
	}
	
	@RequestMapping("v_add.do")
	public String articleAdd(HttpServletRequest request,HttpServletResponse response,Model model){
		List<Chapter> chapterList = chapterMng.getList();
		List<Section> sectionList = sectionMng.getList();
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("sectionList", sectionList);
		return "article/add";
	}
	@RequestMapping("/v_ajaxSections.do")
	public void ajaxSection(HttpServletRequest request,HttpServletResponse response,ModelMap model,String id) throws Exception{
		List<Section> sectionList = null;
		if(!StringUtils.isBlank(id)){
			sectionList = new ArrayList<Section>(chapterMng.findById(Integer.parseInt(id)).getSectionSet());
		}else{
			sectionList = sectionMng.getList();
		}
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"chapter"}); 
		ResponseUtils.renderText(response, JSONArray.fromObject(sectionList,config).toString());
	}
	@RequestMapping("o_save.do")
	public String articleSave(HttpServletRequest request,HttpServletResponse response,ModelMap model,String queryTitle,String queryLabel){
		String sectionId = request.getParameter("section");
		String content = request.getParameter("content");
		articleMng.save(sectionId,queryTitle,queryLabel,content,request);
		return "redirect:v_list.do";
	}
	
	@RequestMapping("o_delete.do")
	public String articleDelete(HttpServletRequest request,HttpServletResponse response,ModelMap model,String articleId){
		WebErrors errors = validateId(articleId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Article article = articleMng.deleteFile(Integer.parseInt(articleId));
		if(article == null){
			errors.addErrorString("删除失败");
			return errors.showErrorPage(model);
		}
		log.info("cms.article.delete");
		return "redirect:v_list.do";
	}
	
	@RequestMapping("o_info.do")
	public String articleInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,String articleId){
		WebErrors errors = validateId(articleId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Article article = articleMng.findById(Integer.parseInt(articleId));
		String content = articleMng.getContent(article.getFileUrl());
		model.addAttribute("article", article);
		model.addAttribute("content", content);
		return "article/info";
	}
	
	@RequestMapping("v_edit.do")
	public String articleEdit(HttpServletRequest request,HttpServletResponse response,ModelMap model,String articleId){
		WebErrors errors = validateId(articleId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		Article article = articleMng.findById(Integer.parseInt(articleId));
		String content = articleMng.getContent(article.getFileUrl());
		List<Chapter> chapterList = chapterMng.getList();
		List<Section> sectionList = sectionMng.getList();
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("sectionList", sectionList);
		model.addAttribute("article", article);
		model.addAttribute("content", content);
		return "article/edit";
	}
	
	@RequestMapping("o_update.do")
	public String articleUpdate(HttpServletRequest request,HttpServletResponse response,ModelMap model,Article article){
		String chapterId = request.getParameter("chapter");
		String sectionId = request.getParameter("sectionList");
		WebErrors errors = validate(chapterId,sectionId,request);
		if(errors.hasErrors()){
			return errors.showErrorPage(model);
		}
		String content = request.getParameter("content");
		String fileUrl = request.getParameter("fileUrl");
		try{
		   articleMng.update(sectionId,article,content,fileUrl);
		}catch(Exception e){
			errors.addErrorString("更新失败");
			return errors.showErrorPage(model);
		}
		 return "redirect:v_list.do";
		
	}
	
	private WebErrors validate(String chapterId, String sectionId,
			HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(chapterId)||StringUtils.isBlank(chapterId)){
			errors.addErrorString("参数不完整");
			return errors;
		}
		return errors;
	}

	private WebErrors validateId(String articleId, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		if(StringUtils.isBlank(articleId)){
			errors.addErrorCode("error.required", "文章id");
			return errors;
		}
		return errors;
	}

	@Autowired
	private ArticleMng articleMng;
	
	@Autowired
	private ChapterMng chapterMng;
	
	@Autowired
	private SectionMng sectionMng;
}
