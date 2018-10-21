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
import java.util.Date;

@WebServlet(urlPatterns = "/")
public class MenuServlet extends HttpServlet {

    //adding some data for testing
    public void init() {
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-20");
            Door door1 = new Door(1, date1, 10, true, "BRW", "Drzwi wejsciowo-wyjsciowe", 3000);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-11");
            Door door2 = new Door(5, date2, 12, false, "Porta", "Drzwi lewoskretne", 5000);

            StorageService.add(door1);
            StorageService.add(door2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
