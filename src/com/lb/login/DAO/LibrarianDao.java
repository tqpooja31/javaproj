package com.lb.login.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.lb.constants.DBCon;
import com.lb.constants.constantdb;
import com.lb.pojo.Librarian;

public class LibrarianDao {

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> createlibrarian(Librarian lb)
			throws JSONException, ClassNotFoundException, SQLException {

	

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_INSERT);

		String name = lb.getName();
		String email = lb.getEmail();
		String password = lb.getPassword();
		long mobno = lb.getMobno();

		Object[] parameter = { name, email, password, mobno };

		setValues(ps, parameter);
        
		status = ps.executeUpdate();

		Map<String, String> mp = new HashMap<>();
		
		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		return mp;
	}

	public static ArrayList<Librarian> getDriveListFromDb() throws SQLException, ClassNotFoundException {
		
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_USER_GETALL);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		
		ArrayList<Librarian> list = new ArrayList<>();
		
		while (resultSet.next()) {
			Librarian u = new Librarian();
			u.setId(resultSet.getInt(1));
			u.setName(resultSet.getString(2));
			u.setEmail(resultSet.getString(3));
			u.setPassword(resultSet.getString(4));
			u.setMobno(resultSet.getLong(5));

			list.add(u);
		}
		return list;

	}

	public static Map<String, String> deletelibrarian(Librarian lib) throws ClassNotFoundException, SQLException {

		System.out.println("in  delete method ");

		

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_DELETE);

		ps.setObject(1, lib.getId());

		status = ps.executeUpdate();
		
		Map<String, String> mp = new HashMap<>();
		

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}

		// System.out.println("bye");
		return mp;
	}

	public static Map<String, String> update(Librarian lib) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_UPDATE);

			ps.setString(1, lib.getName());
			ps.setString(2, lib.getEmail());
			ps.setString(3, lib.getPassword());
			ps.setLong(4, lib.getMobno());
			ps.setInt(5, lib.getId());

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

	public static Map<String, String> chklogin(Librarian lib) throws SQLException, ClassNotFoundException {

		Map<String, String> mapobject = new HashMap<String, String>();

		ResultSet status = null;

		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_USER_GETALL);

		status = ps.executeQuery();
	
		while (status.next()) 
		{
			if (status.getString(3).equals(lib.getEmail()) && status.getString(4).equals(lib.getPassword())) 
			{
				mapobject.put("status", "successfully");
				break;
			}
			else if ("admin@gmail.com".equals(lib.getEmail()) && "admin123".equals(lib.getPassword()))
			{
				mapobject.put("status", "admin");
				break;
			} 
			else 
			{
				mapobject.put("status", "Error");
			}
		}
		return mapobject;

	}

}