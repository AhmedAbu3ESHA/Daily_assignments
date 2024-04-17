package com.example.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Course;
import com.example.entities.Instructor;
import com.example.entities.InstructorDetails;

public class OneToManyDemo {
	public static void main(String[] args) {
		//create session factory
		
		org.hibernate.SessionFactory  sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		// open session
		
		Session session = sessionfactory.openSession(); 
		
		//begin transaction
		session.beginTransaction();
		// do my action on db
//
//		//creat new course
//		
//		Course course=new Course("Spring");
//		
//		//get instructor
//		Instructor instructor=session.get(Instructor.class,8);
//		
//		//set course instructor
//		course.setInstructor(instructor);
//		
//		
//		//open
//		session.persist(course);
//		

		//get course details
//		Course course=session.get(Course.class,10);
//		System.out.println(course);
	
		
		Instructor instructor=session.get(Instructor.class,8);
		
		instructor.getCourses().stream().forEach(c-> System.out.println(c));
		
		Course course1=new Course("Spri",instructor);
		Course course2=new Course("Angular",instructor);
		Course course3=new Course("Java",instructor);
		
		session.persist(course1);
		session.persist(course2);
		session.persist(course3);
		
	
		
		// commit transaction
		
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		sessionfactory.close();
		

	}

}
