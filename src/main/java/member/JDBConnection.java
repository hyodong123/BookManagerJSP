package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {

	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public JDBConnection() {

		// DB 연결을 위한 정보

		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ip주소 : 포트번호 : 버전
		final String userid = "c##java";
		final String passwd = "181612";

// JDBC 드라이버 loading
		try {
			Class.forName(jdbcDriverClassName);

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, userid, passwd);
			System.out.println("오라클 DB 연결 성공");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				conn.close();
			if (rs != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}