<%@page import="com.entity.Video"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html >
<html>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" type="text/css">
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/main.js" type="text/javascript"></script>
<style>
.video-view{
	width: 310px;
    height: 150px;
    margin: 10px;
    margin: 12px 0px 10px 15px;
    float: left;
    overflow: hidden;
    position: relative;
    text-align: center;
    border-radius: 0px 0px 8px 8px;
    box-shadow: 2px 5px 5px #aaa;
    cursor: default;
    color: #FFF;
}
.video-title{
	line-height: 30px;
    display: block;
    background-color: #0088cc;
    font-size: 16px;
    font-weight: 600;
    text-align: center;
}
.thumbnail{
	float:left;
	width:150px;
	height:120px;
	border:none;
}
.video-desc{
	display: block;
    float: right;
    font-size: 14px;
    color: black;
    text-align: left;
    padding: 1px;
    width: 150px;
    height: 100%;	
	
}
</style>
</head>
<body>
	<div id="nav"></div>
<%
		String basePath=request.getRealPath("/");
		List<Video> list=(List<Video>)request.getAttribute("list");
		if(list!=null) for(Video v:list){
		%>
		<div><a href="playVideo.jsp?url=<%=v.getUrl()%>"><%=v.getTitle() %></a></div>
		<%} %>

<%-- <div class="video-view">
            	<small class="video-title">第一节课...</small>
                <img src="http://ytimg.googleusercontent.com/vi/IAxzYNo6bWg/mqdefault.jpg" class="thumbnail">
                <small class="video-desc" >这节课说了好多...</small>
</div> --%>
	<div id="footer"></div>
</body>
</html>