package com.treinobrisa.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	@NotBlank
	private String name;
	@Min(18)
	@Max(150)
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
