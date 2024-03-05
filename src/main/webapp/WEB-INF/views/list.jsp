<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>리스트</h2>

	<p>등록된 전화번호 리스트입니다.</p>

	<c:forEach items="${personList}" var="pList">
		<table border="1">
			<tr>
				<th>이름(name)</th>
				<td>${pList.name}</td>
			</tr>
			<tr>
				<th>핸드폰(hp)</th>
				<td>${pList.hp}</td>
			</tr>
			<tr>
				<th>회사(company)</th>
				<td>${pList.company}</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/delete?no=${pList.personId}">[삭제]</a></td>
				<td><a href="${pageContext.request.contextPath}/modifyform?no=${pList.personId}">[수정]</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	<a href="${pageContext.request.contextPath}/writeform">추가번호 등록</a>

</body>
</html>