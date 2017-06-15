package com.example.jpa.repository.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Paige on 6/14/17.
 */

@Entity
@Table(name = "cellular")
public class CellularEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(name = "cellular_id")
    private String id;

    @Column(name="number", columnDefinition="varchar(100)")
    private String number;



    // getter & setter (highlight and generate getter & setter)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
