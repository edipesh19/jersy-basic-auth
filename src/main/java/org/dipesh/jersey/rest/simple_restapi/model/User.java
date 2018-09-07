package org.dipesh.jersey.rest.simple_restapi.model;

public class User {
	private String name;
	private Long salary;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}

}
