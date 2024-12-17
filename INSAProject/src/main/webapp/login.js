document.addEventListener("DOMContentLoaded", function() {
  // 모든 탭 요소를 가져옵니다.
  const tabs = document.querySelectorAll('.tab');
  // 모든 패널 요소를 가져옵니다.
  const panels = document.querySelectorAll('.panel');

  // 각 탭에 클릭 이벤트를 추가합니다.
  tabs.forEach((tab, index) => {
    tab.addEventListener('click', () => {
      // 모든 패널을 숨깁니다.
      panels.forEach(panel => panel.style.display = 'none');
      
      // 클릭한 탭에 맞는 패널을 표시합니다.
      panels[index].style.display = 'block';

      // 모든 탭에서 'active' 클래스를 제거합니다.
      tabs.forEach(tab => tab.classList.remove('active'));
      
      // 클릭한 탭에 'active' 클래스를 추가합니다.
      tab.classList.add('active');
    });
  });

  // 페이지 로드 시, 첫 번째 탭과 패널을 기본적으로 활성화합니다.
  tabs[0].classList.add('active');
  panels[0].style.display = 'block';
  
  
  
  
});


function windowOpen() {
    //window.open(url,title,속성) => 새로운 팝업창을 열어 줌
/*    var url = "./js_017_window_open_child.html";
    var title ="자식화면"
    var prop = "top=100px, left=300px, width=300px, height=500px";
    */
   // var urlName = url.substring(url.indexOf(".")+1, url.lastIndexOf("."));
	//console.log("접속사이트 이름 : ", urlName)
	var url = "https://www.naver.com"
	 var title ="자식화면"
	 var prop = "top=100px, left=300px, width=300px, height=500px";
	window.open(url,title, prop);

    //window.open(url,title,prop)    

}


function Login(){
	document.getElementsByTagName
	document.querySelectorAll('input[name="tab"]').forEach((input, index) => {
  input.addEventListener('change', function() {
    if (input.checked) {
      console.log(`선택된 탭의 인덱스: ${index}`);  // 인덱스를 출력
    }
  });
});


}