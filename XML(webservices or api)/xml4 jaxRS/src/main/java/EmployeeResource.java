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

@Path("/employees")
@Consumes("application/json")
@Produces("application/json")
public class EmployeeResource {
	static List<Employee> emps=new ArrayList(List.of(
			new Employee(1, "ahmed", 2500),
			new Employee(2, "hussein", 3000),
			new Employee(3, "hany", 2500),
			new Employee(4, "wael", 4000),
			new Employee(5, "tamer", 6000)
			));
	
	@GET
	public List<Employee> getEmployees() {
		
		return emps;

	}
	
	@GET
	@Path("/{code}")
	public Employee getEmployee(@PathParam("code") int code) {
		Employee employee = emps.stream().filter(e->e.getCode()==code).findFirst().get();
		return employee;
	}
	
	@POST
	public Employee addEmployee(Employee emp) {
		emps.add(emp);
		return emp;
	}
	
	@PUT
	@Path("/{code}")
	public Employee updateEmployee(@PathParam("code") int code,Employee updatedEmployee) {
		Employee employee = emps.stream().filter(e->e.getCode()==code).findFirst().get();
		employee.setNameString(updatedEmployee.getNameString());
		employee.setSalary(updatedEmployee.getSalary());
		
		return updatedEmployee;
	}
	
	@DELETE
	@Path("/{code}")
	public Employee deleteEmployee(@PathParam("code") int code) {
		Employee employee = emps.stream().filter(e->e.getCode()==code).findFirst().get();
		emps.remove(employee);
		return employee;
	}
	

}
