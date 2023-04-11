package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	
//	@RequestMapping("/getBoardList")
//	//public List<Board> getBoardList(Model model) {
//	public String getBoardList(Model model) {
//		List<Board> boardlist = new ArrayList<>();
//		for(long i=1; i<=10L; i++) {
//			Board board = new Board();
//			board.setSeq(i);
//			board.setTitle("게시판프로그램테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트 입니다.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardlist.add(board);
//		}
//		model.addAttribute("boardlist", boardlist);
//		return "board/getboardlist";
//		//return boardlist;
//	} 
	
}
