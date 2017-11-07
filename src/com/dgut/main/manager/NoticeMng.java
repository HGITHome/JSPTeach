package com.dgut.main.manager;


import javax.servlet.http.HttpServletRequest;

import com.dgut.common.page.Pagination;
import com.dgut.main.entity.Notice;

public interface NoticeMng {

public Pagination getPage(String queryTitle,Integer pageNo,Integer pageSize);
	
	public Notice findById(Integer id);
	
	public Notice save(Notice bean);
	
	public Notice update(Notice bean);
	
	public Notice deleteById(Integer id);

	public Notice save(String queryTitle, String content, HttpServletRequest request);

	public Notice update(Notice notice, String content)throws RuntimeException;

	public Notice deleteNotice(String noticeId);
}
