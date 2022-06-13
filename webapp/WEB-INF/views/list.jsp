<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>연락처</title>
	</head>
	<body>
		<h1>전화번호부</h1>
		<p>입력한 정보의 내역입니다.</p>
		
		<c:forEach items="${pList}" var="p" varStatus="status">
			<table border="1">
				<tr>
					<td>이름(name)</td>
					<td>${p.name }</td>
				</tr>
				<tr>
					<td>휴대전화(hp)</td>
					<td>${p.hp }</td>
				</tr>
				<tr>
					<td>회사번호(company)</td>
					<td>${p.company }</td>
				</tr>
				<tr>
					<td><a href="./updateForm?personId=${p.personId }">[수정]</a></td>
					<td><a href="./delete/${p.personId }">[삭제]</a></td>
				</tr>
			</table>
			<br>
		</c:forEach>
		
		<a href="./writeForm">추가번호 등록</a>
	</body>
</html>