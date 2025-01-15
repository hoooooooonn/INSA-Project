<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 이름 검색</title>
</head>
<body>
	<table border="1">
	<c:forEach var="s" items="${stu}" varStatus="vs">
		<tr>
		<td>${s.stu_id}</td>
		<td>${s.stu_name}</td>
		<td>${s.age}세</td>
		<td><input type="button" value="선택" onclick="send(this)"></td>
		</tr>
	</c:forEach>
	</table>
</body>
<script type="text/javascript">
function send(button) {
	var tr = button.closest('tr');
	var stuId = tr.querySelector('td').textContent;
    console.log("선택된 row의 stu_id값:", stuId);
    opener.document.getElementById("stuidDiv").value  = stuId;
    self.close();
}
</script>
</html>