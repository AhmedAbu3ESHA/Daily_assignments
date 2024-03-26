import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;

public class JobResource {
	
	private Employee employee;

	public JobResource(Employee employee) {
		super();
		this.employee = employee;
	}
	
	@GET
	public Response getJobs() {
		
		return Response.ok(employee.getJobs()).build();
		
	}
	
	@POST
	public Response addJob(Job job) {
		employee.addJob(job);
		return Response.ok(job).build();
		
	}
	
	
	
	

}
