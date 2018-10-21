package com.javaee.doorstore.web;

import com.javaee.doorstore.domain.Door;
import com.javaee.doorstore.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/newDoorForm")
public class NewDoorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>New door</h2>" +
				"<form method=\"POST\" action=''>" +
				"Id: <input type='number' name='id' /> <br />" +
				"Production date: <input type='date' name='productionDate' /> <br />" +
				"Weight: <input type='text' name='weight' /> <br />" +
				"Is exterior: <input type='checkbox' name='isExterior' /> <br />" +
				"Producer: <input type='text' name='producer' /> <br />" +
				"Description: <input type='text' name='description' /> <br />" +
				"<input type='submit' value=' Add ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
		response.setContentType("text/html");

		long id = Long.parseLong(request.getParameter("id"));
		Date productionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("productionDate"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		boolean isExterior = request.getParameter("isExterior") != null;
		String producer = request.getParameter("producer");
		String description = request.getParameter("description");

		StorageService.add(new Door(id, productionDate, weight, isExterior, producer, description));

		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>A new door has been added</h2>" +
				"<p>Id: " + id + "</p>" +
				"<p>Production date: " + productionDate + "</p>" +
				"<p>Weight: " + weight + "</p>" +
				"<p>Is exterior: " + isExterior + "</p>" +
				"<p>Producer: " + producer + "</p>" +
				"<p>Description: " + description + "</p><br />" +
				"<p><a href=\"newDoorForm\">Add another door</a></p>\n" +
				"<p><a href=\"menu\">Back to menu</a></p>\n" +
				"</body></html>");
		out.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
