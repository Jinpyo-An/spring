package hello.springservlet.web.frontcontroller.v3.controller;

import hello.springservlet.domain.member.Member;
import hello.springservlet.domain.member.MemberRepository;
import hello.springservlet.web.frontcontroller.ModelView;
import hello.springservlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        final List<Member> members = memberRepository.findAll();
        final ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
