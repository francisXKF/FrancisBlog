$(document).ready(function(){
  login();
  categoryOp();
  articleOp();
});

function login(){
  $("#login").click(function(){
    $.ajax({
      url: "login.jsp",
      data: {
        username: "francis",
        password: "123456"
      },
      type: "post",
      datatype: "json",
      success: function(data){
//        $("#testcontent").load("/francisBlog/jsp/index.jsp");
        $("#testcontent").html('<%@include page="/index.html" %>');
      },
      error: function(data){
        alert("error" + data.username);
      }
    });
  });
}

function editorAdd(){
  $(function() {
    var $preview, editor, toolbar;
    Simditor.locale = 'en-US';
    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr'];
//    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'];
//   $('.richEditor').each(function(index, dom){
//      editor = new Simditor({
//        textarea: $(dom),
//        placeholder: '这里输入文字...',
//        toolbar: toolbar,
//        pasteImage: true,
//  //      defaultImage: 'assets/images/image.png',
//        upload: location.search === '?upload' ? {
//          url: '/upload'
//        } : false
//      });
//    }); 
    editor = new Simditor({
      textarea: $('.editor'),
      placeholder: '这里输入文字...',
      toolbar: toolbar,
      pasteImage: true,
//      defaultImage: 'assets/images/image.png',
      upload: location.search === '?upload' ? {
        url: '/upload'
      } : false
    });
    $preview = $('#preview');
    if ($preview.length > 0) {
      return editor.on('valuechanged', function(e) {
        return $preview.html(editor.getValue());
      });
    }
  });
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
      }
      if(statusTxt=="error"){
        alert("无法写新文章...");
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
            $('#commentReply').load("_article_reply.jsp", function(responseTxt, statusTxt, xhr){
              if(statusTxt=="error"){
                $('#commentReply').load("../html/_404.html");
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
