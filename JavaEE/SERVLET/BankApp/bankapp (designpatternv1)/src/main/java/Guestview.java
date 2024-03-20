import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class Guestview {
    Trans trans;
    Trans obj=null;
    //use in guest view
    private void geustview(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("year").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
                if (trans.getTransaction().contains(obj)) {
                    request.setAttribute("message", trans.getTransaction().indexOf(obj));
                    Collections.swap(trans.getTransaction(), trans.getTransaction().indexOf(obj), 0);
                    request.setAttribute("transaction", trans.getTransaction());
                } else {
                    trans.getTransaction().add(obj);
                    request.setAttribute("transaction", trans.getTransaction());
                }
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
