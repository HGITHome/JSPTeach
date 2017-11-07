package com.dgut.main.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.dgut.main.entity.Admin;

public abstract class BaseNotice implements Serializable {

	/**
	 * 公告类
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String title;
	
	private String filePath;
	
	private Date register_time;
	
	private Date lastUpdate_time;
	
	private Admin admin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getRegister_time() {
		return register_time;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public Date getLastUpdate_time() {
		return lastUpdate_time;
	}

	public void setLastUpdate_time(Date lastUpdate_time) {
		this.lastUpdate_time = lastUpdate_time;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseNotice))
			return false;
		BaseNotice other = (BaseNotice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
