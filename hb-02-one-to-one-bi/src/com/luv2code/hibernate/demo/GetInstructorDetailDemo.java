package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student.student;

public class GetInstructorDetailDemo {

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
		
		   //get the instructorDetail object
          int  theId=4;
			
			InstructorDetail tempInstructorDetail=
					session.get(InstructorDetail.class,theId);
			
			//print the instructorDetail 
			System.out.println("Found instructordetail"+ tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor : "+  tempInstructorDetail.getInstructor());
			
			//commit Transaction
			session.getTransaction().commit();
		}
		catch(Exception exc){
			exc.printStackTrace();
			
		}
		finally {
			session.close();
			factory.close();
			
		}
	}
}
