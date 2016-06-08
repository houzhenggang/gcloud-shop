<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8"/>
	<title>重新授权出错</title>
	<link type="image/x-icon" href="favicon.ico" rel="shortcut icon">	
</head>
<body>
	<script>
		var wd = parent;
		if(typeof(wd.RayCloud) == 'undefined'){
			window.location.href = "/index.html#/setting/shop_info/?authorized=false";
		}else{
			wd.RayCloud.pub('iframe.reOauth.error', '<%=request.getAttribute("error")%>', true);
		}
	</script>
	重新授权出错，请重新授权，谢谢！
</body>