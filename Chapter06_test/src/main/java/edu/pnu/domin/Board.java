package edu.pnu.domin;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "board")
@Entity
public class Board {
	
	@Id@GeneratedValue
	private Long seq;
	private Long cnt;
	private String content;
	private Date creatdate;
	private String title;
	
}
