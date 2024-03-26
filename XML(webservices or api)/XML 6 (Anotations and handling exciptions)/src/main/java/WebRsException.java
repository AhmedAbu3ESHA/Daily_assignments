import java.sql.SQLException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WebRsException implements ExceptionMapper<SQLException> {

	@Override
	public Response toResponse(SQLException exception) {
		// TODO Auto-generated method stub
		if (exception instanceof SQLException) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.header("X-Fail", exception.getMessage())
					.build();
		}
		
	}

}
