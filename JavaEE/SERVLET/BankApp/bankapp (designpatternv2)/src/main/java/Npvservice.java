import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Npvservice {
    List<Trans> transNpv=new ArrayList<>();
    npv obj=null;
    deo dao;
    private void shownpv(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("year").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/npv.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            double amount = Double.parseDouble(request.getParameter("amount"));
            int year = Integer.parseInt(request.getParameter("year"));
            int percent = Integer.parseInt(request.getParameter("percentage"));
            double interest = (amount * year * percent) / 100;
            int npv=0;

            if(amount>0&&percent>0&&percent<=100&&year>0&&year<=50){

                String npvState="";
                for (int i = 1; i <= year; i++) {
                    npv= npv+(int) (interest/(Math.pow((1+percent/100),i)));
                }
                if(npv>amount){
                    npvState="Profitable investment";
                }else {
                    npvState=" Non Profitable investment";
                }

                obj = new npv(amount,year,percent,interest,"",0,npv,npvState);
                if (transNpv.contains(obj)) {
                    request.setAttribute("message", transNpv.indexOf(obj));
                    Collections.swap(transNpv, transNpv.indexOf(obj), 0);
                    request.setAttribute("transNpv", transNpv);
                } else {
                    transNpv.add(obj);
                    request.setAttribute("transNpv", transNpv);
                    try {
                        request.getRequestDispatcher("/npv.jsp").forward(request, response);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    request.getRequestDispatcher("/npv.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/npv.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
