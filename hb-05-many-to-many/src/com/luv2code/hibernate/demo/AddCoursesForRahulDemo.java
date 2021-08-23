package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForRahulDemo {

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
			
			//get the student rahul from database
			int theId=1;
			Student tempStudent =session.get(Student.class,theId);
			
			System.out.println("\n loaded student:" + tempStudent);
			System.out.println("\n courses:" + tempStudent.getCourses());
			
			//create more courses
			Course tempCourse1=new Course("thinktank - How to speed logic");
			Course tempCourse2=new Course("common guide 2600 - gaming development");
		
			//add student to those courses
		    tempCourse1.add(tempStudent);
		    tempCourse2.add(tempStudent);
			
			//save the courses
		
		    System.out.println("\n saving the courses...");
			session.save(tempCourse1);
			session.save(tempCourse2);
		   
			session.getTransaction().commit();
			System.out.println("done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}