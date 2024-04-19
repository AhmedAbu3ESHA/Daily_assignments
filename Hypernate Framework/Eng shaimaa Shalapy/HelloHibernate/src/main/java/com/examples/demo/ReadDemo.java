package com.examples.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Instructor;

public class ReadDemo {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
		
		// open session
		Session session = sessionFactory.openSession();
		
		// begin transaction 
		session.beginTransaction();
		
		// do my actions on db
		
//		Instructor instructor = session.get(Instructor.class, 1);
//		System.out.println(instructor);
		
//		List<Instructor> instructors = session.createQuery("from Instructor i",Instructor.class)
//				                              .getResultList();
//		
		List<Instructor> instructors = session.createQuery("from Instructor i WHERE i.firstName LIKE :pattern",Instructor.class)
				                              .setParameter("pattern", "A%")
				                              .getResultList();
		
		instructors.stream().forEach( i -> System.out.println(i));
		
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
