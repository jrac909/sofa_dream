<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="getuser()" value="获取用户">获取用户</button>
	<button onclick="adduser()" value="添加用户">添加用户</button>
	<button onclick="deluser()" value="删除用户">删除用户</button>
	<button onclick="batchDelUser()" value="批量删除">批量删除</button>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery-3.2.0.js"></script>
<script type="text/javascript">
function getuser(){
	alert("成功调用函数");
	$.ajax({
		data : {
	        "id" : "1" //用户id
	    },
	    url:"/Sofa/user/get",
	    dataType:"json",
	    type:'POST',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	    success : function(result){
	        var showMess = result.msg;//失败提示消息
	        if(!showMess){
	        	showMess = "系统忙,请稍后重试";
	        }
	        var phoneNos = result.data.username;
	      	alert(phoneNos);
	    },
	    error : function() {
			alert("cuole");
	    }
	})
}
function adduser(){
	alert("成功调用函数");
	$.ajax({
		data : {
			"username":"用户004",
			"password":"密码",
			"email":"邮箱",
			"photo":"头像",
			"sign":"梦里清风明月",
			"role":1,
			"vip":7,
			"status":0,
			"create_date":"创建时间",
			"update_date":"修改时间"
	    },
		url:"/Sofa/user/add",
		dataType:"json",
		type:'POST',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("成功");
		}
	})
}
function deluser(){
	alert("调用删除");
	$.ajax({
		data:{
			'id':1
		},
		url:'/Sofa/user/del',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("成功删除");
		},
		error:function(){
			alert("删除失败");
		}
	})
}
function batchDelUser(){
	alert("调用批量删除");
	var ids = [];
	ids.push(12);
	ids.push(13);
	$.ajax({
		data:{
			'ids':ids
		},
		url:'/Sofa/user/batchDel',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("批量删除成功");
		},
		error:function(){
			alert("批量删除失败");
		}
	})
}
</script>
</html>