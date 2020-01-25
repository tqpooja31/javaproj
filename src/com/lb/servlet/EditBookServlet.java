package com.lb.servlet;

import java.io.IOException;
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


@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("update");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Book lib = (Book) UtilityJson.getObjectFromJSON(jsonobject, Book.class);
		System.out.println(lib);

		 Map<String,String>mp=BookDao.updatebook(lib);
		 
		   String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

	}

}
