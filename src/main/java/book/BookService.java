package book;

import java.util.List;

public class BookService 
{
    private BookDAO bookDao;

    public BookService(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    public boolean insertBook(Book book) 
    {
        int result = bookDao.insertBook(book);
        return result > 0;
    }

    public Book selectBook(int id) {
        return bookDao.selectBook(id);
    }

    public List<Book> selectAllBooks() {
        return bookDao.selectAllBooks();
    }

    public boolean updateBook(Book book) {
        int result = bookDao.updateBook(book);
        return result > 0;
    }

    public boolean deleteBook(int id) {
        int result = bookDao.deleteBook(id);
        return result > 0;
    }
}
