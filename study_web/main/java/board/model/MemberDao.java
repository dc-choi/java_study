package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao member = null;
	
	private DataSource source = null;
	
	private MemberDao() {
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			Context context = new InitialContext();
			source = (DataSource)context.lookup("java:comp/env/OracleCP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if (member == null) member = new MemberDao();
		return member;
	}
	
	private Connection getConnection() throws SQLException {
		// return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "oraclejava", "oraclejava");
		// 미리 준비된 커넥션 풀에서 커넥션을 맺어준다.
		return source.getConnection();
	}
	
	// 사용한 자원은 역순으로 해제
	private void dbClose(Connection conn, PreparedStatement prestate) {
		if (prestate != null) try { prestate.close(); } catch(Exception e) {}
		if (conn != null) try { conn.close(); } catch(Exception e) {}
	}
	
	private void dbClose(Connection conn, PreparedStatement prestate, ResultSet result) {
		if (result != null) try { result.close(); } catch(Exception e) {}
		if (prestate != null) try { prestate.close(); } catch(Exception e) {}
		if (conn != null) try { conn.close(); } catch(Exception e) {}
	}
}
