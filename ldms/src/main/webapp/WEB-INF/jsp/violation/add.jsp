<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>

<body>
	<h3>위반 차량 정보 등록</h3>

	<form = action="/violation/add" method="post">		
		차량번호: <input type="text" name="no">	<br>
		모델명: <input type="text" name="model"><br>
		배기량: <input type="text" name="cc">	<br>
		위반일시: <input type="text" name="violationDate"><br>
			   <input type="submit" value="등록">
	</form>
</body>
</html>