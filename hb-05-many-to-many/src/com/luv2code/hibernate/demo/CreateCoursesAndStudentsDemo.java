package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			//create the course
			Course tempCourse=new Course("eagle sports magic");
				
			System.out.println("\n saving the course...");
			session.save(tempCourse);
			System.out.println("saved the course:"+ tempCourse);
			
			//create students
			Student tempStudent1=new Student("rahul","sur","rahul@gmail.com");
			Student tempStudent2=new Student("ramesh","chikkam","ramesh@gmail.com");
			Student tempStudent3=new Student("sai","ganesh","sai@gmail.com");
			
			//add the students to course
			tempCourse.add(tempStudent1);
			tempCourse.add(tempStudent2);
			tempCourse.add(tempStudent3);
			
			//save the students
			System.out.println("\n saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("\n saved students:"+ tempCourse.getStudents());
			
			session.save(tempCourse);
			//commit Transaction
			session.getTransaction().commit();
			System.out.println("done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}