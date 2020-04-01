package com.contact.ContactAPI.contact.RestController;

import java.util.List;

import com.contact.ContactAPI.contact.Entity.Employee;
import com.contact.ContactAPI.contact.Exception.EmployeeException;
import com.contact.ContactAPI.contact.Exception.EmployeesNotFoundException;
import com.contact.ContactAPI.contact.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/contacts")
    public List<Employee> getEmployees() throws EmployeesNotFoundException {
        List<Employee> employees = employeeService.retrieveEmployees();

        if(employees == null){
            throw new EmployeesNotFoundException("Employees data is not available");
        }
        return employees;
    }

    @GetMapping("/contacts/hello")
    public String test() {

        return "test";
    }

    @GetMapping("/contacts/{id}")
    public Employee getEmployee(@PathVariable(name="id")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/contacts")
    public ResponseEntity saveEmployee(@RequestBody Employee employee) throws EmployeeException {

        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Success Fully Added", HttpStatus.OK);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteEmployee(@PathVariable(name="id")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    @PutMapping("/contacts/{id}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="id")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
        }

    }

}