<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.min.edu.dto.LoginDto"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>강사 전체 조회</title>
    <!-- 사용자 정의 CSS 추가 -->
    <link rel="stylesheet" href="./css/styles.css">
</head>
<%
    LoginDto dto = (LoginDto)request.getAttribute("dto");
%>
<body>
    <div class="container">
        <!-- 환영 메시지 -->
        <div class="welcome-msg">
            <h2><%=dto.getTeach_name()%>님 환영합니다.</h2>
        </div>
        <hr>

        <!-- 메뉴 목록 -->
        <div class="card">
            <h3>학생</h3>
            <ul>
                <li><a href="./stuListServlet.do">학생조회</a></li>
            </ul>
        </div>

        <div class="card">
            <h3>강사</h3>
            <ul>
                <li><a href="./teachListServlet.do">강사조회</a></li>
            </ul>
        </div>

        <div class="card">
            <h3>수업</h3>
            <ul>
                <li><a href="./manageLec.do">수업관리</a></li>
            </ul>
        </div>

        <div class="card">
            <h3>결재</h3>
        </div>

        <!-- 로그아웃 버튼 -->
        <a href="./loginServlet.do" class="btn">로그아웃</a>
    </div>
</body>
</html>
