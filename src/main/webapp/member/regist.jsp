<%@page import="member.Member"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
String nickname = request.getParameter("nickname");

if (id == null || password == null || nickname == null) {
	response.sendRedirect("registPage.jsp");
} else {
	MemberService service = new MemberService(new MemberDAO());
	Member member = new Member(id, password, nickname);
	if (service.regist(member)) {
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