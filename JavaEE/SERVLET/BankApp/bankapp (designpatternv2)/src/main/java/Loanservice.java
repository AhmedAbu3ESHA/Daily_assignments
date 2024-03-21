import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loanservice {
    List<Loan> transLoan=new ArrayList<>();
    Loan obj=null;

    private void loan(HttpServletRequest request, HttpServletResponse response,deo dao) {
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

                obj = new Loan(principleAmount,Rate,Loan_years,Monthly_Installments,finalAmount);
                if (transLoan.contains(obj)) {
                    request.setAttribute("message14", transLoan.indexOf(obj));
                    Collections.swap(transLoan, transLoan.indexOf(obj), 0);
                    request.setAttribute("transLoan", transLoan);
                } else {
                    transLoan.add(obj);
                    System.out.println(transLoan);
                    request.setAttribute("transLoan", transLoan);
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
