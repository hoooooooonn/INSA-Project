<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록</title>
<link rel="stylesheet" href="./css/teacherAdd.css">
<style>
.table4 td input[type="number"] {
	width: 90%; /* 너비 90%로 통일 */
	padding: 8px; /* 패딩 통일 */
	border: 2px solid #3479db; /* 테두리 색상 통일 */
	border-radius: 5px; /* 둥근 모서리 통일 */
	outline: none; /* 포커스 시 외곽선 없애기 */
	transition: 0.3s; /* 전환 효과 */
}

.table4 td input[type="number"]:focus {
	border-color: #ff9900; /* 포커스 시 테두리 색상 */
}
</style>
</head>
<body>

	<div class="container">
		<h2>★🐰신규 학생 등록🐰★</h2>
		<form action="./registServlet.do" method="post" class="form">
			<table class="table4">
				<thead>
					<tr>
						<th colspan="2">학생 정보 입력</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>학생 이름</th>
						<td><input type="text" name="stu_name"
							value="${param.stu_name}" required></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="stu_phone"
							value="${param.stu_phone}" required></td>
					</tr>
					<tr>
						<th>성별</th>
						<td><input type="text" name="gen" value="${param.gen}"
							required></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="number" name="age" value="${param.age}"
							required></td>
					</tr>
					<tr>
						<th>선호도</th>
						<td><input type="text" name="pref" value="${param.pref}"
							required></td>
					</tr>
					<tr>
						<th>메모</th>
						<td><input type="text" name="note" value="${param.note}"
							required></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit"
							value="학생 등록" class="btn btn-submit"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>

</html>