<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
</head>
<body>
   <h3>회원 등록</h3>
   <form action="regist.jsp" method="post">
      <input type="text" name="id" placeholder="아이디 입력"><br>
      <input type="password" name="pw" placeholder="패스워드 입력"><br>
      <input type="text" name="nickname" placeholder="닉네임 입력"><br>
      <br>
      <input type="submit" value="등록">
      <a href="main.jsp"><input type="button" value="취소"></a>
   </form>
</body>
</html>