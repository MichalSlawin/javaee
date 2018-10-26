package com.javaee.doorstore.web;

import com.javaee.doorstore.domain.Door;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        List<Door> sessionCart;

        if(httpSession.getAttribute("sessionCart") == null) {
            sessionCart = new ArrayList<Door>();
        } else {
            sessionCart = (ArrayList<Door>) httpSession.getAttribute("sessionCart");
        }

        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "    <head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>Cart</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h2>Cart</h2>\n");

        double totalPrice = 0;
        for(Door door : sessionCart) {
            out.println("<p>Id: " + door.getId() + "</p>" +
                    "<p>Production date: " + door.getProductionDate() + "</p>" +
                    "<p>Weight: " + door.getWeight() + "</p>" +
                    "<p>Is exterior: " + door.isExterior() + "</p>" +
                    "<p>Producer: " + door.getProducer() + "</p>" +
                    "<p>Description: " + door.getDescription() + "</p>" +
                    "<p>Price: " + door.getPrice() + "</p><br />");
            totalPrice += door.getPrice();
        }

        out.println(
                "<p>Total price:" + totalPrice + "</p>" +
                "</body>\n</html>");

        out.close();
    }
}
