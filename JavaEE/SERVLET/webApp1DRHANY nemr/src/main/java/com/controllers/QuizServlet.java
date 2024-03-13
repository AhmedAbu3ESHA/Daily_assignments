package com.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.model.GameDetails;


/**
 * Servlet implementation class QuizServlet
 */
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 String[] countries={"egypt","usa","france","uk","russia"};
	 String[] cities={"cairo","washington","paris","london","moscow"};
	 ArrayList<String> items;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        
	 
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GameDetails details=(GameDetails) 
				request.getSession().getAttribute("GameDetails");
		if(details==null) {
			details=new GameDetails(0, 0);
			request.getSession().setAttribute("GameDetails", details);
		}
		
        String action=request.getParameter("action");
        if(action.equals("start")){
        	items=selectCities();
        	String country="what is the capital of "+countries[details.getIndex()];
            request.setAttribute("country",country);
            request.setAttribute("nextEnabled", "");
            request.setAttribute("items", items);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }else if(action.equals("next")){
            Collections.shuffle(items);
            String answer=request.getParameter("answer");
            if(answer.equalsIgnoreCase(cities[details.getIndex()])) {
            	details.setScore(details.getScore()+1);
            	items.remove(answer);
            }
            details.setIndex(details.getIndex()+1);
            request.getSession().setAttribute("index",details.getIndex());
            if (details.getIndex()< countries.length){
                String country="what is the capital of "+countries[details.getIndex()];
                request.setAttribute("country",country);
                request.setAttribute("items", items);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
            }else{
                request.setAttribute("score",details.getScore());
                request.setAttribute("nextEnabled", "disabled");
                request.getSession().invalidate();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }

            }


        }

	}
	
	public ArrayList<String> selectCities(){
		ArrayList<String> cities=new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "root123");
		            Statement st = con.createStatement();
		            ResultSet resultSet = st
		                    .executeQuery("SELECT name FROM city");
	            while (resultSet.next()){
	                cities.add(resultSet.getString("name"));
	            }
	            return cities;

	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cities;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
