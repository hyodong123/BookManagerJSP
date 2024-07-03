<%@page import="book.Book"%>
<%@page import="book.BookDAO"%>
<%@page import="book.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String noStr = request.getParameter("id");
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String priceStr = request.getParameter("price");

	if (noStr == null) {
		response.sendRedirect("main.jsp");
	} else if (title == null || author == null || publisher == null || priceStr == null){
		response.sendRedirect("detailPage.jsp?id=" + noStr);	
	} else {
		BookService service = new BookService(new BookDAO());
		Book book = new Book(Integer.parseInt(noStr), title, author, publisher, Integer.parseInt(priceStr));
		if (service.updateBook(book)) {
			response.sendRedirect("main.jsp");	
		} else {
			response.sendRedirect("modifyPage.jsp?id=" + noStr);	
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 수정 페이지</title>
</head>
<body>

</body>
</html>
