package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
class Mission2ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("테스트 입니다");
	}

//	@Test
//	void testMemberDAO() {
//		System.out.println("이것은 MemberDAO 테스트 입니다");
//		
//		MemberDAO memberDAO = new MemberDAO();
//	
//		List<MemberVO> list = memberDAO.seletMember();
//		
//		for(MemberVO m : list) {
//			System.out.println(m);
//		}
//		
//	}
	
}
