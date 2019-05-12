package org.vexelon.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vexelon.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
