<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 전체 조회</title>

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

<script type="text/javascript">
   function regist() {
      window.location.href = './registServlet.do';
   }
</script>

</head>
<%
    // 학생 목록을 request 속성에서 가져오기
    List<StudentDto> studentList = (List<StudentDto>) request.getAttribute("lists");
    // 검색어
    String searchName = (String) request.getAttribute("searchName");
%>
<body>

<h2>학생 목록</h2>

<!-- 검색 폼 -->
<form action="./stuListServlet.do" method="get">
    <label for="searchName">학생 이름: </label>
    <input type="text" id="searchName" name="searchName" value="<%= searchName != null ? searchName : "" %>" />
    <button type="submit">검색</button>
    <button type="submit">수정</button>
    <button type="submit" onclick="regist()">등록</button>
</form>

<br />

<table class="table4">
    <thead>
        <tr>
            <th>학생 ID</th>
            <th>학생 이름</th>
            <th>전화번호</th>
            <th>성별</th>
            <th>나이</th>
            <th>선호도</th>
            <th>메모</th>
        </tr>
    </thead>
    <tbody>
        <%
            if (studentList != null && !studentList.isEmpty()) {
                // 검색어가 있으면 해당 이름만 필터링하여 출력
                if (searchName != null && !searchName.trim().isEmpty()) {
                    for (StudentDto student : studentList) {
                        if (student.getStu_name().contains(searchName)) {
        %>
                            <tr>
                                <td><%= student.getStu_id() %></td>
                                <td><%= student.getStu_name() %></td>
                                <td><%= student.getStu_phone() %></td>
                                <td><%= student.getGen() %></td>
                                <td><%= student.getAge() %></td>
                                <td><%= student.getPref() %></td>
                                <td><%= student.getNote() %></td>
                            </tr>
        <%
                        }
                    }
                } else {
                    // 검색어가 없으면 전체 학생 목록을 출력
                    for (StudentDto student : studentList) {
        %>
                            <tr>
                                <td><%= student.getStu_id() %></td>
                                <td><%= student.getStu_name() %></td>
                                <td><%= student.getStu_phone() %></td>
                                <td><%= student.getGen() %></td>
                                <td><%= student.getAge() %></td>
                                <td><%= student.getPref() %></td>
                                <td><%= student.getNote() %></td>
                            </tr>
        <%
                    }
                }
            } else {
        %>
            <tr>
                <td colspan="7">검색된 학생이 없습니다.</td>
            </tr>
        <%
            }
        %>
    </tbody>
</table>

</body>
</html>
