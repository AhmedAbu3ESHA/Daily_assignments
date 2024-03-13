package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
	
	public List<Department> selectDepartments(){
		List<Department> departments=new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "root123");
		            Statement st = con.createStatement();
		            ResultSet resultSet = st
		                    .executeQuery("SELECT * FROM departments order by department_id desc");
	            while (resultSet.next()){
	            	int id=Integer.parseInt(resultSet.getString(1));
	            	String name=resultSet.getString(2);
	            	Department dep=new Department(id,name);
	            	departments.add(dep);
	            }
	            return departments;

	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return departments;

	}
	
	public Department selectDepartmentById(int id){
		Department dept=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "root123");
		            PreparedStatement st = con.prepareStatement("SELECT * FROM departments where department_id=?");
		            st.setInt(1, id);
		            ResultSet resultSet = st
		                    .executeQuery();
	            if(resultSet.next()){
	            	
	            	String name=resultSet.getString(2);
	            	dept=new Department(id,name);
	            	return dept;
	            }
	            
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return dept;

	}
	
	public int insertDepartment(String deptName) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "root123");
			        PreparedStatement st = con.prepareStatement("insert into departments(name) values(?)");
			    
			        st.setString(1, deptName);
			        int rows=st.executeUpdate();
			    
			    return rows;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
		public int updateDepartment(int deptId, String deptName) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = 
					DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "root123");
			        PreparedStatement st = con.prepareStatement("update departments set name=? where department_id=?");
			    
			        st.setString(1, deptName);
			        st.setInt(2, deptId);
			        int rows=st.executeUpdate();
			    
			    return rows;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
		
		public int deleteDepartment(int deptId) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = 
						DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "root123");
				        PreparedStatement st = con.prepareStatement("delete from departments where department_id=?");
				        st.setInt(1, deptId);
				        int rows=st.executeUpdate();
				    
				    return rows;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
		}


}
