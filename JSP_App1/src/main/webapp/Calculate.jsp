<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	  int fact = 1;

	  int factorial(int n) {
		for (int i = n; i >= 1; i++) {
			fact += i;
		}
		return fact;
	}%>
	
	
	<%!
	   int n=Integer.parseInt(request.getParameter("v"));
	   int pro=factorial(n);
	   
	   out.println("Factorial "+pro+"<br>");
	   %>
	   
	   
	   <%@ include file="input.html" %>
</body>
</html>