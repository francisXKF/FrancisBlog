<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div  class="panel-group" id="adminCategory" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="adminCategoryTitle">
      <h4 class="panel-title">
        <a id="adminCategoryTitleA" role="button" data-toggle="collapse" data-parent="#admibCategory" href="#" aria-expanded="true" aria-controls="adminCategoryOne">
          后台管理
        </a>
      </h4>
    </div>
    <div id="adminCategoryOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="adminCategoryTitle">
      <div class="panel-body">
        <ul class="nav nav-pills nav-stacked" id="adminOpShow">
          <li role="presentation" class="active" id="MottoManagerBtn"><a href="javascript:void(0)">Motto</a></li>
          <li role="presentation" id="userManagerBtn"><a href="javascript:void(0)">User Manager</a></li>
          <li role="presentation" id="articleTypeManagerBtn"><a href="javascript:void(0)">Article Type Manager</a></li>
          <li role="presentation" id="tagsTypeManagerBtn"><a href="javascript:void(0)">Tags Type Manager</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>