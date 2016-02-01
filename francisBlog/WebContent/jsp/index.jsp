<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/francisBlog/css/fsblog.css">
    <link rel="stylesheet" href="/francisBlog/css/bootstrap.min.css">
    <link rel="stylesheet" href="/francisBlog/css/font-awesome.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
    <script src="/francisBlog/js/fsblog.js"></script>
    <script src="/francisBlog/js/bootstrap-wysiwyg.js"></script>
    <script src="/francisBlog/js/jquery.hotkeys.js"></script>
    <script src="/francisBlog/js/prettify.js"></script>
    <!--    <link rel="stylesheet" href="/francisBlog/css/bootstrap.css">-->
    <title>首页</title>
  </head>
  <body>
    <div class="container">
      <div class="fs-menu">
        <nav class="navbar-fixed-top navbar-inverse">
          <div class="container">
            <ul class="nav nav-pills">
              <li role="presentation" class="active"><a href="#">Home</a></li>
              <li role="presentation"><a href="#">Profile</a></li>
              <li role="presentation"><a href="#">Messages</a></li>
              <li  class="fs-float-right" role="presentation"><a class="fs-float-right" id="login" href="#">Login</a></li>
              <li  class="fs-float-right" role="presentation"><a class="fs-float-right" href="#">Logout</a></li>
            </ul>
          </div>
        </nav>
      </div>
      <div class="fs-top">
        <div class="fs-top-user fs-float-left">
          莫显乎微
        </div>
      </div>
      <div class="container-fluid">
        <div class="fs-row-fluid">
          <div class="fs-span3">
            日历。。。
            <img src="/francisBlog/img/calendar.jpg">
            <h3>导航1</h3>
            <h3>导航2</h3>
            <h3>导航3</h3>
            <h3>导航4</h3>
            
          </div>
          <div class="fs-span9">
            <ul class="nav nav-tabs">
              <li role="presentation" class="active"><a href="#">已发表文章</a></li>
              <li role="presentation"><a href="#">写文章</a></li>
              <li role="presentation"><a href="#">新评论<span class="badge">42</span></a></li>
              <li role="presentation"><a href="#">提示</a></li>
            </ul>
            
            <div id="testcontent">
              <jsp:include page="/jsp/login.jsp" flush="true" />
            </div>
            <br>
            <div>
              <%@include file="_editor.jsp"%>
            </div>
            <br>
            <nav>
              <ul class="pager">
                <li><a href="#">Previous</a></li>
                <li><a href="#">Next</a></li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>