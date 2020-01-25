package com.lb.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lb.login.DAO.LibrarianDao;
import com.lb.pojo.Librarian;
import com.lb.utility.UtilityJson;

@WebServlet("/UpdatelibrarianServlet")
public class UpdatelibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("update");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Librarian lib = (Librarian) UtilityJson.getObjectFromJSON(jsonobject, Librarian.class);
		System.out.println(lib);

		 Map<String,String>mp=LibrarianDao.update(lib);
		 
		   String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();

	}

}
