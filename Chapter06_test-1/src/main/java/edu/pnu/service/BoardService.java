package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domin.DBoard;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	public List<DBoard> getBoardList(){
		return (List<DBoard>) boardRepo.findAll(); // findall 전치가져오는거
	}
	
	public DBoard getBoard(Long seq){
		return boardRepo.findById(seq).get(); 
	}
	
}
