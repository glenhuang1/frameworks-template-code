package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DemoServlet2")
public class DemoServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookie1string = "no cookie1 so far.";
        String cookie2string = "no cookie2 so far.";

        //获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("---no cookie is existing! Adding new session Start---");

            try {
                Thread.sleep(1000*10);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            Cookie cookie1 = new Cookie("cookie1_key","cookie1_value");
            Cookie cookie2 = new Cookie("cookie2_key","cookie2_value");

            cookie1.setMaxAge(10);
            cookie2.setMaxAge(30);

            response.addCookie(cookie1);
            response.addCookie(cookie2);

            System.out.println("---no cookie is existing! Adding new session End---");

        } else {
            //循环所有的cookie
            for(Cookie cookie:cookies){
                if (cookie.getName().equals("cookie1_key")) {
                    cookie1string = cookie.getValue();
                }
                if (cookie.getName().equals("cookie2_key")) {
                    cookie2string = cookie.getValue();
                }

            }

        }


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!</h3>");
        out.println("<h3>Cookie_1 title: </h3>" + cookie1string);
        out.println("<h3>Cookie_1 title: </h3>" + cookie2string);


    }

}
