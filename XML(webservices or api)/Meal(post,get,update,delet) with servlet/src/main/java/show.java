import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletServlet", value = "/servlet-servlet")
public class show extends HttpServlet {
    List<Meals> meals=new ArrayList(List.of(
            new Meals("pizaa", "pizaa11", 2000),
            new Meals("fish", "fish12", 3000),
            new Meals("meat", "meat13", 2500)

    ));

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson meal= new Gson();
        String json = meal.toJson(meals);
        response.setStatus(200);
        response.setHeader("content-type","application/json");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ServletInputStream stream = request.getInputStream();
        //stream->inputstreamreader->bufferedreader
        InputStreamReader inputStreamReader=new InputStreamReader(stream);
        BufferedReader bReader=new BufferedReader(inputStreamReader);

        String json = bReader.lines().collect(Collectors.joining("\n"));
        //		StringBuilder sBuilder=new StringBuilder();
//		while (true) {
//			String line=bReader.readLine();
//			if (line==null)
//				break;
//
//			sBuilder.append(line);
        Gson meal= new Gson();
        Meals meals1=meal.fromJson(json, Meals.class);
        meals.add(meals1);
        response.setStatus(201);
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(json);
    }


    public void destroy() {
    }
}