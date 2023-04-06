package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRespository;

//쿼리 메소드
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	BoardRespository boardRepo;

	// 테스트 데이터를 100건입력(cnt는 random으로 0~100 까지입력)
	//@Test
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
	
	@Test
	public void test() {
		Pageable paging = PageRequest.of(0, 3);
		List<Board> list = boardRepo.queryAnnotationTest(paging);
		
		for(Board b : list) {
			System.out.println(b);
		}
	}
	
	@Test
	public void test3() {
		List<Object[]> list = boardRepo.queryAnnotationTest3("3");
										
		for(Object[] b : list) {
			System.out.println(b);
		}
	}
	
	
	
//	@Test
//	public void testByTitleContaining() {
//		// title에 "1" 포함되면서 cnt가 50보다 큰 데이터 출력
//		// where 10 <= cnt and cnt<= 50 order by asc
//		List<Board> boardList = boardRepo.findByTitleContaining("1");
//		for (Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
//	
//	@Test
//	public void testByTitleAndCnt() {
//		List<Board> boardList = boardRepo.findByTitleAndCnt("1", 50);
//		for (Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
//	
//	@Test
//	public void testFindByCntAndCntOrderBySeqDesc() {
//	    List<Board> boardList = boardRepo.findByCntAndCntOrderBySeqDesc(10, 50);
//	    for (Board board : boardList) {
//	        System.out.println(board.toString());
//	    }
//	}
//
//	
//	@Test
//	public void testByTitleAndContentOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleAndContentOrderBySeqDesc("10", "2", 1);
//		for(Board board : boardList) {
//			System.out.println(board.toString());
//		}
//	}
//	
}
