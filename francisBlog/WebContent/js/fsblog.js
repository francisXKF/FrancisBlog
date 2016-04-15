$(document).ready(function(){
  login();
  categoryOp();
  articleOp();
});
function getRootPah(){
  //获取当前网址，如： http://localhost:8083/proj/meun.jsp  
  var curWwwPath = window.document.location.href;  
  //获取主机地址之后的目录，如： proj/meun.jsp  
  var pathName = window.document.location.pathname;  
  var pos = curWwwPath.indexOf(pathName);  
  //获取主机地址，如： http://localhost:8083  
  var localhostPath = curWwwPath.substring(0, pos);  
  //获取带"/"的项目名，如：/proj  
  var projectName = pathName.substring(0, pathName.substr(1).indexOf('/')+1);  
  return(localhostPath + projectName);
}

function login(){
  $('#loginSubmit').unbind('click').click(function(){
    $.ajax({
      url: "user_login.action",
      data: {
        name: $('#loginUserName').val(),
        password: $('#loginUserPassword').val(),
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        var data = $.parseJSON(txtData);
        if(data.status=="success"){
          $('#loginSubmit').val("已登录");
          location.href="/francisBlog/jsp/index.jsp";
        }
        else if(data.status=="failed"){
          alert("用户？有么？");
        }
        else{
          alert(data);
        }
      },
      error: function(txtData){
        alert("error");
      }
    });
  });
}

function editorAdd(){
  var $preview, editor, toolbar;
  Simditor.locale = 'en-US';
  toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr'];
//    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'];
 $('.editor').each(function(index, dom){
    editor = new Simditor({
      textarea: $(dom),
      placeholder: '这里输入文字...',
      toolbar: toolbar,
      pasteImage: true,
//      defaultImage: 'assets/images/image.png',
//      upload: location.search === '?upload' ? {
//        url: '/upload'
//      } : false
      upload : {
        url : "picture_load.action", //文件上传的接口地址  
        params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交  
        fileKey: 'file', //服务器端获取文件数据的参数名  
        connectionCount: 3,  
        leaveConfirm: '正在上传文件',  
      },
      
      /*success: (function(_this){
        return function(txtData){
          var data = $.parseJSON(txtData);
          _this.trigger('uploadprogress', [file, file.size, file.size]);  
          _this.trigger('uploadsuccess', [file, data]); 
          return $(document).trigger('uploadsuccess', [file, data, _this]);
        }
      })(this),
      */
      imageButton: ['upload']
    });
  }); 
  $preview = $('#preview');
  if ($preview.length > 0) {
    return editor.on('valuechanged', function(e) {
      return $preview.html(editor.getValue());
    });
  }
}

function categoryOp(){
  $('#categoryTitleA').unbind('click').click(function(){
//    $('#categoryTitleA').unbind('click');
    $('.collapse').toggleClass('in');
  });
  $('#categoryTagB').unbind('click').click(function(){
    $('.collapse').toggleClass('in');
  });
}

function articleOp(){
  $('#main').load("_article_list.jsp", function(responseTxt, statusTxt, xhr){
    if(statusTxt=="success"){
      articleList();
      articleDetail();
    }
    if(statusTxt=="error"){
      $('#main').load("../html/_404.html");
    }
  });
  
  $('#listArticle').unbind('click').click(function(){
    $('.fs-article-bar').removeClass("active");
    $('#listArticleLi').addClass("active");
    $('#main').load("_article_list.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        articleList();
        articleDetail();
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
  
  $('#addArticle').unbind('click').click(function(){
    $('.fs-article-bar').removeClass("active");
    $('#addArticleLi').addClass("active");
    $('#main').load("_article_add.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        editorAdd();
        articleAdd();
      }
      if(statusTxt=="error"){
        alert("无法写新文章...");
      }
    });
  });
  
  $('#replyNewArticle').unbind('click').click(function(){
    $('.fs-article-bar').removeClass("active");
    $('#replyNewArticleLi').addClass("active");
    $('#main').load("_article_new_reply.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        $('#replyNewNum').html("");
        articleDetail();
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
}

function articleDetail(){
  $('.fs-article-title').unbind('click').click(function(){
//    var nowId = $(this).attr('id');
//    alert(nowId);
//    alert($(this).html());
    $('#main').load("_article_detail.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        $('.fs-comments').load("_comment.jsp", function(responseTxt, statusTxt, xhr){
          if(statusTxt=="success"){
            editorAdd();
            $('#commentsReply').load("_article_reply.jsp", function(responseTxt, statusTxt, xhr){
              if(statusTxt=="error"){
                $('#commentsReply').load("../html/_404.html");
              }
            });
          }
          if(statusTxt=="error"){
            alert("评论加载失败");
          }
        });
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
}

function articleAdd(){
  $('#addArticleSubmit').unbind('click').click(function(){
    var allowComments = 0;
    if($('#allowComments').is(":checked") == true){
      allowComments = 1;
    }
    $.ajax({
      url: "article_insert.action",
      data: {
        title: $('#addArticleTitle').val(),
        article_type_name: $('#addArticleType').val(),
        content: $('#addArticleContent').val(),
        tags_typeString: $('#addArticleTagsType').val(),
        state: $('input[name="showOrHide"]:checked').val(),
        allow_comments: allowComments
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        var data = $.parseJSON(txtData);
        if(data.status=="success"){
          $('#main').load("_article_list.jsp", function(responseTxt, statusTxt, xhr){
            if(statusTxt=="success"){
              $('.fs-article-bar').removeClass("active");
              $('#listArticleLi').addClass("active");
              articleList();
              articleDetail();
            }
            if(statusTxt=="error"){
              $('#main').load("../html/_404.html");
            }
          });
        }
        else if(data.status=="failed"){
          $("#main").html('<%@include page="/html/_404.html" %>');
        }
        else{
          alert("什么？已添加到数据库，返回出错了？");
        }
      },
      error: function(txtData){
        alert("啊哦，添加失败了");
      }
    });
  });
}

function articleList(){
  $.ajax({
    url: "article_query.action",
    data: {
      article_type_name: "%",
      tags_typeString: "%"
    },
    type: "post",
    datatype: "json",
    success : function(txtData){
      var data = $.parseJSON(txtData);
      $(data).each(function(i){
        var article = data[i];
        $('#listMain').append(
          '<div class="panel panel-default">'+
            '<div class="panel-heading">'+
              '<h3 class="panel-title"><a href="#" class="text-primary fs-article-title" id="articleListTitle">'+article.title+'</a></h3>'+
              '<div class="fs-article-meta">'+
                '<a href="#" id="articleListAuthor">'+article.user+'</a>发表于<span id="articleListPostTime">'+article.post_date+'</span> |'+
                  '分类：<a href="#" id="articleListArticleType">'+article.articleType+'</a> | <a href="#">评论</a>'+
              '</div>'+
            '</div>'+
            '<div class="panel-body" id="articleListContent">'+article.content+
            '</div>'+
          '</div>'
        )
        
      });
//      var article_list = data.articleList;
//      alert(article_list);
//      $.each(article_list, function(i, item){
//        alert(item.title);
//      });
    },
    error: function(txtData){
        alert("啊哦，文章列表拿不到了");
      }
  });
}
