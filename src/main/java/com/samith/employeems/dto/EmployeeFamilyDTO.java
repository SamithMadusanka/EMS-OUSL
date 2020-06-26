package com.samith.employeems.dto;


/**
 * @author - Samith Madusanka on 2020-06-27
 * @project - employee-ms
 **/
public class EmployeeFamilyDTO {
    private int familyMemberId;
    private int employeeId;
    private String familyMemberName;
    private String contactNumber;
    private String memberType;


    @Override
    public String toString() {
        return "EmployeeFamilyDTO{" +
                "familyMemberId=" + familyMemberId +
                ", familyMemberName='" + familyMemberName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", memberType='" + memberType + '\'' +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getFamilyMemberId() {
        return familyMemberId;
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
