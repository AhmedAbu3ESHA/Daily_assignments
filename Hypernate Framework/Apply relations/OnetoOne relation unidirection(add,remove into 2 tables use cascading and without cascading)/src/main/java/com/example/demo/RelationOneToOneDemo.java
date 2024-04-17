package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetails;

public class RelationOneToOneDemo {
	
	public static void main(String[] args) {
		//create session factory
		
		org.hibernate.SessionFactory  sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		
		// open session
		
		Session session = sessionfactory.openSession(); 
		
		//begin transaction
		session.beginTransaction();
		// do my action on db
//	  Instructor inst=session.get(Instructor.class,1);
//	   System.out.println(inst);
		
		// insert in one to one relatio must add in 2 tables (instructor ,instructor details) 
//		InstructorDetails det= new InstructorDetails("youtube.com/ibrahim","reading");
//		Instructor inst= new Instructor("ibrahim","ahmed","ibra@gmail",det);
	//	session.persist(det);
//		session.persist(inst);
		
		// insert in one to one relation add in 2 tables (instructor ,instructor details) use cascading
		
//		InstructorDetails det= new InstructorDetails("youtube.com/ibrahim","reading");
//		Instructor inst= new Instructor("ibrahim","ahmed","ibra@gmail",det);
//		session.persist(inst);
		
		// insert in one to one relation must remove in 2 tables (instructor ,instructor details) use cascading
		
		Instructor instructor = session.get(Instructor.class, 1);
		session.remove(instructor);
		
		// commit transaction
		
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		sessionfactory.close();
		

	}

}
