package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;
import com.blackbox.hibernate.demo.entity.Review;
import com.blackbox.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		//Create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			//Get the student
			int courseId = 8;
			Course theCourse = session.get(Course.class, courseId);
			
			System.out.println("The Course: " + theCourse);
			
			//Delete the course
			session.delete(theCourse);

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");

		}finally {
			session.close();
			factory.close();
		}
	}

}
