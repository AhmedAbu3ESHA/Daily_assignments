package com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Department;
import com.model.DepartmentDAO;

/**
 * Servlet implementation class HRServlet
 */
public class HRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HRServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new DepartmentDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String intent = request.getParameter("intent");
		if (intent == null) {
			List<Department> departments = dao.selectDepartments();
			request.setAttribute("deps", departments);
			request.getRequestDispatcher("/hr-jsp.jsp").forward(request, response);

		} else if (intent.equals("insert")) {
			String deptName = request.getParameter("deptName");
			int insert = dao.insertDepartment(deptName);
			if (insert > 0) {
				List<Department> departments = dao.selectDepartments();
				request.setAttribute("result", "success");
				request.setAttribute("deps", departments);
				request.getRequestDispatcher("/dep-insert.jsp").forward(request, response);
			} else {
				request.setAttribute("result", "error");

				request.getRequestDispatcher("/dep-insert.jsp").forward(request, response);
			}
		}else if(intent.equals("load")) {
			int deptId=Integer.parseInt(request.getParameter("dept_id"));
			Department dept= dao.selectDepartmentById(deptId);
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("/dep-update.jsp").forward(request, response);
			
		}else if(intent.equals("update")) {
			int deptId=Integer.parseInt(request.getParameter("id"));
			String deptName=request.getParameter("deptName");
			int rows=dao.updateDepartment(deptId, deptName);
			request.setAttribute("message", rows>0 ? "success" : "fail");
			request.getRequestDispatcher("/dep-update.jsp").forward(request, response);
		}else if(intent.equals("delete")) {
			int deptId=Integer.parseInt(request.getParameter("dept_id"));
			int rows=dao.deleteDepartment(deptId);
			request.setAttribute("message", rows>0 ? "success" : "fail");
			request.getRequestDispatcher("/dep-insert.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
