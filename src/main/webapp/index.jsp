<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>

</head>
<body>
	<h3>欢迎, 呵呵</h3>
	<form action="${pageContext.request.contextPath }/buildNewAdmin" method="post">
	<label>名字：<input type="text" name="adminName" placeholder="请输入管理员名称"/></label><br>
	<label>密码：<input type="password" name="password"></label><br/>
	<label>头像：<input type="text" name="photo" palceholder="请输入文字"/></label><br/>
	<label>电话: <input type="text" name="number" /></label><br/>
	<label>角色：
		<select name="role">
			<option value="1" selected>普通管理员</option>
			<option value="2">超级管理员</option>
		</select>
	</label>
	<input type="hidden" name="createTime" value="" />
	<input type="hidden" name="updateTime" value="" />
	<input type="submit" value="添加" />
	</form>
	<br/>
	<form action="${pageContext.request.contextPath }/updateAdmin" method="post">
	<label>名字：<input type="text" name="adminName" placeholder="请输入管理员名称"/></label><br>
	<label>密码：<input type="password" name="password"></label><br/>
	<label>头像：<input type="text" name="photo" palceholder="请输入文字"/></label><br/>
	<label>电话: <input type="text" name="number" /></label><br/>
	<label>角色：
		<select name="role">
			<option value="1" selected>普通管理员</option>
			<option value="2">超级管理员</option>
		</select>
	</label>
	<input type="hidden" name="createTime" value="" />
	<input type="hidden" name="updateTime" value="" />
	<input type="submit" value="修改" />
	</form>
	<br/>
	<form action="${pageContext.request.contextPath}/deleteAdmin" method="post">
		<input type="text" name="id" value="4" />
		<input type="submit" value="删除">
	</form>
	<br/>
	<form action="${pageContext.request.contextPath}/getLog" method="post">
		<input type="text" name="adminId" value="2" />
		<input type="submit" value="查看日志">
	</form>
	<form action="${pageContext.request.contextPath}/getPageAdmin" method="post">
		<input type="text" name="size" value="5" />
		<input type="text" name="page" value="1">
		<input type="submit" value="分页查看">
	</form>
</body>
</html>