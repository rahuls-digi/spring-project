package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo1 {

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
			
			//create the course
			Course tempCourse=new Course("eagle sports magic");
			//add some reviews
			tempCourse.addReview(new Review("Great course....i loved it"));
			tempCourse.addReview(new Review("cool course... a lot to learn"));
			tempCourse.addReview(new Review("average course....need to make some more pratiacl"));
			
			//save the course and also leverage the cascadeAll...
			System.out.println("saving the course");
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			//commit Transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
			
		}
	}
}
