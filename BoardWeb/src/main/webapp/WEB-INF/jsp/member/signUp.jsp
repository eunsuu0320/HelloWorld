<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입</h3>
<form name="signForm" action="signup.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input required class="form-control" type="text" name="userId"></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input required class="form-control" type="password" name="userPw"></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input required class="form-control" type="text" name="userName"></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
// document.forms
let check = false;
document.forms.signForm.addEventListener('submit', function (e) {
	if (!check) {
		e.preventDefault();
		alert("입력 값을 확인하세요.");
		return;
	}
	
	this.submit();
})

document.querySelector('input[name="userId"]').addEventListener('change', function (e) {
	let user = this.value;
	fetch('checkId.do?id=' + user)
	.then(data => data.json())
	.then(result => {
		if (result.retCode == 'Exist') {
			alert("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
			document.querySelector('input[name="userId"]').focus();
			document.querySelector('input[name="userId"]').value = "";
		} else {
			alert("사용 가능한 아이디 입니다.");
			check = true;
		}
	})
	.catch(err => console.log(err))
})

document.querySelector('input[name="userPw"]').addEventListener('change', function (e) {
	let pw = this.value;
	
	if (pw.length < 5) {
		alert("5자 이상으로 입력하세요.");
		document.querySelector('input[name="userPw"]').focus();
		document.querySelector('input[name="userPw"]').value = "";
	} else {
		check = true;
	}
}) // 비밀번호 길이
</script>