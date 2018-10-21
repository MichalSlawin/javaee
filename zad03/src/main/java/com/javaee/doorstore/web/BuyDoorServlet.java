package com.javaee.doorstore.web;

import com.javaee.doorstore.domain.Door;
import com.javaee.doorstore.service.StorageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "buyDoor")
public class BuyDoorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "    <head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>Buy doors</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h2>Available doors</h2>\n");

        List<Door> doorsList = StorageService.getAllDoors();

        for(Door door : doorsList) {
            out.println("<p>Id: " + door.getId() + "</p>" +
                    "<p>Production date: " + door.getProductionDate() + "</p>" +
                    "<p>Weight: " + door.getWeight() + "</p>" +
                    "<p>Is exterior: " + door.isExterior() + "</p>" +
                    "<p>Producer: " + door.getProducer() + "</p>" +
                    "<p>Description: " + door.getDescription() + "</p><br />");
        }

        out.println("    </body>\n" +
                "</html>");

        out.close();
    }
}
