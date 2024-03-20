import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class Finalcashservice extends Calculation {
    Trans trans;
    Trans obj=null;
    deo dao;
    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("year").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/finalcash.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            double amount = Double.parseDouble(request.getParameter("amount"));
            int year = Integer.parseInt(request.getParameter("year"));
            int percent = Integer.parseInt(request.getParameter("percentage"));
            double interest = (amount * year * percent) / 100;
            double balance = interest + amount;
            if(amount>0&&percent>0&&percent<=100&&year>0&&year<=50){
                String phone = "";
                obj = new Trans(amount,year,percent,balance,phone,0);
                if (trans.getTransactionlog().contains(obj)) {
                    request.setAttribute("message", trans.getTransactionlog().indexOf(obj));
                    Collections.swap(trans.getTransactionlog(), trans.getTransactionlog().indexOf(obj), 0);
                    request.setAttribute("transaction", trans.getTransactionlog());
                } else {
                    trans.getTransactionlog().add(obj);
                    request.setAttribute("transaction", trans.getTransactionlog());
                    trans.getTransactionlog().get(trans.getTransactionlog().size()-1).setPhone(loginphone);
                    this.dao.save(trans.getTransactionlog().get(trans.getTransactionlog().size()-1).getAmount(), trans.getTransactionlog().get(trans.getTransactionlog().size()-1).getYear(), trans.getTransactionlog().get(trans.getTransactionlog().size()-1).getPercent(), trans.getTransactionlog().get(trans.getTransactionlog().size()-1).getBalance(), trans.getTransactionlog().get(trans.getTransactionlog().size()-1).getPhone());
                }
                try {
                    request.getRequestDispatcher("/finalcash.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("finalcash.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


