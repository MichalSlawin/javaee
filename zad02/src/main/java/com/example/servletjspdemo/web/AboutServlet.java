package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"></head><body>" +
				"<h1>Michał Sławiński</h1>" +
				"<p>IT student of the University of Gdańsk</p>" +
				"<p>Born in Olsztyn in 1996</p>" +
				"<h3>Hobbies:</h3>" +
				"<ul>" +
				"<li>Guitars</li>" +
				"<li>Computer games</li>" +
				"<li>Running</li>" +
				"</ul></body><html>");
	}
}
