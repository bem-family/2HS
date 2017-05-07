package com.bem.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User {
	@Id
	private String id;		//UUID
	private String name;
	private String email;
	private String phone;
	private String qq;
	private int stu_number;	//学号
	private int stu_major;	//专业
	private int stu_depart;	//系部
	private Date reg_time;	//注册时间
	private Date log_time;	//登陆时间
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<OAuth> list;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getStu_number() {
		return stu_number;
	}

	public void setStu_number(int stu_number) {
		this.stu_number = stu_number;
	}

	public int getStu_major() {
		return stu_major;
	}

	public void setStu_major(int stu_major) {
		this.stu_major = stu_major;
	}

	public int getStu_depart() {
		return stu_depart;
	}

	public void setStu_depart(int stu_depart) {
		this.stu_depart = stu_depart;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

	public Date getLog_time() {
		return log_time;
	}

	public void setLog_time(Date log_time) {
		this.log_time = log_time;
	}

	public List<OAuth> getList() {
		return list;
	}

	public void setList(List<OAuth> list) {
		this.list = list;
	}
	
	
}