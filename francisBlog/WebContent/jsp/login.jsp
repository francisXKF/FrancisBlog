<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="/jsp/_base.jsp" %>
    <title>登录</title>
    <style>
      body{
        background-image: url(../img/dwddxqtxw.jpg);
        background-repeat: no-repeat;
        background-size: cover;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="fs-menu">
        <%@ include file="../jsp/_navigation_bar.jsp" %>
      </div>
      <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default fs-transparency">
          <div class="panel-heading">
            <h3 class="panel-title">Hello User</h3>
          </div>
          <div class="panel-body">  
            <form>
              <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">
                  <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                </span>
                <input type="text" class="form-control" id="loginUserName" placeholder="Username" aria-describedby="basic-addon1">
              </div>
              <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">
                  <span class="glyphicon glyphicon-text-background" aria-hidden="true"></span>
                </span>
                <input type="password" class="form-control" id="loginUserPassword" placeholder="Password" aria-describedby="basic-addon1">
              </div>
              <input class="btn btn-primary pull-left" type="button" id="loginSubmit" value="登录">
              <input class="btn btn-default pull-right" type="reset" value="Reset">
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>