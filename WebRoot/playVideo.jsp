<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/main.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/video-js.css" />
<script src="js/video.js" type="text/javascript"></script>

</head>
<body>
<div id="nav"></div>
<%String url=request.getParameter("url"); %>
	
	<video id="videoplayer" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
      data-setup="{}">
    
	<source src="<%=url %>" type="video/<%=url.substring(url.lastIndexOf('.')+1) %>">
    <!-- <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track>Tracks need an ending tag thanks to IE9
    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track>Tracks need an ending tag thanks to IE9 -->
</video>
<script type="text/javascript">
    var myPlayer = null;
    videojs("videoplayer").ready(function(){
        var myPlayer = this;
        myPlayer.play();
    });
</script>
</body>
</html>