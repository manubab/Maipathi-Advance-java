<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.emp.test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<ProductBean> al=(ArrayList<ProductBean>)request.getAttribute("al");
 
if(al.size()==0)
{
	out.println("Products not available ");
}
else 
{
	Iterator<ProductBean> ob=al.iterator();
	
	while(ob.hasNext())
	{
		ProductBean p=(ProductBean)ob.next();
		
		out.println(p.toString());
	}
}
 
%>
</body>
</html>