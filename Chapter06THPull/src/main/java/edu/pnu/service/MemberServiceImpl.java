//package edu.pnu.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import edu.pnu.domain.Member;
//import edu.pnu.persistence.MemberRepository;
//
//public class MemberServiceImpl {
//	@Autowired
//	MemberRepository MemberRepo;
//	
//	public List<Member> getMemberList(Member member){
//		return (List<Member>) MemberRepo.findAll();
//	}
//	
////	public Member getMember(Member member) {
////		return MemberRepo.findById(member.getId()).get();
////	}
//	
//}
