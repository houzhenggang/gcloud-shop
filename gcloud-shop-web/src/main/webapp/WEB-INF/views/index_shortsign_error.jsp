<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String redirectUri = (String)request.getAttribute("redirectUri");
	if(redirectUri == null || redirectUri == "")
		redirectUri = "/index.html#/index/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8"/>
	<title>短授权出错</title>
	<link type="image/x-icon" href="favicon.ico" rel="shortcut icon">	
</head>
<body>
	<script>
		var wd = parent;		
		var redirectUri = '<%=redirectUri %>';
		if(typeof(wd.RayCloud) == 'undefined'){
			alert('<%=request.getAttribute("error")%>');
			window.location.href = redirectUri;
		}else{
			wd.RayCloud.pub('iframe.shortsign.error', '<%=request.getAttribute("error")%>', true);
		}
	</script>
	绑定出错，请重新绑定，谢谢！
</body>