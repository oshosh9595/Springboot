package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
//	@GetMapping("/getBoard")
//	public List<Board> getBoardList(Board board) {
//		return boardService.getBoardList(board);
//	}
	
	@PostMapping("/insertBoard")
	public Board insertBoard(Board board) {
		return boardService.insertBoard(board);
	}
	
	@PutMapping("/updateBoard")
	public Board updateBoard(Board board) {
		return boardService.updateBoard(board);
	}
	
	@DeleteMapping("/deleteBoard/{seq}=?")
	public Board deleteBoard(Board board) {
		return boardService.deleteBoard(board);
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hi Thymeleaf~~");
		return "hello";
	}	
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
		
		return "/getBoardList";
	}
	
}
