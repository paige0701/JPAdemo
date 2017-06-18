package com.example.jpa.controller;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
import com.example.jpa.repository.OneToManyManyToOne.OrderEntity;
import com.example.jpa.service.MemberService;
import com.example.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paige on 16/6/17.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public OrderController() {
    }

    @Autowired
    MemberService _memberService;

    @Autowired
    MemberRepository _memberRepository;

    @Autowired
    OrderService _orderService;

    // 오더 정보를 가지고 온다
    @RequestMapping(method = RequestMethod.GET)
    public List<OrderEntity> find() {

        List<OrderEntity> result = _orderService.findAll();

        return result;
    }

    // 한명의 오더정보를 가지고온다
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<OrderEntity> findOne(@PathVariable(value = "id")String id){
        List<OrderEntity> result = _orderService.findOne(id);
        return result;
    }

    // 오더 하나를 인서트한다
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public MemberEntity register(@PathVariable(value = "id")String id, @RequestBody OrderEntity orders){


        MemberEntity result = _orderService.register(id, orders);
        return result;


    }


}
