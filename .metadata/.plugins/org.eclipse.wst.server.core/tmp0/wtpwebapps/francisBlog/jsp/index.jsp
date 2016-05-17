<%@page import="com.francis.blog.pojo.Motto"%>
<%@page import="com.francis.blog.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/jsp/_base.jsp" %>
    <title>首页</title>
  </head>
  <body>
    <div class="container">
      
      <!--   用于用户浮动窗口 -->
      <div id="userInfoFloatDiv" ></div>
      <div class="fs-menu">
        <%@ include file="../jsp/_navigation_bar.jsp" %>
      </div>
      <div class="fs-top">
        <div class="fs-top-user fs-float-left">
          <div class="page-header">
            <h1> 
            <%
            	Motto motto = (Motto)session.getAttribute("motto");
            	if(motto == null){
            		out.print("<small>NullPointerException...</small>");
            	}
            	else{
            		out.print("<small id='mottoShowId' name='"+motto.getId()+"'>"+motto.getName()+"</small>");
            	}
            %>
            </h1>
          </div>
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
            <jsp:include page="/jsp/_category.jsp" flush="true" />
            </div>
          </div>
          <div class="fs-span9">
            <ul class="nav nav-tabs">
              <li role="presentation" class="active fs-article-bar" id="listArticleLi"><a href="#" id="listArticle">已发表文章</a></li>
               <%
                  User index_user = (User)session.getAttribute("login_user");
                  if(index_user != null){
                    out.print(
                      "<li role='presentation' class='fs-article-bar' id='addArticleLi'>"+
                          "<a href='#' id='addArticle' role='button'>写文章</a>"+
                      "</li>"
                    );
                  }
                %>
              <li role="presentation" class="fs-article-bar" id="replyNewArticleLi">
                <a href="#" id="replyNewArticle">新评论<span class="badge" id="replyNewNum">3</span></a>
              </li>
              <li role="presentation" class="fs-article-bar" id="hintBtn"><a href="#">提示</a></li>
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