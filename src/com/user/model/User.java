package com.user.model;

import java.util.Date;

public class User {

	private String id;
	private String name;
	private Date membershipStartDate;

	public User(String id, String name, Date membershipStartDate) {
		super();
		this.id = id;
		this.name = name;
		this.membershipStartDate = membershipStartDate;
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

	public Date getMembershipStartDate() {
		return membershipStartDate;
	}

	public void setMembershipStartDate(Date membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}
}
