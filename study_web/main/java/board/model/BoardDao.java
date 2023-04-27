package board.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DAO
 * 데이터베이스에 접근하기 위한 객체
 */
public class BoardDao {
	private static BoardDao board = null;
	/**
	 * 커넥션 풀
	 * 
	 * DB와 연결된 커넥션을 미리 만들어서 풀에 저장해두고, 필요할 때 커넥션을 풀에서 가져다 쓰고 반환하는 기법
	 * 커넥션을 생성하는데 필요한 시간을 줄일 수 있음.
	 * 사용자가 접속할 때 마다 재사용하기 때문에 프로그램의 효율과 성능이 개선됨.
	 * 
	 * 톰켓에서 커넥션 풀을 설정한다고 한다.
	 * META-INF에서 context.xml을 추가해서 다음 키워드를 입력한다.
	 * 
	 * <Resource name="OracleCP"
      		auth="Container"
      		driverClassName="oracle.jdbc.OracleDriver"
      		url="jdbc:oracle:thin:@localhost:1521/xepdb1"
      		username="oraclejava"
      		password="oraclejava"
      		type="javax.sql.DataSource"
      		maxActive="50"
      		maxWait="-1" />
	 */
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
		PreparedStatement prestate = null;
		
		boolean result = false;
		
		String sql =
			"INSERT INTO m1board(no, title, name, password, content) " +
			"VALUES(m1board_seq.nextval, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, board.getTitle());
			prestate.setString(2, board.getName());
			prestate.setString(3, board.getPassword());
			prestate.setString(4, board.getContent());
			prestate.executeUpdate(); // DB에 삽입, 수정, 삭제시 executeUpdate()
			
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate);
		}
		
		return result;
	}
	
	public List<BoardDto> getBoardList() {
		Connection conn = null;
		PreparedStatement prestate = null;
		ResultSet result = null;
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		String sql =
			"SELECT no, title, name, to_char(writeday, 'yyyy-MM-DD') as writeday, readcount " +
			"FROM m1board " + 
			"ORDER BY no DESC ";
		
		try {
			conn = getConnection();
			prestate = conn.prepareStatement(sql);
			result = prestate.executeQuery(); // DB에 조회시 executeQuery()
			
			while (result.next()) {
				BoardDto board = new BoardDto();
				board.setNo(result.getLong("no"));
				board.setTitle(result.getString("title"));
				board.setName(result.getString("name"));
				board.setWriteday(result.getString("writeday"));
				board.setNo(result.getLong("no"));
				board.setReadcount(result.getInt("readcount"));
				
				list.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate, result);
		}
		
		return list;
	}
	
	public BoardDto getBoardView(Long no) {
		Connection conn = null;
		PreparedStatement prestate = null;
		ResultSet result = null;
		BoardDto board = null;
		
		String sql =
			"SELECT no, title, name, content, to_char(writeday, 'yyyy-MM-DD') as writeday, readcount " +
			"FROM m1board " + 
			"WHERE no = ? ";
		
		try {
			conn = getConnection();
			prestate = conn.prepareStatement(sql);
			prestate.setLong(1, no);
			result = prestate.executeQuery();
			
			// 상세조회도 next로 값을 확인해야 함.
			if (result.next()) {
				board = new BoardDto();
				board.setNo(result.getLong("no"));
				board.setTitle(result.getString("title"));
				board.setName(result.getString("name"));
				board.setContent(result.getString("content"));
				board.setWriteday(result.getString("writeday"));
				board.setReadcount(result.getInt("readcount"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate, result);
		}
		
		return board;
	}
	
	public boolean updateReadcount(Long no) {
		Connection conn = null;
		PreparedStatement prestate = null;
		
		boolean result = false;
		
		String sql =
			"UPDATE m1board " +
			"SET readcount = readcount + 1 " +
			"WHERE no = ?";
			
		try {
			// 자동으로 커밋을 해줌.
			conn = getConnection();
			// conn.setAutoCommit(false); // 커밋을 제어할 수 있음.
			prestate = conn.prepareStatement(sql);
			prestate.setLong(1, no);
			// executeUpdate()는 갱신된 갯수를 반환함.
			if (prestate.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate);
		}
		
		return result;
	}
	
	public boolean updateBoard(BoardDto board) {
		Connection conn = null;
		PreparedStatement prestate = null;
		
		boolean result = false;
		
		String sql =
			"UPDATE m1board " +
			"SET title = ?, name = ?, content = ? " +
			"WHERE no = ? AND password = ?";
		
		try {
			conn = getConnection();
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, board.getTitle());
			prestate.setString(2, board.getName());
			prestate.setString(3, board.getContent());
			prestate.setLong(4, board.getNo());
			prestate.setString(5, board.getPassword());
			if (prestate.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate);
		}
	
		return result;
	}
	
	public boolean deleteBoard(BoardDto board) {
		Connection conn = null;
		PreparedStatement prestate = null;
		
		boolean result = false;
		
		String sql =
			"DELETE FROM m1board " +
			"WHERE no = ? AND password = ?";
		
		try {
			conn = getConnection();
			prestate = conn.prepareStatement(sql);
			prestate.setLong(1, board.getNo());
			prestate.setString(2, board.getPassword());
			if (prestate.executeUpdate() > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, prestate);
		}
	
		return result;
	}
}
