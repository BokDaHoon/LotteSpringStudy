<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<button type="button" class="btn btn-info float-right" style="margin-left: 10px;" id="logoutRequest">로그아웃</button>
<button type="button" class="btn btn-primary float-right" onclick="go('/board/write');">글쓰기</button>
<table class="table">
  <thead class="thead-inverse">
    <tr>
      <th>#</th>
      <th>제목</th>
      <th>작성자</th>
      <th>날짜</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${boardlist}" var="item">
  		<tr>
	      <th scope="row">${item.no }</th>
	      <td><a href="/board/read/${item.no }">${item.title }</a></td>
	      <td>${item.writer }</td>
	      <td>${item.date }</td>
	    </tr>
  	</c:forEach>
  </tbody>
</table>

<script>

$('#logoutRequest').click(function(){
	$.ajax({
		type : 'POST',
		url : '/auth/logoutRequest',
		success : function() {
			location.href = "/";
		}
	});
});
</script>