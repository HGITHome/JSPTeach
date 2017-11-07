package com.dgut.main.dao;

import java.util.List;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Section;

public interface SectionDao {
	
	public Pagination getPage(String querySectionName,Integer pageNo,Integer pageSize,Integer chapterId);
	
	public Section findById(Integer id);
	
	public Section findBySectionName(String sectionName);
	
	public Section save(Section bean);
	
	public Section updateByUpdater(Updater<Section> updater);
	
	public Section deleteById(Integer id);

	public List<Section> getList();
}
