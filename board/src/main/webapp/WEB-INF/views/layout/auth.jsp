<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:choose>
	<c:when test="${!isLogged}">
		<%@ include file="/WEB-INF/views/auth/default.jsp"%>
	</c:when>
	<c:otherwise>
		<h3>${auth.name } 님 환영해요!</h3>
	</c:otherwise>
</c:choose>
