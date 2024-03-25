

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeResource
 */
public class EmployeeResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Employee> emps=new ArrayList(List.of(
			new Employee(1, "ahmed", 2000),
			new Employee(2, "hussein", 3000),
			new Employee(3, "hany", 2500),
			new Employee(4, "wael", 4000),
			new Employee(5, "tamer", 6000)
			));
	
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String json = gson.toJson(emps);
		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
//		}
		Employee emp=gson.fromJson(json, Employee.class);
		emps.add(emp);
		response.setStatus(201);
		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(json);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String route=req.getRequestURI();
//		String subString=route.substring("/employees".length());
//		String[] splitStrings=subString.split("/");
//		int code=Integer.parseInt(splitStrings[2]);
//		
//		ServletInputStream stream = req.getInputStream();
//		//stream->inputstreamreader->bufferedreader
//		InputStreamReader inputStreamReader=new InputStreamReader(stream);
//		BufferedReader bReader=new BufferedReader(inputStreamReader);
//		String json = bReader.lines().collect(Collectors.joining("\n"));
//		
//		Employee updatedEmployee=gson.fromJson(json, Employee.class);
//		Employee currentEmployee=emps.stream().filter(e->e.getCode()==code).findFirst().get();
//		
//		currentEmployee.setNameString(updatedEmployee.getNameString());
//		currentEmployee.setSalary(updatedEmployee.getSalary());
		
//		resp.setStatus(200);
//		resp.setHeader("Content-Type", "application/json");
		resp.getWriter().write("put");
	}
	


}
