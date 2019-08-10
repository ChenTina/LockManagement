<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	
	<form action="${pageContext.request.contextPath }/user/insertUser.action">
		<table border="1">
		<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex"></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>人员类别</td>
				<td><input type="text" name="usertype"></td>
			</tr>
			<tr>
				<td>所在小区</td>
				<td><input type="text" name="community"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input type="text" name="idcard"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>  
	
	
	<form action="${pageContext.request.contextPath }/user/queryUserByname.action">
		<table border="1">
		<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  
	
	<form action="${pageContext.request.contextPath }/user/queryUserBySex.action">
		<table border="1">
		<tr>
				<td>性别</td>
				<td><input type="text" name="sex"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  
	
	<form action="${pageContext.request.contextPath }/user/findAlluser.action">
		<table border="1">
		
			<tr>
				<td><input type="submit" value="查询全部"></td>
			</tr>
		</table>
	</form> 
	
	
	<form action="${pageContext.request.contextPath }/user/queryUserByCtime.action">
		<table border="1">
		<tr>
				<td>开始时间</td>
				<td><input type="text" name="startTime"></td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td><input type="text" name="endTime"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  
	
	<form action="${pageContext.request.contextPath }/user/queryUserByAge.action">
		<table border="1">
		<tr>
				<td>开始年龄</td>
				<td><input type="text" name="ages"></td>
			</tr>
			<tr>
				<td>结束年龄</td>
				<td><input type="text" name="agee"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  
	
	<form action="${pageContext.request.contextPath }/user/queryUserBynnc.action">
		<table border="1">
		<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input type="text" name="idcard"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  

<form action="${pageContext.request.contextPath }/user/findAllmark.action">
		<table border="1">
		
			<tr>
				<td><input type="submit" value="查询全部记录"></td>
			</tr>
		</table>
	</form>
	
	
 <form action="${pageContext.request.contextPath }/user/upload.action"  method="post" enctype="multipart/form-data">

  <label>姓名：</label><input type="text" name="name"><br>
  <label>姓别：</label><input type="text" name="sex"><br>
  <label>省份证：</label><input type="text" name="idcard"><br>
  <label>地址：</label><input type="text" name="address"><br>

  <label>上传头像：</label><input type="file" name="file"><br>

  <input type="submit">

  </form>
  
  <form action="${pageContext.request.contextPath }/user/mohuquery.action">
		<table border="1">
		<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>  
	

</body>
</html>