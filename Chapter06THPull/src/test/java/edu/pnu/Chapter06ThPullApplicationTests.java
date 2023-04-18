package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Chapter06ThPullApplicationTests {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	private void insetMember(Member member) {
		
		for(int i=0; i < 10; i++) {
			Member m = new Member();
			m.setId("Id" + i);
			m.setPassword("Password" + i);
			m.setName("Name" + i);
			m.setRole("Role" + i);
			
			memberRepo.save(m);
		}
		
	}
	
}
