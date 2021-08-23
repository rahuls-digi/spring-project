package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student.student;

public class DeleteDemo {

	public static void main(String[] args) {

		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				                                  .addAnnotatedClass(Instructor.class)
				                                  .addAnnotatedClass(InstructorDetail.class)
				                                  .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try {
			
		    // start theTransaction
			session.beginTransaction();
		
			//get instructor by primary key or id
			int  theId=2;
			
			Instructor tempInstructor=
					session.get(Instructor.class,theId);
			
			System.out.println("Found instructor"+ tempInstructor);
			//delete the instructor
			if(tempInstructor!= null) {
				System.out.println("deleting "+ tempInstructor);
				
				//note: will also delete associated "details" objects
				//because of the casecade.all
				
				session.delete(tempInstructor);
				
			}
			
			
			//commit Transaction
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
			
		}
	}
}
