<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.min.edu.dto.LoginDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인 페이지</title>

<!-- Bootstrap 3 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 사용자 정의 CSS 추가 -->
<link rel="stylesheet" href="./css/styles.css">

<!-- header.jsp 파일을 포함 -->
<%@ include file="./header.jsp"%>
</head>
<body>

	<!-- 페이지 본문 내용 -->
	<div class="container">
		<h2>수업 조회</h2>
		<hr>

		<!-- 수업 완료/미완료 영역 -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="scrollable-table-container" style="overflow: scroll">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>수업명</th>
										<th>학생명</th>
										<th>회차</th>
										<th>강사 확인</th>
										<th>학생 확인</th>
										<th>최종 확인</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty lists}">
									<!-- 수업 목록을 출력 -->
									<c:forEach var="d" items="${lists}">
										<!-- confirm 값에 따라 행 스타일을 다르게 설정 -->
										<tr>
<!-- 										<tr> -->
											<td>${d.lec_name}</td>
											<td>${d.stu_name}</td>
											<td>${d.lec_cnt}</td>
											<td>${d.teach_conf}</td>
											<td>${d.stu_conf}</td>
											<td>${d.confirm}</tr>
									</c:forEach>
									</c:when>
									<c:otherwise>
										<h2 style="background-color: red"><b>조회된 수업이 없습니다.</b></h2>
									</c:otherwise>
								</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Bootstrap 3 JS -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
