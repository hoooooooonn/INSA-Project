<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.LecDto"%>
<%@page import="com.min.edu.dto.CheckDto"%>
<%@page import="com.min.edu.dto.EduDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<%
	List<EduDto> lists = (List<EduDto>)request.getAttribute("lists");

%>
<body>
<form action="./manageLec.do" method="post">
<h1>수업관리</h1>
<table>
    <tr>
        <td>
            <select name="role1">
                <option value="">전체</option>
                <option value="Y">완료</option>
                <option value="N">미완료</option>
            </select>
        </td>
        <td>
            <select name="role2">
                <option>전체</option>
                <option value="학생">학생</option>
                <option value="강사">강사</option>
            </select>
        </td>
        <td>
            <input type="text" name="search"><input type="submit" value="검색">
        </td>
	</tr> 
	  </table>
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
		<td>
			<button type="button">수정</button>
		</td>
    </tr>
    
    
    
			<%
			}
		%>
		
		<tfoot>
			<tr>
				<th colspan="8">
					<button type="button" onclick="history.back(-1)">이전화면이동</button>
				</th>
			</tr>
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
</script>
</html>