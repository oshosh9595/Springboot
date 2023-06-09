package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDAO memberDAO = new MemberDAO();
	
	public List<MemberVO> getMembers(){
		return memberDAO.getMembers();
	}
	
	public MemberVO getMember(Integer id) {
		return memberDAO.getMember(id);
	}
	
	public MemberVO addMember(MemberVO member) {
		return memberDAO.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDAO.updateMember(member);
	}
	
	public MemberVO deleteMember(Integer id) {
		return memberDAO.deleteMember(id);
	}
	
}
