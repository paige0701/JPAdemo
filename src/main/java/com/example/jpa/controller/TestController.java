package com.example.jpa.controller;

import com.example.jpa.repository.OneToOne.PersonEntity;
import com.example.jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@RestController
public class TestController {


    @Autowired
    PersonService _service;


    @RequestMapping("/")
    public Object testing(){


        // Using _Service to use the .getList method
        List<PersonEntity> a = _service.getList();

        // Just testing if the above method works
//        for(PersonEntity b : a){
//            System.out.print("now!! = ");
//            System.out.println(b.getName());
//        }


        // Trying out .getSelectedList using PersonId
//        PersonEntity onePerson = _service.getSelectedList("001");
//        System.out.print(onePerson.getName());




        return a;

    }
}
