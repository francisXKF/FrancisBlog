/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2016-02-19 02:47:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/../html/_search_bar.html", Long.valueOf(1454982995907L));
    _jspx_dependants.put("/jsp/../html/_navigation_bar.html", Long.valueOf(1455850055056L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/francisBlog/css/fsblog.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/francisBlog/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/francisBlog/css/font-awesome.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/francisBlog/util/simditor/styles/simditor.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/francisBlog/util/simditor/styles/font-awesome.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"/francisBlog/js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"/francisBlog/js/fsblog.js\"></script>\r\n");
      out.write("<!--    <script src=\"/francisBlog/js/require.js\"></script>-->\r\n");
      out.write("    <script src=\"/francisBlog/util/simditor/scripts/module.js\"></script>\r\n");
      out.write("    <script src=\"/francisBlog/util/simditor/scripts/uploader.js\"></script>\r\n");
      out.write("    <script src=\"/francisBlog/util/simditor/scripts/hotkeys.js\"></script>\r\n");
      out.write("    <script src=\"/francisBlog/util/simditor/scripts/simditor.js\"></script>\r\n");
      out.write("    <!--    <link rel=\"stylesheet\" href=\"/francisBlog/css/bootstrap.css\">-->\r\n");
      out.write("    <title>首页</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"fs-menu\">\r\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<nav class=\"navbar-fixed-top navbar-inverse\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <ul class=\"nav nav-pills\">\r\n");
      out.write("      <li role=\"presentation\" class=\"active\"><a href=\"../jsp/index.jsp\">Home</a></li>\r\n");
      out.write("      <li role=\"presentation\"><a href=\"#\">Profile</a></li>\r\n");
      out.write("      <li role=\"presentation\"><a href=\"#\">Messages</a></li>\r\n");
      out.write("      <li  class=\"pull-right\" role=\"presentation\"><a class=\"fs-float-right\" href=\"#\">Logout</a></li>\r\n");
      out.write("      <li  class=\"pull-right\" role=\"presentation\"><a class=\"fs-float-right\" id=\"login\" href=\"../jsp/login.jsp\">Login</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fs-top\">\r\n");
      out.write("        <div class=\"fs-top-user fs-float-left\">\r\n");
      out.write("          莫显乎微\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"fs-row-fluid\">\r\n");
      out.write("          <div class=\"fs-span3\">\r\n");
      out.write("            <div>\r\n");
      out.write("              ");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<form class=\"form-inline\">\r\n");
      out.write("  <div class=\"input-group\">\r\n");
      out.write("    <label class=\"sr-only\" for=\"searchInput\">search</label>\r\n");
      out.write("    <input type=\"text\" class=\"form-control\" id=\"searchInput\" placeholder=\"\">\r\n");
      out.write("    <span class=\"input-group-btn\">\r\n");
      out.write("      <input class=\"btn btn-default\" type=\"button\" value=\"Search\">\r\n");
      out.write("    </span>\r\n");
      out.write("  </div>\r\n");
      out.write("</form>");
      out.write("<br>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--   分类    -->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/jsp/_category.jsp", out, true);
      out.write("\r\n");
      out.write("            \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"fs-span9\">\r\n");
      out.write("            <ul class=\"nav nav-tabs\">\r\n");
      out.write("              <li role=\"presentation\" class=\"active fs-article-bar\" id=\"listArticleLi\"><a href=\"#\" id=\"listArticle\">已发表文章</a></li>\r\n");
      out.write("              <li role=\"presentation\" class=\"fs-article-bar\" id=\"addArticleLi\"><a href=\"#\" id=\"addArticle\" role=\"button\">写文章</a></li>\r\n");
      out.write("              <li role=\"presentation\" class=\"fs-article-bar\" id=\"replyNewArticleLi\">\r\n");
      out.write("                <a href=\"#\" id=\"replyNewArticle\">新评论<span class=\"badge\" id=\"replyNewNum\">3</span></a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li role=\"presentation\" class=\"fs-article-bar\" id=\"\"><a href=\"#\">提示</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div id=\"main\" class=\"\">\r\n");
      out.write("              <!--      文章内容        -->\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
