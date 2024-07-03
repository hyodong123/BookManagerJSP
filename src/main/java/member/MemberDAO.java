package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public int deleteMember(int no) {
		int result = 0;

		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		// sql문
		String sql = "delete member where no = ?";
		// PreparedStatment 객체 생성 <- sql 문으로
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			// 파라미터 set
			jdbc.pstmt.setInt(1, no);

			// 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;

		// 결과처리
	}

	public int updateMember(Member member) {
	      JDBConnection jdbc = new JDBConnection();
	      
	      String sql = new StringBuilder()
	            .append("update member ")
	            .append("set password=?, nickname=? ")
	            .append("where no=?").toString();
	      int result = 0;
	      try {
	         jdbc.pstmt = jdbc.conn.prepareStatement(sql);

	         jdbc.pstmt.setString(1, member.getPassword());
	         jdbc.pstmt.setString(2, member.getNickname());
	         jdbc.pstmt.setInt(3, member.getNo());

	         result = jdbc.pstmt.executeUpdate();

	         System.out.println(result + "행이 수정되었습니다.");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         jdbc.close();
	      }
	      return result;
	   }

	@SuppressWarnings("finally")
	public static int insertMember(Member member) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// sql문 만들기
		String sql = new StringBuilder().append("insert into member (no, id, password, nickname, regdate)")
				.append("values (member_seq.nextval, ? , ? , ? , sysdate)").toString();

		int result = 0;
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, member.getId());
			jdbc.pstmt.setString(2, member.getPassword());
			jdbc.pstmt.setString(3, member.getNickname());
			// SQL문 실행

			if (result == 0) {
				System.out.println(result + "행이 추가되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 객체 닫기
			return result;

		}
	}

	public List<Member> selectMemberAll() {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// PreparedStatement 변수, ResultSet 변수 선언
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// sql문 만들기
		String sql = "select * from member";

		List<Member> memberList = new ArrayList<>();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			while (jdbc.rs.next()) {
				Member member = new Member(jdbc.rs.getInt("no"), jdbc.rs.getString("id"), jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"), jdbc.rs.getDate("regdate"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	public Member selectMember(int no) {
		Member member = null;

		// DB 연결
		JDBConnection jdbc = new JDBConnection();

		// sql문 만들기
		String sql = "select * from member where no=?";

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);

			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				member = new Member(jdbc.rs.getInt("no"), jdbc.rs.getString("id"), jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"), jdbc.rs.getDate("regdate"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 객체 닫기
			jdbc.close();
		}

		return member;
	}

}
