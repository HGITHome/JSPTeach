package com.dgut.main.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.dao.SectionDao;
import com.dgut.main.entity.Section;
import com.dgut.main.manager.SectionMng;

@Service
@Transactional
public class SectionMngImpl implements SectionMng {

	@Transactional(readOnly=true)
	public Pagination getPage(String querySectionName, Integer pageNo,
			Integer pageSize,Integer chapterId) {
		
		return dao.getPage(querySectionName, pageNo, pageSize,chapterId);
	}
	@Transactional(readOnly=true)
	public List<Section> getList(){
		return dao.getList();
	}
	
	@Transactional(readOnly=true)
	public Section findById(Integer id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly=true)
	public Section findBySectionName(String sectionName) {
		
		return dao.findBySectionName(sectionName);
	}

	
	public Section save(Section bean) {
		
		return dao.save(bean);
	}


	public Section update(Section bean) {
	  Updater<Section> updater = new Updater<Section>(bean);
		return dao.updateByUpdater(updater);
	}

	
	public Section deleteById(Integer id) {
		
		return dao.deleteById(id);
	}

	@Autowired
	private SectionDao dao;
}
