<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String redirectUri = request.getParameter("redirectUri");
	if(null == redirectUri){
		Object redirectUriObj = request.getAttribute("redirectUri");
		if(redirectUriObj != null){
			redirectUri = String.valueOf(redirectUriObj);
		}
	}
	if(null == redirectUri){
		response.sendRedirect("/index.html");
	} else {
		response.sendRedirect("/index.html#" + redirectUri);
	}
%>