package org.example;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "supplier")
public class supplier {

    @Id
    long supplier_id;


    String supplier_name;

    String supplier_adress;

    @OneToMany(mappedBy = "supplier")
    List<delivery> deliveries;


}
