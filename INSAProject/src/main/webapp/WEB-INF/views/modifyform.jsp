<%@page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정화면</title>

<style type="text/css">

table, th, td {
	border: 1px solid black;
}


.required-field:required {
	border: 2px solid red;
	outline: none;
}

.required-field:required:focus {
	border-color: black;
	box-shadow: 0 0 5px black;
}

</style>

</head>

<%
LoginDto dto = (LoginDto) request.getAttribute("teacherInfo");
%>

<body>

<%=dto %>
<!-- 	<form action="./teachUpdateServlet.do" method="post"> -->
<!-- 		<table> -->
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<th>아이디</th> -->
<!-- 					<th>이름</th> -->
<!-- 					<th>전화번호</th> -->
<!-- 				</tr> -->

<!-- 			</thead> -->

<!-- 			<tbody> -->
<!-- 				<tr> -->
<%-- 					<td><input type="text" value="<%=dto.getTeach_id()%>" disabled="disabled"></td> --%>
<!-- 					<td><input type="text" name="name" -->
<%-- 						placeholder="<%=dto.getTeach_name()%>"></td> --%>
<!-- 					<td><input type="text" name="phone" -->
<%-- 						placeholder="<%=dto.getTeach_phone()%>"></td> --%>
<!-- 				</tr> -->

<!-- 			</tbody> -->

<!-- 			<tfoot> -->
<!-- 				<tr> -->
<!-- 					<th colspan="4"><input type="submit" value="수정"> <input -->
<!-- 						type="reset" value="초기화"> <input type="button" -->
<!-- 						value="뒤로가기" onclick="history.back(-1)"> -->
<!-- 						 <input type="button" -->
<%-- 						value="삭제하기" onclick="location.href='./teachDelServlet.do?seq=<%=dto.getTeach_id()%>'"> --%>
<!-- 						</th> -->
<!-- 				</tr> -->
<!-- 			</tfoot> -->

<!-- 		</table> -->

<!-- 	</form> -->
</body>
</html>