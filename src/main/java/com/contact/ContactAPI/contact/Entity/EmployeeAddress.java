package com.contact.ContactAPI.contact.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Getter @Setter @NoArgsConstructor
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    private Employee employee;

    private String street;

    private String city;

    private String state;

    private String zip;

}
