<%@page import="com.min.edu.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보수정화면</title>
<link rel="stylesheet" href="./css/teacherupdate.css">

<style>
	.table4 td input[type="number"] {
    width: 90%;
    padding: 8px;
    border: 2px solid #3479db;
    border-radius: 5px;
    outline: none;
    transition: 0.3s;
}

</style>
</head>

<body>
	<div class="container">
	  <h2>학생 정보 수정</h2>
		<form action="./stuModify.do" method="post">
			<!-- 학생 ID는 수정할 수 없으므로 hidden으로 전달 -->
			<input type="hidden" name="stu_id" value="${dto.stu_id}">

			<table class="table4">

				<thead>
					<tr>
						<th>ID</th>
						<th>성명</th>
						<th>전화번호</th>
						<th>성별</th>
						<th>나이</th>
						<th>선호도</th>
						<th>메모</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${dto.stu_id}</td>
						<td><input type="text" name="stu_name" value="${dto.stu_name}" required></td>
						<td><input type="text" name="stu_phone" value="${dto.stu_phone}" required></td>
						<td><input type="text" name="gen" value="${dto.gen}" required></td>
						<td><input type="number" name="age" value="${dto.age}" required></td>
						<td><input type="text" name="pref" value="${dto.pref}" required></td>
						<td><input type="text" name="note" value="${dto.note}" required></td>
					</tr>
				</tbody>
				<tfoot>

					<!-- 수정 완료 버튼 -->
					<tr>
						<td colspan="7" class="text-center">
						<input type="submit" value="수정완료" class="btn btn-submit"></td>
					</tr>
				</tfoot>
			</table>

		</form>
	</div>
</body>
</html>
