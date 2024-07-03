<%@page import="member.MemberDAO"%>
<%@page import="member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String noStr = request.getParameter("no");
if (noStr == null)
	response.sendRedirect("Main.jsp");
else {
	MemberService service = new MemberService(new MemberDAO());
	if (service.remove(Integer.parseInt(noStr))) {
		response.sendRedirect("Main.jsp");
	}else {
		response.sendRedirect("detailPage.jsp?np=" + noStr);
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