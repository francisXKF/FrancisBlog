/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2016-02-10 14:05:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005farticle_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<div>\r\n");
      out.write("  <div class=\"panel panel-default\">\r\n");
      out.write("    <div class=\"panel-heading\">\r\n");
      out.write("      <h3 class=\"panel-title\"><a href=\"#\" class=\"text-primary fs-article-title\" id=\"one\">Test One Title</a></h3>\r\n");
      out.write("      <div class=\"fs-article-meta\">\r\n");
      out.write("        <a href=\"#\">francisXu</a>发表于2012-01-01 01:01:01 | 分类：<a href=\"#\">其他</a> | <a href=\"#\">评论</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"panel-body\">\r\n");
      out.write("      <p>毕业项目中的一部分，开始挖坑，想起多少写下来。</p>\r\n");
      out.write("\r\n");
      out.write("      <p>初步的思路是</p>\r\n");
      out.write("\r\n");
      out.write("      <ol>\r\n");
      out.write("        <li>字符串相似度，相似度太高的直接结束</li>\r\n");
      out.write("        <li>parse 代码为 AST</li>\r\n");
      out.write("        <li>AST 去除无用信息，变形。比如变量名，函数名，for-while 转换等。</li>\r\n");
      out.write("        <li>AST 相似度判断</li>\r\n");
      out.write("      </ol>\r\n");
      out.write("\r\n");
      out.write("      <p>目前有一份测试数据，大约2000提交，目测重复的代码很多。</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"panel panel-default\">\r\n");
      out.write("    <div class=\"panel-heading\">\r\n");
      out.write("      <h3 class=\"panel-title\"><a href=\"#\" class=\"text-primary fs-article-title\" id=\"two\">Test Two Title</a></h3>\r\n");
      out.write("      <div class=\"fs-article-meta\">\r\n");
      out.write("        <a href=\"#\">francisXu</a>发表于2012-01-01 01:01:01 | 分类：<a href=\"#\">其他</a> | <a href=\"#\">评论</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"panel-body\">\r\n");
      out.write("      <p>毕业项目中的一部分，开始挖坑，想起多少写下来。</p>\r\n");
      out.write("\r\n");
      out.write("      <p>初步的思路是</p>\r\n");
      out.write("\r\n");
      out.write("      <ol>\r\n");
      out.write("        <li>字符串相似度，相似度太高的直接结束</li>\r\n");
      out.write("        <li>parse 代码为 AST</li>\r\n");
      out.write("        <li>AST 去除无用信息，变形。比如变量名，函数名，for-while 转换等。</li>\r\n");
      out.write("        <li>AST 相似度判断</li>\r\n");
      out.write("      </ol>\r\n");
      out.write("\r\n");
      out.write("      <p>目前有一份测试数据，大约2000提交，目测重复的代码很多。</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"panel panel-default\">\r\n");
      out.write("    <div class=\"panel-heading\">\r\n");
      out.write("      <h3 class=\"panel-title\"><a href=\"#\" class=\"text-primary fs-article-title\">Test One Title</a></h3>\r\n");
      out.write("      <div class=\"fs-article-meta\">\r\n");
      out.write("        <a href=\"#\">francisXu</a>发表于2012-01-01 01:01:01 | 分类：<a href=\"#\">其他</a> | <a href=\"#\">评论</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"panel-body\">\r\n");
      out.write("      <p>毕业项目中的一部分，开始挖坑，想起多少写下来。</p>\r\n");
      out.write("\r\n");
      out.write("      <p>初步的思路是</p>\r\n");
      out.write("\r\n");
      out.write("      <ol>\r\n");
      out.write("        <li>字符串相似度，相似度太高的直接结束</li>\r\n");
      out.write("        <li>parse 代码为 AST</li>\r\n");
      out.write("        <li>AST 去除无用信息，变形。比如变量名，函数名，for-while 转换等。</li>\r\n");
      out.write("        <li>AST 相似度判断</li>\r\n");
      out.write("      </ol>\r\n");
      out.write("\r\n");
      out.write("      <p>目前有一份测试数据，大约2000提交，目测重复的代码很多。</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>");
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