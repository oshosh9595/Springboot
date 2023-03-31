package edu.pnu.dao.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	
	private List<MemberVO> list;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		for(int i = 0; i <= 5; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i, new Date()));
		}
	}
	
	@Override
	public Map<String, Object> getMembers() {
		Map<String, Object> map = new HashMap<>();
		map.put("sql", "from list getMembers()");
		map.put("data", "list");
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("sql", "from m getMember()");
//		map.put("data", "m");
//		return map;
		for(MemberVO m : list) {
			if(m.getId() == id) {
				return (Map<String, Object>) m;
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		member.setId(list.size() + 1);
		member.setRegidate(new Date());
		list.add(member);
		return null;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		for(MemberVO m : list) {
			if(member.getId() == m.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				return (Map<String, Object>) m;
			}
		}
		
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		
		for(MemberVO m : list) {
			if(m.getId() == id) {
				list.remove(m);
				return (Map<String, Object>) m;
			}
		}
		
		return null;
	}

}
