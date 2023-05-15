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

	public int checkID(String id) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		int count = 0;
		
		String sql =
			"SELECT COUNT(*) as count FROM tbl_member " +
			"WHERE id = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setString(1, id);
			result = state.executeQuery();
			
			if (result.next()) {
				count = result.getInt("count");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			count = -1;
		} finally {
			dbClose(conn, state, result);
		}
		
		return count;
	}

	public boolean registerMember(MemberDto dto) {
		Connection conn = null;
		PreparedStatement state = null;
		
		boolean result = false;
		
		String sql =
			"INSERT INTO tbl_member(id, password, name, birth, phone, zipcode, address1, address2) " +
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setString(1, dto.getId());
			state.setString(2, dto.getPassword());
			state.setString(3, dto.getName());
			state.setString(4, dto.getBirth());
			state.setString(5, dto.getPhone());
			state.setString(6, dto.getZipcode());
			state.setString(7, dto.getAddress1());
			state.setString(8, dto.getAddress2());
			state.executeUpdate();
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state);
		}
		
		return result;
	}

	public MemberDto getUser(MemberDto dto) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		MemberDto member = null;
		
		String sql =
			"SELECT id, name " +
			"FROM tbl_member " +
			"WHERE id = ? AND password = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setString(1, dto.getId());
			state.setString(2, dto.getPassword());
			result = state.executeQuery();
			
			if (result.next()) {
				member = new MemberDto();
				member.setId(result.getString("id"));
				member.setName(result.getString("name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state, result);
		}
		
		return member;
	}
}
