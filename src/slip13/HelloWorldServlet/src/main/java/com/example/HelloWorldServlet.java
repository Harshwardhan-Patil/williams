package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Entry Form</title></head><body>");
        out.println("<h2>Enter Student Details</h2>");
        out.println("<form method='post' action='HelloWorldServlet'>");
        out.println("Name: <input type='text' name='name'><br><br>");
        out.println("Standard: ");
        out.println("<select name='standard'>");
        out.println("<option value='1st'>1st</option>");
        out.println("<option value='2nd'>2nd</option>");
        out.println("<option value='3rd'>3rd</option>");
        out.println("<option value='4th'>4th</option>");
        out.println("</select><br><br>");
        out.println("<input type='submit' value='Add'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String standard = request.getParameter("standard");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Student Added</title></head><body>");
        out.println("<h2>Student Added Successfully!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Standard:</strong> " + standard + "</p>");
        out.println("</body></html>");
}
}