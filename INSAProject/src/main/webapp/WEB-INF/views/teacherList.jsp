<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 목록 조회</title>
<script type="text/javascript" src="./js/teacherlist.js"></script>
<link rel="stylesheet" href="./css/teacherlist.css">
</head>

<body>
	<div class="container">
		<div class="header">
			<span class="title"><b>강사 전체 목록</b></span>
			<div>
				<select name="search" calss="search">
					<option vlaue="id">아이디</option>
					<option vlaue="name">이름</option>
					<option vlaue="phone">전화번호</option>
				</select>
				<input type="text" name="searchtext">
				<input type="button" value="검색">
			</div>
			<button class="back-btn" onclick="location.href='./mainpageServlet.do?id=${dto.teach_id}'">이전페이지</button>
		</div>
		<hr>

		<table class="table4">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dto" items="${lists}" varStatus="vs">
				<tr>
					<td>${dto.teach_id}</td>
					<td>${dto.teach_name}</td>
					<td>${dto.teach_phone}</td>
					<td><button class="detail-btn"
							onclick="location.href='./teachUpdateServlet.do?id=${dto.teach_id}'">상세보기</button></td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" class="text-center">
						<form action="./teachAddServlet.do" method="get">
							<button type="submit" class="add-btn">강사등록</button>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
