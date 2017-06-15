package com.example.jpa.repository.JPA;

import javax.persistence.*;

/**
 * Created by Paige on 6/15/17.
 */
@Entity
@Table(name="R_WORK_SAVE") //Table name in Capital letters
public class WorkSaveRelation {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="work_id")
    private WorkEntity work;


}
