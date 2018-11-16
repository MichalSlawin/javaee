package com.javaee.doorstore.web;

import com.javaee.doorstore.domain.Door;
import com.javaee.doorstore.service.StorageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class MenuServlet extends HttpServlet {

    public void init() {
        List<Door> doorsList = new ArrayList<Door>();
        getServletContext().setAttribute("application_doors", doorsList);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "    <head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>Menu</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h2>Door store</h2>\n" +
                "        <p><a href=\"./newDoorForm\">Add a door</a></p>\n" +
                "        <p><a href=\"./buyDoor\">Buy doors</a></p>\n" +
                "    </body>\n" +
                "</html>");
        out.close();
    }
}
