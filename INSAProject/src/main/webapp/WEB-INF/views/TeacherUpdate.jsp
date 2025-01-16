<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<link rel="stylesheet" href="./css/teacherupdate.css">

</head>

<body>

	<div class="container">
		<h2>강사 정보 수정</h2>
		<form action="./teachUpdateServlet.do" method="post" class="form">
			<table class="table4">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="teach_id"
							value="${dto.teach_id}" readonly></td>
						<td><input type="text" name="teach_name"
							value="${dto.teach_name}"></td>
						<td><input type="text" name="teach_phone"
							value="${dto.teach_phone}"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" class="text-center"><input type="submit"
							value="수정" class="btn btn-submit"> <input type="reset"
							value="초기화" class="btn btn-reset"> <input type="button"
							value="삭제" onclick="delTeacher()" class="btn btn-danger">
							<input type="button" value="뒤로가기" class="btn btn-back"
							onclick="history.back(-1)"></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>


	<div class="container">
		<h2>강사 교육 일지</h2>
		<form action="./teachUpdateServlet.do" method="post" class="form">
			<table class="table4">
				<thead>
				<tr>
					<th>ID</th>
					<th>교육일시</th>
					<th>교육제목</th>
					<th>담당학생</th>
				</tr>
				
<!-- 					<tr> -->
<!-- 						<th>교육일시</th> -->
<!-- 						<td><input type="text" name="teachingDate" -->
<%-- 							value="${dto.teach_id}" ></td> --%>
<!-- 						<th>담당학생</th> -->
<!-- 						<td><input type="text" name="teachingStu" -->
<%-- 							value="${dto.teach_id}" ></td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th>교육제목</th> -->
<!-- 						<td ><input type="text" name="teachingTitle" -->
<%-- 							value="${dto.teach_id}" ></td> --%>
<!-- 						<th>교육 난이도</th> -->
<!-- 						<td> <input type="text" name="teachingContent" -->
<%-- 							value="${dto.teach_id}" ></td> --%>
<!-- 					</tr> -->
				</thead>
				<tbody>
				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</form>
	</div>

</body>
<script type="text/javascript">
	function delTeacher() {
		location.href = "./teachDelServlet.do?id=${dto.teach_id}";
	}
</script>

</html>
