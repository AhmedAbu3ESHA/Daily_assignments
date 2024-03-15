import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

    List<Trans> transaction =new ArrayList();
    Trans obj = null;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        obj value = request.getSession();


        String intent = request.getParameter("intent");
        String phone;
        if(intent.equals("show")) {
    double amount = Double.parseDouble(request.getParameter("amount"));
    int year = Integer.parseInt(request.getParameter("year"));
    int percent = Integer.parseInt(request.getParameter("percentage"));
    double interest = (amount * year * percent) / 100;
    double balance = interest + amount;
    phone ="";
    obj = new Trans(amount, year, percent, balance, phone);
if( transaction.contains(obj)){
    request.setAttribute("message",transaction.indexOf(obj));
    Collections.swap(transaction,transaction.indexOf(obj),0);
    request.setAttribute("transaction", transaction);
}else {
    transaction.add(obj);
    request.setAttribute("transaction", transaction);
}
         try {
             request.getRequestDispatcher("/index.jsp").forward(request, response);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }

     } else if (intent.equals("save")) {
         for (int i = 0; i < transaction.size(); i++) {
             transaction.get(i).setPhone(request.getParameter("pho"));
             this.deo.save(transaction.get(i).getAmount(), transaction.get(i).getYear(), transaction.get(i).getPercent(), transaction.get(i).getBalance(),transaction.get(i).getPhone());
         }
 }}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    public void destroy() {
    }
}