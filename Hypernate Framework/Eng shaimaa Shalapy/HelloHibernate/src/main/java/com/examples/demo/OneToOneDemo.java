package com.examples.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Instructor;
import com.examples.entities.InstructorDetails;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();
		
		// open session
		Session session = sessionFactory.openSession();
		
		// begin transaction 
		session.beginTransaction();
		
		// do my actions on db
//		
//		Instructor instructor = session.get(Instructor.class, 7);
//		session.remove(instructor);
	//	System.out.println(instructor);
//		
		
//		InstructorDetails details = new InstructorDetails("youtube.com/ibrahim","Reading");
//		Instructor hussien = new Instructor("Ibrahim", "Ali", "hussien@gmail.com",details);
//////		session.persist(details);
//		session.persist(hussien);
//				
		
		// Lazy Fetching demo
		
		Instructor instructor = session.get(Instructor.class, 8);
		System.out.println(instructor);
		System.out.println("before requesting the details");
		System.out.println(instructor.getDetails());
		
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
