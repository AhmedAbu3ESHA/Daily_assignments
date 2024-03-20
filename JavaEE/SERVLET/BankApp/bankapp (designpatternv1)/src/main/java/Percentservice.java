import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class Percentservice extends Calculation{
    Trans trans;
    Trans obj=null;
    deo dao;
    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
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
                obj = new Tran(amount, year, percent, finalamount, loginphone);
                if (trans.getTransPercent().contains(obj)) {
                    request.setAttribute("message", trans.getTransPercent().indexOf(obj));
                    Collections.swap(trans.getTransPercent(), trans.getTransPercent().indexOf(obj), 0);
                    request.setAttribute("transPercent", trans.getTransPercent());
                } else {
                    trans.getTransPercent().add(obj);
                    request.setAttribute("transPercent", trans.getTransPercent());
                    trans.getTransPercent().get(trans.getTransPercent().size()-1).setPhone(loginphone);
                    this.dao.save(trans.getTransPercent().get(trans.getTransPercent().size()-1).getAmount(), trans.getTransPercent().get(trans.getTransPercent().size()-1).getYear(), trans.getTransPercent().get(trans.getTransPercent().size()-1).getPercent(), trans.getTransPercent().get(trans.getTransPercent().size()-1).getBalance(), trans.getTransPercent().get(trans.getTransPercent().size()-1).getPhone());

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
