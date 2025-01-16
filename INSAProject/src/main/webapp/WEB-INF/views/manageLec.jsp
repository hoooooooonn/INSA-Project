<%@page import="com.min.edu.dto.EduDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>수업관리</title>
<link rel="stylesheet" href="./css/manageLecCss.css">
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
<body>
<form action="./manageLec.do" method="post">
		<table>
				
			<tr>
				<td>
				<h1>수업관리</h1>
				</td>
					<td>
				<select name="role1">
						<option value="">전체</option>
						<option value="Y">완료</option>
						<option value="N">미완료</option>
				</select>
<!-- 				</td> -->
<!-- 				<td> -->
				<select name="role2">
						<option>전체</option>
						<option value="학생">학생</option>
						<option value="강사">강사</option>
				</select>
<!-- 				</td> -->
<!-- 				<td> -->
					<input type="text" name="search"><input type="submit" value="검색">
<!-- 				</td> -->
<!-- 				<td> -->
					<a href="./insertLec.do"><input type="button" value="추가" style="background-color: #2ee8e8"></a>
					<button style="text-align: center;" id="backButton" type="button">이전화면이동</button>
				</td>
			</tr>
		</table>
		<table class="table4">
			<thead>
				<tr>
					<td>SEQ</td>
					<td>수업</td>
					<td>강사이름</td>
					<td>학생이름</td>
					<td>수업회차</td>
					<td>강사확인</td>
					<td>학생확인</td>
					<td>최종확인</td>
					<td>수정</td>
				</tr>
			</thead>
<%-- 			<% --%>
<!--      	for (EduDto dto : lists) { -->
<%--     	%> --%>
<!-- 			<tr> -->
<%-- 				<td><%=dto.getSeq() %></td> --%>
<%-- 				<td><%=dto.getLec_name() %></td> --%>
<%-- 				<td><%=dto.getTeach_name() %></td> --%>
<%-- 				<td><%=dto.getStu_name() %></td> --%>
<%-- 				<td><%=dto.getLec_cnt() %></td> --%>
<%-- 				<td><%=dto.getTeach_conf() %></td> --%>
<%-- 				<td><%=dto.getStu_conf() %></td> --%>
<%-- 				<td><%=dto.getConfirm() %></td> --%>
<!-- 				<td> -->
<!-- 					<button type="button">수정</button> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<%-- 			<% --%>
<!--  			} -->
<%-- 		%> --%>

			<c:forEach var="d" items="${lists}" varStatus="vs">
				<tr>
					<td>${d.getSeq()}</td>
					<td>${d.getLec_name()}</td>
					<td>${d.getTeach_name()}</td>
					<td>${d.getStu_name()}</td>
					<td>${d.getLec_cnt()}</td>
					<td>${d.getTeach_conf()}</td>
					<td>${d.getStu_conf()}</td>
					<td>${d.getConfirm()}</td>
					<td>
						<button type="button">수정</button>
					</td>
				</tr>

			</c:forEach>

			<tfoot>
<!-- 	<tr> -->
<!-- 		<th colspan="8"> -->
<!-- 			<button id="backButton" type="button">이전화면이동</button> -->
<!-- 		</th> -->
<!-- 	</tr> -->
</tfoot>
		</table>
</form>
</body>
<script type="text/javascript">
	var btns = document.querySelectorAll("button");
	for (let i = 0 ; i < btns.length ; i++){
		btns[i].onclick = function (){
			var seq = this.parentNode.parentNode.children[0].textContent;
			console.log("선택된 row의 seq값", seq)
			location.href="./updateChk.do?seq="+seq;
		}
	}
	
	document.getElementById("backButton").addEventListener("click", function() {
	    history.back(-1);
	});
</script>
</html>