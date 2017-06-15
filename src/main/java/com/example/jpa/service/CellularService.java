package com.example.jpa.service;

import com.example.jpa.repository.OneToOne.CellularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Paige on 6/14/17.
 */
@Service
public class CellularService {

    @Autowired
    CellularRepository _cellrepo;


}
