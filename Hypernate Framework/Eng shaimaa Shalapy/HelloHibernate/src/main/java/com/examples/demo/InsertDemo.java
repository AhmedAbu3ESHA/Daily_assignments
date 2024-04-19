package com.examples.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Instructor;

public class InsertDemo {

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
		
		Instructor ins1 = new Instructor("Shaimaa", "Shalaby", "shaimaa.hshalabygmail.com");
		Instructor ins2 = new Instructor("Ahmed", "Omran", "ahmed.omran@gmail.com");
		Instructor ins3 = new Instructor("Amir", "Mohamed", "amir.mohamed@gmail.com");
		Instructor ins4 = new Instructor("Hamza", "Shalaby", "hamza.hshalabygmail.com");
		
		session.persist(ins1);
		session.persist(ins2);
		session.persist(ins3);
		session.persist(ins4);
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		
		// close session factory

	}

}
