package com.blackbox.springboot.crudappdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.springboot.crudappdemo.entity.Employee;

@Repository
public interface EmployeeDAOSpringHJPARepository extends JpaRepository<Employee, Integer> {

}
