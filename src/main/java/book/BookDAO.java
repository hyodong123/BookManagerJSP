package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO 
{
    public int deleteBook(int id)
    {
        int result = 0;
        DBConn jdbc = new DBConn();
        String sql = "DELETE FROM Book WHERE ID = ?";

        try {
            jdbc.pstmt = jdbc.conn.prepareStatement(sql);
            jdbc.pstmt.setInt(1, id);
            result = jdbc.pstmt.executeUpdate();
            System.out.println(result + " 개의 행이 삭제되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close();
        }
        return result;
    }

    public int updateBook(Book book)
    {
        DBConn jdbc = new DBConn();
        String sql = "UPDATE Book SET TITLE=?, AUTHOR=?, PUBLISHER=?, PRICE=? WHERE ID=?";
        int result = 0;

        try {
            jdbc.pstmt = jdbc.conn.prepareStatement(sql);
            jdbc.pstmt.setString(1, book.getTitle());
            jdbc.pstmt.setString(2, book.getAuthor());
            jdbc.pstmt.setString(3, book.getPublisher());
            jdbc.pstmt.setInt(4, book.getPrice());
            jdbc.pstmt.setInt(5, book.getId());
            result = jdbc.pstmt.executeUpdate();
            System.out.println(result + " 개의 행이 수정되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close();
        }
        return result;
    }

    public int insertBook(Book book) 
    {
        DBConn jdbc = new DBConn();
        String sql = "INSERT INTO Book (ID, TITLE, AUTHOR, PUBLISHER, PRICE) VALUES (book_seq.nextval, ?, ?, ?, ?)";
        int result = 0;

        try {
            jdbc.pstmt = jdbc.conn.prepareStatement(sql);
            // jdbc.pstmt.setInt(1, book.getId()); // ID는 시퀀스로 자동 생성
            jdbc.pstmt.setString(1, book.getTitle());
            jdbc.pstmt.setString(2, book.getAuthor());
            jdbc.pstmt.setString(3, book.getPublisher());
            jdbc.pstmt.setInt(4, book.getPrice());
            result = jdbc.pstmt.executeUpdate();
            if (result > 0) 
            {
                System.out.println(result + " 개의 행이 추가되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close();
        }
        return result;
    }

    public List<Book> selectAllBooks()
    {
        DBConn jdbc = new DBConn();
        String sql = "SELECT * FROM Book";
        List<Book> bookList = new ArrayList<>();

        try {
            jdbc.pstmt = jdbc.conn.prepareStatement(sql);
            jdbc.rs = jdbc.pstmt.executeQuery();

            while (jdbc.rs.next()) 
            {
                Book book = new Book(
                    jdbc.rs.getInt("ID"),
                    jdbc.rs.getString("TITLE"),
                    jdbc.rs.getString("AUTHOR"),
                    jdbc.rs.getString("PUBLISHER"),
                    jdbc.rs.getInt("PRICE")
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close();
        }
        return bookList;
    }

    public Book selectBook(int id) 
    {
        Book book = null;
        DBConn jdbc = new DBConn();
        String sql = "SELECT * FROM Book WHERE ID=?";

        try {
            jdbc.pstmt = jdbc.conn.prepareStatement(sql);
            jdbc.pstmt.setInt(1, id);
            jdbc.rs = jdbc.pstmt.executeQuery();

            if (jdbc.rs.next()) {
                book = new Book(
                    jdbc.rs.getInt("ID"),
                    jdbc.rs.getString("TITLE"),
                    jdbc.rs.getString("AUTHOR"),
                    jdbc.rs.getString("PUBLISHER"),
                    jdbc.rs.getInt("PRICE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbc.close();
        }
        return book;
    }
}
