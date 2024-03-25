import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletServlet", value = "/servlet-servlet")
public class numofmeals extends HttpServlet {
    List<Meals> meals=new ArrayList(List.of(
            new Meals("pizaa", "pizaa11", 2000),
            new Meals("fish", "fish12", 3000),
            new Meals("meat", "meat13", 2500)

    ));
    List<Meals> show=new ArrayList<>();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson meal= new Gson();

		String route=request.getRequestURI();
		String subString=route.substring("/meals".length());
		String[] splitStrings=subString.split("/");
		int code=Integer.parseInt(splitStrings[2]);
        show = meals.stream().limit(code).toList();
        String json = meal.toJson(show);
        response.setStatus(200);
        response.setHeader("content-type","application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
		String route=req.getRequestURI();
        String subString=route.substring("/meals".length());
		String[] splitStrings=subString.split("/");
		String name=splitStrings[2];

        Gson gson=new Gson();
		ServletInputStream stream = req.getInputStream();
		//stream->inputstreamreader->bufferedreader
		InputStreamReader inputStreamReader=new InputStreamReader(stream);
		BufferedReader bReader=new BufferedReader(inputStreamReader);
		String json = bReader.lines().collect(Collectors.joining("\n"));

        Meals updatedEmployee=gson.fromJson(json, Meals .class);
        Meals  currentEmployee=meals.stream().filter(e->e.getName().equals(name)).findFirst().get();
		currentEmployee.setName(updatedEmployee.getName());
		currentEmployee.setDesc(updatedEmployee.getDesc());

        resp.setStatus(200);
		resp.setHeader("Content-Type", "application/json");
        resp.getWriter().write("put");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String route=req.getRequestURI();
        String subString=route.substring("/meals".length());
        String[] splitStrings=subString.split("/");
        String name=splitStrings[2];
        Meals  meals1=meals.stream().filter(e->e.getName().equals(name)).findFirst().get();

        meals.remove(meals1);
        Gson gson=new Gson();
        String json=gson.toJson(meals1);
        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().write(json);


    }

    public void destroy() {
    }
}