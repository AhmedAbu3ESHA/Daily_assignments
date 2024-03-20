import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;

public class Loanservice {
    loan trans;
    loan obj=null;
    deo dao;
    private void loan(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("year").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/loan.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            double principleAmount = Double.parseDouble(request.getParameter("amount"));
            int Rate = (int) Double.parseDouble(request.getParameter("percentage"));
            int Loan_years = Integer.parseInt(request.getParameter("year"));

            if(principleAmount>0&&Rate>0&&Rate<=100&&Loan_years>0&&Loan_years<=100){
                double interestPaid = principleAmount * (Rate / 100) * Loan_years;
                double finalAmount = principleAmount + interestPaid;
                int Number_of_Months = Loan_years* 12 ;
                double Installments =finalAmount/Number_of_Months;
                double Monthly_Installments = Math.round(Installments);

                obj = new loan(principleAmount,Loan_years,Rate,finalAmount,"",);
                if (trans.getTransLoan().contains(obj)) {
                    request.setAttribute("message14", trans.getTransLoan().indexOf(obj));
                    Collections.swap(trans.getTransLoan(), trans.getTransLoan().indexOf(obj), 0);
                    request.setAttribute("transLoan", trans.getTransLoan());
                } else {
                    trans.getTransLoan().add(obj);
                    System.out.println(trans.getTransLoan());
                    request.setAttribute("transLoan", trans.getTransLoan());
                }
                try {
                    request.getRequestDispatcher("/loan.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else{
                request.setAttribute("message13", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/loan.jsp").forward(request,response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
