/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.35
 * Generated at: 2016-11-01 09:35:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class master_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(7);
    _jspx_dependants.put("jar:file:/Users/i076218/Documents/02IDE/workspaces/pp/third/apache-tomcat-8.0.35/webapps/../../../third/thrid-web/target/thrid-web/WEB-INF/lib/spring-webmvc-4.1.6.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1427245024000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.1.6.RELEASE.jar", Long.valueOf(1467197210000L));
    _jspx_dependants.put("/WEB-INF/tags/template/javaScriptVariables.tag", Long.valueOf(1477489012000L));
    _jspx_dependants.put("jar:file:/Users/i076218/Documents/02IDE/workspaces/pp/third/apache-tomcat-8.0.35/webapps/../../../third/thrid-web/target/thrid-web/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/tags/template/js.tag", Long.valueOf(1477901119000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1431168206000L));
    _jspx_dependants.put("/WEB-INF/tags/template/css.tag", Long.valueOf(1477987470000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.release();
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head id=\"Head1\">\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    ");
      if (_jspx_meth_template_005fcss_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"/thrid-web/_ui/js/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body class=\"easyui-layout\" class=\"layout\"  fit=\"true\"   scroll=\"no\">\n");
      out.write("<noscript>\n");
      out.write("<div class=\"loading-tips\">\n");
      out.write("    <img src=\"images/noscript.gif\" alt='抱歉，请开启脚本支持！' />\n");
      out.write("</div>\n");
      out.write("</noscript>\n");
      out.write("\n");
      out.write("<div id=\"loading-mask\" class=\"loading-mask\">\n");
      out.write("<div id=\"pageloading\" class=\"loading-page\"> \n");
      out.write("    <img src=\"images/loading.gif\" align=\"absmiddle\" /> 正在加载中,请稍候...</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    <div region=\"north\" split=\"true\" border=\"false\" class=\"layout-north\">\n");
      out.write("        <span style=\"float:right; padding-right:20px;\" class=\"head\">welcome! <a href=\"#\" id=\"editpass\">修改密码</a> <a href=\"#\" id=\"loginOut\">安全退出</a></span>\n");
      out.write("        <span class=\"north-title\"><img src=\"images/blocks.gif\" width=\"20\" height=\"20\" align=\"absmiddle\" /> Blaimar</span>\n");
      out.write("    </div>\n");
      out.write("    <div region=\"south\" split=\"true\" style=\"height: 30px; background: #D2E0F2; \">\n");
      out.write("        <div class=\"footer\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div region=\"west\" split=\"true\"  title=\"");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\" style=\"width:180px;\" id=\"west\">\n");
      out.write("\t\t\t<div id=\"nav\">\n");
      out.write("\t\t<!--  导航内容 -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div id=\"mainPanle\" region=\"center\" style=\"background: #eee; overflow-y:hidden\">\n");
      out.write("        <div id=\"tabs\" class=\"easyui-tabs\"  style=\"padding:5px;\" fit=\"true\" border=\"false\" >\n");
      out.write("\t\t\t<div title=\"欢迎使用\" style=\"padding:20px;overflow:hidden; color:red; \" >\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!--修改密码窗口-->\n");
      out.write("<!--     <div id=\"w\" class=\"easyui-window\" title=\"修改密码\" collapsible=\"false\" minimizable=\"false\" -->\n");
      out.write("<!--         maximizable=\"false\" icon=\"menu-icon-save\"  style=\"width: 300px; height: 150px; padding: 5px; -->\n");
      out.write("<!--         background: #fafafa;\"> -->\n");
      out.write("<!--         <div class=\"easyui-layout\" fit=\"true\"> -->\n");
      out.write("<!--             <div region=\"center\" border=\"false\" style=\"padding: 10px; background: #fff; border: 1px solid #ccc;\"> -->\n");
      out.write("<!--                 <table cellpadding=3> -->\n");
      out.write("<!--                     <tr> -->\n");
      out.write("<!--                         <td>新密码：</td> -->\n");
      out.write("<!--                         <td><input id=\"txtNewPass\" type=\"password\" class=\"txt01\" /></td> -->\n");
      out.write("<!--                     </tr> -->\n");
      out.write("<!--                     <tr> -->\n");
      out.write("<!--                         <td>确认密码：</td> -->\n");
      out.write("<!--                         <td><input id=\"txtRePass\" type=\"password\" class=\"txt01\" /></td> -->\n");
      out.write("<!--                     </tr> -->\n");
      out.write("<!--                 </table> -->\n");
      out.write("<!--             </div> -->\n");
      out.write("<!--             <div region=\"south\" border=\"false\" style=\"text-align: right; height: 30px; line-height: 30px;\"> -->\n");
      out.write("<!--                 <a id=\"btnEp\" class=\"easyui-linkbutton\" icon=\"menu-icon-ok\" href=\"javascript:void(0)\" > -->\n");
      out.write("<!--                     确定</a> <a id=\"btnCancel\" class=\"easyui-linkbutton\" icon=\"icon-cancel\" href=\"javascript:void(0)\">取消</a> -->\n");
      out.write("<!--             </div> -->\n");
      out.write("<!--         </div> -->\n");
      out.write("<!--     </div> -->\n");
      out.write("\n");
      out.write("\t<div id=\"mm\" class=\"easyui-menu\" style=\"width:150px;\">\n");
      out.write("\t\t<div id=\"tabupdate\">刷新</div>\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\n");
      out.write("\t\t<div id=\"close\">关闭</div>\n");
      out.write("\t\t<div id=\"closeall\">全部关闭</div>\n");
      out.write("\t\t<div id=\"closeother\">除此之外全部关闭</div>\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\n");
      out.write("\t\t<div id=\"closeright\">当前页右侧全部关闭</div>\n");
      out.write("\t\t<div id=\"closeleft\">当前页左侧全部关闭</div>\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\n");
      out.write("\t\t<div id=\"exit\">退出</div>\n");
      out.write("\t</div>\n");
      out.write(" \n");
      out.write("    ");
      if (_jspx_meth_template_005fjs_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("   \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jucierTplBasePath}/nav/menu.jsp", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), out, false);
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_template_005fcss_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  template:css
    org.apache.jsp.tag.web.template.css_tag _jspx_th_template_005fcss_005f0 = (new org.apache.jsp.tag.web.template.css_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_template_005fcss_005f0);
    _jspx_th_template_005fcss_005f0.setJspContext(_jspx_page_context);
    _jspx_th_template_005fcss_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_template_005fcss_005f0);
    return false;
  }

  private boolean _jspx_meth_spring_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /WEB-INF/views/pages/master.jsp(31,44) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("nav.tree");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_template_005fjs_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  template:js
    org.apache.jsp.tag.web.template.js_tag _jspx_th_template_005fjs_005f0 = (new org.apache.jsp.tag.web.template.js_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_template_005fjs_005f0);
    _jspx_th_template_005fjs_005f0.setJspContext(_jspx_page_context);
    _jspx_th_template_005fjs_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_template_005fjs_005f0);
    return false;
  }
}
