package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.dao.log.LogDaoFilelmpl;
import edu.pnu.dao.log.LogDaoH2lmpl;
import edu.pnu.dao.member.MemberDao;
import edu.pnu.dao.member.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDao memberDao;
	private LogDaoFilelmpl logdao;
	
	public MemberService() {
		//this.memberDao = new MemberDaoH2Impl();
		memberDao = new MemberDaoH2Impl();
		logdao = new LogDaoH2lmpl();
		//memberDao = new MemberDaoListImpl();
	}
	
	@SuppressWarnings("unchecked")
	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberDao.getMembers();
		//List<MemberVO> list = (List<MemberVO>) map.get("data");
		//if(map != null ) {
		logdao.addLog("get", map);
		return (List<MemberVO>) map.get("data");
		//}
		//return null;
	}

	@SuppressWarnings("unchecked")
	public MemberVO getMember(Integer id) {
		Map<String, Object> map = memberDao.getMember(id);
		logdao.addLog("get", map);
		return (MemberVO) map.get("data");
	}

	@SuppressWarnings("unchecked")
	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = memberDao.addMember(member);
		logdao.addLog("get", map);
		return (MemberVO) map.get("data");
	}

	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = memberDao.updateMember(member);
		logdao.addLog("get", map);
		return (MemberVO) map.get("data");
	}

	public MemberVO deleteMember(Integer id) {
		Map<String, Object> map = memberDao.deleteMember(id);
		logdao.addLog("get", map);
		return (MemberVO) map.get("data");
	}

}
