<%@page import="com.francis.blog.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar-fixed-top navbar-inverse">
  <div class="container">
    <ul class="nav nav-pills">
      <li role="presentation" class="active"><a href="../jsp/index.jsp">Home</a></li>
      <li role="presentation" id="profileBtn"><a href="#">Profile</a></li>
      <li role="presentation"><a href="#">Messages</a></li>
      <li  class="pull-right" role="presentation"><a class="fs-float-right" href="#" id="logout">Logout</a></li>
      <li  class="pull-right" role="presentation"><a class="fs-float-right" id="login" href="../jsp/login.jsp">
      <%
      	User user = (User)session.getAttribute("login_user");
      	if(user == null){
      		out.print("login");
      	}
      	else{
      		out.print(user.getName());
      	}
      %></a></li>
    </ul>
  </div>
</nav>