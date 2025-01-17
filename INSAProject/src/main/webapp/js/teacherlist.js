function UpdateUser() {
	alert("updateUser");
}


function deleteUser() {
	let con = confirm('정말 삭제하시겠습니까?');
	console.log(con);

	if (con == true) {
		location.href="./teachDeleteServlet.do";
		alert('삭제완료');
	} else {
		alert('취소완료');
	}
}


function AddTeacher(){
	location.href="./teachAddServlet.do";
}