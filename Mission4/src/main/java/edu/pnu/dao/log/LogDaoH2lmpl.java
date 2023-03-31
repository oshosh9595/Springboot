package edu.pnu.dao.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class LogDaoH2lmpl implements LogDaoFilelmpl {
	
	static Connection con;

	public LogDaoH2lmpl() {
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
	public void addLog(String string, Map<String, Object> map) {
		PreparedStatement psmt;
		
		try {
			//String sql = String.format("insert into dblog(method, sqlstring, success) values(?, ?, ?)",
			//	    string, map != null?"true" : "false");
			String sql = "insert into dblog(method, sqlstring, success) values(?, ?, ?)";
			
			psmt =  con.prepareStatement(sql);
			psmt.setString(1, string);
			psmt.setObject(2, map.get("sql"));
			psmt.setObject(3, map.get("TF"));
			psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
