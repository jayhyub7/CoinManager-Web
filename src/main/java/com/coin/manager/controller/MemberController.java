package com.coin.manager.controller;

import com.coin.manager.entity.Member;
import com.coin.manager.form.MemberForm;
import com.coin.manager.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@ResponseBody
@RequestMapping("member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public @ResponseBody Member signUp(@RequestBody @Valid MemberForm memberForm) throws Exception {
        Member member = memberService.signUp(memberForm);
        member.setPassword("");
        return member;
    }

    @PostMapping("/update")
    public @ResponseBody Member update(@RequestBody @Valid MemberForm memberForm) throws Exception {
        Member member = memberService.update(memberForm);
        member.setPassword("");
        return member;
    }
}
