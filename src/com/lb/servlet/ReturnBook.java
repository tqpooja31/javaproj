package com.lb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.lb.login.DAO.BookDao;
import com.lb.pojo.IssueBook;
import com.lb.utility.UtilityJson;


@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

	 IssueBook BK = (IssueBook) UtilityJson.getObjectFromJSON(jsonobject, IssueBook.class);
		System.out.println(BK);

		Map<String, String> mp=null;
		try {
			mp = BookDao.returnIssuebook(BK);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mp);
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();

		
	}

}
