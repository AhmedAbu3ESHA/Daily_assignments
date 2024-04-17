package com.example.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetails;

public class RelationOneToOneBidirection {
	public static void main(String[] args) {
		//create session factory
		
		org.hibernate.SessionFactory  sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		
		// open session
		
		Session session = sessionfactory.openSession(); 
		
		//begin transaction
		session.beginTransaction();
		// do my action on db
		InstructorDetails det=session.get(InstructorDetails.class,2);
  
	    System.out.println(det.getInstructor());

		// commit transaction
		
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		sessionfactory.close();
		

	}

}
