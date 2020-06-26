package com.samith.employeems.repository.department;

import com.samith.employeems.model.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author - Anuradha Ranasinghe on 2020-06-27
 * @project - employee-ms
 **/
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
