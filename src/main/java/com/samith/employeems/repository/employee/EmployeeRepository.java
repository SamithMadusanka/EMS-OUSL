package com.samith.employeems.repository.employee;

import com.samith.employeems.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT s FROM Employee s WHERE s.supervisor.employeeId=?1")
    List<Employee> findBySupervisorId(int supervisorId);

}
