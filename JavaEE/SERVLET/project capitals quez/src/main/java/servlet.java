import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletServlet", value = "/servlet-servlet")
public class servlet extends HttpServlet {
String[] countries = {"egypt","usa","france","uk"};
String[] city = {"cairo","ws","paris","london"};
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
int index=0;
int score=0;

        Object s = request.getSession().getAttribute("index");
        if (s == null){
            request.getSession().setAttribute("index",0);
        }
        s = request.getSession().getAttribute("score");
        if (s == null){
            request.getSession().setAttribute("score",0);
        }
        String action=request.getParameter("action");
        if(action.equals("start")){
            String question="What is the capital of "+countries[index];
            request.setAttribute("question",question);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equals("next")) {
            score= (int) request.getSession().getAttribute("score");
            index= (int) request.getSession().getAttribute("index");
            String ans=request.getParameter("answer");
            if(ans.equals(city[index])){
                score++;
                request.getSession().setAttribute("score",score);
            }
            index++;
            request.getSession().setAttribute("index",index);
            if(index<countries.length){
                String question="What is the capital of "+countries[index];
                request.setAttribute("question",question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                try {
                    requestDispatcher.forward(request,response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
            }
            request.setAttribute("score",score);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void destroy() {
    }
}