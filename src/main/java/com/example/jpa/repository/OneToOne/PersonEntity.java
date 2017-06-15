package com.example.jpa.repository.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Paige on 6/14/17.
 */
@Entity
@Table(name="Person")
public class PersonEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(name="person_id")
    private String personId;

    @Column(name="name", columnDefinition="varchar(100)")
    private String name;


    @OneToOne // This is how we specify the One to One relationships
    @JoinColumn(name="cellular_id") // Specify which column you want to relate
    private CellularEntity cellular;


    // getters and setters
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CellularEntity getCellular() {
        return cellular;
    }

    public void setCellular(CellularEntity cellular) {
        this.cellular = cellular;
    }


}
