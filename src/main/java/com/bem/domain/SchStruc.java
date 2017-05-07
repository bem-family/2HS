package com.bem.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SchStruc")
public class SchStruc {
	@Id
	private String id;			//UUID
	private String stu_depart;	//系部
	private String stu_major;	//专业
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStu_depart() {
		return stu_depart;
	}
	public void setStu_depart(String stu_depart) {
		this.stu_depart = stu_depart;
	}
	public String getStu_major() {
		return stu_major;
	}
	public void setStu_major(String stu_major) {
		this.stu_major = stu_major;
	}
	
	
	
}
