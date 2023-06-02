package org.example;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "payment")
public class payment {
    @Id
    long payment_id;

    Date payment_date;

    float payment_amt;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    org.example.customer customer;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    org.example.employee employee;
}
