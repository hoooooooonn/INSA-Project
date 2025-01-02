<%@page import="com.min.edu.dto.EduDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수업확인 수정</title>
</head>
<%
	EduDto dto = (EduDto)request.getAttribute("dto");
%>
<body>
	<form action="./updateChk.do" method="post"></form>
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
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
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getLec_name() %></td>
			<td><%=dto.getTeach_name() %></td>
			<td><%=dto.getStu_name() %></td>
			<td><%=dto.getLec_cnt() %></td>
			
			<td>
				<select>
					<option value="Y" <%=dto.getTeach_conf().equalsIgnoreCase("Y")?"selected":"" %>>Y</option>
					<option value="N" <%=dto.getTeach_conf().equalsIgnoreCase("N")?"selected":"" %>>N</option>
				</select>
			</td>
			<td>
				<select>
					<option value="Y" <%=dto.getStu_conf().equalsIgnoreCase("Y")?"selected":"" %>>Y</option>
					<option value="N" <%=dto.getStu_conf().equalsIgnoreCase("N")?"selected":"" %>>N</option>
				</select>
			</td>
			<td>
				<select>
					<option value="Y" <%=dto.getConfirm().equalsIgnoreCase("Y")?"selected":"" %>>Y</option>
					<option value="N" <%=dto.getConfirm().equalsIgnoreCase("N")?"selected":"" %>>N</option>
				</select>
			</td>
			<td>
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</body>
</html>