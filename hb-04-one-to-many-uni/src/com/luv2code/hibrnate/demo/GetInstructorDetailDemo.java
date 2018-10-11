package com.luv2code.hibrnate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int theId = 2;
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			if (instructorDetail != null) {
				System.out
						.println(" get instructor from instructorDetail object : " + instructorDetail.getInstructor());

			}
			System.out.println("Deleting instructor Detail :" + instructorDetail);
			session.delete(instructorDetail);
			session.getTransaction().commit();
			System.out.println("Done!!");
		} catch (Exception e) {
			e.printStackTrace();
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
