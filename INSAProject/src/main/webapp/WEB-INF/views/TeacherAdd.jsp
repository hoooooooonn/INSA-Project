<%@ page import="java.util.List"%>
<%@ page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>강사 등록</title>
    <link rel="stylesheet" href="./css/teacherAdd.css">
</head>
<%
    List<LoginDto> lists = (List<LoginDto>) request.getAttribute("teacherList");
%>
<body>

    <div class="container">
        <h2>🎀 신규 강사 등록 🎀</h2>
        <form action="./teachAddServlet.do" method="post" class="form">
            <table class="table4">
                <thead>
                    <tr>
                        <th colspan="2">강사 정보 입력</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>아이디</th>
                        <% int newTeacherId = lists.size() + 1; %>
                        <td>
                            <input type="text" name="id" value="<%= newTeacherId %>" disabled>
                            <input type="hidden" name="id" value="<%= newTeacherId %>">
                        </td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="name" placeholder="강사 이름을 입력하세요" required></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input type="text" name="phone" placeholder="전화번호를 입력하세요" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="text-center">
                            <input type="submit" value="강사 등록" class="btn btn-submit">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>
