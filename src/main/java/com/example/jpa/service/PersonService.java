package com.example.jpa.service;

import com.example.jpa.repository.OneToOne.PersonEntity;
import com.example.jpa.repository.OneToOne.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@Service
public class PersonService {

    // Using autowire to use the PersonRepository
    @Autowired
    private PersonRepository personRepository;

    // Selecting everything from PersonRepository
    public List<PersonEntity> getList(){


        // Using .findAll method to retrieve everything from personRepo
        List<PersonEntity> personList = personRepository.findAll();

        // returning the selected ones
        return personList;
    }


    // Getting only the selected one row from personRepository
    public PersonEntity getSelectedList(String id){

        // Using Person ID to retrieve one specific person information for Person Repo
        PersonEntity person  = personRepository.findOne(id);

        return person;

    }












}

