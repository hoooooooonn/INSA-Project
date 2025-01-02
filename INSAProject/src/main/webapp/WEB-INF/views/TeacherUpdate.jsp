<%@page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
</head>
<%
LoginDto dto = (LoginDto) request.getAttribute("loginDto");
%>
<body>

<form action="./teachUpdateServlet.do" method="post">
<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
				</tr>

			</thead>

			<tbody>
				<tr>
					<td><%=dto%></td>
				</tr>
			</tbody>

			<tfoot>
				<tr>
					<th colspan="4"><input type="submit" value="수정"> <input
						type="reset" value="초기화"> <input type="button"
						value="뒤로가기" onclick="history.back(-1)"></th>
				</tr>
			</tfoot>

		</table>
</form>

</body>
</html>