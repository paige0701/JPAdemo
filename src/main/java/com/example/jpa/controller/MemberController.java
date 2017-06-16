package com.example.jpa.controller;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by paige on 16/6/17.
 * /Users/Paige/Desktop/spring/JPAdemo/target/demo-0.0.1-SNAPSHOT.jar
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController {


    @Autowired
    MemberService _memberService;



    // 전체 회원 정보 조회
    @RequestMapping(method= RequestMethod.GET)
    public Object find(){

        List<MemberEntity> result = _memberService.findAll();

        return result;
    }


    // 특정 회원 정보 조회
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object find(@PathVariable( value = "id" ) String id ) {

        MemberEntity result = _memberService.findOne(id);

        return result;
    }


    // 회원 정보 등록
    @RequestMapping(method = RequestMethod.POST)
    public Object register(@RequestBody MemberEntity member){

        MemberEntity list = new MemberEntity();
        list.setAddress(member.getAddress());
        list.setName(member.getName());
        list.setId(member.getId());

        MemberEntity result = _memberService.register(list);

        return result;

    }


    // 회원 정보 업데이트하기
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Object modify(@PathVariable(value = "id") String id, @RequestBody MemberEntity memberInfo){

        MemberEntity result = _memberService.modify(id,memberInfo);

        return result;
    }


    // 특정 회원 지우기
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Object remove(@PathVariable(value="id") String id){

        _memberService.remove(id);
        List<MemberEntity> result = _memberService.findAll();
        return result;
    }




}
