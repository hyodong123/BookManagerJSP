<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="book.*" import="java.util.*" pageEncoding="UTF-8"%>
<%
    BookService service = new BookService(new BookDAO());
    List<Book> bookList = service.selectAllBooks();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<style>
	body {
        background-color: #BBDEFB;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <h1>도서 관리 메인 페이지</h1>
    <a href="registPage.jsp"><button>도서 등록</button></a><br>
    <h3>도서 목록</h3>
    <%
        if (bookList.size() == 0) { %>
        <p>등록되어 있는 도서가 없습니다.</p>   
    <% } else { %>
        <table>
            <tr><th>도서 번호</th><th>도서 제목</th><th>저자</th><th>출판사</th><th>가격</th><th>상세보기</th></tr>
            <% for (Book book : bookList) { %>
                <tr>
                    <td><%= book.getId() %></td>
                    <td><a href="detailPage.jsp?id=<%= book.getId() %>"><%= book.getTitle() %></a></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getPublisher() %></td>
                    <td><%= book.getPrice() %></td>
                    <td><a href="detailPage.jsp?id=<%= book.getId() %>"><button>상세보기</button></a></td>
                </tr>
            <% } %>
        </table>
    <% } %>
</body>
</html>
