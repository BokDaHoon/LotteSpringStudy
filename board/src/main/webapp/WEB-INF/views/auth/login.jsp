<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form>
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력해주세요.">
    <small id="emailHelp" class="form-text text-muted">We'll never share your ID with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해주세요.">
  </div>
  <button type="submit" class="btn btn-primary" id="login">로그인</button>
</form>

<script>

$('#login').click(function(e){
	e.preventDefault();
	
	var Auth = {
		id: $('#id').val(),
		pw: $('#pw').val()
	}
	
	if(Auth.id == '' || Auth.pw == ''){
		alert("모두 입력해주세요");
		return false;
	}
	
	$.ajax({
		type : 'POST',
		url : '/auth/loginRequest',
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