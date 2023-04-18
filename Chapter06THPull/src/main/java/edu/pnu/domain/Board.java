package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	@Column(insertable = false, updatable = false, columnDefinition = "data default now()")
	private Date createDate;
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;

//	@ManyToOne
//	@JoinColumn(name ="MEMBER_ID", nullable = false )
//	private Member member;
//	
//	public void setMember(Member member) {
//		this.member = member;
//		member.getBoardList().add(this);
//	}
	
}
