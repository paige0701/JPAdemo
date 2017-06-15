package com.example.jpa;

import com.example.jpa.repository.OneToOne.CellularEntity;
import com.example.jpa.repository.OneToOne.CellularRepository;
import com.example.jpa.repository.OneToOne.PersonEntity;
import com.example.jpa.repository.OneToOne.PersonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Paige on 6/14/17.
 */
@Transactional
@Rollback
public class OneToOneTest extends DemoApplicationTests {

    @Autowired
    PersonRepository personrepo;

    @Autowired
    CellularRepository cellularrepo;

    @Test
    public void testingOneToOne() throws Exception{


        // Creating an object of CellularEntity Class using new keyword.
        CellularEntity cellular = new CellularEntity();

        // now I can set value in object referencing
        cellular.setNumber("3");

        // Save the object to CellularRepository
        cellularrepo.save(cellular);


        // Creating an object of PersonEntity Class using new keyword
        PersonEntity person = new PersonEntity();

        // Setting value into an object
        person.setName("Paige");

        // Set cellularEntity in to an object
        person.setCellular(cellular);

        // save it !
        personrepo.save(person);

        // Check if the value cellular id from person class matches id from cellular class
        Assert.assertEquals(person.getCellular().getId(), cellular.getId());






    }

}
