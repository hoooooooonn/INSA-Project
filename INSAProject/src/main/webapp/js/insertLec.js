function stuOpen(){
	
	var url = "./searchStuServlet.do?student="+document.getElementById("student").value
	var title = "학생이름검색"
	var prop = "top=100px, left=300px, width=300px, height=500px"

	window.open(url,title,prop)
}


function teaOpen(){
	var url = "./SearchTeaServlet.do?teacher="+document.getElementById("teacher").value
	var title = "강사이름검색"
	var prop = "top=100px, left=300px, width=300px, height=500px"

	window.open(url,title,prop)
}