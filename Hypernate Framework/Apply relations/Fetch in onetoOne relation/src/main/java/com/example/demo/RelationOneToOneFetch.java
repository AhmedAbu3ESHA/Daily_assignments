package com.example.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetails;

public class RelationOneToOneFetch {
	public static void main(String[] args) {
		//create session factory
		
		org.hibernate.SessionFactory  sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		
		// open session
		
		Session session = sessionfactory.openSession(); 
		
		//begin transaction
		session.beginTransaction();
		// do my action on db

		Instructor inst=session.get(Instructor.class,8);

		System.out.println(inst);
		
		System.out.println(inst.getDetails());

		// commit transaction
		
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		sessionfactory.close();
		

	}

}