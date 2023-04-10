package edu.pnu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domin.Member;
import edu.pnu.service.MemberService;

@Controller
public class MemberController {

	MemberService memberservice;
	
	@GetMapping("/member")
	private List<Member> getMember() {
		return memberservice.getMember();
	}
	
}
