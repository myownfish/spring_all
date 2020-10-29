package com.luv2code.springboot.demo.springbootcruddemo.service;

import java.util.List;

import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee save(Employee employee);

    public void deleteById(int id);

    public Employee findById(int theId);

}
