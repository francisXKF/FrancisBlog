/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2016-02-06 14:22:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005fcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div  class=\"panel-group\" id=\"category\" role=\"tablist\" aria-multiselectable=\"true\">\r\n");
      out.write("  <div class=\"panel panel-default\">\r\n");
      out.write("    <div class=\"panel-heading\" role=\"tab\" id=\"categoryTitle\">\r\n");
      out.write("      <h4 class=\"panel-title\">\r\n");
      out.write("        <a role=\"button\" data-toggle=\"collapse\" data-parent=\"#category\" href=\"#categoryOne\" aria-expanded=\"true\" aria-controls=\"categoryOne\">\r\n");
      out.write("          Title\r\n");
      out.write("        </a>\r\n");
      out.write("      </h4>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"categoryOne\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"categoryTitle\">\r\n");
      out.write("      <div class=\"panel-body\">\r\n");
      out.write("        <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("          <li role=\"presentation\"><a href=\"#\">category_one</a></li>\r\n");
      out.write("          <li role=\"presentation\"><a href=\"#\">category_two</a></li>\r\n");
      out.write("          <li role=\"presentation\"><a href=\"#\">category_three</a></li>\r\n");
      out.write("          <li role=\"presentation\"><a href=\"#\">category_four</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"panel panel-default\">\r\n");
      out.write("    <div class=\"panel-heading\" role=\"tab\" id=\"categoryTarget\">\r\n");
      out.write("      <h4 class=\"panel-title\">\r\n");
      out.write("        <a class=\"collapsed\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#category\" href=\"#categoryTwo\" aria-expanded=\"false\" aria-controls=\"categoryTwo\">\r\n");
      out.write("          target\r\n");
      out.write("        </a>\r\n");
      out.write("      </h4>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"categoryTwo\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"categoryTarget\">\r\n");
      out.write("      <div class=\"panel-body\">\r\n");
      out.write("        <span class=\"label label-default\">Default</span>\r\n");
      out.write("        <span class=\"label label-primary\">Primary</span>\r\n");
      out.write("        <span class=\"label label-success\">Success</span>\r\n");
      out.write("        <span class=\"label label-info\">Info</span>\r\n");
      out.write("        <span class=\"label label-warning\">Warning</span>\r\n");
      out.write("        <span class=\"label label-danger\">Danger</span>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--\r\n");
      out.write("  <div class=\"category-title\">\r\n");
      out.write("    <div class=\"title-group\">\r\n");
      out.write("      <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("        <li role=\"presentation\"><a href=\"#\">category_one</a></li>\r\n");
      out.write("        <li role=\"presentation\"><a href=\"#\">category_two</a></li>\r\n");
      out.write("        <li role=\"presentation\"><a href=\"#\">category_three</a></li>\r\n");
      out.write("        <li role=\"presentation\"><a href=\"#\">category_four</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"category-target\">\r\n");
      out.write("    <span class=\"label label-default\">Default</span>\r\n");
      out.write("    <span class=\"label label-primary\">Primary</span>\r\n");
      out.write("    <span class=\"label label-success\">Success</span>\r\n");
      out.write("    <span class=\"label label-info\">Info</span>\r\n");
      out.write("    <span class=\"label label-warning\">Warning</span>\r\n");
      out.write("    <span class=\"label label-danger\">Danger</span>\r\n");
      out.write("  </div>\r\n");
      out.write("-->");
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