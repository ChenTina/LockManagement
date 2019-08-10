<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		 welcome!
		${requestScope.product.id } 
		${requestScope.product.logintime } 
		${requestScope.product.logouttime } 
		${requestScope.product.user } 
		${requestScope.product.agentid }
		${requestScope.product.address } 
		${requestScope.product.user } 
		${requestScope.product.commerciality } 
		${requestScope.product.factorytime } 
		${requestScope.product.renttime } 
		添加成功！

</body>
</html>