package org.vexelon.net.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Course;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
            
			
			// start a transaction
			session.beginTransaction();
					
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("LazyEager Instructor: " + tempInstructor);
			
			// get course for the instructor
			System.out.println("LazyEager Courses: " + tempInstructor.getCourses());

			
			//commit transaction
			session.getTransaction().commit();
			
			// add clean up code
			session.close();
			
			System.out.println("Session is closed\n!");
			// option 1: call getter method while session is open
			
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
