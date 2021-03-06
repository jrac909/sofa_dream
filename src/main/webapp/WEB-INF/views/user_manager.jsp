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
	<button onclick="updateUser()" value="修改用户">修改用户</button>
	<button onclick="queryUser()" value="条件查询">条件查询</button>
	<button onclick="getUsers()" value="分页获取">分页获取</button>
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

function updateUser(){
	alert("调用修改用户");
	$.ajax({
		data:{
			'id':2,
			'password':'123456',
			'role':3,
			'status':0
		},
		url:'/Sofa/user/update',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("修改成功");
		},
		error:function(){
			alert("修改失败");
		}
	})
}
function queryUser(){
	alert("调用条件查询");
	$.ajax({
		data:{
			'username':'用户',
			'email':'邮箱',
			'role':'1',
			'vip':'3',
			'status':'0'
		},
		url:'/Sofa/user/query',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("条件查询成功");
		},
		error:function (){
			alert("条件查询失败");
		}
	})
}
function getUsers(){
	alert("调用分页获取");
	$.ajax({
		data:{
			'currentPage':'2',
			'pageSize':'3'
		},
		url:'/Sofa/user/getAll',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function (data){
			alert("获取用户成功");
		},
		error:function (){
			alert("获取用户失败");
		}
	})
}
</script>
</html>