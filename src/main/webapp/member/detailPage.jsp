<%@page import="member.Member"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String noStr = request.getParameter("no");
if (noStr == null) {
	response.sendRedirect("main.jsp");
} else {
	MemberService service = new MemberService(new MemberDAO());
	Member member = service.read(Integer.parseInt(noStr));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 페이지</title>
</head>
<body>
	<h3>회원 상세 정보</h3>
	<%
	if (member == null) {
	%>
	<p>해당 회원 정보가 없습니다.</p>
	<%
	} else {
	%>
	<ul>
		<li>회원번호 : <%=member.getNo()%></li>
		<li>아이디 : <%=member.getId()%></li>
		<li>닉네임 : <%=member.getNickname()%></li>
		<li>등록일 : <%=member.getRegdate() %></li>
	</ul>
	<br>
	<a href="modifyPage.jsp?no=<%=member.getNo()%>"><button>회원정보수정</button></a>
	<a href="removePage.jsp?no=<%=member.getNo()%>"><button>회원삭제</button></a>
	<%
	}
	%>
</body>
</html>
<%
}
%>