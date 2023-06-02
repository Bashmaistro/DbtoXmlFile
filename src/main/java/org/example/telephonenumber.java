package org.example;



import javax.persistence.*;

@Entity
@Table(name = "telephonenumber")
public class telephonenumber {


    @Id
    long telephone;

    @OneToOne
    @JoinColumn(name = "SSN" ,referencedColumnName = "SSN")
    person person;

    public void setTelephone(Long id) {
        this.telephone = id;
    }

    public Long getTelephone() {
        return telephone;
    }
}
