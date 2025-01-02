<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 목록 조회</title>
<script type="text/javascript" src="./js/teacherlist.js"></script>
<style>
.table4 {
    width: 100%;
    border-collapse: collapse;
}

.table4 th, .table4 td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}

.table4 thead {
    background-color: #f2f2f2;  
    color: black; 
}
</style>

</head>
<%
List<LoginDto> lists = (List<LoginDto>) request.getAttribute("teacherList");
%>
<body>
	<span style="font-size: 20px"><b>강사 전체 목록</b></span>
	<button onclick="history.back(-1)">이전페이지</button>
	<hr>

	<div class="container">
		<table class="table table-success table-striped">
			<thead class="table-info">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (LoginDto dto : lists) {
				%>
				<tr>
					<td><%=dto.getTeach_id()%></td>
					<td><%=dto.getTeach_name()%></td>
					<td><%=dto.getTeach_phone()%></td>
					<th colspan="8" style="text-align: center;">
					<input class="btn btn-success btn-lg" type="button" value="상세보기"> 
					</th>
				</tr>
				<%
				}
				%>
			</tbody>
			<tfoot>
				<tr>

					<th colspan="8">
					<form action="./teachAddServlet.do"  method="get">
						<input type="submit" value="강사등록">
					</form>
					</th>
				</tr>

			</tfoot>
		</table>
	</div>
</body>
<script type="text/javascript">
	document.querySelector("input[type=button]").onclick=function(){
		console.log("수정화면이동");
		location.href="./teachUpdateServlet.do"; 
	}
</script>
</html>