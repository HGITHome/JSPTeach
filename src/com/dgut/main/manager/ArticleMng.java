package com.dgut.main.manager;


import javax.servlet.http.HttpServletRequest;

import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Article;

public interface ArticleMng {

public Pagination getPage(String queryChapterName,String querySectionName , String queryLabel,String title,Integer pageNo,Integer pageSize);
	
	public Article findById(Integer id);
	
	public Article save(Article bean);
	
	public Article update(Article bean);
	
	public Article deleteById(Integer id);

	public void save(String sectionId, String queryTitle, String queryLabel,
			String content,HttpServletRequest request);

	public Article deleteFile(Integer id);

	public String getContent(String fileUrl);

	public Article update( String sectionId, Article article,String content,String fileUrl) throws RuntimeException;
}
