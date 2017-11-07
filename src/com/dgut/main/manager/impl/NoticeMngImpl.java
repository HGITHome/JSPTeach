package com.dgut.main.manager.impl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.common.hibernate3.Updater;
import com.dgut.common.page.Pagination;
import com.dgut.common.util.FileUtils;
import com.dgut.main.Constants;
import com.dgut.main.dao.NoticeDao;
import com.dgut.main.entity.Admin;
import com.dgut.main.entity.Notice;
import com.dgut.main.manager.NoticeMng;
import com.dgut.main.web.CmsUtils;
@Service
@Transactional
public class NoticeMngImpl implements NoticeMng {

	@Transactional(readOnly=true)
	public Pagination getPage(String queryTitle, Integer pageNo,
			Integer pageSize) {
		
		return dao.getPage(queryTitle, pageNo, pageSize);
	}

	@Transactional(readOnly=true)
	public Notice findById(Integer id) {
		
		return dao.findById(id);
	}

	public Notice save(String queryTitle, String content,HttpServletRequest request){
		Admin admin = CmsUtils.getAdmin(request);
		Notice bean = new Notice();
		bean.setTitle(queryTitle);
		bean.setRegister_time(new Date());
		bean.setLastUpdate_time(new Date());
		bean.setAdmin(admin);
		bean.setFilePath(FileUtils.saveFile(Constants.NOTICE_FILEPATH, content));
		save(bean);
		return bean;
		
	}
	
	public Notice save(Notice bean) {
		
		return dao.save(bean);
	}

	
	public Notice update(Notice notice, String content) throws RuntimeException{
		notice.setLastUpdate_time(new Date());
		try {
			if(FileUtils.writeFileContent(notice.getFilePath(), content)){
				update(notice);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return notice;
	}
	
	
	public Notice update(Notice bean) {
		Updater<Notice> updater = new Updater<Notice>(bean);
		return dao.updateByUpdater(updater);
	}

	public Notice deleteNotice(String noticeId){
		Notice bean = findById(Integer.parseInt(noticeId));
		if(FileUtils.delFile(bean.getFilePath())){
			return deleteById(Integer.parseInt(noticeId));
		}
		return null;
	}
	
	public Notice deleteById(Integer id) {
		
		return dao.deleteById(id);
	}
	@Autowired
	private NoticeDao dao;

}
