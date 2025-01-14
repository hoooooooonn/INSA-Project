<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 수업 추가</title>
</head>
<body>
	<h2>신규수업 추가</h2>
	<table>
		<tr>
			<td>학생이름
					<select name="학생">
				<c:forEach var="d" items="${lists}" varStatus="vs">
						<option value="student">${d.stu_name}</option>
				</c:forEach>
					</select>
			</td>
		</tr>
		<tr>
			<td>담당강사
			<select name="강사">
				<c:forEach var="t" items="${teach}" varStatus="vs">
						<option value="teacher">${t.teach_name}</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>수업
				<select name="수업">
					<option value="lecName">보컬</option>
					<option value="lecName">통기타</option>
					<option value="lecName">일렉기타</option>
					<option value="lecName">드럼</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>요일
				<select name="요일">
					<option value="day">월</option>
					<option value="day">화</option>
					<option value="day">수</option>
					<option value="day">목</option>
					<option value="day">금</option>
					<option value="day">토</option>
					<option value="day">일</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>시간
			<select name="시간">
				<c:forEach var="i" begin="10" end="20" step="1">
					<option value="hour">${i}시</option>
				</c:forEach>
			</select>
			</td>
		</tr>
	</table>
	<input type="submit" value="완료">
</body>
</html>