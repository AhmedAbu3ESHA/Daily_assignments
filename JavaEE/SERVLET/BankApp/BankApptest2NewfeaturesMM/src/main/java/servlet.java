import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletServlet", value = "/servlet-servlet")
public class servlet extends HttpServlet {

    deo deo;

    public void init() throws ServletException {
        super.init();
        this.deo = new deo();
    }


    List<Trans> transaction=new ArrayList<>();
    Trans obj=null;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String intent = request.getParameter("intent");
        String phone= "";
            if (intent.equals("show")) {
                if (transaction.size() < 5){
                    show(request, response);
                }
                else{
                    request.setAttribute("message5", "You have reached your limit, please register! ");
                    try {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (intent.equals("save")) {
                save(request, response);
            }
            // show year
            else if (intent.equals("Calculate Year")) {
                showyear(request, response);
            }
            //calculate percent
            else if (intent.equals("Calculate Percent")) {
                showpercent(request, response);
            }
            //calcutae final amount
            else if (intent.equals("calculate Amount")) {
                showlogin(request, response);
            }
            //npv
            else if (intent.equals("show npv")) {
                shownpv(request, response);
            }
            //login
            else if(intent.equals("Login")){

            if(this.deo.check_phone(request.getParameter("phone"))==1)
            {
                try {
                    request.getRequestDispatcher("/options.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {request.setAttribute("message8", "Phone not found"); try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            }
        }

    }

    private void show(HttpServletRequest request, HttpServletResponse response) {
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
                obj = new Trans(amount, year, percent, balance, phone);
                if (transaction.contains(obj)) {
                    request.setAttribute("message", transaction.indexOf(obj));
                    Collections.swap(transaction, transaction.indexOf(obj), 0);
                    request.setAttribute("transaction", transaction);
                } else {
                    transaction.add(obj);
                    request.setAttribute("transaction", transaction);
                }
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalied data ! ");
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    // npv
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
                String phone = "";
                String npvState="";
                for (int i = 1; i <= year; i++) {
                    npv= npv+(int) (interest/(Math.pow((1+percent/100),i)));
                }
                if(npv>amount){
                    npvState="Profitable investment";
                }else {
                    npvState=" Non Profitable investment";
                }

                obj = new Trans(amount, year, percent, phone, npv);
                if (transaction.contains(obj)) {
                    request.setAttribute("message", transaction.indexOf(obj));
                    Collections.swap(transaction, transaction.indexOf(obj), 0);
                    request.setAttribute("transaction", transaction);
                } else {
                    transaction.add(obj);
                    request.setAttribute("transaction", transaction);
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
    //year
    private void showyear(HttpServletRequest request, HttpServletResponse response) {
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
            if(amount>0&&percent>0&&percent<=100&&finalamount>0){
                String phone = "";
                int year= (int) ((finalamount-amount)*100/(amount*percent));
                int yearpayback= (int) ((2*amount-amount)*100/(amount*percent));
                obj = new Trans(amount, year, percent, finalamount, phone,yearpayback);
                if (transaction.contains(obj)) {
                    request.setAttribute("message", transaction.indexOf(obj));
                    Collections.swap(transaction, transaction.indexOf(obj), 0);
                    request.setAttribute("transaction", transaction);
                } else {
                    transaction.add(obj);
                    request.setAttribute("transaction", transaction);
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
    //show login
    private void showlogin(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("amount").isEmpty() || request.getParameter("year").isEmpty() || request.getParameter("percentage").isEmpty()) {
            request.setAttribute("me", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/calcAmount.jsp").forward(request, response);
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
                obj = new Trans(amount, year, percent, balance, phone);
                if (transaction.contains(obj)) {
                    request.setAttribute("message", transaction.indexOf(obj));
                    Collections.swap(transaction, transaction.indexOf(obj), 0);
                    request.setAttribute("transaction", transaction);
                } else {
                    transaction.add(obj);
                    request.setAttribute("transaction", transaction);
                }
                try {
                    request.getRequestDispatcher("/calcAmount.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("calcAmount.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //show percent
    private void showpercent(HttpServletRequest request, HttpServletResponse response) {
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
            if(amount>0&&finalamount>0&&year>0&&year<50){
                String phone = "";
                int percent=(int)((finalamount-amount)*100/(amount*year));
                obj = new Trans(amount, year, percent, finalamount, phone);
                if (transaction.contains(obj)) {
                    request.setAttribute("message", transaction.indexOf(obj));
                    Collections.swap(transaction, transaction.indexOf(obj), 0);
                    request.setAttribute("transaction", transaction);
                } else {
                    transaction.add(obj);
                    request.setAttribute("transaction", transaction);
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

    //save
    private void save(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("pho").isEmpty()) {
            request.setAttribute("message2", " Invalied Input ");

            try {
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            for (int i = 0; i < transaction.size(); i++) {
                transaction.get(i).setPhone(request.getParameter("pho"));
                this.deo.save(transaction.get(i).getAmount(), transaction.get(i).getYear(), transaction.get(i).getPercent(), transaction.get(i).getBalance(), transaction.get(i).getPhone());
            }
            request.setAttribute("message3", " Data saved ! ");
            request.setAttribute("transaction",transaction);
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void destroy() {
    }
}