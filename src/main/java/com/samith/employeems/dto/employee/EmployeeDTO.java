package com.samith.employeems.dto.employee;

import com.samith.employeems.dto.department.DepartmentDTO;

import java.util.List;

/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private String contactNumber;
    private int departmentId;
    private String departmentName;
    private List<EmployeeFamilyDTO> familyDetails;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", familyDetails=" + familyDetails +
                '}';
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeFamilyDTO> getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(List<EmployeeFamilyDTO> familyDetails) {
        this.familyDetails = familyDetails;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
