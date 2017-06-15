package com.example.jpa.repository.Testing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Paige on 6/13/17.
 */
@Entity
@Table(name="test")
public class TestEntity {


    @Id
    @Column(name="content", columnDefinition="varchar(100)", nullable=false)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
