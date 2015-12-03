<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" >
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title></title>
<style type="text/css">
    /* Custom Styles */
    ul.nav-tabs{
        width: 140px;
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-tabs li{
        margin: 0;
        border-top: 1px solid #ddd;
    }
    ul.nav-tabs li:first-child{
        border-top: none;
    }
    ul.nav-tabs li a{
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
    }
    ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
        color: #fff;
        background: #0088cc;
        border: 1px solid #0088cc;
    }
    ul.nav-tabs li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-tabs li:last-child a{
        border-radius: 0 0 4px 4px;
    }
    ul.nav-tabs.affix{
        top: 30px; /* Set the top position of pinned element */
    }
</style>
<script type="text/javascript">
$(document).ready(function(){
    $("#myNav").affix({
        offset: { 
            top: 125 
     	}
    });
});
</script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
	<!-- <nav class="navbar navbar-default navbar-static-top" role="navigation">
    	<div class="container">
        	<div class="navbar-header">
            	<a href="#" class="navbar-brand" style="height:20px;">网站名称</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a class="menuItem" href="Video_list" target="left">视频</a></li>
                     <li><a class="menuItem" href="lab/english.html">实验室</a></li>
                    <li><a class="menuItem" href="computervirus/BDindex.html">病毒课程</a></li>
                </ul>
                <a class="pull-right"  style="padding-top:15px;color:#333">登陆</a>
                
            </div>
        </div>
        
    </nav> -->
    <div class="container">
    <div class="jumbotron">
        <h1>C-WTO</h1>
    </div>
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
                <li><a class="active" href="Video_list" target="main">视频</a></li>
                 <li><a href="admin/upload.jsp" target="main">视频上传</a></li>
                 <li><a href="login.jsp" target="main">登陆</a></li>
                <li><a  href="lab/english.html">实验室</a></li>
                <li><a  href="computervirus/BDindex.html">计算机病毒和入侵检测</a></li>
                <li><a  href="cloudcomputeclass/index.html">物联网和云计算</a></li>
               
            </ul>
        </div>
        <!-- <div class="col-xs-9"></div> -->
        <iframe name="main" class="col-xs-9"  onload="setWinHeight(this)" src="Video_list" scrolling="no"  seamless frameborder="0" ></iframe>
        
    </div>
	
	</div>
	<script type="text/javascript">
function setWinHeight(ob) {                     //自动调整iframe高度
    var win=ob; 
    if (document.getElementById) { 
        if (win && !window.opera) { 
            if (win.contentDocument && win.contentDocument.body.offsetHeight) 
                {win.height = win.contentDocument.body.offsetHeight; }

            else if(win.Document && win.Document.body.scrollHeight) 
                {win.height = win.Document.body.scrollHeight; }
        } 
    } 
} 
 
</script>


	
</body>
</html>