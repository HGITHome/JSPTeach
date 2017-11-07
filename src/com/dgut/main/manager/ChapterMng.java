package com.dgut.main.manager;


import java.util.List;

import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Chapter;

public interface ChapterMng {

    public Pagination getPage(String queryChapterName,Integer pageNo,Integer pageSize);
    
	
    public List<Chapter> getList();
   
	public Chapter findById(Integer id);
	
	public Chapter findByChapterName(String chapterName);
	
	public Chapter save(Chapter bean);
	
	public Chapter update(Chapter bean);
	
	public Chapter deleteById(Integer id);
}
