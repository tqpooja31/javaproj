package com.lb.login.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.lb.constants.DBCon;
import com.lb.constants.constantdb;
import com.lb.pojo.Book;
import com.lb.pojo.IssueBook;
import com.lb.pojo.Librarian;

public class BookDao {

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> createbook(Book bk) throws JSONException, ClassNotFoundException, SQLException {

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_Addbook);
          int    id=bk.getId();
		String callno = bk.getCallno();
		String name = bk.getBname();
		String author = bk.getAuthor();
		String publisher = bk.getPublisher();
		int quantity = bk.getQuantity();
		int issued = bk.getIssued();

		Object[] parameter = { id,callno, name, author, publisher, quantity, issued };

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		return mp;
	}

	public static ArrayList<Book> getDriveListFromDb() throws SQLException, ClassNotFoundException {
		ArrayList<Book> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_USER_GETALL1);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			Book u = new Book();
			u.setId(resultSet.getInt(1));
			u.setCallno(resultSet.getString(2));
			u.setBname(resultSet.getString(3));
			u.setAuthor(resultSet.getString(4));
			u.setPublisher(resultSet.getString(5));
			u.setQuantity(resultSet.getInt(6));
			u.setIssued(resultSet.getInt(7));

			list.add(u);
		}
		return list;
	}

	public static Map<String, String> updatebook(Book lib) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_BookUPDATE);

			ps.setInt(7,lib.getId());
			ps.setString(1, lib.getCallno());
			ps.setString(2, lib.getBname());
			ps.setString(3, lib.getAuthor());
			ps.setString(4, lib.getPublisher());
			ps.setInt(5, lib.getQuantity());
			ps.setInt(6, lib.getIssued());

			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;
	}
	
	public static Map<String, String> deletebook(Book lib) throws ClassNotFoundException, SQLException {

		System.out.println("in  delete method ");

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_DELETEbook);

		ps.setObject(1, lib.getId());

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}

		// System.out.println("bye");
		return mp;
	}

	public static Map<String, String> createIssuebook(IssueBook bk)
			throws JSONException, ClassNotFoundException, SQLException {

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_Addissuebook);

		String callno = bk.getCallno();
		int studid = bk.getStudid();
		String name = bk.getSname();
		long smob = bk.getSmobno();
		Date temp = bk.getIssuedate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String issuedate = sdf.format(temp);

		String returnstatus ="no";

		Object[] parameter = { callno, studid, name, smob, issuedate, returnstatus };

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) 
		{			
			mp.put("Msg", "successfully");
			PreparedStatement ps2 = con.prepareStatement(constantdb.STR_USER_updateissuebook);
			ps2.setString(1,callno);
		
			int k=ps2.executeUpdate();
			System.out.println("updated " + k);
		} 
		else
		{
			mp.put("Msg", "Error");
		}
		return mp;
	}

	public static ArrayList<IssueBook> getissueBook() throws SQLException, ClassNotFoundException {
		ArrayList<IssueBook> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_USER_GETALL2);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			IssueBook u = new IssueBook();
			u.setCallno(resultSet.getString(2));
			u.setStudid(resultSet.getInt(3));
			u.setSname(resultSet.getString(4));
			u.setSmobno(resultSet.getLong(5));
			u.setIssuedate(resultSet.getDate(6));
			u.setReturnstatus(resultSet.getString(7));
			System.out.println(u);
			list.add(u);
		}
		return list;
	}

	public static Map<String, String> returnIssuebook(IssueBook ibk) throws SQLException, ClassNotFoundException {
		
		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_returnissuebook);

		ps.setString(1,ibk.getCallno());
		ps.setInt(2,ibk.getStudid());
		
		status = ps.executeUpdate();

		if (status == 1) 
		{			
			
			PreparedStatement ps2 = con.prepareStatement(constantdb.STR_USER_updatereturnissuebook);
			ps2.setString(1,ibk.getCallno());		
			int k=ps2.executeUpdate();
			System.out.println("updated " + k);
			
			mp.put("Msg", "successfully");
		} 
		else
		{
			mp.put("Msg", "Error");
		}
		return mp;

	}

}
