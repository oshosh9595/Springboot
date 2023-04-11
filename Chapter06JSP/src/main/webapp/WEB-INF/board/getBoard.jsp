<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�� ��</title>
</head>
<body>
<center>
<h1>�Խñ� ��</h1>
<hr>
<form action="updateBoard" method="post">
<input name="seq" type="hidden" value="${board.seq}">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td>
		<td align="left"><input name="title" type="text" value="${board.title}"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left">${board.writer}</td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="10">
			${board.content }</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">�����</td>
		<td align="left"><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
	<tr>
		<td bgcolor="orange">��ȸ��</td>
		<td align="left">${board.cnt}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�� ����"/>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoardView">�۵��</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard?seq=${board.seq }">�ۻ���</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList">�۸��</a>
</center>
</body>
</html>