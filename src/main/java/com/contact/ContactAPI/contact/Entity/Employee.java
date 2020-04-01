package com.contact.ContactAPI.contact.Entity;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="EMP_ID")
    private Long id;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "employee")
    private EmployeeName employeeName;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "employee")
    private EmployeeAddress employeeAddress;

    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
    private List<PhoneContact> phoneNumbersWithType;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "employee")
    private Email email;


}