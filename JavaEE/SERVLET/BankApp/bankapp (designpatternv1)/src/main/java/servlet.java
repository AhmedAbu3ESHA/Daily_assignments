import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servletServlet", value = "/servlet-servlet")
public class servlet extends HttpServlet {

    deo dao;
    String loginphone;

    public void init() throws ServletException {
        super.init();
        this.dao = new deo();
    }


    List<Tran> transaction=new ArrayList<>();


    List<Tran> transYear=new ArrayList<>();
    List<Tran> transPercent=new ArrayList<>();
    List<Tran> transactionlog=new ArrayList<>();
    Tran obj=null;

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
            } else if (intent.equals("guestregister")) {
                save(request, response);
                this.dao.saveregphone(request.getParameter("pho"));
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
            }else if(intent.equals("clear")){
                clear(request, response);
            }

    }

    private void clear(HttpServletRequest request, HttpServletResponse response) {
        transaction.clear();
        transNpv.clear();
        transLoan.clear();
        transYear.clear();
        transPercent.clear();
        transactionlog.clear();
        try {
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //use in register in guest


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
            if(this.dao.check_phone(request.getParameter("phone"))==1||this.dao.checkregphone(request.getParameter("phone"))==1)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void destroy() {
    }
}