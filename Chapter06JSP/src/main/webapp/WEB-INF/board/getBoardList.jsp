<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�۸��</title>
</head>
<body>
<center>
<h1>�Խñ� ���</h1>
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
				<td bgcolor="red" width="100">��ȣ</td>
				<td bgcolor="red" width="200">����</td>
				<td bgcolor="red" width="150">�ۼ���</td>
				<td bgcolor="red" width="200">����</td>
				<td bgcolor="red" width="150">�����</td>
				<td bgcolor="red" width="100">��ȸ��</td>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.seq}</td>
				<td align="left"><a href="getBoard?seq=${board.seq}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.content}</td>
				<td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
	</table>
<br>
<a href="insertBoard">���۵��</a>
</center>	
	
</body>
</html>