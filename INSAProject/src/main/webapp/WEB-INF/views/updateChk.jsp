<%@page import="com.min.edu.dto.EduDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수업확인 수정</title>
<c:set var="d" value="${dto}"/>
</head>

<body>
	<form action="./updateChk.do" method="post">
		<input type="hidden" name="seq" value="${d.getSeq()}">
	<table>
		<tr>
			<td>SEQ</td>
			<td>수업</td>
			<td>강사이름</td>
			<td>학생이름</td>
			<td>수업회차</td>
			<td>강사확인</td>
			<td>학생확인</td>
			<td>최종확인</td>
		</tr>

		<tr>
			<td>${d.getSeq()}</td>
			<td>${d.getLec_name()}</td>
			<td>${d.getTeach_name()}</td>
			<td>${d.getStu_name()}</td>
			<td>${d.getLec_cnt()}</td>
			<td>
<!-- 				<select> -->
<%-- 					<option value="Y" ${d.getTeach_conf().equalsIgnoreCase('Y')?"selected":""}>Y</option> --%>
<%-- 					<option value="N" ${d.getTeach_conf().equalsIgnoreCase('N')?"selected":""}>N</option> --%>
<!-- 				</select> --> 

			<select name="teach">
						
							<option value="Y" ${d.getTeach_conf() eq 'Y' ?"selected":""}>Y</option>
							<option value="N" ${d.getTeach_conf() eq 'N' ?"selected":""}>N</option>
					
						
			</select>
			</td>
			<td>
<!-- 				<select> -->
<%-- 					<option value="Y" ${d.getStu_conf().equalsIgnoreCase('Y')?"selected":"" }>Y</option> --%>
<%-- 					<option value="N" ${d.getStu_conf().equalsIgnoreCase('N')?"selected":"" }>N</option> --%>
<!-- 				</select> -->
				<select name="student">
							<option value="Y" ${d.getStu_conf() eq 'Y' ?"selected":""}>Y</option>
							<option value="N" ${d.getStu_conf() eq 'N' ?"selected":""}>N</option>
			</select>
			</td>
			<td>
<!-- 				<select> -->
<%-- 					<option value="Y" ${d.getConfirm().equalsIgnoreCase('Y')?"selected":"" }>Y</option> --%>
<%-- 					<option value="N" ${d.getConfirm().equalsIgnoreCase('N')?"selected":"" }>N</option> --%>
<!-- 				</select> -->
				<select name="confirm">
							<option value="Y" ${d.getConfirm() eq 'Y' ?"selected":""}>Y</option>
							<option value="N" ${d.getConfirm() eq 'N' ?"selected":""}>N</option>
			</select>
			</td>
			<td>
				<input type="submit" value="수정">
				<input type="button" value="삭제" onclick="delCheck()">
			</td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
function delCheck(){
	location.href="./delCheck.do?seq=${d.getSeq()}";
}

</script>
</html>