package com.luv2code.springboot.demo.springbootcruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.demo.springbootcruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.demo.springbootcruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    @Qualifier("employeeDAOJpaImpl")
//    private EmployeeDAO theEmployeeDAO;

    @Autowired
    private EmployeeRepository repository;
    
    @Override
    @Transactional
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> employee = repository.findById(theId);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

}
