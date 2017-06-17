package com.example.jpa.service;

import com.example.jpa.repository.OneToManyManyToOne.MemberEntity;
import com.example.jpa.repository.OneToManyManyToOne.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
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
    MemberRepository _memberRepository;

    // 전체 회원 목록 조회
    public List<MemberEntity> findAll(){

        List<MemberEntity> result = _memberRepository.findAll();
        return result;
    }


    // 한명의 회원 정보 조회
    public MemberEntity findOne(String id){

        MemberEntity result = _memberRepository.findOne(id);
        return result;

    }

    // 회원 등록하기
    public MemberEntity register(MemberEntity member){

        MemberEntity result =  _memberRepository.save(member);
        return result;

    }

    // 회원 정보 수정
    public MemberEntity modify(String id, MemberEntity member){

        MemberEntity selectedMember = _memberRepository.getOne(id);
        selectedMember.setName(member.getName());
        selectedMember.setAddress(member.getAddress());
        MemberEntity result = _memberRepository.save(selectedMember);

        return result;
    }

    //한명 회원 정보 지우기
    public void remove(String id){

        MemberEntity member = _memberRepository.getOne(id);
        _memberRepository.delete(member);


    }

}

