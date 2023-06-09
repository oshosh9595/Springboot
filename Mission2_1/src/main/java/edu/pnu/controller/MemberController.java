package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	private	MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	private static final Logger Log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController(MemberService memberService) {
		
		Log.info("Info Message입니다");
		Log.warn("Warn Message입니다");
		Log.error("Error Message입니다");
		Log.debug("Debug Message입니다");
		Log.trace("Trace Message입니다");
	}
	
	@GetMapping("/member2")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	
	@GetMapping("/member2/{id}")
	public MemberVO getMember(@PathVariable Integer id){
		return memberService.getMember(id);
	}
	
	@PostMapping("/member2")
	public MemberVO addMember(MemberVO member){
		return memberService.addMember(member);
	}
	
	@PutMapping("/member2")
	public MemberVO updateMember(MemberVO member){
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member2/{id}")
	public MemberVO deleteMember(@PathVariable Integer id){
		return memberService.deleteMember(id);
	}
}
