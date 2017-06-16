package com.example.jpa.controller;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 회원 정보 등록하기
     *
     * @param id
     * @param memberInfo
     * @return
     */


    // 회원 정보 업데이트하기
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Object modify(@PathVariable(value = "id") String id, @RequestBody MemberEntity memberInfo){


        List<MemberEntity> result = new ArrayList<>();
        /**
         * @PathVariable 은  url
         *
         */

        return result;
    }



}
