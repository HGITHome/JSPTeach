package com.dgut.main.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dgut.common.hibernate3.Finder;
import com.dgut.common.hibernate3.HibernateBaseDao;

import com.dgut.common.page.Pagination;
import com.dgut.main.dao.ArticleDao;
import com.dgut.main.entity.Article;

@Repository
public class ArticleDaoImpl extends HibernateBaseDao<Article, Integer> implements
		ArticleDao {

	
	public Pagination getPage(String queryChapterName, String querySectionName,
			String queryLabel, String title, Integer pageNo, Integer pageSize) {
		Finder f = Finder.create("select bean from Article bean where 1=1");
		if(!StringUtils.isBlank(queryChapterName)){
			f.append(" and bean.section.chapter.name like:chapterName");
			f.setParam("chapterName", queryChapterName);
		}
		if(!StringUtils.isBlank(querySectionName)){
			f.append(" and bean.section.name like :sectionName");
			f.setParam("sectionName", querySectionName);
		}
		if(!StringUtils.isBlank(queryLabel)){
			f.append(" and bean.label like :label");
			f.setParam("label", queryLabel);
		}
		if(!StringUtils.isBlank(title)){
			f.append(" and bean.title like :title");
			f.setParam("title", title);
		}
		f.append(" order by bean.id asc");
		return find(f,pageNo,pageSize);
	}

	
	public Article findById(Integer id) {
		Article bean = super.get(id);
		return bean;
	}

	
	public Article save(Article bean) {
		getSession().save(bean);
		return bean;
	}


	
	public Article deleteById(Integer id) {
		Article bean = super.get(id);
		if(bean != null){
			getSession().delete(bean);
		}
		return bean;
	}

	
	protected Class<Article> getEntityClass() {
		
		return Article.class;
	}

}
