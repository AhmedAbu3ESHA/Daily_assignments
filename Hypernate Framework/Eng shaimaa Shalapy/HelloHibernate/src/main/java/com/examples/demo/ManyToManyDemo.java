package com.examples.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examples.entities.Course;
import com.examples.entities.Instructor;
import com.examples.entities.InstructorDetails;
import com.examples.entities.Student;

public class ManyToManyDemo {

	public static void main(String[] args) {
		
		// create session factory 
		SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
		
		// open session
		Session session = sessionFactory.openSession();
		
		// begin transaction 
		session.beginTransaction();
		
		// do my actions on db
		
		
//		// create Student
//		Student st = new Student("Hamza","Amir","hamza@gmail.com");
//		
//		// get instructor 
//		Instructor instructor = session.get(Instructor.class, 8);
//		
//		// create course
//		Course c = new Course("Math",instructor);
//		
//		// add course to student
//		st.addCourse(c);
//		
//		// persist student
//		session.persist(st);
		
//*******************************************************************
//		
//		// get instructor courses
//		Instructor instructor = session.get(Instructor.class, 1);
//		
//		// get student
//		Student st = session.get(Student.class, 2);
//		
//		
//		// add list of courses to the student
//		st.addCourses(instructor.getCourses());
//		
//		
//		// persist the student
//		session.persist(st);
		
		
//*******************************************************************
		// get instructor
		Instructor ins = session.get(Instructor.class, 2);
		// create new course
		Course c = new Course("PHP",ins);
		
		
		// get student
		Student st = new Student("Omar","Omran","omar@gmail.com");
		
		// add student to the course
		c.addStudent(st);
		
		
		// persist course
		session.persist(c);
		
		
		
		
		
		
		
		// commit transaction 
		session.getTransaction().commit();
		
		// close session
		session.close();
		
		// close session factory
		sessionFactory.close();

	}

}
