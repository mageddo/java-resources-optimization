package com.mageddo.spring.reactive.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author elvis
 * @version $Revision: $<br/>
 * $Id: $
 * @since 11/9/17 6:54 PM
 */

@Entity(name = "USER")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(nullable = false, length = 2)
	private int age;

	@Column(name = "NAME")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
