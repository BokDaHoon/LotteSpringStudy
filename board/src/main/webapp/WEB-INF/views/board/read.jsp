<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<button type="button" class="btn btn-info float-right" id="list">목록</button>
<c:if test="${id eq vo.writer_id }">
	<button type="button" class="btn btn-success float-right" id="edit" style="margin-right: 5px;">수정</button>
	<button type="button" class="btn btn-danger float-right" id="delete" style="margin-right: 5px;">삭제</button>
</c:if>

<h5>Title : ${vo.title }</h1>
<h5>Writer : ${vo.writer }</h5>
<h5>Date : ${vo.date }</h5>
<hr>
<h3>Content</h3>
${vo.content }

<script>
$('#list').click(function(){
	location.href = '/board';
});

$('#edit').click(function(){
	location.href = '/board/edit/${vo.no}';
});

$('#delete').click(function(){
	$.ajax({
		type : 'POST',
		url : '/board/delete/${vo.no}',
		success : function() {
			location.href = "/board";
		}
	});
});
</script>
