package com.lb.constants;

public class constantdb {

	
	public static String STR_USER_INSERT = "insert into librarian(Lname,Email,Password,mobno) values(?,?,?,?)";
	public static String STR_USER_GETALL = "select * from librarian";
	public static String STR_USER_DELETE = "delete from librarian where Lid=?";
	public static String STR_USER_UPDATE = "update librarian set Lname=?,Email=?,Password=?,mobno=? where Lid=?";
	
	
	public static String STR_USER_Addbook = "insert into book(id,callno,bname,Author,publisher,quantity,issue) values(?,?,?,?,?,?,?)";
	public static String STR_USER_GETALL1 = "select * from book";
	
	
	public static String STR_USER_Addissuebook = "insert into issuebook(callno,studid,sname,smobno,issuedate,Returnstatus) values(?,?,?,?,?,?)";
	public static String STR_USER_GETALL2 = "select * from issuebook";
	public static String STR_USER_updateissuebook="UPDATE book SET issue = issue + 1 , quantity = quantity - 1 where callno=?";
	public static String STR_USER_returnissuebook="update issuebook set Returnstatus='yes' where callno=? and studid=?";
	public static String STR_USER_updatereturnissuebook="UPDATE book SET issue = issue - 1 , quantity = quantity + 1 where callno=?";
	public static String STR_USER_BookUPDATE="update book set callno=?,bname=?,Author=?,publisher=?,quantity=?,issue=? where id=?";
	public static String STR_USER_DELETEbook="delete from book where id=?";
	
	public static String STR_student_INSERT = "insert into student(sid,sname,smobno,email) values(?,?,?,?)";
	public static String STR_student_GETALL = "select * from student";
	public static String STR_student_DELETE = "delete from student where sid=?";
	public static String STR_student_UPDATE = "update student set sname=?,smobno=?,email=? where sid=?";
}
