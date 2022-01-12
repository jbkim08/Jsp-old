<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp 에 자바 빈 객체 만들기 : id는 객체의 이름  scope는 범위 -->
<jsp:useBean id="user2" class="beans.User" scope="page" />

<!-- 파마메터를 통해 값을 입력  -->
<jsp:setProperty property="*" name="user2"/>

이메일 : <%= user2.getEmail() %>
패스워드 : <%= user2.getPassword() %>

</body>
</html>