package edu.pnu.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domin.Member;

@Service
public class MemberService {

	@Autowired
	MemberService memberservice;
	
	private Connection con;
	
	public MemberService() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> getMember() {
		
		Statement st = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * form member");
			
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setRole(rs.getString("role"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				rs.close();
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		return null;
	}
	
	public Member getMembers() throws SQLException{
		Statement st = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("select id form member where id=?");
			
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				
				return m;
			}
		}catch(Exception e) {
			e.printStackTrace();
			rs.close();
			st.close();
		}
		return null;
	}
}
