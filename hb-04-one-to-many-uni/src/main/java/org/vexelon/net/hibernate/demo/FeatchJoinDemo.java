package org.vexelon.net.hibernate.demo;

import java.text.ParseException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vexelon.net.hibernate.demo.entity.Course;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;


public class FeatchJoinDemo {

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
            
			//option 2: Hibernate query with HQL
			// start a transaction
			session.beginTransaction();
					
			// get the instructor from db
			int theId = 1;
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);
			
			//Set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("LazyEager Instructor: " + tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			// add clean up code
			session.close();
			
			System.out.println("Session is closed!\n");
			
			// get course for the instructor
			System.out.println("LazyEager: Courses: " + tempInstructor.getCourses());			
			
			System.out.println("LazyEager Done");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}

	}

}
