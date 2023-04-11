package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06JspApplicationTests {

	@Autowired
	BoardRepository boardRepo;

	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void BoadInsertTest() {

		for (int i = 0; i < 100; i++) {
			Board b = new Board();
			int n = (int) (Math.random() * 101);
			b.setTitle("title" + i);
			b.setWriter("writer" + i);
			b.setContent("content" + i);
			b.setCreateDate(new Date());
			b.setCnt((long) n);

			boardRepo.save(b);
		}
	}
	
}
