import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class Yearservice extends Calculation{
    Trans trans;
    Trans obj=null;
    deo dao;
    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
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
                obj = new Tran(amount, year, percent,finalamount,loginphone,yearpayback);
                if (trans.getTransYear().contains(obj)) {
                    request.setAttribute("message", trans.getTransYear().indexOf(obj));
                    Collections.swap(trans.getTransYear(), trans.getTransYear().indexOf(obj), 0);
                    request.setAttribute("transYear", trans.getTransYear());
                } else {
                    trans.getTransYear().add(obj);
                    request.setAttribute("transYear", trans.getTransYear());
                    trans.getTransYear().get(trans.getTransYear().size()-1).setPhone(loginphone);
                    this.dao.saveyears(trans.getTransYear().get(trans.getTransYear().size()-1).getAmount(), trans.getTransYear().get(trans.getTransYear().size()-1).getYear(), trans.getTransYear().get(trans.getTransYear().size()-1).getPercent(), trans.getTransYear().get(trans.getTransYear().size()-1).getBalance(), trans.getTransYear().get(trans.getTransYear().size()-1).getPhone(),trans.getTransYear().get(trans.getTransYear().size()-1).getYearpayback());
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
