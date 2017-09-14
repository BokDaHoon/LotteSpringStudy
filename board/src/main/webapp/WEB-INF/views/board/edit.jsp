<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="post" action="/board/edit/${board.no }">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요." value=${board.title }>
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea class="form-control" name="content" id="content" rows="8">${board.content }</textarea>
  </div>
  <div class="form-group">
    <label for="file">파일 업로드</label>
    <input type="file" class="form-control-file" id="file" name="file">
  </div>
  
  <button type="submit" class="btn btn-primary">수정하기</button>
</form>