<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
  <h2>add article</h2>
  <div>
    <h4>Title:</h4>
    <input class="form-control" type="text" >
  </div>
  <div>
    <h4>Tags:</h4>
    <input class="form-control" type="text" >
    <div>common tags:a b c </div>
  </div>
  <div>
    <h4>Content:</h4>
    <textarea class="editor" placeholder="这里输入内容" data-autosave="editor-content" autofocus required></textarea>
  </div>
  <div>
    <h4>privilege</h4>
    <input class="form-control" type="text" >
  </div>
  <div>
    <input class="btn btn-info" type="button" value="提交">
    <input class="btn btn-default" type="button" value="取消">
  </div>
</div>