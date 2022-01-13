<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Step 1: HTML form 작성 -->
<form action="todo-demo.jsp">
	새 할일 : <input type="text" name="theItem" />
	<input type="submit" value="입력" />
</form>
<!-- Step 1.5: 입력한 아이템을 테스트 출력 (완료!)-->

<!-- Step 2: To do 리스트에 새 아이템 추가 -->
<%
	//먼저 세션에 todo리스트가 있는지 확인
	List<String> items = (List<String>)session.getAttribute("todoList");

	//만약에 todo리스트가 없다면 items = null 이므로 새로 만들기
	if(items == null){
		items = new ArrayList<String>();
		session.setAttribute("todoList", items);
	}
	// 입력한 할일을 받아서 리스트에 추가 그리고 그 리스트를 세션에 저장
	String theItem = request.getParameter("theItem");
	// 입력한 할일이 널이나 공백이 아니면 입력
	if((theItem != null)&&(!theItem.trim().equals(""))){
		// 리스트에 같은 할일이 있으면 입력 안함
		if(!items.contains(theItem.trim())){
			items.add(theItem);
			session.setAttribute("todoList", items);
		}
	}

%>
<!-- Step 3: to do 리스트 출력하기 -->
<hr>
<b>할일 리스트 : </b>
<ol>
<%
	for(String s : items){
		out.println("<li>" + s + "</li>");
	}
%>
</ol>
</body>
</html>





