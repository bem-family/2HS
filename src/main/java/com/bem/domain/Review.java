package com.bem.domain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.bem.utils.Time;
import com.fasterxml.jackson.core.format.DataFormatMatcher;

@Entity
public class Review {

	@Id
	private String id;
	private String top_id;	//主题id
	private String user_name; //用户昵称
	private String user_head; //用户头像
	private String comment_id;	//评论人id
	private String parent_id;	//回复父类id
	private String content;	//回复内容
	private Timestamp c_time;	//创建时间
	
	
	public Review(){
		this.id =  UUID.randomUUID().toString().replace("-", "");
		this.c_time = (new Time()).timestamp();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getTop_id() {
		return top_id;
	}

	public void setTop_id(String top_id) {
		this.top_id = top_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_head() {
		return user_head;
	}

	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}

	public String getC_time() {
		return c_time.toString();
	}

	public void setC_time(Timestamp c_time) {
		this.c_time = c_time;
	}

	
	
	
	
	
	
}
