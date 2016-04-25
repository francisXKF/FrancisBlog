<%@page import="com.francis.blog.pojo.Motto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/jsp/_base.jsp" %>
    <title>Admin</title>
  </head>
  <body>
    <div class="container">
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
            <!--   分类    -->
            <div id="adminCategoryPlace">
            <jsp:include page="/jsp/admin/_admin_category.jsp" flush="true" />
            </div>
          </div>
          <div class="fs-span9">
            <div id="adminMain" class="">
              <!--      具体内容        -->
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>