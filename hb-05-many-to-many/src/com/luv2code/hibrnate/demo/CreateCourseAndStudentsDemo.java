package com.luv2code.hibrnate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Course course = new Course("Math");

			System.out.println("Saving the Course!!: " + course);
			session.save(course);
			// create Students
			Student student1 = new Student("ahmed", "gamal", "ahmedgamal@gmail.com");
			Student student2 = new Student("sherif", "Ali", "sherifAli@gmail.com");
			course.addStudent(student1);
			course.addStudent(student2);
			System.out.println("saving the students");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + course.getStudents());
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			session.close();
			factory.close();
		}

	}
}
