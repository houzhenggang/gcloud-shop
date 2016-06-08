<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8"/>
	<title>绑定店铺出错</title>
	<link type="image/x-icon" href="favicon.ico" rel="shortcut icon">	
</head>
<body>
	<script>
		var wd = parent;
		if(typeof(wd.RayCloud) == 'undefined'){
			alert('<%=request.getAttribute("error")%>');
			window.location.href = "/index.html#/index/";
		}else{
			alert('<%=request.getAttribute("error")%>');
		}
	</script>
	绑定店铺失败，请重启浏览器<br/>
	可能原因：绑定的店铺未订购超级掌柜！
</body>