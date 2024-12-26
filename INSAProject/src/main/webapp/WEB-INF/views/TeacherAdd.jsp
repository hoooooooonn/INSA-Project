<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
/* List<LoginDto> lists = (List<LoginDto>) request.getAttribute("teacherList"); */
%>
<body>

<h3>강사 등록</h3>
<hr>
<form action="./teachAddServlet.do" method="post">
	<table>
		<thead>
			<tr>
				<th colspan="2">신규강사등록</th>
			</tr>
		</thead>
			<tr>
				<th>아이디</th>
			</tr>
		
		<tbody>
		</tbody>
	
	</table>
</form>

</body>
</html>