package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domin.DBoard;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//model interface이다
	
	@GetMapping("/board")
	public void getBoardList(Model model) {
	//public List<DBoard> getBoardList() {
		
		List<DBoard> list = boardService.getBoardList();
		model.addAttribute("boardlist", list);
		
		//return boardService.getBoardList();
	}
	
//	@GetMapping("/board")
//	public List<DBoard> getBoard(Long seq) {
//		if(seq == null) {
//			System.out.println("getBoard : All");
//			return boardService.getBoardList();
//		}
//		System.out.println("getBoard : " + seq);
//		
//		List<DBoard> list = new ArrayList<>();
//		list.add(boardService.getBoard(seq));
//		return list;
//	}
	
	@GetMapping("/board/{seq}")
	public DBoard getBoardbyPath(@PathVariable Long seq){
		System.out.println("getBoard PathVariable : " + seq);
		return boardService.getBoard(seq); 
	}
	
}
