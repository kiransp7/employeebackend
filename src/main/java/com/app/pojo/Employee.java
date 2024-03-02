package com.app.pojo;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")
@Setter
@Getter
@ToString
public class Employee extends BaseEntity{
	
	@Column(name = "ename")
	@Length(max = 20)
	@NotNull
	private String name;
	
	@Column(name = "loc")
	@Length(max = 20)
	@JsonProperty("location")
	private String location;
	
	@Column(name = "dept")
	@Length(max = 20)
	@JsonProperty("department")
	@NotNull
	private String dept;

	
	public Employee() {
		System.out.println("Employee Pojo Constructor");
	}
	
	
	
	

}
