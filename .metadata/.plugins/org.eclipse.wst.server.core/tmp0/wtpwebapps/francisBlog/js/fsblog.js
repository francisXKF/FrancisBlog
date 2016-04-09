$(document).ready(function(){
  login();
  categoryOp();
  articleOp();
});

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
      upload: location.search === '?upload' ? {
        url: '/upload'
      } : false
    });
  }); 
//    editor = new Simditor({
//      textarea: $('.editor'),
//      placeholder: '这里输入文字...',
//      toolbar: toolbar,
//      pasteImage: true,
////      defaultImage: 'assets/images/image.png',
//      upload: location.search === '?upload' ? {
//        url: '/upload'
//      } : false
//    });
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
    alert($('#addArticleTagsType').val());
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
        alert("yes");
        var data = $.parseJSON(txtData);
//        alert(result);
        if(data.status=="success"){
          alert("ok");
          alert(data.selfsession.login_user.name);
          $('#main').load("_article_list.jsp", function(responseTxt, statusTxt, xhr){
            if(statusTxt=="success"){
              articleDetail();
            }
            if(statusTxt=="error"){
              $('#main').load("../html/_404.html");
            }
          });
        }
        else if(data.status=="failed"){
          $("#testcontent").html('<%@include page="/html/_404.html" %>');
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
