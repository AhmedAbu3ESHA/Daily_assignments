import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Register {
    public abstract void register(HttpServletRequest request, HttpServletResponse response,deo dao);
}
