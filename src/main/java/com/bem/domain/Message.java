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
	private String formUserID;
	private String toUserID;
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
	public String getFormUserID() {
		return formUserID;
	}
	public void setFormUserID(String formUserID) {
		this.formUserID = formUserID;
	}
	public String getToUserID() {
		return toUserID;
	}
	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
