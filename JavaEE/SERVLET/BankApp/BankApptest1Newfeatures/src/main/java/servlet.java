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
    boolean logged = false;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String intent = request.getParameter("intent");
        String phone= "";
        if (logged){
            if (intent.equals("show")) {
                //put phone
                show(request,response);
            } else if (intent.equals("save")) {
                //make trans
                save(request, response);
            }
        } else {
            if (intent.equals("show")) {
                if (transaction.size() < 5){
                    show(request, response);
                }
                else{
                    request.setAttribute("message5", "You have reached your limit ");
                    try {
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (intent.equals("save")) {
                save(request, response);
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

    private void save(HttpServletRequest request, HttpServletResponse response) {
        logged = true;
        if (request.getParameter("pho").isEmpty()) {
            request.setAttribute("message2", " Invalied Input ");
            try {
                request.getRequestDispatcher("/savedata.jsp").forward(request, response);
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
            request.setAttribute("transaction", transaction);

            try {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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