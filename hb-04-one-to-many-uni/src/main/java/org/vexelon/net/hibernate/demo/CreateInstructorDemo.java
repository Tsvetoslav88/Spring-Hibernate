package org.vexelon.net.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Course;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) throws ParseException {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
            
			// create the objects
			Instructor tempInstructor = new Instructor("Ivan", "Ivanov", "iva@abv.bg");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Video Game");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
					
			// save the instructor
			//NOTE: this will ALSO save the detail object
			// because of CascadeType
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}

	}

}
