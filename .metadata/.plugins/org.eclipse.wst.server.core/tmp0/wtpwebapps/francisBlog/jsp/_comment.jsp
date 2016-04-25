<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
  <div class="panel panel-default">
    <div class="panel-heading">评论:</div>
    <div class="panel-body">
      <table>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">Name:</div>
              <div class="panel-body"><input class="form-control" type="text" name="username"></div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">Email:</div>
              <div class="panel-body"><input class="form-control" type="email" name="userEmail"></div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">URL:</div>
              <div class="panel-body"><input class="form-control" type="url" name="userUrl"></div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">Content:</div>
              <div class="panel-body">
                <textarea class="editor" placeholder="这里输入内容"
                          data-autosave="editor-content" autofocus required id="addCommentContent"></textarea>
              </div>
            </div>
          </td>
        </tr>
      </table>
      <div>
        <input class="btn btn-info" type="button" id="commentSubmit"value="提交">
        <input class="btn btn-default pull-right" type="button" value="取消">
      </div>
    </div>
  </div>
</div>