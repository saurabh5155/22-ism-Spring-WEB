package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class SearchByNameBean {
	@NotBlank
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
