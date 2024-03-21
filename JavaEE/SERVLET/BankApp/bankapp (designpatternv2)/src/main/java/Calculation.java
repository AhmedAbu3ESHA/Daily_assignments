import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Calculation {
    public abstract void show(HttpServletRequest request, HttpServletResponse response, deo dao);


}
