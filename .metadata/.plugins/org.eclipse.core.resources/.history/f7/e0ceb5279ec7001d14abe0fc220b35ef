package edu.pnu.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.Person;

@Service
public class BoardService {

	private List<Person> List = new ArrayList<>();
	
	public BoardService() {
		//ArrayList<Person> list = new ArrayList<>();
		
		List.add(new Person("홍길동", 2000, "백수", "선플"));
		List.add(new Person("홍길덩", 2001, "백수", "악플"));
		List.add(new Person("홍길돈", 2002, "백수", "선플"));
	
	}

	public List<Person> getPsersons(){
		return List;
	}
	
	
}
