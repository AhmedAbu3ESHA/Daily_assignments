import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationException implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.header("X-Fail-validation", exception.getMessage())
				.build();
	}

}
