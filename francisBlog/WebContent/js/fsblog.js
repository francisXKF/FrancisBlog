var startPage = 0;
var g_articleType = "%";
$(document).ready(function(){
  login();
  logout();
  categoryOp();
  articleOp();
  hintBtnClick();
  MottoOp();
  userOp();
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
          mottoQuery();
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
function logout(){
  $('#logout').unbind('click').click(function(){
    $.ajax({
      url: "user_logout.action",
      data: {},
      type: "post",
      datatype: "json",
      success: function(txtData){
        var data = $.parseJSON(txtData);
        if(data.status=="success"){
          location.href="/francisBlog/jsp/login.jsp";
        }
        else{
          alert("退出失败...");
          location.href="/francisBlog/jsp/index.jsp";
        }
      }
    })
  });
}
function hintBtnClick(){
  $('#hintBtn').unbind('click').click(function(){
    $('.fs-article-bar').removeClass("active");
    $('#hintBtn').addClass("active");
    $('#main').load("../html/_hint.html");
  });
  $('#profileBtn').unbind('click').click(function(){
    $('li[role="presentation"]').removeClass("active");
    $('#profileBtn').addClass("active");
    $('.fs-article-bar').removeClass("active");
    $('#hintBtn').addClass("active");
    
    $('#main').load("../html/_hint.html");
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
  $('#categoryPlace').load("_category.jsp", function(responseTxt, statusTxt, xhr){
    if(statusTxt=="success"){
      articleTypeLoad();
    }
    if(statusTxt=="error"){
      $('#categoryPlace').load("../html/_404.html");
    }
  });
  $('#categoryTitleA').unbind('click').click(function(){
    $('.collapse').toggleClass('in');
  });
  $('#categoryTagB').unbind('click').click(function(){
    $('.collapse').toggleClass('in');
  });
}

function articleOp(){
  $('#main').load("_article_list.jsp", function(responseTxt, statusTxt, xhr){
    if(statusTxt=="success"){
      startPage = 0;
      articleList();
      articleDetail();
    }
    if(statusTxt=="error"){
      $('#main').load("../html/_404.html");
    }
  });
  listArticle();
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
        commentNew();
        articleDetail();
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
}

function MottoOp(){
  $('#MottoManagerBtn').unbind('click').click(function(){
    $('#adminCategoryOne li').removeClass("active");
    $('#MottoManagerBtn').addClass("active");
    $('#adminMain').load("admin/_admin_motto.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        mottoAdd();
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
}

function userOp(){
  $('#userManagerBtn').unbind('click').click(function(){
    $('#adminCategoryOne li').removeClass("active");
    $('#userManagerBtn').addClass("active");
    $('#adminMain').load("admin/_admin_user_info.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        userList();
      }
      if(statusTxt=="error"){
        $('#main').load("../html/_404.html");
      }
    });
  });
}

function listArticle(){
  $('#listArticle').unbind('click').click(function(){
    startPage = 0;
    $('.fs-article-bar').removeClass("active");
    $('#listArticleLi').addClass("active");
    $('#main').empty();
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
}

function articleDetail(){
  $('.fs-article-title').unbind('click').click(function(){
//    var nowId = $(this).attr('id');
//    alert(nowId);
    $('.fs-article-bar').removeClass("active");
    $('#listArticleLi').addClass("active");
    var id = $(this).attr("id");
    $('#main').load("_article_detail.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        $('.fs-comments').load("_comment.jsp", function(responseTxt, statusTxt, xhr){
          if(statusTxt=="success"){
            editorAdd();
            $('#commentMain').addClass("fs-hidden");
            $.ajax({
              url: "article_queryById.action",
              data: {
                id: id,
              },
              type: "post",
              datatype: "json",
              success: function(txtData){
                var data = $.parseJSON(txtData);
                var article = data[0];
                $('.fs-article-title').html(article.title);
                $('.fs-article-info').html('<a href="#" name='+article.user+'>'+article.user+'</a>'+
                            '发表于'+article.post_date+' | 分类：<a href="#">'+article.articleType+'</a> | <a href="#">评论</a>');
                $('.fs-article-content').html(article.content);
                articleUpdateClick(article);
                articleDelete(article.id);
                articleReplyLoad(article.id);
                commentAddClick(article.id);
                
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

function articleAdd(article_id){
  $('#addArticleSubmit').unbind('click').click(function(){
    var allowComments = 0;
    if($('#allowComments').is(":checked") == true){
      allowComments = 1;
    }
    if(article_id != null && article_id != ""){
      URLString = "article_update.action";
    }
    else{
      URLString = "article_insert.action";
    }
    $.ajax({
      url: URLString,
      data: {
        id: article_id,
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
              startPage = 0;
              articleTypeLoad();
              articleList();
              articleDetail();
            }
            if(statusTxt=="error"){
              $('#main').load("../html/_404.html");
            }
          });
        }
        else if(data.status=="failed"){
          alert("啊哦，添加失败了:" + data.errorMsg);
          $('#main').load("../html/_404.html");
        }
        else{
          alert("什么？已添加到数据库，返回出错了？");
        }
      },
      error: function(txtData){
    	data = $.parseJSON(txtData);
        alert("啊哦，添加失败了" + data.errorMsg);
      }
    });
  });
}

function articleDelete(article_id){
  $('#deleteArticleBtn').unbind('click').click(function(){
    $.ajax({
      url: "article_delete.action",
      data: {
        id: article_id,
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
              startPage = 0;
              articleTypeLoad();
              articleList();
              articleDetail();
            }
            if(statusTxt=="error"){
              $('#main').load("../html/_404.html");
            }
          });
        }
        else if(data.status=="failed"){
          alert("啊哦，删除失败了:" + data.errorMsg);
          $('#main').load("../html/_404.html");
        }
        else{
          alert("什么？已添加到数据库，返回出错了？");
        }
      },
      error: function(txtData){
    	data = $.parseJSON(txtData);
        alert("啊哦，添加失败了" + data.errorMsg);
      }
    });
  });
}
function articleList(){
  $('.fs-article-bar').removeClass("active");
  $('#listArticleLi').addClass("active");
  NProgress.start();
  $.ajax({
    url: "article_query.action",
    data: {
      article_type_name: g_articleType,
      tags_typeString: "%",
      start: startPage
    },
    type: "post",
    datatype: "json",
    success : function(txtData){
      var data = $.parseJSON(txtData);
      $('#listMain').empty();
      $(data).each(function(i){
        var article = data[i];
        $('#listMain').append(
          '<div class="panel panel-default">'+
            '<div class="panel-heading">'+
              '<h3 class="panel-title"><a href="#" class="text-primary fs-article-title" id="'+article.id+'">'+article.title+'</a></h3>'+
              '<div class="fs-article-meta">'+
                '<a href="#" id="art" name="'+article.user+'">'+article.user+
                    '</a>发表于<span name="'+article.post_date+'">'+article.post_date+'</span> |'+
                  '分类：<a href="#" name="'+article.articleType+'">'+article.articleType+'</a> | <a href="#">评论</a>'+
              '</div>'+
            '</div>'+
            '<div class="panel-body">'+article.content+
            '</div>'+
          '</div>'
        )
        
      });
      NProgress.done();
      articleDetail();
      pageBarLoad();
    },
    error: function(txtData){
        alert("啊哦，文章列表拿不到了");
      }
  });
}

function articleUpdateClick(article){
  $('#updateArticleBtn').unbind('click').click(function(){
//    alert("enter");
    $('.fs-article-bar').removeClass("active");
    $('#addArticleLi').addClass("active");
    $('#main').load("_article_add.jsp", function(responseTxt, statusTxt, xhr){
      if(statusTxt=="success"){
        $('#addArticleTitle').val(article.title);
        $('#addArticleType').val(article.articleType);
        $('#addArticleTagsType').val(article.tagsType);
        $('#addArticleContent').val(article.content);
        editorAdd();
        articleAdd(article.id)
      }
      if(statusTxt=="error"){
        alert("无法写新文章...");
      }
    });
  });
}

function commentAddClick(article_id){
  //click the comment btn
  $('.fs-comment').unbind('click').click(function(){
    $('#commentMain').removeClass("fs-hidden");
    commentAdd(article_id, 0);
  }),
  //click the reply comment btn
  $('.fs-reply-btn').unbind('click').click(function(){
    var replycomment_id = $(this).attr("name");
    $('#commentMain').removeClass("fs-hidden");
    commentAdd(article_id, replycomment_id);
  })
}

function commentAdd(article_id, replycomment_id){
  $('#commentSubmit').unbind('click').click(function(){
    $.ajax({
      url: "comments_insert.action",
      data: {
        article_id : article_id,
        username: $('input[name="username"]').val(),
        useremail: $('input[name="userEmail"]').val(),
        userurl: $('input[name="userUrl"]').val(),
        replycomment_id: replycomment_id,
        content: $('#addCommentContent').val()
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        $('input[name="username"]').val("");
        $('input[name="userEmail"]').val("");
        $('input[name="userUrl"]').val("");
        $('#addCommentContent').val("");
        $('#commentMain').addClass("fs-hidden");
        articleReplyLoad(article_id);
      },
      error: function(txtData){
        alert("Why?怎么不能评论")
      }
    })
  });
}

function articleReplyLoad(article_id){
  $('#commentsReply').load("_article_reply.jsp", function(responseTxt, statusTxt, xhr){
    if(statusTxt=="success"){
      $.ajax({
        url: "comments_queryByArticleId.action",
        data: {
          article_id: article_id,
        },
        type: "post",
        datatype: "json",
        success: function(txtData){
          
          var listGroupItem = '<div class="list-group-item"></div>';
          var fsReplyBody = '<div class="fs-reply-bd"></div>';
          var fsArticleMeta ='<div class="fs-article-meta"></div>';
          var fsReplyList = '<div class="fs-reply-list"></div>';
          
          var data = $.parseJSON(txtData);
          $(data).each(function(i){
            var comments = data[i];
            var baseInfo = '<a href="#" id="'+comments.user+'">'+comments.user+'</a>回复于：'+
                            '<span class="text-muted">'+comments.comment_date+'</span>'+
                            '<a href="#commentMain">'+
                            '<span class="btn btn-xs glyphicon glyphicon-comment fs-reply-btn" name="'+comments.id+'">'
                            +'</span></a><span>'+comments.content+'</span><hr>';
            if(comments.replycomment_id == 0){
              $(listGroupItem).attr("id", "item" + comments.id).appendTo('#0');
              $(fsReplyBody).attr("id", "body" + comments.id).appendTo('#item' + comments.id);
              $(fsArticleMeta).attr("id", "meta" + comments.id).appendTo('#body' + comments.id);
              $(baseInfo).appendTo('#meta' + comments.id);  
              $(fsReplyList).attr("id", "list" + comments.id).appendTo('#item' + comments.id);
              $('<ul></ul>').attr("id", "ul" + comments.id).appendTo('#list' + comments.id);

            }
            else{
              $('<li></li>').attr("id", "li" + comments.id).appendTo('#ul'+comments.replycomment_id);
              $(fsArticleMeta).attr("id", "meta" + comments.id).appendTo('#li' + comments.id);
              $(baseInfo).appendTo('#meta' + comments.id);
              $('<ul></ul>').attr("id", "ul" + comments.id).appendTo('#li' + comments.id);

            }
          });
          commentAddClick(article_id);
        },
        error: function(txtData){
          alert("咦？评论呢？");
        }
      });
    }
    if(statusTxt=="error"){
      $('#commentsReply').load("../html/_404.html");
    }
  });
}

function commentNew(){
  //alert("select first");
  //$('#replyNewArticle').unbind('click').click(function(){
//    alert("select!");
    $.ajax({
      url: "comments_queryByTime.action",
      data: {
        
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        var data = $.parseJSON(txtData);
        $(data).each(function(i){
          var comments = data[i];
          $('#commentNewReply').append(
            '<tr>'+
              '<td>'+
                '<div class="fs-article-meta">'+
                  '<a href="#">'+comments[0]+'</a> : <span>评论了你的文章</span> :'+ 
                  '<span>'+
                      '<a href="javascript:void(0)" id="'+comments[1]+'" class="text-primary fs-article-title">'+comments[2]+'</a>'+
                  '</span>'+
                  '<div>'+
                  '<span class="text-muted">'+comments[3]+'</span>'+
                  '</div>'+
                '</div>'+
              '</td>'+
            '</tr>'
          );
        });
        articleDetail();
      }
    });
  //});
}

function pageBarLoad(){
  $.ajax({
    url: "article_querySize.action",
    data:{
      article_type_name: g_articleType,
      tags_typeString: "%"
    },
    type: "post",
    datatype: "json",
    success: function(txtData){
      var data = $.parseJSON(txtData);
      var cnt = data.cnt;
      $('#pageBar').empty();
      $('#pageBar').append('<li id="pageBarLeft">'+
                    '<a href="#" aria-label="Previous">'+
                    '<span aria-hidden="true">&laquo;</span>'+
                    '</a>'+
                    '</li>');
      for(i = 0; i < cnt; i++){
        $('#pageBar').append(
                  '<li name="pageBarLi'+ i +'"><a href="#"><span>'+
                  i+'</span></a></li>'
        );
      }
      $('#pageBar').append('<li id="pageBarRight">'+
                    '<a href="#" aria-label="Next">'+
                    '<span aria-hidden="true">&raquo;</span>'+
                    '</a>'+
                    '</li>'
      );
      $('li[name="pageBarLi'+startPage+'"]').addClass("active");
      if(startPage == 0){
        $('#pageBarLeft').addClass("disabled");
      }
      if(startPage == (cnt-1)){
        $('#pageBarRight').addClass("disabled");
      }
      pageBarClick();
    },
    error: function(txtData){
      alert("页码条呢？。。。");
    }
  });
}

function pageBarClick(){
  $('#pageBarLeft').unbind('click').click(function(){
    if($('#pageBarLeft').hasClass("disabled")){
      //not op
    }
    else{
      startPage = startPage - 1;
      articleList();
    }
  });
  $('#pageBarRight').unbind('click').click(function(){
    if($('#pageBarRight').hasClass("disabled")){
      //not op
    }
    else{
      startPage = startPage + 1;
      articleList();
    }
  });
  $('li[name*="pageBarLi"]').unbind('click').click(function(){
    var pageNum = $(this).find('span').text();
    startPage = pageNum;
    articleList();
  });
}

function articleTypeLoad(){
  $.ajax({
    url: "articleType_query.action",
    data: {},
    type: "post",
    datatype: "json",
    success: function(txtData){
      var data = $.parseJSON(txtData);
      $('#articleTypeListShow').empty();
      $('#articleTypeListShow').append(
                  '<li role="presentation" class="active" id="articleTypeLi' + 0 +'">'+
                  '<a href="javascript:void(0)">%</a></li>'
      );
      $(data).each(function(i){
        var articleType = data[i];
        $('#articleTypeListShow').append(
                  '<li role="presentation" id="articleTypeLi' + articleType[0] +'">'+
                  '<a href="javascript:void(0)">'+articleType[1]+'</a></li>'
        );
      });
      articleTypeClick();
    },
    error: function(txtData){
      alert("你是想说文章类型拿不到么。。。");
    }
  })
}

function articleTypeClick(){
  $('li[id*="articleTypeLi"]').unbind('click').click(function(){
    $('li[id*="articleTypeLi"]').removeClass("active");
    $(this).addClass("active");
    g_articleType = $(this).find("a").text();
    articleOp();
  });
}

function mottoAdd(){
  $('#mottoAddBtn').unbind('click').click(function(){
    $.ajax({
      url: "motto_insert.action",
      data: {
        name: $('#mottoAddInput').val()
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        mottoQuery();
      },
      error: function(txtData){
        $('#commentsReply').load("../../html/_404.html");
      }
    })
  });
}

//暂时不用
function mottoDelete(){
  var mottoId = $('#mottoShowId').val();
  $('#mottoDeleteBtn').unbind('click').click(function(){
    $.ajax({
      url: "motto_delete.action",
      data: {
        id: mottoId
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        alert("删除成功");
      },
      error: function(txtData){
        alert("删除失败");
      }
    });
  });
}

function mottoQuery(){
  $.ajax({
    url: "motto_query.action",
    data: {},
    type: "post",
    datatype: "json",
    success: function(txtData){
      location.href="/francisBlog/jsp/admin.jsp";
    },
    error: function(txtData){
      alert("重新加载Motto失败...");
      $('#adminMain').load("../html/_404.html");
    }
  })
}

function userList(){
  $.ajax({
    url: "user_queryList.action",
    data: {},
    type: "post",
    datatype: "json",
    success: function(txtData){
      var data = $.parseJSON(txtData);
      $(data).each(function(i){
        user = data[i];
        $('#userInfoTable').append(
          '<tr id="userInfoTr'+user[0]+'" name="'+user[0]+'">'+
            '<td name="userInfoName'+user[0]+'">'+user[1]+'</td>'+
            '<td name="userInfoEmail'+user[0]+'">'+user[2]+'</td>'+
            '<td name="userInfoLinkURL'+user[0]+'"><a href="'+user[3]+'" target="_blank">'+user[3]+'</a></td>'+
            '<td name="userInfoIdentity'+user[0]+'">'+user[4]+'</td>'+
            '<td><span class="btn btn-xs glyphicon glyphicon-pencil user-info-edit"'+
                  'name="'+user[0]+'"></span>'+
                 ' <span class="btn btn-xs glyphicon glyphicon-remove user-info-delete"'+
                  'name="'+user[0]+'"></span</td>'+
          '</tr>'
        );
      });
      userUpdateClick();
      userDelete();
    },
    error: function(txtData){
      alert("0.0 用户呢？");
      $('#adminMain').load("../html/_404.html");
    }
  })
}

function userUpdateClick(){
  $('.user-info-edit').unbind('click').click(function(){
    var trId = $(this).attr("name");
    var username = $('td[name="userInfoName'+trId+'"]').text();
    var userEmail = $('td[name="userInfoEmail'+trId+'"]').text();
    var userUrl = $('td[name="userInfoLinkURL'+trId+'"]').text();
    var useridentity = $('td[name="userInfoIdentity'+trId+'"]').text();
    
    $('#userInfoTr' + trId).empty();
    $('#userInfoTr' + trId).append(
      '<td><input type="text" class="form-control" style="width: 100px" name="userInfoName'+trId+'" value="'+username+'"></td>'+
      '<td><input type="text" class="form-control" style="width: 100px" name="userInfoEmail'+trId+'" value="'+userEmail+'"></td>'+
      '<td><input type="text" class="form-control" style="width: 150px" name="userInfoLinkURL'+trId+'" value="'+userUrl+'"></td>'+
      '<td><input type="text" class="form-control" style="width: 100px" name="userInfoIdentity'+trId+'" value="'+useridentity+'"></td>'+
      '<td><span class="btn btn-xs glyphicon glyphicon-ok fs-user-update" name="'+trId+'""></span>'+
//           ' <span class="btn btn-xs glyphicon glyphicon-remove"'+
//            'name="'+user[0]+'"></span>'+
      '</td>'
    );
    userUpdate();
  });
}

function userUpdate(){
  $('.fs-user-update').unbind('click').click(function(){
    userId = $(this).attr("name");
    var username = $('input[name="userInfoName'+userId+'"]').val();
    var userEmail = $('input[name="userInfoEmail'+userId+'"]').val();
    var userUrl = $('input[name="userInfoLinkURL'+userId+'"]').val();
    var useridentity = $('input[name="userInfoIdentity'+userId+'"]').val();
    $.ajax({
      url: "user_update.action",
      data: {
        id: userId,
        name: username,
        Email: userEmail,
        linkURL: userUrl,
        identity: useridentity
      },
      type: "post",
      datatype: "json",
      success: function(txtData){
        userQuery(userId);
      },
      error: function(txtData){
        alert("0.0 更新失败了？");
        $('#adminMain').load("../html/_404.html");
      }
    });
  });
}

function userQuery(user_id){
  $.ajax({
    url: "user_queryById.action",
    data: {
      id: user_id
    },
    type: "post",
    datatype: "json",
    success: function(txtData){
      var data = $.parseJSON(txtData);
      var user = data.queryUser;
      $('#userInfoTr' + user_id).empty();
      $('#userInfoTr' + user_id).append(
        '<td name="userInfoName'+user.id+'">'+user.name+'</td>'+
            '<td name="userInfoEmail'+user.id+'">'+user.email+'</td>'+
            '<td name="userInfoLinkURL'+user.id+'"><a href="'+user[3]+'" target="_blank">'+user.linkURL+'</a></td>'+
            '<td name="userInfoIdentity'+user.id+'">'+user.identity+'</td>'+
            '<td><span class="btn btn-xs glyphicon glyphicon-pencil user-info-edit"'+
                  'name="'+user.id+'"></span>'+
                 ' <span class="btn btn-xs glyphicon glyphicon-remove"'+
                  'name="'+user.id+'"></span</td>'
      );
    },
    error: function(txtData){
        alert("0.0 查找失败了？");
        $('#adminMain').load("../html/_404.html");
      }
  });
}

function userDelete(){
  $('.user-info-delete').unbind('click').click(function(){
    if(confirm("确定要删除该用户？")){
      var userId = $(this).attr("name");
      $.ajax({
        url: "user_delete.action",
        data: {
          id: userId
        },
        type: "post",
        datatype: "json",
        success: function(txtData){
          $('#userInfoTr' + userId).remove();
        },
        error: function(txtData){
          alert("0.0 删除失败了？");
          $('#adminMain').load("../html/_404.html");
        } 
      });
    }
    else{
      alert("好吧 不删了");
    }
  });
}