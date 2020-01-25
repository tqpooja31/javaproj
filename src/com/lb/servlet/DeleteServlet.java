package com.lb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.lb.login.DAO.LibrarianDao;
import com.lb.pojo.Librarian;
import com.lb.utility.UtilityJson;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in delete");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Librarian lib = (Librarian) UtilityJson.getObjectFromJSON(jsonobject, Librarian.class);
		//System.out.println(lib);

		Map<String, String> mp = null;
		try 
		{
			mp = LibrarianDao.deletelibrarian(lib);
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
