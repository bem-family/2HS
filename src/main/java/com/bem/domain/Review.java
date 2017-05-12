package com.bem.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	private String id;
	private String top_id;	//主题id
	private String comment_id;	//评论人id
	private String parent_id;	//回复父类id
	private String content;	//回复内容
	private long c_time;	//创建时间
	
	
	public Review(){
		this.id =  UUID.randomUUID().toString().replace("-", "");
		this.c_time = new Date().getTime();
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

	public long getC_time() {
		return c_time;
	}

	public void setC_time(long c_time) {
		this.c_time = c_time;
	}
	
	
	
	
	
}
