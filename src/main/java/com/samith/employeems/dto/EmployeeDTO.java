package com.samith.employeems.dto;

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
    private List<EmployeeFamilyDTO> familyDetails;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", familyDetails=" + familyDetails +
                '}';
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
