<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
  <div class="panel panel-default">
    <div class="panel-heading text-center">
      <div class="fs-article-title"><!--Test One Title--></div>
      <div class="fs-article-meta fs-article-info">
        <!--<a href="#">francisXu</a>发表于2012-01-01 01:01:01 | 分类：<a href="#">其他</a> | <a href="#">评论</a>-->
      </div>
    </div>
    <div class="panel-body fs-article-content"><!--
      <p>毕业项目中的一部分，开始挖坑，想起多少写下来。</p>

      <p>初步的思路是</p>

      <ol>
        <li>字符串相似度，相似度太高的直接结束</li>
        <li>parse 代码为 AST</li>
        <li>AST 去除无用信息，变形。比如变量名，函数名，for-while 转换等。</li>
        <li>AST 相似度判断</li>
      </ol>

      <p>目前有一份测试数据，大约2000提交，目测重复的代码很多。</p>-->
    </div>
  </div>
  <a href="#" class="btn btn-primary pull-left">修改</a>
  <a href="#commentMain" class="btn btn-info pull-right fs-comment">评论</a><br>
  <hr>
  <div id="commentsReply">
    <!--  回复历史信息  -->
  </div>
  <hr>
  <div class="fs-comments" id="commentMain">
    <!-- 评论   -->
  </div>
</div>