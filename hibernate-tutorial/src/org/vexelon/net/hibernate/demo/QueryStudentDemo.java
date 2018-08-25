package org.vexelon.net.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
					
			// query the students 
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			
			// display the students
			displayStudents(theStudent);
			
			// query students: lastname='Patrov'
			theStudent = session.createQuery("from Student s where s.lastName = 'Patrov'").getResultList();

			// display the students
			System.out.println("\n\nStudents who have last name of Patrov");
			displayStudents(theStudent);
			
			// query students: lastname='Patrov' or firstName='Ivan'
			theStudent = session.createQuery("from Student s where s.lastName = 'Patrov' or s.firstName='Ivan'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Patrov Or first name of Ivan");
			displayStudents(theStudent);
			
			// query students where email  LIKE '%abv.bg'
			theStudent = session.createQuery("from Student s where s.email LIKE '%abv.bg'").getResultList();
						
			// display the students
			System.out.println("\n\nStudents who  email ends with @abv.bg");
			displayStudents(theStudent);

			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student student : theStudent) {
			System.out.println(student);
		}
	}

}
