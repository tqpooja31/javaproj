package com.lb.pojo;

import java.util.Date;

public class IssueBook {

	private String callno, sname;
	private int studid;
	private long smobno;
	private Date issuedate = new Date();
	private String returnstatus;

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getStudid() {
		return studid;
	}

	public void setStudid(int studid) {
		this.studid = studid;
	}

	public long getSmobno() {
		return smobno;
	}

	public void setSmobno(long smobno) {
		this.smobno = smobno;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	@Override
	public String toString() {
		return "IssueBook [callno=" + callno + ", sname=" + sname + ", studid=" + studid + ", smobno=" + smobno
				+ ", issuedate=" + issuedate + ", returnstatus=" + returnstatus + "]";
	}

	
}
