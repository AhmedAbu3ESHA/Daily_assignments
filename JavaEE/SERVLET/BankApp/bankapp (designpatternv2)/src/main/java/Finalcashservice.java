import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Finalcashservice extends Calculation {
    List<Trans> transactionlog=new ArrayList<>();
    Trans obj=null;

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response,deo dao) {
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
                if (transactionlog.contains(obj)) {
                    request.setAttribute("message", transactionlog.indexOf(obj));
                    Collections.swap(transactionlog, transactionlog.indexOf(obj), 0);
                    request.setAttribute("transaction", transactionlog);
                } else {
                    transactionlog.add(obj);
                    request.setAttribute("transaction", transactionlog);
                    transactionlog.get(transactionlog.size()-1).setPhone(loginphone);
                    dao.save(transactionlog.get(transactionlog.size()-1).getAmount(), transactionlog.get(transactionlog.size()-1).getYear(), transactionlog.get(transactionlog.size()-1).getPercent(), transactionlog.get(transactionlog.size()-1).getBalance(), transactionlog.get(transactionlog.size()-1).getPhone());
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


