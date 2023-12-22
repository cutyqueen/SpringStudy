<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StringdoB.jsp</title>
</head>
<body>
	<h1>StringdoB.jsp</h1>
	<h3> 전달된 msg 정보를 출력 </h3>
	jsp : <%=request.getParameter("msg") %><hr>
	el : ${param.msg}<hr>
	
	<h3>modelAttribute 어노테이션을 사용하여 정보 전달 - el 표현식 출력 </h3>
	<!-- 저장도 어노테이션으로 대체됨. 받아쓰기만 하면됨 -->
	spring - el : ${requestScope.msg }<hr>
	spring - el : ${msg }<hr> <!-- 영역객체 생략됨 -->
	
	age : ${age }
</body>
</html>