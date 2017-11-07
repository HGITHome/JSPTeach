package com.dgut.main.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.dao.ChapterDao;
import com.dgut.main.entity.Chapter;
import com.dgut.main.manager.ChapterMng;

@Service
@Transactional
public class ChapterMngImpl implements ChapterMng {

	@Transactional(readOnly=true)
	public Pagination getPage(String queryChapterName, Integer pageNo,
			Integer pageSize) {
		
		return dao.getPage(queryChapterName, pageNo, pageSize);
	}
	@Transactional(readOnly=true)
	 public List<Chapter> getList(){
	    return dao.getList();	 
	 }
	
	@Transactional(readOnly=true)
	public Chapter findById(Integer id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly=true)
	public Chapter findByChapterName(String chapterName) {
		
		return dao.findByChapterName(chapterName);
	}

	
	public Chapter save(Chapter bean) {
		
		return dao.save(bean);
	}

	
	public Chapter update(Chapter bean) {
		Updater<Chapter> updater = new Updater<Chapter>(bean);
		return dao.updateByUpdater(updater);
	}

	
	public Chapter deleteById(Integer id) {
		
		return dao.deleteById(id);
	}
	
	@Autowired
	private ChapterDao dao;

}
