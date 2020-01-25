package com.lb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lb.login.DAO.BookDao;
import com.lb.login.DAO.LibrarianDao;
import com.lb.pojo.Book;
import com.lb.pojo.Librarian;
import com.lb.utility.UtilityJson;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in delete");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Book lib = (Book) UtilityJson.getObjectFromJSON(jsonobject, Book.class);
		//System.out.println(lib);

		Map<String, String> mp = null;
		try 
		{
			mp = BookDao.deletebook(lib);
		}
		catch (ClassNotFoundException e) 
		{
          e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println(mp);

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);

		response.getWriter().write(jsonString);

		System.out.println(jsonString);

		response.flushBuffer();

	}
	
}


