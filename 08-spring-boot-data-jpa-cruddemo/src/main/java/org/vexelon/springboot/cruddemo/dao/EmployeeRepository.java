package org.vexelon.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vexelon.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
