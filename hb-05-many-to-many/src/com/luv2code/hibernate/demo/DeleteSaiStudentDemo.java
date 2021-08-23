package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteSaiStudentDemo {

	public static void main(String[] args) {

		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				                                  .addAnnotatedClass(Instructor.class)
				                                  .addAnnotatedClass(InstructorDetail.class)
				                                  .addAnnotatedClass(Course.class)
				                                  .addAnnotatedClass(Review.class)
				                                  .addAnnotatedClass(Student.class)
				                                  .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try {
			
		    // start theTransaction
			session.beginTransaction();
			
			//get the student  from database
			int theId=3;
			Student tempStudent =session.get(Student.class,theId);
			
			System.out.println("\n loaded student:" + tempStudent);
			System.out.println("\n courses:" + tempStudent.getCourses());
			
			//delete a student
			System.out.println("\n deleting student..:"+ tempStudent);
			session.delete(tempStudent);
			
		   
			session.getTransaction().commit();
			System.out.println("done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}