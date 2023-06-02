package org.example;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shoe")

public class shoe {


    @Id
    long shoe_id;

    String shoe_brand;
    Float shoe_cost;
    String shoe_gender;
    int shoe_size;
    String shoe_color;
    String shoe_type;
    int shoe_qty;

    @OneToMany(mappedBy = "shoe" )
     List<stockin> stockins;

    @OneToMany(mappedBy = "shoe" )
     List<stockused> stockuseds;



}
