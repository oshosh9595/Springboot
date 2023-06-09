package edu.pnu.service;

import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {

	private List<MemberVO> list; 
	
	// 전체 리스트 불러오기
	public List<MemberVO> getMembers(){
		return list;
	} 
	
	// 데이터 addMember
	public MemberVO addMember(MemberVO member) {
		member.setId(list.size() + 1);
		member.setRegidate(new Date());
		list.add(member);
		return member;
	}
	
}
