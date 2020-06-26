package com.samith.employeems.repository;

import com.samith.employeems.model.EmployeeFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public interface EmployeeFamilyRepository extends JpaRepository<EmployeeFamily, Integer> {

    @Query("SELECT f FROM EmployeeFamily f WHERE f.employee.employeeId=?1")
    List<EmployeeFamily> findByEmployeeId(int employeeId);

}
