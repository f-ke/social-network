package com.uwarterloorookie.bean;


import org.springframework.beans.factory.annotation.Value;


public class Department {

    private  int id;
    private String departmentName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
