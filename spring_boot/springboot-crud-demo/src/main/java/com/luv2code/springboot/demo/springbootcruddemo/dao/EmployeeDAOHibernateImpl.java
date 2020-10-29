package com.luv2code.springboot.demo.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.springbootcruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = currentSession.createQuery(
                "from Employee", Employee.class);
        
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee save(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);
        
        currentSession.saveOrUpdate(employee);
        
        return employee;
    }



    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);
        
        Query theQuery = currentSession.createQuery(
                "delete from Employee where id = :employeeId");
        
        theQuery.setParameter("employeeId", id);
        theQuery.executeUpdate();
    }

    @Override
    public Employee findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);
        
        Employee theEmployee = currentSession.get(Employee.class, theId);
        
        return theEmployee;
    }

    
    
    
    
    
    
    
    
}
