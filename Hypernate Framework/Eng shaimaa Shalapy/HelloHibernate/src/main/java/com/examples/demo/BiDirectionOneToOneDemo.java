package com.examples.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Instructor;
import com.examples.entities.InstructorDetails;

public class BiDirectionOneToOneDemo {

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
		InstructorDetails details = session.get(InstructorDetails.class, 4);
		System.out.println(details);
		System.out.println(details.getInstructor());
//		
		
//		InstructorDetails details = new InstructorDetails("youtube.com/ibrahim","Reading");
//		Instructor hussien = new Instructor("Ibrahim", "Ali", "hussien@gmail.com",details);
////		session.persist(details);
//		session.persist(hussien);
//				
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
