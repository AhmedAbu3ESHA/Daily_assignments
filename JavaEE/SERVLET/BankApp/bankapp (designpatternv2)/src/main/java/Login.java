import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login {
    deo dao;

    private void login(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("phone").isEmpty()) {
            request.setAttribute("me2", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            if(this.dao.check_phone(request.getParameter("phone"))==1||this.dao.checkregphone(request.getParameter("phone"))==1)
            {
                loginphone=request.getParameter("phone");
                try {
                    request.getRequestDispatcher("/options.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                request.setAttribute("message8", "Phone not found"); try {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }}
    }
}
