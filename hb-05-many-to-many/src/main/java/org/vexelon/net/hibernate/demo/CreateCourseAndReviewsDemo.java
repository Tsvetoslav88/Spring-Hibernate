package org.vexelon.net.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.hibernate.demo.entity.Course;
import org.vexelon.net.hibernate.demo.entity.Instructor;
import org.vexelon.net.hibernate.demo.entity.InstructorDetail;
import org.vexelon.net.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
					
			// crate a course
			Course theCourse = new Course("Pacman");
			
			// add some reviews 
			theCourse.addReview(new Review("Great course ... loved it"));
			theCourse.addReview(new Review("Cool course, job well done"));
			theCourse.addReview(new Review("What a dumb course, you are an idiot"));
			
			// save the courses .. and leverage cascade all
			System.out.println("Saving the course");
			System.out.println(theCourse);
			session.save(theCourse);
		
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
