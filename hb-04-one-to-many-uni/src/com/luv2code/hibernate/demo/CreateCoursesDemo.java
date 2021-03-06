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

public class CreateCoursesDemo {

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
			
			//get the instructor from db
			int theId=1;
					Instructor tempInstructor=session.get(Instructor.class, theId);	
		    //create some courses
			Course tempCourse1=new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2=new Course(" PinBar Masterclass");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//commit Transaction
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
			
		}
	}
}
