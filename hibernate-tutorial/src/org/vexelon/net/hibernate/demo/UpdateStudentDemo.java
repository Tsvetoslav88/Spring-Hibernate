package org.vexelon.net.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: PK
			System.out.println("\nGetting student with id: " +studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstName("Scooby");
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email of all students to @gmail
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// commit the transaction
						session.getTransaction().commit();
			
			System.out.println("Done");			
			
		}finally {
			factory.close();
		}

	}

}
