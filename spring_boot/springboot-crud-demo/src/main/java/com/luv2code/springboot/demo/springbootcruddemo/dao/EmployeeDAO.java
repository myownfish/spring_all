package com.luv2code.springboot.demo.springbootcruddemo.dao;

import java.util.List;

import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee save(Employee employee);
    public void deleteById(int id);
    public Employee findById(int theId);
}
