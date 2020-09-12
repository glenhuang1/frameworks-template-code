package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DemoServlet1")
public class DemoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            Thread.sleep(1000*5);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }


        Cookie cookie1 = new Cookie("username","jack");
        Cookie cookie2 = new Cookie("password","1234");

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!</h3>");
    }
}
