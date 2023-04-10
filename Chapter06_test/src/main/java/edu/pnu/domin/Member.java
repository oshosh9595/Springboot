package edu.pnu.domin;

import org.springframework.boot.autoconfigure.AutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "member")
@AllArgsConstructor
@AutoConfiguration
@Entity
public class Member {
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private String id;
	private String name;
	private String password;
	private String role;
	
}
