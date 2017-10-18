package com.bem.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bem.utils.ID;

@Entity
public class Classify implements Serializable {

	@Id
	private String id;

	private String name;

	@OneToMany(mappedBy = "classify", orphanRemoval = true,cascade = CascadeType.MERGE)
	private List<Task> task;

	public Classify() {
		this.id = ID.uuid();
	}

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

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
