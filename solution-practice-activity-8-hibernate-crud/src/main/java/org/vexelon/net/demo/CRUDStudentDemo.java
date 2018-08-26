package org.vexelon.net.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vexelon.net.demo.entity.Employee;

public class CRUDStudentDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		
		try {
			//create Session for objects creation
			Session session = factory.getCurrentSession();
			
			// create Employee objects
			System.out.println("Creating of employee objects");
			Employee employee1 = new Employee("Ivan", "Ivanov", "X");
			Employee employee2 = new Employee("Petar", "Petrov", "Y");
			Employee employee3 = new Employee("Dimitar", "Dimitrov", "X");
			
			// start a transaction
			session.beginTransaction();
			
			// save the Employee objects
			System.out.println("Save the employees...");
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			// commit transaction
			session.getTransaction().commit();
			
			///////////////////////////////////////////
			
			//  get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: PK
			System.out.println("\nGetting Employee with id: " + employee1.getId());
			Employee theEmployee = session.get(Employee.class, employee1.getId());
			
			System.out.println("Get complete: " + theEmployee);
			
			session.getTransaction().commit();
			
			
			/////////////////////////////////////////
			
			// get a new session for find employees for a given company
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee for company X
			System.out.println("\nGetting Employees in company X");
			List<Employee> employeesInXCompany = session.createQuery("from Employee e where e.company = 'X'").getResultList();
			
			for (Employee employee : employeesInXCompany) {
				System.out.println(employee);
			}
			
			
			session.getTransaction().commit();

			//////////////////////////////////////////
			
			// delete an object with PK 3
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete object id=3
			System.out.println("\nDeleting employee id=3");
			session.createQuery("delete from Employee where id=3").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");

		}finally {
			factory.close();
		}
	}
}
