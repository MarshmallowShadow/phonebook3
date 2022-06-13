<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>등록</title>
	</head>
	<body>
		<h1>전화번호부</h1>
		<h2>등록폼</h2>
		
		<p>전화번호 등록할려면<br>
			아래 황목을 가입하고 "등록" 버튼을 눌러주세요
		</p>
		<form action="/phonebook3/write" method="get">
			<label for="name">이름(name)</label>
			<input type="text" id="name" name="name" value=""><br>
			<label for="hp">전화번호(hp)</label>
			<input type="text" id="hp" name="hp" value=""><br>
			<label for="company">회사번호(company)</label>
			<input type="text" id="company" name="company" value=""><br>
			<button type="submit">등록</button>
		</form>
	</body>
</html>