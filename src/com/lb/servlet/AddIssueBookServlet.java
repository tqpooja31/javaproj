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
import com.lb.pojo.Book;
import com.lb.pojo.IssueBook;
import com.lb.utility.UtilityJson;


@WebServlet("/AddIssueBookServlet")
public class AddIssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

	 IssueBook BK = (IssueBook) UtilityJson.getObjectFromJSON(jsonobject, IssueBook.class);
		System.out.println(BK);

		try {
			Map<String, String> mp= BookDao.createIssuebook(BK);
			System.out.println(mp);
			String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	

}
