package com.bem.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "OAuth")
public class OAuth {
	@Id
	private String id;		//UUID
	private String oauth_name;
	private String oauth_id;
	private String oauth_access_token;
	private String oauth_expires;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JsonBackReference
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOauth_name() {
		return oauth_name;
	}

	public void setOauth_name(String oauth_name) {
		this.oauth_name = oauth_name;
	}

	public String getOauth_id() {
		return oauth_id;
	}

	public void setOauth_id(String oauth_id) {
		this.oauth_id = oauth_id;
	}

	public String getOauth_access_token() {
		return oauth_access_token;
	}

	public void setOauth_access_token(String oauth_access_token) {
		this.oauth_access_token = oauth_access_token;
	}

	public String getOauth_expires() {
		return oauth_expires;
	}

	public void setOauth_expires(String oauth_expires) {
		this.oauth_expires = oauth_expires;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
