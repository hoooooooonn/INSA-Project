<%@ page import="java.util.List"%>
<%@ page import="com.min.edu.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>강사 목록 조회</title>
    <script type="text/javascript" src="./js/teacherlist.js"></script>
    <link rel="stylesheet" href="./css/teacherlist.css">
</head>
<%
    List<LoginDto> lists = (List<LoginDto>) request.getAttribute("teacherList");
%>
<body>
    <div class="container">
        <div class="header">
            <span class="title"><b>강사 전체 목록</b></span>
            <button class="back-btn" onclick="history.back(-1)">이전페이지</button>
        </div>
        <hr>

        <table class="table4">
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>상세보기</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (LoginDto dto : lists) {
                %>
                <tr>
                    <td><%=dto.getTeach_id()%></td>
                    <td><%=dto.getTeach_name()%></td>
                    <td><%=dto.getTeach_phone()%></td>
                    <td><button class="detail-btn" onclick="location.href='./teachUpdateServlet.do'">상세보기</button></td>
                </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4" class="text-center">
                        <form action="./teachAddServlet.do" method="get">
                            <button type="submit" class="add-btn">강사등록</button>
                        </form>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>
