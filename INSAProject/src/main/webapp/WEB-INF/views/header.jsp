<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Global Navigation Bar</title>

    <!-- 사용자 정의 CSS 추가 -->
    <link rel="stylesheet" href="./css/styles.css">
    <!-- Bootstrap 3 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <!-- GNB (Global Navigation Bar) -->
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
            <!-- 성연메모 : 어차피 서블릿에서 session 으로 가져올거기때문에 굳이 id 보내줄 필요없음 -->
<%--                 <a class="navbar-brand " href="./mainpageServlet.do?id=${dto.teach_id}">Welcome, ${dto.teach_name}님</a> --%>
                <a class="navbar-brand" href="./mainpageServlet.do">Welcome, ${dto.teach_name}님</a>
            </div>

            <!-- 메뉴 항목 -->
            <ul class="nav navbar-nav">
                <li><a href="./stuListServlet.do">학생조회</a></li>
                <li><a href="./teachListServlet.do">강사조회</a></li>
                <li><a href="./manageLec.do">수업관리</a></li>
                <li><a href="#">결재</a></li>
                <li><a href="#">수업일지</a></li>
            </ul>

            <!-- 로그아웃 버튼 (우측에 배치) -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="./loginServlet.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
