package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
