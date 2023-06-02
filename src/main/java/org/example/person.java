package org.example;



import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table(name = "person")
public class person {

    @Id
    long SSN;
    String person_Adress;
    String person_Fname;

    java.lang.String person_Mname;
    String person_Lname;
    String person_Gender;
    Date person_Bdate;

    @OneToOne
    @JoinColumn(name = "telephone" ,referencedColumnName = "telephone")
     telephonenumber telephone;

    @OneToOne(mappedBy = "person" ,fetch = FetchType.EAGER)
    org.example.customer customer;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER)
    org.example.employee employee;












}
