package edu.chart.hellograph.dto;

import java.io.Serializable;

public class TestS implements Serializable{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestS [name=" + name + ", age=" + age + "]";
	}
	
	
	
}