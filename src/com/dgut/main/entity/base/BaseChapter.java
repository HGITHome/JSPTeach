package com.dgut.main.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.dgut.main.entity.Section;

public abstract class BaseChapter implements Serializable {

	/**
	 * 章类
	 */
	private static final long serialVersionUID = 1L;
	
	private int hascode = Integer.MIN_VALUE;
	
	private Integer id;
	
	private String name;
	
	private Integer priority;

	private Date register_time;
	
	private Date lastUpdate_time;
	
	private Set<Section> sectionSet;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	
	
	
	public Set<Section> getSectionSet() {
		return sectionSet;
	}

	public void setSectionSet(Set<Section> sectionSet) {
		this.sectionSet = sectionSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hascode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseChapter other = (BaseChapter) obj;
		if (hascode != other.hascode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
