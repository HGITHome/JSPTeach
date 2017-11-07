package com.dgut.main.manager;


import java.util.List;

import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Section;

public interface SectionMng {

	public Pagination getPage(String querySectionName,Integer pageNo,Integer pageSize,Integer chapterId);
	
	public List<Section> getList();
	
	public Section findById(Integer id);
	
	public Section findBySectionName(String sectionName);
	
	public Section save(Section bean);
	
	public Section update(Section bean);
	
	public Section deleteById(Integer id);
}
