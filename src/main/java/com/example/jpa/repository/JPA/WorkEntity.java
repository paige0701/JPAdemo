package com.example.jpa.repository.JPA;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Paige on 6/15/17.
 */
@Entity
@Table(name="T_WORK")
public class WorkEntity {

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Private Variables
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="name")
    private String name;

}
