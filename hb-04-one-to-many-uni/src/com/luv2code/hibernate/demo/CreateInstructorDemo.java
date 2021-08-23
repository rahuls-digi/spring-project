package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student.student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		//create session factory
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				                                  .addAnnotatedClass(Instructor.class)
				                                  .addAnnotatedClass(InstructorDetail.class)
				                                  .addAnnotatedClass(Course.class)
				                                  .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		try {
			//create the objects
			Instructor tempInstructor=new Instructor("susan", "public", "susanpublic@gmail.com");
			
			InstructorDetail tempInstructorDetail=
					new InstructorDetail("www.Egalesports.com/youtube","gamer");
			
		//String query = "insert into db_name(?, ?, ?) where id = _id ";)
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
		    // start theTransaction
			session.beginTransaction();
			
			//save the instructor
			//note: this will also save the details objects
			//because of the CascadeType.all
		    System.out.println("saving instructor:"+ tempInstructor);
			session.save(tempInstructor);
			
			//commit Transaction
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
			
		}
	}
}
