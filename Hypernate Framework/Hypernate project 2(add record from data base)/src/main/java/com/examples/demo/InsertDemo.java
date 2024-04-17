package com.examples.demo;


import com.examples.entitis.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class InsertDemo {
	public static void main(String[] args) {
	//creat session factory
	SessionFactory sessionFactory =new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Instructor.class)
			.buildSessionFactory();
	
	
	//open session
	Session session=sessionFactory.openSession();
	
	//begin transaction
	session.beginTransaction();
	
	
	//do action on db
	Instructor ins1=new Instructor("ahmed","mhamed", "ahmed@gmail");
	
	session.persist(ins1);
	
	//commit transacttion
	session.getTransaction().commit();
	
	//close session
	session.close();
	//
	sessionFactory.close();
	}
}