package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domin.DBoard;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter06Test1ApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	BoardService boardservice;
	
	@Test
	void contextLoads() {
	}

	@Test
	void insertDataTest() {
		for(int i=1; i< 10; i++) {
			boardRepo.save(DBoard.builder()
					.title("title" + i)
					.content("Content" +i)
					.creatDate(new Date())
					.cnt(0L)
					.build()
					);
		}
	}
	
	@Test
	void getBoardListTest() {
		List<DBoard> list = boardservice.getBoardList();
		for(DBoard board : list) {
			System.out.println(board);
		}
	}
	
	
	
	
	
	
	
}
