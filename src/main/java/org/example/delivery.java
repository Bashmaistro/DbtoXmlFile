package org.example;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

import java.sql.Timestamp;
import java.time.LocalTime;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "delivery")
public class delivery {


    @Id
    long delivery_id;

    Date delivery_date;

    Timestamp delivery_time;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    org.example.supplier supplier;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    org.example.employee employee;


}
