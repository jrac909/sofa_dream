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
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery-3.2.0.js"></script>
<script type="text/javascript">
function getuser(){
	alert("成功调用函数");
	$.ajax({
		data : {
	        "phoneNoNums" : "12" //请求的手机号码
	    },
	    url:"/Sofa/user/get",
	    dataType:"json",

	    success : function(result){
	        var showMess = result.msg;//失败提示消息
	        if(!showMess){
	        	showMess = "系统忙,请稍后重试";
	        }
	        //获取可售的手机号码
	        var phoneNos = result.data.username;
	      	alert(phoneNos);
	    },
	    error : function() {
			alert("cuole");
	    }
	})
}
</script>
</html>