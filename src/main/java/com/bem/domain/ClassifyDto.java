package com.bem.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class ClassifyDto {

	@NotEmpty(message = "The title must not be null")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
