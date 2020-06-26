package com.samith.employeems.model;

import javax.persistence.*;


/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
@Entity
public class EmployeeFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int familyMemberId;
    private String familyMemberName;
    private String contactNumber;
    private String memberType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public int getFamilyMemberId() {
        return familyMemberId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setFamilyMemberId(int familyMemberId) {
        this.familyMemberId = familyMemberId;
    }

    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
