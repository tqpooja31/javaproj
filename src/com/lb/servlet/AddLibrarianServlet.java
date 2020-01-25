package com.lb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
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

@WebServlet("/AddLibrarianServlet")
public class AddLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Librarian lib = (Librarian) UtilityJson.getObjectFromJSON(jsonobject, Librarian.class);
		System.out.println(lib);

		try {
			Map<String, String> mp= LibrarianDao.createlibrarian(lib);
//			System.out.println(mp);
			String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("in sql not allowed email duplicat entry");
			Map<String, String> mp = new HashMap<>();
			mp.put("Msg","Exist");
			String jsonString = (String) UtilityJson.getJSONFromObject(mp);
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			response.flushBuffer();
		}
		catch (SQLException e) {
		    
			//e.printStackTrace();
		}
	}

}
