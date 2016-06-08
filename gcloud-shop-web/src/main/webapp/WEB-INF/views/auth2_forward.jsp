<%@page import="com.gcloud.shop.core.tb.TBConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.sendRedirect(new StringBuilder("https://oauth.taobao.com/authorize?response_type=code&client_id=").append(TBConstant.APPKEY)
			.append("&redirect_uri=http://shop.gcloud.com/auth2.do&state=1000&view=web").toString()); %>