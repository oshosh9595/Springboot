package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	private Connection con;
	
	public MemberDaoH2Impl() {
        try {
            // JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
            
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
	}
	
	@Override
	public Map<String, Object> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			String sql = "select * from member order by id asc";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next() ) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
 			}
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("data", list);
			map.put("TF", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "select * from member where id=?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("data", m);
			map.put("TF", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private int getNextId() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(id) from member");
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;		
	}
	
	@Override
	public Map<String, Object> addMember(MemberVO member) {
		
		int id = getNextId();
		
		PreparedStatement st = null;
		try {
			String sql = "insert into member (name,pass) values (?,?)";
			st = con.prepareStatement(sql);
			st.executeUpdate();
			MemberVO m = new MemberVO();
			//m.setPass(rs.getString("pass"));
			//m.setName(rs.getString("name"));
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("data", member);
			map.put("TF", true);
			//return getMember(id);
			return map;
		} catch (Exception e) {
			System.out.println("E 오류");
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.out.println("쿼리 오류");
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		PreparedStatement st = null;
		try {
			String sql = "update member set name=?,pass=? where id=?";
			st = con.prepareStatement(sql);
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			st.setInt(3, member.getId());
			st.executeUpdate();
			
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sql);
			map.put("data", member);
			map.put("TF", true);
			//return getMember(member.getId());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		PreparedStatement st = null;
		try {
			String sql = "delete from member where id=?";
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			if (st.executeUpdate() == 1) {
				Map<String, Object> map = new HashMap<>();
				map.put("sql", sql);
				map.put("TF", true);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
