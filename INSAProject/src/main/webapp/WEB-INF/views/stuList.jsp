<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생전체조회</title>

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
	background-color: #6c7ae0;
	color: white;
}
</style>
</head>
<% 
	List<StudentDto> studentList = (List<StudentDto>) request.getAttribute("lists");
%>
<body>

	<h2>학생 목록</h2>
	
	<table class="table4">
		<thead>
			<tr>
				<th>학생 ID</th>
				<th>학생 이름</th>
				<th>전화번호</th>
				<th>성별</th>
				<th>나이</th>
				<th>선호도</th>
				<th>메모</th>
			</tr>
		</thead>
		<tbody>
			<% 
                for (StudentDto student : studentList) {
            %>
			<tr>
				<td><%= student.getStu_id() %></td>
				<td><%= student.getStu_name() %></td>
				<td><%= student.getStu_phone() %></td>
				<td><%= student.getGen() %></td>
				<td><%= student.getAge() %></td>
				<td><%= student.getPref() %></td>
				<td><%= student.getNote() %></td>
			</tr>
			<% 
                }
            %>
            
		</tbody>
	</table>


</body>
</html>