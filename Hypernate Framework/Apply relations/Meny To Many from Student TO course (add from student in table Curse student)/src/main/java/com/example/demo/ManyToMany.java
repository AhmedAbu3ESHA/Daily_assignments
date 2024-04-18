package com.example.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Course;
import com.example.entities.Instructor;
import com.example.entities.InstructorDetails;
import com.example.entities.Student;


public class ManyToMany {
	public static void main(String[] args) {
		//create session factory
		
		org.hibernate.SessionFactory  sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// open session
		
		Session session = sessionfactory.openSession(); 
		
		//begin transaction
		session.beginTransaction();
		// do my action on db
//		//creat student
//
//		Student st=new Student("Hamza","ali","h@yahoo.com");
//		
//		
//		//get instructor
//		Instructor instructor=session.get(Instructor.class,8);		
//		
//		
//		//creat new course
//		Course course=new Course("c++",instructor);
//	
//		//add course to student
//  	     st.addCourse(course);
//		
		//		//pirsest to 
       // session.persist(st);
//		
	////////_____________________________________________________________________////////////////////////	
		
//		
		Instructor ins = session.get(Instructor.class, 2);
//		
//		Course c = new Course("Spring",ins);
//		
//		session.persist(c);
		//get student
		
		Student st = session.get(Student.class, 2);
		
		st.addCourses(ins.getCourses());


		// commit transaction
		
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		sessionfactory.close();
		

	}

}
