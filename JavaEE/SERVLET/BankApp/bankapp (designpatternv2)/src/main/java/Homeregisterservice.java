import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class Homeregisterservice extends Register{
    List<Trans> transaction=new ArrayList<>();
    Trans obj=null;

    @Override
    public void register(HttpServletRequest request, HttpServletResponse response,deo dao) {
        if (request.getParameter("pho").isEmpty()) {
            request.setAttribute("message2", " Invalied Input ");

            try {
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(dao.check_phone(request.getParameter("pho"))==0){
            for (int i = 0; i < transaction.size(); i++) {
                transaction.get(i).setPhone(request.getParameter("pho"));
               dao.save(transaction.get(i).getAmount(), transaction.get(i).getYear(), transaction.get(i).getPercent(), transaction.get(i).getBalance(), transaction.get(i).getPhone());
            }
            request.setAttribute("message3", " Data saved ! ");
            request.setAttribute("transaction",transaction);
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(dao.check_phone(request.getParameter("pho"))==1)
        {request.setAttribute("message9", "You already have an account"); try {
            request.getRequestDispatcher("reg.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }
}
