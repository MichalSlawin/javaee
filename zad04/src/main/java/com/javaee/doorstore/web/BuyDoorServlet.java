package com.javaee.doorstore.web;

import com.javaee.doorstore.domain.Door;
import com.javaee.doorstore.service.StorageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        List<Door> doorsList = StorageService.getDoorsList();

        for(Door door : doorsList) {
            out.println("<p>Id: " + door.getId() + "</p>" +
                    "<p>Production date: " + door.getProductionDate() + "</p>" +
                    "<p>Weight: " + door.getWeight() + "</p>" +
                    "<p>Is exterior: " + door.isExterior() + "</p>" +
                    "<p>Producer: " + door.getProducer() + "</p>" +
                    "<p>Description: " + door.getDescription() + "</p>" +
                    "<p>Price: " + door.getPrice() + "</p>" +
                    "<form method='POST' action=''>" +
                    "<input name='id' hidden value='" + door.getId() + "' />" +
                    "<input type='submit' value=' Add to cart ' />" +
                    "</form>");
        }

        out.println(
                "</body>\n" +
                "</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession();

        List<Door> sessionCart;

        if(httpSession.getAttribute("sessionCart") == null) {
            sessionCart = new ArrayList<Door>();
        } else {
            sessionCart = (ArrayList<Door>) httpSession.getAttribute("sessionCart");
        }
        long id = Long.parseLong(request.getParameter("id"));
        Door door = StorageService.getDoor(id);
        sessionCart.add(door);
        httpSession.setAttribute("sessionCart", sessionCart);

        PrintWriter out = response.getWriter();

        out.println("<h2>Product added to cart</h2>" +
                "<a href='./cart'><p>Go to cart</p></a>" +
                "<a href='./buyDoor'><p>Continue shopping</p>");
    }

}
