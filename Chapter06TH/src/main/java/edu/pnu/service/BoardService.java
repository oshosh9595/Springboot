package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepo;
	
//	public List<Board> getBoardList(Board board) {
//		List<Board> list = new ArrayList<>();
//		Board b = new Board();
//		
//		for(int i=0; i < 10; i++) {
//			b.setSeq(1L);
//			b.setTitle("title" + i);
//			b.setWriter("writer" + i);
//			b.setContent("content" + i);
//			b.setCreateDate(new Date());
//			b.setCnt(0L);
//			
//			list.add(b);
//		}
//		return list;
//	}
	
	public List<Board> getBoardList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	public Board insertBoard(Board board) {	
		return boardRepo.save(board);
	}

	public Board updateBoard(Board board) {
		Board upBoard = boardRepo.findById(board.getSeq()).get();
		upBoard.setTitle(board.getTitle());
		upBoard.setContent(board.getContent());
		return boardRepo.save(board);
	}

	public Board deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
		return boardRepo.save(board);
	}
	
	
}
