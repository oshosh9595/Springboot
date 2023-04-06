package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRespository extends CrudRepository<Board, Long> {

	
	@Query("select b from Board b order by b.seq desc ")
	List<Board> queryAnnotationTest(Pageable paging);
	
	@Query(value = "select seq, title, writer, createdate"
					+ "form board where title like '%'||?1||'%' "
					+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchkeyword);
	
//	List<Board> findByTitleContaining(String title);
//
//	List<Board> findByTitleAndCnt(String title,  long cnt);
//
//	List<Board> findByCntAndCntOrderBySeqDesc(long cnt, long seq);
//
//	List<Board> findByTitleAndContentOrderBySeqDesc(String title, String content, long seq);
}
