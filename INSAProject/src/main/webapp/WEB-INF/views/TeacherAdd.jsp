<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tbody {
	border: 1px solid black;
}

}
</style>
</head>
<%
List<LoginDto> lists = (List<LoginDto>) request.getAttribute("teacherList");
%>
<body>

	<h3>강사 등록</h3>
	<hr>
	<form action="./teachAddServlet.do" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="6">🎀신규강사등록🎀</th>
				</tr>
			</thead>
			<tbody>
			
			<tr>
				<th>아이디</th>
					<%int newTeacherId = lists.size() + 1;%>
					<td><input type="text" name="id" placeholder="<%=newTeacherId %>" disabled></td>
					<td><input type="hidden" name="id" value="<%=newTeacherId %>"></td>
				<th>이름</th>
					<td><input type="text" name="name" ></td>
				<th>전화번호</th>
					<td><input type="text" name="phone" ></td>
			</tr>

			<tr>
					<th colspan="6"><input type="submit" value="강사등록"></th>
				</tr>
			</tbody>

		</table>
	</form>

</body>
</html>