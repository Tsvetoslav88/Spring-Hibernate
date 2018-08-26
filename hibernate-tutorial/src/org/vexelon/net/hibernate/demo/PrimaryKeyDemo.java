package org.vexelon.net.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) throws ParseException {
		
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
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent1 = new Student("Ivan", "Ivanov", "Ivan@abv.bg",theDateOfBirth);
			Student tempStudent2 = new Student("Mitko", "Petrov", "Mitko@abv.bg",theDateOfBirth);
			Student tempStudent3 = new Student("Petrov", "Patrov", "Petar@abv.bg",theDateOfBirth);

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
