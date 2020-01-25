package com.lb.pojo;

import java.io.PrintWriter;

public class Librarian {
//	{"name":"riya","password":"12345678","email":"r@gmail.com","mobno":12345678}
	private int id;
	private String name;
	private String email;
	private String password;
	private long mobno;
	
	
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobno="
				+ mobno + "]";
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
		
	
}
