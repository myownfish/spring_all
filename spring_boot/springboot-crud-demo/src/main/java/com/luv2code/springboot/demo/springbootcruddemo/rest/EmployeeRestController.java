package com.luv2code.springboot.demo.springbootcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.springbootcruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;
import com.luv2code.springboot.demo.springbootcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    EmployeeService theEmployeeService;
    
    @GetMapping("/employees")
//    @ResponseBody
    public List<Employee> findAll() {
        return theEmployeeService.findAll();
    }
    
    @GetMapping("/employees/{theId}")
    public Employee getById(@PathVariable int theId) {
        return theEmployeeService.findById(theId);
    }
    
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee ) {
        return theEmployeeService.save(theEmployee);
    }
    
    @DeleteMapping("/employees/{theId}")
    public void delete(@PathVariable int theId) {
        theEmployeeService.deleteById(theId);
    }
    
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee) {
        theEmployeeService.save(theEmployee);
        return theEmployee;
    }
}
