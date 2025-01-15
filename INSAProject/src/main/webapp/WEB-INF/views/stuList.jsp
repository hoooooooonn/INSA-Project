<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 전체 조회</title>
<link rel="stylesheet" href="./css/teacherupdate.css">
<link rel="stylesheet" href="./css/teacherlist.css">

<style>
h3 {
	font-size: 20px;
	color: #333;
	text-align: center;
	margin-bottom: 20px;
}
</style>
<script type="text/javascript">
	function regist() {
		window.location.href = './registServlet.do';
	}
</script>


</head>

<body>

	<div class="container">
		<div class="header">
			<span class="title"><b>학생 목록 조회</b></span>

			<!-- 검색 폼 -->
			<form action="./stuListServlet.do" method="get">
				<div>
					<label for="searchName">학생 이름: </label> <input type="text"
						class="input-search" id="searchName" name="searchName"
						value="${searchName != null ? searchName : ''}" /> <input
						type="submit" value="검색">
				</div>
			</form>
			<button class="back-btn"
				onclick="location.href='./mainpageServlet.do?id=${dto.teach_id}'">이전페이지</button>
		</div>

		<hr>

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
					<th>수정</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty lists}">
						<c:choose>
							<c:when test="${not empty searchName}">
								<c:forEach var="student" items="${lists}">
									<c:if test="${fn:contains(student.stu_name, searchName)}">
										<tr>
											<td><a href="./stuUpdate.do?seq=${student.stu_id}">${student.stu_id}</a></td>
											<td>${student.stu_name}</td>
											<td>${student.stu_phone}</td>
											<td>${student.gen}</td>
											<td>${student.age}</td>
											<td>${student.pref}</td>
											<td>${student.note}</td>
											<td>
												<button
													onclick="location.href='./stuModify.do?stu_id=${student.stu_id}'">수정</button>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="student" items="${lists}">
									<tr>
										<td>${student.stu_id}</td>
										<td>${student.stu_name}</td>
										<td>${student.stu_phone}</td>
										<td>${student.gen}</td>
										<td>${student.age}</td>
										<td>${student.pref}</td>
										<td>${student.note}</td>
										<td>
											<button
												onclick="location.href='./stuModify.do?stu_id=${student.stu_id}'">수정</button>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8">검색된 학생이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>

				<tr>
					<td colspan="8" class="text-center"><input type="button"
						value="학생등록" class="btn btn-submit"
						onclick="window.location.href='./registServlet.do'"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		var btns = document.querySelectorAll("button");
		for (let i = 0; i < btns.length; i++) {
	        if (!btns[i].classList.contains("back-btn")) {
				btns[i].onclick = function() {
					var stu_id = this.parentNode.parentNode.children[0].textContent; // id값 가져온다.
					console.log("선택된 row의 id값 : ", stu_id)
					location.href = "./stuModify.do?stu_id=" + stu_id;
				}
			}
		}
	</script>

</body>
</html>
