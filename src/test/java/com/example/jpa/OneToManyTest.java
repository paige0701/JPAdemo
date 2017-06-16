//package com.example.jpa;
//
//import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
//import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
//import com.example.jpa.repository.OneToManyManyToOne.OrderEntity;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@Rollback
//public class OneToManyTest extends DemoApplicationTests{
//
//    @Autowired
//    private MemberRepository orderRepository;
//    @Test
//    public void oneToManyAndManyToOneTest() {
//        OrderEntity order = new OrderEntity();
//        order.setItem("item");
//        order.setPrice(1000);
//        order.setCnt(1);
//
//        List<OrderEntity> orderList = new ArrayList<OrderEntity>();
//        orderList.add(order);
//
//        MemberEntity member = new MemberEntity();
//        member.setAddress("주소");
//        member.setName("Name");
//        member.setOrders(orderList);
//        orderRepository.save(member);
//
//        Assert.assertEquals(member.getOrders().get(0).getOrderId(), order.getOrderId());
//    }
//}