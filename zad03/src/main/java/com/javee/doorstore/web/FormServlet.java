package com.javee.doorstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>New door</h2>" +
				"<form action='data'>" +
				"Id: <input type='text' name='id' /> <br />" +
				"Production date: <input type='text' name='productionDate' /> <br />" +
				"Weight: <input type='text' name='weight' /> <br />" +
				"Id: <input type='text' name='id' /> <br />" +
				"<input type='submit' value=' Add ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}
