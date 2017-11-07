package com.dgut.main.dao;

import java.util.List;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Chapter;

public interface ChapterDao {
	
	public Pagination getPage(String queryChapterName,Integer pageNo,Integer pageSize);
	
	 public List<Chapter> getList();
	
	public Chapter findById(Integer id);
	
	public Chapter findByChapterName(String chapterName);
	
	public Chapter save(Chapter bean);
	
	public Chapter updateByUpdater(Updater<Chapter> updater);
	
	public Chapter deleteById(Integer id);
}
