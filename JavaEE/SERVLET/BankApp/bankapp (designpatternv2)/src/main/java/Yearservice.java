import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yearservice extends Calculation{
    List<Trans> transYear=new ArrayList<>();
    Trans obj=null;

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response, deo dao) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("finalamount").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/numofyears.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            double amount = Double.parseDouble(request.getParameter("amount"));
            double finalamount = Double.parseDouble(request.getParameter("finalamount"));
            int percent = Integer.parseInt(request.getParameter("percentage"));
            if(amount>0&&percent>0&&percent<=100&&finalamount>0&&finalamount>amount){
                int year= (int) ((finalamount-amount)*100/(amount*percent));
                int yearpayback= (int) ((2*amount-amount)*100/(amount*percent));
                obj = new Trans(amount, year, percent,finalamount,loginphone,yearpayback);
                if (transYear.contains(obj)) {
                    request.setAttribute("message", transYear.indexOf(obj));
                    Collections.swap(transYear, transYear.indexOf(obj), 0);
                    request.setAttribute("transYear",transYear);
                } else {
                    transYear.add(obj);
                    request.setAttribute("transYear", transYear);
                    transYear.get(transYear.size()-1).setPhone(loginphone);
                    dao.saveyears(transYear.get(transYear.size()-1).getAmount(), transYear.get(transYear.size()-1).getYear(), transYear.get(transYear.size()-1).getPercent(), transYear.get(transYear.size()-1).getBalance(), transYear.get(transYear.size()-1).getPhone(),transYear.get(transYear.size()-1).getYearpayback());
                    try {
                        request.getRequestDispatcher("/numofyears.jsp").forward(request, response);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    request.getRequestDispatcher("/numofyears.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/numofyears.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
