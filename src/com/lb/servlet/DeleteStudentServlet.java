package com.lb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lb.login.DAO.StudentDao;

import com.lb.pojo.Student;
import com.lb.utility.UtilityJson;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in delete");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Student lib = (Student) UtilityJson.getObjectFromJSON(jsonobject, Student.class);
		//System.out.println(lib);

		Map<String, String> mp = null;
		try 
		{
			mp = StudentDao.deletestudent(lib);
		}
		catch (ClassNotFoundException e) 
		{
          e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);

		response.getWriter().write(jsonString);

		System.out.println(jsonString);

		response.flushBuffer();

	}

	}


