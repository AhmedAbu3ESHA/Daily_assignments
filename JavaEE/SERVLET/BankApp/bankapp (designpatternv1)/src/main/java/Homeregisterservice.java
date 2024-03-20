import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Homeregisterservice extends Register{
    Trans trans;
    Trans obj=null;
    deo dao;
    @Override
    public void register(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("pho").isEmpty()) {
            request.setAttribute("message2", " Invalied Input ");

            try {
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(this.dao.check_phone(request.getParameter("pho"))==0){
            for (int i = 0; i < trans.getTransaction().size(); i++) {
                trans.getTransaction().get(i).setPhone(request.getParameter("pho"));
                this.dao.save(trans.getTransaction().get(i).getAmount(), trans.getTransaction().get(i).getYear(), trans.getTransaction().get(i).getPercent(), trans.getTransaction().get(i).getBalance(), trans.getTransaction().get(i).getPhone());
            }
            request.setAttribute("message3", " Data saved ! ");
            request.setAttribute("transaction",trans.getTransaction());
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(this.dao.check_phone(request.getParameter("pho"))==1)
        {request.setAttribute("message9", "You already have an account"); try {
            request.getRequestDispatcher("reg.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }
}
