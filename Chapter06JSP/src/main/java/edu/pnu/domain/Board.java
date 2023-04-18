package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //시컨스 생성안할려고
	private Long seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	@Column(insertable = false, updatable = false, columnDefinition = "date default now()")
	private Date createDate;
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;
	
	
	
}
