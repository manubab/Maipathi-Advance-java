<%@ page language="java" contentType="text/html;
     charset=UTF-8"
	pageEncoding="UTF-8"
	import="test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="ob" class="test.ProductBean" scope="session" />
	<jsp:setProperty property="code" param="code" name="ob" />
	<jsp:setProperty property="name" param="name" name="ob" />
	<jsp:setProperty property="price" param="price" name="ob" />
	<jsp:setProperty property="qty" param="qty" name="ob" />
	<%
	out.println("Product details loaded to Bean Object.....!<br>");
	%>
	<a href="view.jsp">ViewDetailsFromBean</a>

</body>
</html>