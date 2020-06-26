package com.samith.employeems.service;

import com.samith.employeems.dto.employee.EmployeeDTO;
import com.samith.employeems.dto.employee.EmployeeFamilyDTO;
import com.samith.employeems.exception.EmployeeMSException;
import com.samith.employeems.model.department.Department;
import com.samith.employeems.model.employee.Employee;
import com.samith.employeems.model.employee.EmployeeFamily;
import com.samith.employeems.repository.department.DepartmentRepository;
import com.samith.employeems.repository.employee.EmployeeFamilyRepository;
import com.samith.employeems.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeFamilyRepository employeeFamilyRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeFamilyRepository employeeFamilyRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeFamilyRepository = employeeFamilyRepository;
        this.departmentRepository = departmentRepository;
    }


    public void saveEmployee(EmployeeDTO employeeDTO) {
        try {
            Employee employee = convertToEmployee(employeeDTO);
            employeeRepository.save(employee);
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
            List<EmployeeFamily> byEmployeeId = employeeFamilyRepository.findByEmployeeId(employeeId);
            if (!byEmployeeId.isEmpty()) {
                employeeFamilyRepository.deleteAll(byEmployeeId);
            }
            employeeRepository.delete(byId.get());
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee removing failed");
        }
    }


    public EmployeeDTO findByEmployeeId(int employeeId) {
        try {
            Optional<Employee> byId = employeeRepository.findById(employeeId);
            if (!byId.isPresent()) throw new EmployeeMSException("Employee not found");
            EmployeeDTO employeeDTO = convertToEmployeeDTO(byId.get());
            List<EmployeeFamily> byEmployeeId = employeeFamilyRepository.findByEmployeeId(employeeId);
            if (byEmployeeId.isEmpty()) return employeeDTO;
            List<EmployeeFamilyDTO> familyDTOS = new ArrayList<>();
            for (EmployeeFamily employeeFamily : byEmployeeId) {
                familyDTOS.add(convertToEmployeeFamilyDTO(employeeFamily));
            }
            employeeDTO.setFamilyDetails(familyDTOS);
            return employeeDTO;
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee finding failed");
        }
    }

    public void saveEmployeeFamily(EmployeeFamilyDTO employeeFamilyDTO) {
        try {
            Optional<Employee> byId = employeeRepository.findById(employeeFamilyDTO.getEmployeeId());
            if (!byId.isPresent()) throw new EmployeeMSException("Employee not found");
            EmployeeFamily employeeFamily = convertToEmployeeFamily(employeeFamilyDTO);
            employeeFamily.setEmployee(byId.get());
            employeeFamilyRepository.save(employeeFamily);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee family detail saving failed");
        }
    }

    public void updateEmployeeFamily(EmployeeFamilyDTO employeeFamilyDTO) {
        try {
            Optional<EmployeeFamily> byId = employeeFamilyRepository.findById(employeeFamilyDTO.getFamilyMemberId());
            if (!byId.isPresent()) throw new EmployeeMSException("Employee family not found");
            EmployeeFamily employeeFamily = convertToEmployeeFamily(employeeFamilyDTO);
            employeeFamily.setFamilyMemberId(employeeFamilyDTO.getFamilyMemberId());
            employeeFamily.setEmployee(byId.get().getEmployee());
            employeeFamilyRepository.save(employeeFamily);
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee family updating failed");
        }
    }

    public void removeEmployeeFamily(int employeeFamilyId) {
        try {
            Optional<EmployeeFamily> byId = employeeFamilyRepository.findById(employeeFamilyId);
            if (!byId.isPresent()) throw new EmployeeMSException("Employee family not found");
            employeeFamilyRepository.delete(byId.get());
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Employee family detail removing failed");
        }
    }

    public void assignDepartment(int employeeId, int departmentId) {
        try {
            Optional<Employee> byEmpId = employeeRepository.findById(employeeId);
            if (!byEmpId.isPresent()) throw new EmployeeMSException("Employee not found");
            Optional<Department> byDptId = departmentRepository.findById(departmentId);
            if (!byDptId.isPresent()) throw new EmployeeMSException("Department not found");
            Employee employee = byEmpId.get();
            employee.setDepartment(byDptId.get());
            employeeRepository.save(employee);
        } catch (EmployeeMSException e) {
            e.printStackTrace();
            throw new EmployeeMSException("Department assigning attempt failed");
        }
    }

    private Employee convertToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setContactNumber(employeeDTO.getContactNumber());
        employee.setEmail(employeeDTO.getEmail());
        Optional<Department> byId = departmentRepository.findById(employeeDTO.getDepartmentId());
        byId.ifPresent(employee::setDepartment);
        return employee;
    }

    private EmployeeFamily convertToEmployeeFamily(EmployeeFamilyDTO employeeFamilyDTO) {
        EmployeeFamily employeeFamily = new EmployeeFamily();
        employeeFamily.setFamilyMemberName(employeeFamilyDTO.getFamilyMemberName());
        employeeFamily.setContactNumber(employeeFamilyDTO.getContactNumber());
        employeeFamily.setMemberType(employeeFamilyDTO.getMemberType());
        return employeeFamily;
    }

    private EmployeeFamilyDTO convertToEmployeeFamilyDTO(EmployeeFamily employeeFamily) {
        EmployeeFamilyDTO employeeFamilyDTO = new EmployeeFamilyDTO();
        employeeFamilyDTO.setFamilyMemberId(employeeFamily.getFamilyMemberId());
        employeeFamilyDTO.setFamilyMemberName(employeeFamily.getFamilyMemberName());
        employeeFamilyDTO.setContactNumber(employeeFamily.getContactNumber());
        employeeFamilyDTO.setMemberType(employeeFamily.getMemberType());
        return employeeFamilyDTO;
    }

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setContactNumber(employee.getContactNumber());
        employeeDTO.setEmail(employee.getEmail());
        if (employee.getDepartment() != null) {
            employeeDTO.setDepartmentId(employee.getDepartment().getDepartmentId());
            employeeDTO.setDepartmentName(employee.getDepartment().getDepartmentName());
        }
        return employeeDTO;
    }

}
