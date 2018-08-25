package org.vexelon.net.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Student;

public class PrimaryKeyDema {

	public static void main(String[] args) {
		
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("Creating 2 student objects");
			Student tempStudent1 = new Student("Ivan", "Ivanov", "Ivan@abv.bg");
			Student tempStudent2 = new Student("Mitko", "Petrov", "Mitko@abv.bg");
			Student tempStudent3 = new Student("Petrov", "Patrov", "Petar@abv.bg");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students..");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}
	}

}
