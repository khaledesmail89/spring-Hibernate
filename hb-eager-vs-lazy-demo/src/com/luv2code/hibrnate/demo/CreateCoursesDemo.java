package com.luv2code.hibrnate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("instructor: " + tempInstructor);
			System.out.println("Courses: " + tempInstructor.getCourses());
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tmpStudent : theStudents) {
			System.out.println(tmpStudent);
		}
	}

}
