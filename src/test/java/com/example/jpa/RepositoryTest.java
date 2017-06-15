package com.example.jpa;

import com.example.jpa.repository.Testing.TestEntity;
import com.example.jpa.repository.Testing.TestRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Paige on 6/13/17.
 */
@Transactional
@Rollback
public class RepositoryTest extends DemoApplicationTests {

    @Autowired
    TestRepository _test;

    @Test
    public void test() throws Exception{


        // Checking if list is null or not
        List<TestEntity> list = _test.findAll();
        assertNotNull(list);

        TestEntity tn = new TestEntity();
        tn.setContent("Hello!!!!");

        // Trying insert
        TestEntity a = _test.save(tn);
        assertSame("Hello!!!!",a.getContent());

        // Trying update
        tn.setContent("Bye !!");
        a = _test.save(tn);
        assertEquals("Bye !!", a.getContent());

        // Trying deleting all
        _test.deleteAll();



    }




}
