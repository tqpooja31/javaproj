package com.lb.login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.lb.constants.DBCon;
import com.lb.constants.constantdb;
import com.lb.pojo.Student;

public class StudentDao {

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> Addstudent(Student lb)
			throws JSONException, ClassNotFoundException, SQLException {

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_student_INSERT);

		int sid=lb.getSid();
		String sname = lb.getSname();
		long smobno = lb.getSmobno();
		String email = lb.getEmail();
		
		

		Object[] parameter = { sid,sname,  smobno, email };

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		return mp;
	}

	public static ArrayList<Student> getstudent() throws SQLException, ClassNotFoundException {
		ArrayList<Student> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_student_GETALL);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			Student u = new Student();
			u.setSid(resultSet.getInt(1));
			u.setSname(resultSet.getString(2));
			u.setSmobno(resultSet.getLong(3));
			u.setEmail(resultSet.getString(4));
			list.add(u);
		}
		return list;

	}
	public static Map<String, String> deletestudent(Student lib) throws ClassNotFoundException, SQLException {

		System.out.println("in  delete method ");

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_student_DELETE);

		ps.setObject(1, lib.getSid());

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}

		// System.out.println("bye");
		return mp;
	}

	public static Map<String, String> updatestudent(Student lib) {

		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_student_UPDATE);

			ps.setInt(4,lib.getSid());
			ps.setString(1, lib.getSname());
			ps.setLong(2, lib.getSmobno());
			ps.setString(3, lib.getEmail());
			
			

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
	
}
