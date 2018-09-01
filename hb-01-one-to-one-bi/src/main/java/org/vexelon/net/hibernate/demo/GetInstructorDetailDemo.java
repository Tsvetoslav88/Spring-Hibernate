package org.vexelon.net.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) throws ParseException {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
            
			
			// start a transaction
			session.beginTransaction();
					

			// get instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor 
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}

	}

}
