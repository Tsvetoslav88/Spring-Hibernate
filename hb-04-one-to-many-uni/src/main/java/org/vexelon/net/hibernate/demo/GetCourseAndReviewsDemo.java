package org.vexelon.net.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Course;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;
import org.vexelon.net.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) throws ParseException {
		// create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		
		// create Session
		Session session = factory.getCurrentSession();
		
		try {
            
			
			// start a transaction
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course theCourse = session.get(Course.class, theId);
		
			// print the course
			System.out.println(theCourse);
					
			// print the reviews
			System.out.println(theCourse.getReviews());
					
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
