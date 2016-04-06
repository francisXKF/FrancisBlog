<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
  <div class="panel panel-default">
    <div class="panel-heading">写文章:</div>
    <div class="panel-body">
      <table>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">题目:</div>
              <div class="panel-body"><input class="form-control" type="text"></div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">分类:</div>
              <div class="panel-body"><input class="form-control" type="text"></div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">标签:</div>
              <div class="panel-body"><input class="form-control" type="text"></div>
              <div class="panel-body">
                <small>最近使用标签:</small>
                <span class="label label-default">Default</span>
                <span class="label label-primary">Primary</span>
                <span class="label label-success">Success</span>
                <span class="label label-info">Info</span>
                <span class="label label-warning">Warning</span>
                <span class="label label-danger">Danger</span>
              </div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">内容:</div>
              <div class="panel-body">
                <textarea class="editor" placeholder="这里输入内容" data-autosave="editor-content" autofocus required></textarea>
              </div>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div class="panel panel-default">
              <div class="panel-heading">权限:</div>
              <div class="panel-body">
                <label class="radio-inline">
                  <input type="radio" name="showOrHide" id="optionsRadios1" value="option1" checked>
                  显示
                </label>
                <label class="radio-inline">
                  <input type="radio" name="showOrHide" id="optionsRadios2" value="option2">
                  隐藏
                </label>
                <br>
                <label class="checkbox-inline">
                  <input type="checkbox" id="allowComments" value="option1" checked>允许评论
                </label>
              </div>
            </div>
          </td>
        </tr>
      </table>
      <div>
        <input class="btn btn-info" type="button" value="发布">
        <input class="btn btn-default pull-right" type="reset" value="取消">
      </div>
    </div>
  </div>
</div>