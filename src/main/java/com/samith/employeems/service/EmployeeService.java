package com.samith.employeems.service;

import com.samith.employeems.dto.EmployeeDTO;
import com.samith.employeems.exception.EmployeeMSException;
import com.samith.employeems.model.Employee;
import com.samith.employeems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void saveEmployee(EmployeeDTO employeeDTO) {
        try {
            employeeRepository.save(convertToEmployee(employeeDTO));
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee saving failed");
        }
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        try {
            Optional<Employee> byId = employeeRepository.findById(employeeDTO.getEmployeeId());
            if (!byId.isPresent()) throw new EmployeeMSException("Employee not found");
            Employee employee = convertToEmployee(employeeDTO);
            employee.setEmployeeId(byId.get().getEmployeeId());
            employeeRepository.save(employee);
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee updating failed");
        }
    }

    public void removeEmployee(int employeeId) {
        try {
            Optional<Employee> byId = employeeRepository.findById(employeeId);
            if (!byId.isPresent()) throw new EmployeeMSException("Employee not found");
            employeeRepository.delete(byId.get());
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee removing failed");
        }
    }

    private Employee convertToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setContactNumber(employeeDTO.getContactNumber());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setContactNumber(employee.getContactNumber());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    public EmployeeDTO findByEmployeeId(int employeeId) {
        try {
            Optional<Employee> byId = employeeRepository.findById(employeeId);
            if (!byId.isPresent()) throw new EmployeeMSException("Employee not found");
            return convertToEmployeeDTO(byId.get());
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee finding failed");
        }
    }
}
