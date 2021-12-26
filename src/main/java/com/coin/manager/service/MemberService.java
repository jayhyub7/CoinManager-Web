package com.coin.manager.service;

import com.coin.manager.entity.Member;
import com.coin.manager.exception.DuplicateEmailException;
import com.coin.manager.exception.SuchNoMemberException;
import com.coin.manager.form.MemberForm;
import com.coin.manager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member signUp(MemberForm memberForm) throws Exception {
        if (memberRepository.existsByEmail(memberForm.getEmail())) {
            throw new DuplicateEmailException();
        }
        Member member = memberRepository.save(Member.CreateMember(memberForm));
        return member;
    }

    @Transactional
    public Member update(MemberForm memberForm) throws Exception {
        Member member = Member.CreateMember(memberForm);
        if (memberRepository.findByEmail(memberForm.getEmail()).isEmpty()) {
            throw new SuchNoMemberException();
        }

        return memberRepository.save(member);
    }


}
