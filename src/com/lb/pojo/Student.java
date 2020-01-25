package com.lb.pojo;

public class Student {

	private int sid;
	private String sname;
	private long smobno;
	private String email;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getSmobno() {
		return smobno;
	}
	public void setSmobno(long smobno) {
		this.smobno = smobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", smobno=" + smobno + ", email=" + email + "]";
	}
	
	
	
	
}
