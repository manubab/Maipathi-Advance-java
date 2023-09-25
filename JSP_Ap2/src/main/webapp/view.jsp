<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ob" type="test.ProductBean" scope="session" />
	ProductCode :<jsp:getProperty property="code" name="ob" />
	ProducName :<jsp:getProperty property="name" name="ob" />
	ProductPrice:<jsp:getProperty property="price" name="ob" />
	ProductQty :<jsp:getProperty property="qty" name="ob" />
	
</body>
</html>