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
    String loginphone;
    public void init() throws ServletException {
        super.init();
        this.deo = new deo();
    }


    List<Trans> transaction=new ArrayList<>();
    List<Trans> transNpv=new ArrayList<>();
    List<Trans> transLoan=new ArrayList<>();
    List<Trans> transYear=new ArrayList<>();
    List<Trans> transPercent=new ArrayList<>();
    Trans obj=null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String intent = request.getParameter("intent");
        String phone= "";
        String hide="hidden";
            if (intent.equals("show")) {
                if (transaction.size() < 50){
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
                this.deo.saveregphone(request.getParameter("pho"));
            }
            else if(intent.equals("Login")){

                login(request, response);
            }  // show year
            else if (intent.equals("Calculate Year")) {
                showyear(request, response);
            }
            //calculate percent
            else if (intent.equals("Calculate Percent")) {
                showpercent(request, response);
            }
            //calculate final amount
            else if (intent.equals("calculate Amount")) {
                showlogin(request, response);
            }
            //npv
            else if (intent.equals("show npv")) {
                shownpv(request, response);
            }
            //home register
            else if(intent.equals("homeregister")){
                homeregisterlogic(request, response);
            }
            //loan register
            else if(intent.equals("show loan")){
                loan(request,response);
            }

    }
    //use in guest view
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
                request.setAttribute("message6", " Invalid data ! ");
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //use in register in guest
    private void save(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("pho").isEmpty()) {
            request.setAttribute("message2", " Invalied Input ");

            try {
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else if(this.deo.check_phone(request.getParameter("pho"))==0){
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
        }else if(this.deo.check_phone(request.getParameter("pho"))==1)
        {request.setAttribute("message9", "You already have an account"); try {
            request.getRequestDispatcher("reg.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("phone").isEmpty()) {
            request.setAttribute("me2", " Invalid Inputs ");
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            if(this.deo.check_phone(request.getParameter("phone"))==1||this.deo.checkregphone(request.getParameter("phone"))==1)
            {
                loginphone=request.getParameter("phone");
                try {
                    request.getRequestDispatcher("/options.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }else {
                request.setAttribute("message8", "Phone not found"); try {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }}
    }

    //show years
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
            if(amount>0&&percent>0&&percent<=100&&finalamount>0&&finalamount>amount){
                int year= (int) ((finalamount-amount)*100/(amount*percent));
                int yearpayback= (int) ((2*amount-amount)*100/(amount*percent));
                obj = new Trans(amount, year, percent, finalamount,loginphone,yearpayback);
                if (transYear.contains(obj)) {
                    request.setAttribute("message", transYear.indexOf(obj));
                    Collections.swap(transYear, transYear.indexOf(obj), 0);
                    request.setAttribute("transYear", transYear);
                } else {
                    transYear.add(obj);
                    request.setAttribute("transYear", transYear);
                    for (int i = 0; i < transYear.size(); i++) {
                        transYear.get(i).setPhone(loginphone);
                        this.deo.saveyears(transYear.get(i).getAmount(), transYear.get(i).getYear(), transYear.get(i).getPercent(), transYear.get(i).getFinalAmount(), transYear.get(i).getPhone(),transYear.get(i).getYearpayback());
                    }
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
            if(amount>0&&finalamount>0&&year>0&&year<50&&finalamount>amount){
                int percent=(int)((finalamount-amount)*100/(amount*year));
                obj = new Trans(amount, year, percent, finalamount, loginphone);
                if (transPercent.contains(obj)) {
                    request.setAttribute("message", transPercent.indexOf(obj));
                    Collections.swap(transPercent, transPercent.indexOf(obj), 0);
                    request.setAttribute("transPercent", transPercent);
                } else {
                    transPercent.add(obj);
                    request.setAttribute("transPercent", transPercent);
                    for (int i = 0; i < transPercent.size(); i++) {
                        transPercent.get(i).setPhone(loginphone);
                        this.deo.save(transPercent.get(i).getAmount(), transPercent.get(i).getYear(), transPercent.get(i).getPercent(), transPercent.get(i).getFinalAmount(), transPercent.get(i).getPhone());
                    }
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
        double Rate = Double.parseDouble(request.getParameter("percentage"));
        int Loan_years = Integer.parseInt(request.getParameter("year"));
        if(principleAmount>0&&Rate>0&&Rate<=100&&Loan_years>0&&Loan_years<=100){
        double interestPaid = principleAmount * (Rate / 100) * Loan_years;
        double finalAmount = principleAmount + interestPaid;
        int Number_of_Months = Loan_years* 12 ;
        double Installments =finalAmount/Number_of_Months;
        double Monthly_Installments = Math.round(Installments);

            obj = new Trans(principleAmount, Rate,Loan_years,Monthly_Installments,finalAmount);
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

    private void homeregisterlogic(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("phone2").isEmpty()) {
            request.setAttribute("message10", " Invalied Input ");

            try {
                request.getRequestDispatcher("/homeregister.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            if(this.deo.checkregphone(request.getParameter("phone2"))==0){
            this.deo.saveregphone(request.getParameter("phone2"));
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            }else if(this.deo.checkregphone(request.getParameter("phone2"))==1){

                request.setAttribute("message11", "You already have an account");
                try {
                    request.getRequestDispatcher("homeregister.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


//NPV
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

                obj = new Trans(amount, year, percent, loginphone, npv,npvState);
                if (transNpv.contains(obj)) {
                    request.setAttribute("message", transNpv.indexOf(obj));
                    Collections.swap(transNpv, transNpv.indexOf(obj), 0);
                    request.setAttribute("transNpv", transNpv);
                } else {
                    transNpv.add(obj);
                    request.setAttribute("transNpv", transNpv);
                    for (int i = 0; i < transNpv.size(); i++) {
                        transNpv.get(i).setPhone(loginphone);
                        this.deo.savenpv(transNpv.get(i).getAmount(), transNpv.get(i).getYear(), transNpv.get(i).getPercent(), transNpv.get(i).getPhone(), transNpv.get(i).getNpv(),transNpv.get(i).getNpvState());
                    }try {
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

    //show login
    private void showlogin(HttpServletRequest request, HttpServletResponse response) {
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




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void destroy() {
    }
}