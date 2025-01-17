<%@page import="com.min.edu.dto.EduDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<EduDto> lists = (List<EduDto>)request.getAttribute("lists");
%>
</head>
<body>
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
    	<%
			for (EduDto dto : lists) {
		%>
    <tr>
		<td><%=dto.getSeq() %></td>
        <td><%=dto.getLec_name() %></td>
        <td><%=dto.getTeach_name() %></td>
        <td><%=dto.getStu_name() %></td>
        <td><%=dto.getLec_cnt() %></td>
        <td><%=dto.getTeach_conf() %></td>
        <td><%=dto.getStu_conf() %></td>
        <td><%=dto.getConfirm() %></td>

    </tr>
    
			<%
			}
		%>
  </table>
</body>
</html>