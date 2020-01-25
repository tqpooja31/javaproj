package com.lb.pojo;

public class Book {
//	{"callno":"as","bname":"sgdfghjhhhhh","author":"dfghjjjjjjjjjjjjj","publisher":"fggggggggggggggggggggg","quantity":2}
	private int id;
	private String callno,bname,author,publisher;
	private int quantity,issued;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIssued() {
		return issued;
	}
	public void setIssued(int issued) {
		this.issued = issued;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", callno=" + callno + ", bname=" + bname + ", author=" + author + ", publisher="
				+ publisher + ", quantity=" + quantity + ", issued=" + issued + "]";
	}
	
	
	
	
}
