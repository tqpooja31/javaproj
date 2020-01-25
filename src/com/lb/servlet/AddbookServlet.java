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
import com.lb.login.DAO.LibrarianDao;
import com.lb.pojo.Book;
import com.lb.pojo.Librarian;
import com.lb.utility.UtilityJson;


@WebServlet("/AddbookServlet")
public class AddbookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
	String jsonobject = request.getReader().readLine();
	System.out.println(jsonobject);

	Book BK = (Book) UtilityJson.getObjectFromJSON(jsonobject, Book.class);
	System.out.println(BK);

	try {
		Map<String, String> mp= BookDao.createbook(BK);
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