<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
.box{
   width: 300px;
   background: #191919;
   text-align: center;
   padding: 40px;
   margin: 100px auto;
}

.box h2{
   color: white;
   text-transform: uppercase;
}

.box input[type=text], .box input[type=password]{
   border: 0px;
   background: none;
   margin: 20px auto;
   text-align: center;
   border: 2px solid #3479db;
   padding: 15px 10px;
   width: 200px;
   outline: none;
   color: white;
   border-radius: 25px;
   transition: 0.2s; 
}

.box input[type=text]:focus, .box input[type=password]:focus{
   width: 280px;
   border-color: orange;
}

.box input[type=submit]{
   border: 0px;
   background: none;
   margin: 20px auto;
   text-align: center;
   border: 2px solid #3479db;
   padding: 15px 10px;
   
   outline: none;
   color: white;
   border-radius: 5px;
   
   width: 100px;
   transition: 0.5s; 
   cursor: pointer;
}

.box input[type=submit]:hover{
   background: yellow;
   color: black;
}


</style>
</head>
<body>
	<form class="box" action="./loginServlet.do" method="post">
		<h2>인사 뮤직 아카데미</h2>
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