package edu.pnu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.pnu.domain.MemberVO;

public class MemberDAO {
	static Connection con;
	static PreparedStatement psmt;
	static Statement stmt;
	static ResultSet rs;
	//MemberDAO memberDAO = new MemberDAO();
	
	public MemberDAO() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		}catch (Exception e) {
			System.out.println("db오류");
			e.printStackTrace();
		}
	}	
	
	public List<MemberVO> getMembers(){
		List<MemberVO> list = new ArrayList<>();
		
		try {
			psmt = con.prepareStatement("select * from member");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getInt("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setRegidate(rs.getDate("regidate"));
				
				list.add(memberVO);
			}
			
		}catch (SQLException e) {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberVO getMember(Integer id){
		MemberVO memberVO = new MemberVO();
		try {
			String sql = "select * from member where id=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()){
				memberVO.setId(rs.getInt("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setRegidate(rs.getDate("regidate"));
			}
			
		}catch (Exception e) {
			try {
				rs.close();
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return memberVO;
	}
	
	public MemberVO addMember(MemberVO member) {
		try {
			String sql = "insert into memeber(pass, name) value(?, ?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getPass());
			psmt.setString(2, member.getName());
			psmt.executeUpdate();
			
			return member;
			
		}catch (Exception e) {
			try {
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
	
	public MemberVO updateMember(MemberVO member) {
		try {
			psmt = con.prepareStatement("update member set  name=?, pass=? and id=?");
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			psmt.setInt(3, member.getId());
			psmt.executeUpdate();
			
			return member;
		}catch (Exception e) {
			System.out.println("update 오류");
			e.printStackTrace();
			try {
				psmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return null;
	}

	public MemberVO deleteMember(Integer id) {
		try {
			psmt = con.prepareStatement("delete from member where id=?");
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("delete 오류");
			e.printStackTrace();
			try {
				psmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return getMember(id);
	}
}
