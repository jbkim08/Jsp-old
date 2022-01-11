<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 스크립틀릿 태그는 여러줄의 자바코드를 실행 --%>
    <% 
        for(int i=1; i<=5; i++){
            out.println("<br> JSP & 서블릿 : " + i);
        }
    
    %>
	
</body>
</html>