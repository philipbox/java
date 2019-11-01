<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>
<h2>파일 전송</h2>
	<form action="/fileupload" id="fileupload" name="fileupload"
		method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<table border="1">
			<tr>
				<th>&nbsp;파일&nbsp;</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="파일 전송"></td>
			</tr>
		</table>


	</form>
</body>
</html>