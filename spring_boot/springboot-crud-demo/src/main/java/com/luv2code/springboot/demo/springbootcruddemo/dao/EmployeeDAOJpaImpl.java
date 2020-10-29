package com.luv2code.springboot.demo.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    EntityManager theEntityManager;
    
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = theEntityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee save(Employee employee) {

        Employee theEmployee = theEntityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        Query query = theEntityManager.createQuery("delete from Employee where id = :employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public Employee findById(int theId) {

        return theEntityManager.find(Employee.class, theId);
    }

}
