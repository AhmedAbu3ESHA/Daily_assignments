import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Percentservice extends Calculation{
    List<Trans> transPercent=new ArrayList<>();
    Trans obj=null;
    @Override
    public void show(HttpServletRequest request, HttpServletResponse response, deo dao) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("finalamount").isEmpty() || request.getParameter("year").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/percent.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            double amount = Double.parseDouble(request.getParameter("amount"));
            double finalamount = Double.parseDouble(request.getParameter("finalamount"));
            int year= Integer.parseInt(request.getParameter("year"));
            if(amount>0&&finalamount>0&&year>0&&year<50&&finalamount>amount){
                int percent=(int)((finalamount-amount)*100/(amount*year));
                obj = new Trans(amount, year, percent, finalamount, loginphone);
                if (transPercent.contains(obj)) {
                    request.setAttribute("message",transPercent.indexOf(obj));
                    Collections.swap(transPercent,transPercent.indexOf(obj), 0);
                    request.setAttribute("transPercent", transPercent);
                } else {
                    transPercent.add(obj);
                    request.setAttribute("transPercent", transPercent);
                    transPercent.get(transPercent.size()-1).setPhone(loginphone);
                    dao.save(transPercent.get(transPercent.size()-1).getAmount(), transPercent.get(transPercent.size()-1).getYear(), transPercent.get(transPercent.size()-1).getPercent(), transPercent.get(transPercent.size()-1).getBalance(), transPercent.get(transPercent.size()-1).getPhone());

                    try {
                        request.getRequestDispatcher("/percent.jsp").forward(request, response);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    request.getRequestDispatcher("/percent.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/percent.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
