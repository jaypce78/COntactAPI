package com.contact.ContactAPI.contact.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contact.ContactAPI.contact.Entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}