package com.example.demo;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String name=request.getParameter("name");
      String pass=request.getParameter("pass");

      String message;
      if (name.equals("hany")&&pass.equals("123")){
          message="succ";
      }
      else{
          message="fail";
      }
      request.setAttribute("message",message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}