package org.vexelon.net.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating a new student object");
			Student tempStudent = new Student("Daffy", "Duck", "Daffy@abv.bg");
			
			// start a transaction
			session.beginTransaction();
					
			// save the student object
			System.out.println("Saving the student..");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			// find out student's id: PK
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: PK
			System.out.println("\nGetting student with id: " +tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			// commit the transaction
			
			System.out.println("Done");
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
