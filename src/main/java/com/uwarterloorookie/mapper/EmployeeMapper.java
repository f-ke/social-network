package com.uwarterloorookie.mapper;


import com.uwarterloorookie.bean.Employee;

//@Mapper
public interface EmployeeMapper {
    public Employee getEmployeeById(int id);
    public void insertEmp(Employee employee);

}
