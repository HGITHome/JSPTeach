package com.dgut.main.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dgut.common.hibernate3.Finder;
import com.dgut.common.hibernate3.HibernateBaseDao;

import com.dgut.common.page.Pagination;
import com.dgut.main.dao.ChapterDao;
import com.dgut.main.entity.Chapter;


@Repository
public class ChapterDaoImpl extends HibernateBaseDao<Chapter, Integer> implements
		ChapterDao {

	
	public Pagination getPage(String queryChapterName, Integer pageNo,
			Integer pageSize) {
		Finder f = Finder.create("select bean from Chapter bean where 1=1");
		if(!StringUtils.isBlank(queryChapterName)){
			f.append(" and bean.name like:chapterName");
			f.setParam("chapterName", queryChapterName);
		}
		f.append(" order by bean.id asc");
		return find(f,pageNo,pageSize);
	}

	 public List<Chapter> getList(){
		 String hql = "from Chapter bean order by bean.id asc";
		 return find(hql);
	 }
	
	public Chapter findById(Integer id) {
		Chapter bean = super.get(id);
		return bean;
	}

	
	public Chapter findByChapterName(String chapterName) {
		String hql="select bean from Chapter bean where bean.name like:chapterName";
		return (Chapter) findUnique(hql, chapterName);
	}

	
	public Chapter save(Chapter bean) {
		getSession().save(bean);
		return bean;
	}

	

	
	public Chapter deleteById(Integer id) {
		Chapter bean = super.get(id);
		if(bean != null){
			getSession().delete(bean);
		}
		return bean;
	}

	
	protected Class<Chapter> getEntityClass() {
		
		return Chapter.class;
	}

}
