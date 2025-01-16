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
<script type="text/javascript" src="./js/insertLec.js"></script>
    <link rel="stylesheet" href="./css/insertLecCss.css">
</head>
<body>
	<form action="./insertLec.do" method="post">
	<table>
	<h2>신규수업 추가</h2>
		<tr>
			<td>학생이름
				<input type="text" id="student" >
<!-- 			</td> -->
<!-- 			<td> -->
				<input type="hidden" id="stuidDiv" name="student"></input>
<!-- 			</td> -->
<!-- 			<td> -->
				<input type="button" id="searchbtn" value="검색" onclick="stuOpen()">
			</td>
		</tr>
		<tr>
			<td>담당강사
				<input type="text" id ="teacher">
<!-- 			</td> -->
<!-- 			<td> -->
				<input type="hidden" id="teaidDiv" name ="teacher"></input>
<!-- 			</td> -->
<!-- 			<td> -->
				<input type="button" id="searchbtn" value="검색" onclick="teaOpen()">
			</td>
		</tr>
		<tr>
			<td>수업
				<select name="lec">
					<option value="10">보컬</option>
					<option value="20">통기타</option>
					<option value="30">일렉기타</option>
					<option value="40">드럼</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>요일
				<select name="days">
					<option value="월">월</option>
					<option value="화">화</option>
					<option value="수">수</option>
					<option value="목">목</option>
					<option value="금">금</option>
					<option value="토">토</option>
					<option value="일">일</option>
				</select>
<!-- 				<input type="button" value="선택" onclick="selectday()"> -->
			</td>
		</tr>
		<tr>
			<td>시간
			<select name="clock">
				<c:forEach var="i" begin="10" end="20" step="1">
					<option value="${i}">${i}시</option>
				</c:forEach>
			</select>
			</td>
		</tr>
	</table>
	
<input type="submit" value="완료">
<input type="button" id="back" value="취소" onclick="history.back();">
	</form>
</body>
<script type="text/javascript">
	const frm = document.forms[0];
	frm.addEventListener('submit', (event)=>{
	event.preventDefault();
	let stu = document.getElementsByName("student")[0].textContent;
	let tea = document.getElementsByName("teacher")[0].textContent;
	let lec = document.getElementsByName("lec")[0].value;
	let days = document.getElementsByName("days")[0].value;
	let clock = document.getElementsByName("clock")[0].value;
	console.log(stu);
	console.log(tea);
	console.log(lec);
	console.log(days);
	console.log(clock);
	frm.action="./insertLec.do"
	frm.method="post"
	frm.submit()
})

// function selectday(){
// 	var days = document.getElementsByName("days")[1];
// 	var dayChoice = "";
// 	for(let i = 0 ; i < days.length ; i++){
// 		if(days.options[i].selected){
// 			dayChoice += day.options[i].textContent + "\n"
// 		}
// 	}}

</script>
</html>