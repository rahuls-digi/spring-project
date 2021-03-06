package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student.student;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {

		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				                                  .addAnnotatedClass(Instructor.class)
				                                  .addAnnotatedClass(InstructorDetail.class)
				                                  .addAnnotatedClass(Course.class)
				                                  .addAnnotatedClass(Review.class)
				                                  .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try {
            
		    // start theTransaction
			session.beginTransaction();
			
			//get the course
			int theId=13;
			Course tempCourse=session.get(Course.class , theId);
			
			//print the course
			System.out.println("deleting the coures...");
			System.out.println(tempCourse);
			
			//print the course reviews
			System.out.println(tempCourse.getReviews());
			
			//deleting the course
			session.delete(tempCourse);
			
			//commit Transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
			
		}
	}
}
