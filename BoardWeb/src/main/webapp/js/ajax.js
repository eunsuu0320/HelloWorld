/**
 * ajax.js
 * Asynchronous Javascript And Xml
 */
// 비동기 vs 동기 방식
// 비동기 방식은 아래 세 코드가 다 같이 동시에 실행한다.
/*setTimeout(function() {
	console.log("1");
}, 1000); // 일정 시간이 지나면 이 함수를 실행 시키겠다. 적은 건 1초

setTimeout(function() {
	console.log("2");
}, 2000);

setTimeout(function() {
	console.log("start")
}, 2500);*/

// {"id": 1, "first_name": "Hong"} => json객체
// -> {id : 1, first_name : Hong} => javascript 객체

// 객체. XMLHttpRequ;set
	console.log("start");
let xhtp = new XMLHttpRequest(); // 대표적인 비동기 방식
xhtp.open('get', 'replyList.do?bno=1302'); // 요청할 페이지 지정
xhtp.send(); // 페이지 요청
xhtp.onload = function () {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function (item) {
		console.log(item);
		let tr = document.createElement('tr');
		// r글번호 내용 작성자
		for(let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');
		td.innerHTML = item[prop];
		tr.appendChild(td);			
		}
		// button 만들기
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		
		document.querySelector('tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

function memberList() {
	//console.log("2");
	//console.log(xhtp.responseText); //pasing 파싱 하기 전 {"id": 1, "first_name": "Hong"}
	let data = JSON.parse(xhtp.responseText);
	//console.log(data); // 파싱 이후 {id : 1, first_name : Hong}
	let str = "<ul>"
	data.forEach(function(item, idxm, arr) {
		console.log(item);
		str += "<li>" + item.id + ", " + item.first_name + "</li>";
	});
	str += "<ul>";
	document.querySelector('#show').innerHTML = str;
}
console.log("end");

// 순차적으로 코드가 진행되는 게 동기 방식 (1번이 끝나야 2번, 2번이 끝나야 3번)




// fetch('data/sample.json') 