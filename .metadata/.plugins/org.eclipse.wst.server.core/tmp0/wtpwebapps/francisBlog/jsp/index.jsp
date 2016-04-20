<%@page import="com.francis.blog.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/francisBlog/css/fsblog.css">
    <link rel="stylesheet" href="/francisBlog/css/bootstrap.min.css">
    <link rel="stylesheet" href="/francisBlog/css/font-awesome.min.css">
    <link rel="stylesheet" href="/francisBlog/util/simditor/styles/simditor.css">
    <link rel="stylesheet" href="/francisBlog/util/simditor/styles/font-awesome.min.css">
    
    <script src="/francisBlog/js/jquery.min.js"></script>
    <script src="/francisBlog/js/fsblog.js"></script>
<!--    <script src="/francisBlog/js/require.js"></script>-->
    <script src="/francisBlog/util/simditor/scripts/module.js"></script>
    <script src="/francisBlog/util/simditor/scripts/uploader.js"></script>
    <script src="/francisBlog/util/simditor/scripts/hotkeys.js"></script>
    <script src="/francisBlog/util/simditor/scripts/simditor.js"></script>
    <!--    <link rel="stylesheet" href="/francisBlog/css/bootstrap.css">-->
    <title>首页</title>
  </head>
  <body>
    <div class="container">
      <div class="fs-menu">
        <%@ include file="../html/_navigation_bar.html" %>
      </div>
      <div class="fs-top">
        <div class="fs-top-user fs-float-left">
          <%
          	User login_user = (User)request.getSession().getAttribute("login_user");
          	if(login_user != null){
          		out.print(login_user.getName());
          	}
          %>
        </div>
      </div>
      <div class="container-fluid">
        <div class="fs-row-fluid">
          <div class="fs-span3">
            <div>
              <%@ include file="../html/_search_bar.html" %><br>
            </div>
            <!--   分类    -->
            <div id="categoryPlace">
            //<jsp:include page="/jsp/_category.jsp" flush="true" />
            </div>
          </div>
          <div class="fs-span9">
            <ul class="nav nav-tabs">
              <li role="presentation" class="active fs-article-bar" id="listArticleLi"><a href="#" id="listArticle">已发表文章</a></li>
              <li role="presentation" class="fs-article-bar" id="addArticleLi"><a href="#" id="addArticle" role="button">写文章</a></li>
              <li role="presentation" class="fs-article-bar" id="replyNewArticleLi">
                <a href="#" id="replyNewArticle">新评论<span class="badge" id="replyNewNum">3</span></a>
              </li>
              <li role="presentation" class="fs-article-bar" id=""><a href="#">提示</a></li>
            </ul>
            <div id="main" class="">
              <!--      文章内容        -->
              
            </div>

          </div>
        </div>
      </div>
    </div>
  </body>
</html>