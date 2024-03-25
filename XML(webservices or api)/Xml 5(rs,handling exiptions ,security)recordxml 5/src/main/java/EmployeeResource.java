import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	@Context HttpHeaders headers;
	
	
	static List<Employee> emps=new ArrayList(List.of(
			new Employee("ahmed", 2000, 1),
			new Employee("hussein", 2000, 2),
			new Employee("tamer", 3000, 3),
			new Employee("zeed", 4000, 4),
			new Employee("ebeed", 6000, 5),
			new Employee("wael", 2300, 6),
			new Employee("mahmoud", 1500, 7)
			));
	
	@GET
	public Response getEmployees(){
		String usernameString = headers.getHeaderString("username");
		if (usernameString.equals("hany")) {
			return Response.ok(emps).build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
		
	}
	
	@GET
	@Path("/{code}")
	public Response getEmployeeByCode(@PathParam("code") int code) {
		Employee selectedEmployee=emps.stream()
				.filter(e->e.getCode()==code)
				.findFirst()
				.orElse(null);
		if (selectedEmployee==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(selectedEmployee).build();
//		return Response.status(200).entity(selectedEmployee).build();
	}
	
	@POST
	public Response addEmployee(Employee employee) {
		if (emps.contains(employee)) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		emps.add(employee);
		return Response.status(201).entity(employee).build();
//		return Response.ok(employee).build();
	}
	
	@PUT
	@Path("/{code}")
	public Response updateEmployee(@PathParam("code") int code,Employee updateEmployee) {
		if (code!=updateEmployee.getCode()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		Employee currentEmployee=emps.stream().filter(e->e.getCode()==code).findFirst().get();
		currentEmployee.setName(updateEmployee.getName());
		currentEmployee.setSalary(updateEmployee.getSalary());
		return Response.ok(updateEmployee).build();
	}
	
	@DELETE
	@Path("/{code}")
	public Response deleteEmployee(@PathParam("code") int code) {
		Employee currentEmployee=emps.stream().filter(e->e.getCode()==code).findFirst().get();
		emps.remove(currentEmployee);
		return Response.ok(currentEmployee).build();
	}

}
