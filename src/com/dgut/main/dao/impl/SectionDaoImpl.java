package com.dgut.main.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.dgut.common.hibernate3.Finder;
import com.dgut.common.hibernate3.HibernateBaseDao;
import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.dao.SectionDao;
import com.dgut.main.entity.Section;

@Repository
public class SectionDaoImpl extends HibernateBaseDao<Section, Integer> implements
		SectionDao {

	
	public Pagination getPage(String querySectionName, Integer pageNo,
			Integer pageSize,Integer chapterId) {
		Finder f = Finder.create("select bean from Section bean where 1=1");
		if(!StringUtils.isBlank(querySectionName)){
			f.append(" and bean.name like:sectionName");
			f.setParam("sectionName", querySectionName);
		}
		f.append(" and bean.chapter.id =:id");
		f.setParam("id", chapterId);
		f.append(" order by bean.id asc");
		return find(f,pageNo,pageSize);
	}

	public List<Section> getList(){
		String hql = "from Section bean order by bean.id asc";
		return find(hql);
	}
	
	public Section findById(Integer id) {
		Section bean = super.get(id);
		return bean;
	}

	
	public Section findBySectionName(String sectionName) {
		String hql = "select bean from Section bean where bean.name like :sectionName";
		return (Section) findUnique(hql, sectionName);
	}

	
	public Section save(Section bean) {
		getSession().save(bean);
		return bean;
	}



	
	public Section deleteById(Integer id) {
		Section bean  = super.get(id);
		if(bean != null){
			getSession().delete(bean);
		}
		return bean;
	}

	
	protected Class<Section> getEntityClass() {
		
		return Section.class;
	}

}
