package com.dgut.main.manager.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.common.util.FileUtils;
import com.dgut.main.Constants;
import com.dgut.main.dao.ArticleDao;
import com.dgut.main.entity.Admin;
import com.dgut.main.entity.Article;
import com.dgut.main.manager.ArticleMng;
import com.dgut.main.manager.ChapterMng;
import com.dgut.main.manager.SectionMng;
import com.dgut.main.web.CmsUtils;

@Service
@Transactional
public class ArticleMngImpl implements ArticleMng {

	@Transactional(readOnly=true)
	public Pagination getPage(String queryChapterName, String querySectionName,
			String queryLabel, String title, Integer pageNo, Integer pageSize) {
		
		return dao.getPage(queryChapterName, querySectionName, queryLabel, title, pageNo, pageSize);
	}

	@Transactional(readOnly=true)
	public Article findById(Integer id) {
		
		return dao.findById(id);
	}

	public String getContent(String fileUrl){
		return FileUtils.readFile(fileUrl);
	}
	
	public void save(String sectionId, String queryTitle, String queryLabel,
			String content,HttpServletRequest request){
		Admin admin = CmsUtils.getAdmin(request);
		Article bean = new Article();
		bean.setTitle(queryTitle);
		bean.setFileUrl(FileUtils.saveFile(Constants.Article_FILEPATH, content));
		bean.setLabel(queryLabel);
		bean.setSection(sectionMng.findById(Integer.parseInt(sectionId)));
		bean.setRegister_time(new Date());
		bean.setLastUpdate_time(new Date());
		bean.setAdmin(admin);
		save(bean);
	}
	
	
	public Article save(Article bean) {
		
		return dao.save(bean);
	}

	
	public Article update( String sectionId, Article article,String content,String fileUrl) throws RuntimeException{
		article.setSection(sectionMng.findById(Integer.parseInt(sectionId)));
		article.setLastUpdate_time(new Date());
		try {
			if(FileUtils.writeFileContent(fileUrl, content)){
				update(article);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		return article;
	}
	
	public Article update(Article bean) {
		Updater<Article> updater = new Updater<Article>(bean);
		return dao.updateByUpdater(updater);
	}

	public Article deleteFile(Integer id){
		Article bean = findById(id);
		 if(FileUtils.delFile(bean.getFileUrl())){
			return deleteById(id);
		 }
		 return null;
	}
	
	public Article deleteById(Integer id) {
		return dao.deleteById(id);
	}
	
	@Autowired
	private ArticleDao dao;
	
	@Autowired
	private SectionMng sectionMng;
	


}
