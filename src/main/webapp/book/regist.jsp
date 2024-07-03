<%@page import="book.Book"%>
<%@page import="book.BookDAO"%>
<%@page import="book.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String title = request.getParameter("title");
String author = request.getParameter("author");
String publisher = request.getParameter("publisher");
int price = Integer.parseInt(request.getParameter("price"));

if (title == null || author == null || publisher == null) {
	response.sendRedirect("registPage.jsp");
} else {
	BookService service = new BookService(new BookDAO());
	Book book = new Book(0, title, author, publisher, price); // Assuming the id is auto-generated
	if (service.insertBook(book)) {
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("registPage.jsp");
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
