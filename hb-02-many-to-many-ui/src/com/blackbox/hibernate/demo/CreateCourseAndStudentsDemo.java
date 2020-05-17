package com.blackbox.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blackbox.hibernate.demo.entity.Course;
import com.blackbox.hibernate.demo.entity.Instructor;
import com.blackbox.hibernate.demo.entity.InstructorDetail;
import com.blackbox.hibernate.demo.entity.Review;
import com.blackbox.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			int theId= 1;
			Student theStudent = session.get(Student.class, theId);
			System.out.println("\nThe Student: " + theStudent);
			System.out.println("\nThe Courses: " + theStudent.getCourses());
			//Create couses
			Course tempCourse1 = new Course("How to finish without start");
			Course tempCourse2 = new Course("How to start to finish");
			
			//Add courses to the Student
			System.out.println("***************Saving the courses******");
			tempCourse1.addStudent(theStudent);
			tempCourse2.addStudent(theStudent);
			
			//Save the Courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			System.out.println("\nThe Courses: " + theStudent.getCourses());


			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");

		}finally {
			session.close();
			factory.close();
		}
	}

}