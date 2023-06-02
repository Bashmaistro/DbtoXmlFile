package org.example;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "stockin")
public class stockin {



    @Id
    long stckin_id;

    Date stckin_date;



    int stckin_qty;

    @ManyToOne
    @JoinColumn(name = "shoe_id")
     shoe shoe;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    org.example.employee employee;
    public int getStckin_qty() {
        return stckin_qty;
    }

}
