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
	static CallableStatement cstmt;
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
			String sql = "{call InsetUser(?,?,?)}";
	        cstmt = con.prepareCall(sql);
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("id :");
	        String id = scanner.nextLine();
	        System.out.println("uname :");
	        String pass = scanner.nextLine();
	        System.out.println("email :");
	        String name = scanner.nextLine();
	        cstmt.setString(1, id);
	        cstmt.setString(2, pass);
	        cstmt.setString(3, name);
	        cstmt.executeUpdate();
		}catch (Exception e) {
			try {
				cstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return member;
	}
	
	public MemberVO updateMember(MemberVO member) {
		try {
			Scanner scanner = new Scanner(System.in);
			psmt = con.prepareStatement("update user set  uname=? and email=?");
			
			String uname = scanner.next();
			psmt.setString(1, uname);
			String email = scanner.next();
			psmt.setString(2, email);
			int result = psmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정 되었습니다.");
			}else {
				System.out.println("수정 실패!!");
			}
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
			Scanner scanner = new Scanner(System.in);
			psmt = con.prepareStatement("delete from user where uid=?");
			String uid = scanner.next();
			psmt.setString(1, uid);
			int result = psmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("삭제 되었습니다.");
			}else {
				System.out.println("삭제 실패!!");
			}
			
		}catch (Exception e) {
			System.out.println("delete 오류");
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
}
