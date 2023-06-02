package org.example;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "customer")
public class customer {

    @Id
    long cust_id;

    @OneToOne
    @JoinColumn(name = "SSN", referencedColumnName = "SSN")
    org.example.person person;

    @OneToMany(mappedBy = "customer")
     List<payment> payments;







}
