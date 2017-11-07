package com.dgut.main.dao;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Article;

public interface ArticleDao {
	
	public Pagination getPage(String queryChapterName,String querySectionName , String queryLabel,String title,Integer pageNo,Integer pageSize);
	
	public Article findById(Integer id);
	
	public Article save(Article bean);
	
	public Article updateByUpdater(Updater<Article> updater);
	
	public Article deleteById(Integer id);
}
