package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao board = null;
	private DataSource source = null;
	
	private BoardDao() {
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			Context context = new InitialContext();
			source = (DataSource)context.lookup("java:comp/env/OracleCP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		if (board == null) board = new BoardDao();
		return board;
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

	public boolean insertBoard(BoardDto board) {
		Connection conn = null;
		PreparedStatement state = null;
		
		boolean result = false;
		
		String sql =
			"INSERT INTO tbl_board(no, title, content, id) " +
			"VALUES(seq_board.nextval, ?, ?, ?)";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setString(1, board.getTitle());
			state.setString(2, board.getContent());
			state.setString(3, board.getMemberDto().getId());
			state.executeUpdate();
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state);
		}
		
		return result;
	}

	public List<BoardDto> getBoardList() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		String sql =
			"SELECT b.no no, b.title title, m.id id, b.regdate regdate, b.readcount readcount, m.name name " +
			"FROM tbl_board b JOIN tbl_member m " +
			"ON b.id = m.id ORDER BY no DESC";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			
			while (result.next()) {
				MemberDto member = new MemberDto();
				member.setId(result.getString("id"));
				member.setName(result.getString("name"));
				
				BoardDto board = new BoardDto();
				board.setNo(result.getLong("no"));
				board.setTitle(result.getString("title"));
				board.setRegdate(result.getString("regdate"));
				board.setReadcount(result.getInt("readcount"));
				board.setMemberDto(member);
				
				list.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state, result);
		}
		
		return list;
	}

	public BoardDto getBoardView(Long no) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		BoardDto board = null;
		
		String sql =
			"SELECT b.no no, b.title title, b.content content, m.id id, b.regdate regdate, b.readcount readcount, m.name name " +
			"FROM tbl_board b JOIN tbl_member m " +
			"ON b.id = m.id " +
			"WHERE b.no = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setLong(1, no);
			result = state.executeQuery();
			
			if (result.next()) {
				MemberDto member = new MemberDto();
				member.setId(result.getString("id"));
				member.setName(result.getString("name"));
				
				board = new BoardDto();
				board.setNo(result.getLong("no"));
				board.setTitle(result.getString("title"));
				board.setContent(result.getString("content"));
				board.setRegdate(result.getString("regdate"));
				board.setReadcount(result.getInt("readcount"));
				board.setMemberDto(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state, result);
		}
		
		return board;
	}

	public boolean updateReadcount(Long no) {
		Connection conn = null;
		PreparedStatement state = null;
		boolean result = false;
		
		String sql = 
			"UPDATE tbl_board " +
			"SET readcount = readcount + 1 " +
			"WHERE no = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setLong(1, no);
			
			if (state.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state);
		}
		
		return result;
	}

	public boolean updateBoard(BoardDto board) {
		Connection conn = null;
		PreparedStatement state = null;
		
		boolean result = false;
		
		String sql = 
			"UPDATE tbl_board " +
			"SET title = ?, content = ? " +
			"WHERE no = ? AND id = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setString(1, board.getTitle());
			state.setString(2, board.getContent());
			state.setLong(3, board.getNo());
			state.setString(4, board.getMemberDto().getId());
			
			if (state.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state);
		}
		
		return result;
	}

	public boolean deleteBoard(BoardDto board) {
		Connection conn = null;
		PreparedStatement state = null;
		
		boolean result = false;
		
		String sql = 
			"DELETE FROM tbl_board " +
			"WHERE no = ? AND id = ?";
		
		try {
			conn = getConnection();
			state = conn.prepareStatement(sql);
			state.setLong(1, board.getNo());
			state.setString(2, board.getMemberDto().getId());
			
			if (state.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, state);
		}
		
		return result;
	}
}
