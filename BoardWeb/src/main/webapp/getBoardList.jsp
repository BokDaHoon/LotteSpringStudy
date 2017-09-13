<%@ page import="java.util.List" %>
<%@ page import="org.springframework.context.support.AbstractApplicationContext" %>
<%@ page import="org.springframework.context.support.GenericXmlApplicationContext" %>
<%@ page import="com.springbook.biz.board.BoardService" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

<%

	List<BoardVO> boardList = (List) session.getAttribute("boardList");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다...<a href="logout.do">Log-out</a></h3>
	<form action="getBoardList.jsp" method="post">
		<table border="1" cellpading="0" cellspacing="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<table border="1" cellpading="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			
			<% for (BoardVO board : boardList) { %>
			<tr>
				<td><%= board.getSeq() %></td>
				<td align="left"><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
				<td><%= board.getWriter() %></td>
				<td><%= board.getRegDate() %></td>
				<td><%= board.getCnt() %></td>
			</tr>
			<% } %>
		</table>
</body>
</html>