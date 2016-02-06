$(document).ready(function(){
  login();
  editorAdd();
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
    
    editor = new Simditor({
      textarea: $('#richEditor'),
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