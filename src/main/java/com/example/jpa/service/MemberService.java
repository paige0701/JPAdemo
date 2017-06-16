package com.example.jpa.service;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Paige on 6/14/17.
 */
@Service
public class MemberService {

    /**
     *  MemberService라는 Class안에 Member에 관한 Methods 를 정의했다
     *  여기서 MemberService는 Class로 정의했지만 interface로 한다면 아래에 있는 method를 추상메소드로 한들고
     *  Implements 라는 파일에서 Service를 implement해서 사용하고 추상메소드를 오버라이딩해서 사용할수도 있다
     *
     * @return
     */

    @Autowired
    MemberRepository _memberRempository;

    // 전체 회원 목록 조회
    public List<MemberEntity> findAll(){

        List<MemberEntity> result = _memberRempository.findAll();


        return result;
    }


    // 한명의 회원 정보 조회
    public MemberEntity findOne(String id){

        MemberEntity result = _memberRempository.findOne(id);
        return result;

    }

    // 회원 등록하기
    public List<MemberEntity> register(){
        return null;
    }

    // 회원 정보 수정
    public List<MemberEntity> modify(){
        return null;
    }

    //한명 회원 정보 지우기
    public void remove(){}

}

