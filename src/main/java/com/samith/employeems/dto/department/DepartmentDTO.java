package com.samith.employeems.dto.department;

/**
 * @author - Anuradha Ranasinghe on 2020-06-27
 * @project - employee-ms
 **/
public class DepartmentDTO {

    private int departmentId;
    private String departmentName;

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
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
}
