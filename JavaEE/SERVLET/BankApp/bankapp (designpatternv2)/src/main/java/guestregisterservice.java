import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class guestregisterservice extends Register{

    @Override
    public void register(HttpServletRequest request, HttpServletResponse response ,deo dao) {
        if (request.getParameter("phone2").isEmpty()) {
            request.setAttribute("message10", " Invalied Input ");

            try {
                request.getRequestDispatcher("/homeregister.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            if(dao.checkregphone(request.getParameter("phone2"))==0){
                dao.saveregphone(request.getParameter("phone2"));
                try {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else if(dao.checkregphone(request.getParameter("phone2"))==1){

                request.setAttribute("message11", "You already have an account");
                try {
                    request.getRequestDispatcher("homeregister.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
