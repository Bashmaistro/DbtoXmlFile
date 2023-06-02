package org.example;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "stockused")
public class stockused {
    @Id
    long stckused_id;

    Date stckused_date;



    int stckused_qty;

    @ManyToOne
    @JoinColumn(name = "shoe_id")
     shoe shoe;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    org.example.employee employee;

    public int getStckused_qty() {
        return stckused_qty;
    }
}
