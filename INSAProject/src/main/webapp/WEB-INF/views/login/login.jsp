<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>인사 뮤직 아카데미</h2>
	<form action="./loginServlet.do" method="post">
		<div class="warpper">

			<div class="panels">
				<div class="panel" id="one-panel">
					<input type="text" name="id" placeholder="ID 입력"> <input
						type="text" name="pw" placeholder="PW 입력">
					<input type="submit" value="로그인">
				</div>

			</div>
		</div>

	</form>
</body>
</html>