<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ctrl+shift+/ 주석-->
<!-- 정적 인클루드 : 미리 컴파일해둠, 자주 바꾸지 않을때 -->
<%@ include file="copyright.txt" %>
<br>
<!-- 동적 인클루드 : 볼때마다 새로고침, 자주 수정할때 -->
<jsp:include page="update.txt" />

<!-- 자바 변수등을 넣을려면 정적 include를 사용 -->
<%@ include file="variable.jsp" %>
<%=name %>

<!-- 실행시(runtime)에 두개의 html중에 id가 있을경우 login.html 없을경우 fail.html -->
<% 
String id = request.getParameter("id"); %>

<!-- 동적 인클루드시 html 한글이 안깨짐 -->
<% if(id == null) { %>
	<jsp:include page="fail.html" />
<% } else { %>
	<jsp:include page="login.html" />
<% } %>

</body>
</html>