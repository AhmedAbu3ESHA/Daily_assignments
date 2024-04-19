package com.examples.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Course;
import com.examples.entities.Instructor;
import com.examples.entities.InstructorDetails;

public class OneToManyDemo {

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
		
//		// get instructor
		Instructor instructor = session.get(Instructor.class, 1);
		
//		instructor.getCourses().stream().forEach(c -> System.out.println(c));
		
		Course course1 = new Course("C++",instructor);
		instructor.addCourse(course1);
		
		session.persist(instructor);
		
//		
////		// create courses
//		Course course1 = new Course("Java",instructor);
//		Course course2 = new Course("Angular",instructor);
//		Course course3 = new Course("J2EE",instructor);
//		Course course4 = new Course("JSF",instructor);
////		
//
//		session.persist(course1);
//		session.persist(course2);
//		session.persist(course3);
//		session.persist(course4);
//
//		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
