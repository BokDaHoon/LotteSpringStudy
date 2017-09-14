<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form>
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력해주세요.">
  </div>
   <div class="form-group">
    <label for="name">닉네임</label>
    <input type="text" class="form-control" id="name" name="name" placeholder="닉네임을 입력해주세요.">
  </div>
  <div class="form-group">
    <label for="pw">비밀번호</label>
    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해주세요.">
  </div>
   <div class="form-group">
    <label for="pw2">비밀번호 확인</label>
    <input type="password" class="form-control" id="pw2" placeholder="비밀번호를 확인해주세요.">
  </div>
  <button type="submit" class="btn btn-primary" id="register">회원가입</button>
</form>

<script>
$('#register').click(function(e){
	e.preventDefault();
	
	var Auth = {
		id: $('#id').val(),
		pw: $('#pw').val(),
		name: $('#name').val()
	};
	
	if(Auth.id == '' || Auth.pw == '' || Auth.name == ''){
		alert("모두 입력해주세요");
		return false;
	}
	
	if(Auth.pw.length < 4){
		alert("비밀번호 4글자 이상");
		return false;
	}
	
	$.ajax({
		type : 'POST',
		url : '/auth/joinRequest',
		data: Auth,
		dataType: 'json',
		success : function(obj) {
			if(obj.code == 1){
				location.href = '/board';
			} else {
				alert(obj.result);
			}
		}
	});
});

</script>