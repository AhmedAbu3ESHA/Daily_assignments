package com.examples.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Course;
import com.examples.entities.Instructor;
import com.examples.entities.InstructorDetails;

public class ManyToOneDemo {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
		
		// open session
		Session session = sessionFactory.openSession();
		
		// begin transaction 
		session.beginTransaction();
		
		
//		// create course
//		Course course = new Course("Spring 5");
//		
		// get instructor
		Instructor instructor = session.get(Instructor.class, 1);
		
		
//		
//		
//		// set course instructor 
//		course.setInstructor(instructor);
//		
//		// persist course
//		session.persist(course);
		
//		Course course = session.get(Course.class, 10);
//		System.out.println(course);
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
