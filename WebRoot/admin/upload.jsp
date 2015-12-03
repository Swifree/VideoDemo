<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>视频上传</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<script src="js/main.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/video-js.css" />
<script src="js/video.js" type="text/javascript"></script>

  </head>
  
  <body>
  <p>上传视频</p>
  <div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal" action="admin/Video_add" method="post" enctype="multipart/form-data">
			
				<div class="control-group">
					 <label class="control-label" for="title">标题</label>
					<div class="controls">
						<input id="title" name="title" type="text" required/>
					</div>
				</div>
				
				
				
				<div class="control-group">
					 <label class="control-label" for="detail">介绍</label>
					<div class="controls">
						<input id="detail" name="detail" type="text" />
					</div>
				</div>
				
				<div class="control-group">
					 <label class="control-label" for="inputUrl">视频</label>
					<div class="controls">
						<input id="inputUrl" type="file" name="file" accept="video/*" required/>
					</div>
				</div>
				
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn">添加</button>
					</div>
				</div>
				
			</form>
		</div>
	</div>
</div>
 
   
  </body>
</html>
