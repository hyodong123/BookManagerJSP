<%@page import="book.BookDAO"%>
<%@page import="book.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String idStr = request.getParameter("id");
if (idStr == null) {
	response.sendRedirect("main.jsp");
} else {
	BookService service = new BookService(new BookDAO());
	if (service.deleteBook(Integer.parseInt(idStr))) {
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("detailPage.jsp?id=" + idStr);
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 삭제</title>
</head>
<body>

</body>
</html> 
