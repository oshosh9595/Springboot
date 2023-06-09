package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.Service.BoardService;
import edu.pnu.domain.Person;

@RestController
public class BoardController {
	
	BoardService boardService = new BoardService();
	//di 버전 - 브드 서비스에 Service 언노테이션 쓸때 위코드말고 이렇게 쓸수있다
	//@Autowired  
	//BoardService boardService;
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post : " + name;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "선플");
	}
	
//	@GetMapping("/getPersons")
//	public List<Person> getPersons() {
//		//ArrayList<Person> list = new ArrayList<>();
//		List<Person> List = new ArrayList<>();
//		List.add(new Person("홍길동", 2000, "백수", "선플"));
//		List.add(new Person("홍길덩", 2001, "백수", "악플"));
//		List.add(new Person("홍길돈", 2002, "백수", "선플"));
//		
//		return List;
//	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		return boardService.getPsersons();
	}
	
}
