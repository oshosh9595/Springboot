package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRespository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRespository boardRepo;
	
	@Test
	public void BoadInsertTest() {
		
		Board b = new Board();
		for(int i=0; i < 10; i++) {
			b.setTitle("title");
			b.setWriter("writer");
			b.setContent("content");
			b.setCreateDate(new Date());
			b.setCnt(0L);
			
			boardRepo.save(b);
		}
	}
	
	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
	@Test
	public void testUpdateBoard() {
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}
	
	@Test
	public void testDeletBoard() {
		boardRepo.deleteById(1L);
	}
	
	
}
