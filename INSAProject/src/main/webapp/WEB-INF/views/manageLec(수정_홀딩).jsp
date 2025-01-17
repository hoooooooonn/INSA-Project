<%@page import="com.min.edu.dto.EduDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/teacherlist.css">
<title>수업관리</title>

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
</head>

<body>
   <div class="container">
        <div class="header">
            <span class="title"><b>수업관리</b></span>
            <!-- 검색 폼 -->
            <form action="./searchClass.do" method="get" class="search-form">
                <select name="role1">
                    <option value="">전체</option>
                    <option value="Y">완료</option>
                    <option value="N">미완료</option>
                </select>
                <select name="role2">
                    <option value="">전체</option>
                    <option value="학생">학생</option>
                    <option value="강사">강사</option>
                </select>
                <input type="text" name="search" placeholder="검색">
                <input type="submit" value="검색">
            </form>
        </div>

        <table class="table4">
            <thead>
                <tr>
                    <th>SEQ</th>
                    <th>수업</th>
                    <th>강사이름</th>
                    <th>학생이름</th>
                    <th>수업회차</th>
                    <th>강사확인</th>
                    <th>학생확인</th>
                    <th>최종확인</th>
                    <th>수정</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="d" items="${lists}" varStatus="vs">
                    <tr>
                        <td>${d.getSeq()}</td>
                        <td>${d.getLec_name()}</td>
                        <td>${d.getTeach_name()}</td>
                        <td>${d.getStu_name()}</td>
                        <td>${d.getLec_cnt()}</td>
                        <td>${d.getTeach_conf()}</td>
                        <td>${d.getStu_conf()}</td>
                        <td>${d.getConfirm()}</td>
                        <td>
                            <button type="button">수정</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

            <tfoot>
                <tr>
                    <td colspan="9" class="text-center">
                        <button id="backButton" class="back-btn" type="button">이전화면이동</button>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
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
	
	document.getElementById("backButton").addEventListener("click", function() {
	    history.back(-1);
	});
</script>
</html>