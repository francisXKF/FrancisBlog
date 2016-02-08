<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div  class="panel-group" id="category" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="categoryTitle">
      <h4 class="panel-title">
        <a id="categoryTitleA" role="button" data-toggle="collapse" data-parent="#category" href="#categoryOne" aria-expanded="true" aria-controls="categoryOne">
          文章分类
        </a>
      </h4>
    </div>
    <div id="categoryOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="categoryTitle">
      <div class="panel-body">
        <ul class="nav nav-pills nav-stacked">
          <li role="presentation"><a href="#">category_one</a></li>
          <li role="presentation"><a href="#">category_two</a></li>
          <li role="presentation"><a href="#">category_three</a></li>
          <li role="presentation"><a href="#">category_four</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="categoryTag">
      <h4 class="panel-title">
        <a id="categoryTagB" class="collapsed" role="button" data-toggle="collapse" data-parent="#category" href="#categoryTwo" aria-expanded="false" aria-controls="categoryTwo">
          标签
        </a>
      </h4>
    </div>
    <div id="categoryTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="categoryTag">
      <div class="panel-body">
        <span class="label label-default">Default</span>
        <span class="label label-primary">Primary</span>
        <span class="label label-success">Success</span>
        <span class="label label-info">Info</span>
        <span class="label label-warning">Warning</span>
        <span class="label label-danger">Danger</span>
      </div>
    </div>
  </div>
</div>
<!--
  <div class="category-title">
    <div class="title-group">
      <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="#">category_one</a></li>
        <li role="presentation"><a href="#">category_two</a></li>
        <li role="presentation"><a href="#">category_three</a></li>
        <li role="presentation"><a href="#">category_four</a></li>
      </ul>
    </div>
  </div>
  <div class="category-target">
    <span class="label label-default">Default</span>
    <span class="label label-primary">Primary</span>
    <span class="label label-success">Success</span>
    <span class="label label-info">Info</span>
    <span class="label label-warning">Warning</span>
    <span class="label label-danger">Danger</span>
  </div>
-->