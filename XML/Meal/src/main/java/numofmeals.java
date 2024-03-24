import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.gson.Gson;
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

    public void destroy() {
    }
}