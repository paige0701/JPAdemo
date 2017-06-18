package com.example.jpa.service;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
import com.example.jpa.repository.OneToManyManyToOne.OrderEntity;
import com.example.jpa.repository.OneToManyManyToOne.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 전체 주문 목록 보기
     * @return Result 주문 목록
     */
    public List<OrderEntity> findAll(){
        List<OrderEntity> result = _orderRepository.findAll();
        return result;

    } // End of Method - findAll

    /**
     * 한명의 오더 목록 보기
     * @return Result 주문 목록
     */
    public List<OrderEntity> findOne(String id){
        MemberEntity member = _memberRepository.findOne(id);
        List<OrderEntity> order = member.getOrders();
        return order;

    } // End of Method - FindOne

    /**
     * 오더 추가하기
     * @return Result 추가한 오더 목록
     */
    public MemberEntity register(String id, OrderEntity order){


        // 받아온 아이디로 멤버를 조회한다
        MemberEntity member = _memberRepository.findOne(id);
        // findOne, getOne 차이를 알아야할듯


        // 오더에 위에 받아온 멤버를 받아온다
        order.setMember(member);

        ArrayList<OrderEntity> orderList = new ArrayList<>();

        // 리스트에 받아온 오더를 add한다
        orderList.add(order);

        // 멤버에 오더 리스트를 넣는다
        member.setOrders(orderList);

        // member,order repository 에 저장한다
        _orderRepository.save(orderList);
        _memberRepository.save(member);


        return member;

    } // End of Method - Register

    /**
     * 오더 수정하기
     * @return Result 수정한 오더 목록
     */
    public void modify(String id, OrderEntity order){


    } // End of Method - Modify

    /**
     * 특정 오더 지우기
     */
    public void remove(String id){

    } // End of Method - Remove




}
