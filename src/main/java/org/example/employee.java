package org.example;

import java.sql.Date;

import java.util.List;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "employee")
public class employee {
    Date emp_datein;
    Float emp_salary;

    String emp_status;

    @Id
    long emp_id;

    @OneToOne
    @JoinColumn(name = "SSN", referencedColumnName = "SSN")
    org.example.person person;

    @OneToMany(mappedBy = "employee")
     List<delivery> deliveries;

    @OneToMany(mappedBy = "employee")
     List<stockin> stockins;

    @OneToMany(mappedBy = "employee")
     List<stockused> stockuseds;

    @OneToMany(mappedBy = "employee")
     List<payment> payments;




}
