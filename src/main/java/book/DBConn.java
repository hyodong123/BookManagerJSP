package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn 
{
    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public DBConn() 
    {
        final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String userid = "c##java";
        final String passwd = "181612";

        try {
            Class.forName(jdbcDriverClassName);
            conn = DriverManager.getConnection(url, userid, passwd);
            System.out.println("오라클 DB 연결 성공");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() 
    {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getDBConnection() 
    {
        return conn;
    }
}
