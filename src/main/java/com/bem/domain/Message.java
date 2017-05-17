package com.bem.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {
	@Id
	private String id;
	private String status;	//接收状态
	private Date time;		//发送时间
	private User formUserID;
	private User toUserID;
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getFormUserID() {
		return formUserID;
	}
	public void setFormUserID(User formUserID) {
		this.formUserID = formUserID;
	}
	public User getToUserID() {
		return toUserID;
	}
	public void setToUserID(User toUserID) {
		this.toUserID = toUserID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
