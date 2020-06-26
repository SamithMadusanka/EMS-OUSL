package com.samith.employeems.repository.employee;

import com.samith.employeems.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
