package com.example.jpa.service;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
import com.example.jpa.repository.OneToManyManyToOne.OrderEntity;
import com.example.jpa.repository.OneToManyManyToOne.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@Service
public class OrderService {



    @Autowired
    MemberRepository _memberRepository;

    @Autowired
    OrderRepository _orderRepository;

    // 전체 주문 정보 불러오기
    public List<OrderEntity> findAll(){
        List<OrderEntity> result = _orderRepository.findAll();
        return result;


    }

    // 특정 한명의 오더 정보 불러오기
    public List<OrderEntity> findOne(String id){
        MemberEntity member = _memberRepository.getOne(id);
        List<OrderEntity> order = member.getOrders();
        return order;


    }

    // 오더 추가하기
    public MemberEntity register(String id, OrderEntity order){


        // 조회해서 아이디로
        MemberEntity member = _memberRepository.getOne(id);

        // 오더에 .. 멤버도 넣어줘야됨..
        order.setMember(member);

        // 오더 넣고
        ArrayList<OrderEntity> orderList = new ArrayList<>();
        orderList.add(order);

        member.setOrders(orderList);

        _memberRepository.save(member);

        return member;

    }

    // 한개의 오더 업데이트하기
    public void modify(String id, OrderEntity order){

    }

    // 한개의 오더 지우기
    public void remove(String id){

    }




}
