/*package com.cattsoft.webpub.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.webpub.util.ReqUtil;

*//**
 * 显示树的标签
 * <p>Title: 新九七系统</p>
 * <p>Description: 新九七系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: CATTSoft</p>
 * @author not attributable
 * @version 1.0
 *//*
public class TreeTag
    extends BodyTagSupport {
	Logger log = Logger.getLogger(TreeTag.class);

  public TreeTag() {
  }

  JspWriter out = null;
  public String target = null;
  public String treeID = null;
  public String href = null;
  private String hrefLeaf = null;
  public String jsPath = null;
  public String xmlID = null;
  public String rootName = "目录";
  public String depth = null;
  public String menuWidth = null;
  public String showMenu = null;
  public String initMenu = null;
  public String nodeType = null;
  public String leafType = null;
  public String formName = "formName";

  public JspWriter getOut() {
    if (out == null) {
      out = pageContext.getOut();
    }
    return out;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public void setHrefend(String hrefProd) {
    this.hrefLeaf = hrefLeaf;
  }

  public void setJsPath(String jsPath) {
    this.jsPath = jsPath;
  }

  public void setXmlID(String xmlID) {
    this.xmlID = xmlID;
  }

  public void setTreeID(String treeID) {
    this.treeID = treeID;
  }

  public void setHrefLeaf(String hrefLeaf) {
    this.hrefLeaf = hrefLeaf;

  }

  public void setRootName(String rootName) {
    this.rootName = rootName;
  }

  public void setDepth(String depth) {
    this.depth = depth;
  }

  public void setMenuWidth(String menuWidth) {
    this.menuWidth = menuWidth;
  }

  public void setShowMenu(String showMenu) {
    this.showMenu = showMenu;
  }

  public void setInitMenu(String initMenu) {
    this.initMenu = initMenu;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public void setLeafType(String leafType) {
    this.leafType = leafType;
  }

  public void setFormName(String formName) {
    this.formName = formName;
  }

  public String getTarget() {
    return target;
  }

  public int doStartTag() {
    getOut();
    String path = getJsPath();
    if (path != null) {
      path += "/";
    }
    try {
      if (path != null) {
        out.println("<script src=\"" + path + "sps_tree.js\"></script>");
        out.println("<script src=\"" + path + "tree_menu.js\"></script>");
      }
      out.println("<script>");
      if(getNodeType()!=null){
        out.println("var nodeType = \"" + getNodeType() + "\"");
      }else{
        out.println("var nodeType = \"url\"");
      }
      if(getLeafType()!=null){
        out.println("var leafType = \"" + getLeafType() + "\"");
      }else{
        out.println("var leafType = \"url\"");
      }

      out.println("var nUrl = \"" + getHref() + "\"");
      out.println("var lUrl = \"" + getHrefLeaf() + "\"");
      out.println("var selectedNode = null;");
      out.println("var tar = \"" + getTarget() + "\"");
      if (getMenuWidth() != null && !"".equalsIgnoreCase(getMenuWidth())) {
        out.println("var menu = new tree_menu(" + getMenuWidth() + ");");
      }
      else {
        out.println("var menu = new tree_menu(120);");
      }
      out.println("var unfoldAllItem = null;");
      out.println("var foldAllItem = null;");
      if (getInitMenu() != null && ("y".equalsIgnoreCase(getInitMenu()) ||
                                    "true".equalsIgnoreCase(getInitMenu()) ||
                                    "yes".equalsIgnoreCase(getInitMenu()))) {
        out.println("beforeItemAdd();");
      }
      out.println(
          "unfoldAllItem = menu.add(\"全部展开\",null,'js',\"unfold(root,null,-1)\");");
      out.println(
          "foldAllItem = menu.add(\"全部收缩\",null,'js',\"unfold(root,true,-1)\");");

      if (getInitMenu() != null && "y".equalsIgnoreCase(getInitMenu()) ||
          "true".equalsIgnoreCase(getInitMenu()) ||
          "yes".equalsIgnoreCase(getInitMenu())) {

        out.println("afterItemAdd();");
      }
      out.println(
          "document.body.oncontextmenu=function(){event.returnValue=false;}");
      out.println("document.body.onmousedown=function(){");
      if (getShowMenu() != null && ! ("".equalsIgnoreCase(getShowMenu()) ||
                                      "y".equalsIgnoreCase(getShowMenu()) ||
                                      "true".equalsIgnoreCase(getShowMenu()) ||
                                      "yes".equalsIgnoreCase(getShowMenu()))) {
        out.println("  return;");
      }
      out.println(" if(event.button==2){");
      out.println("   beforeMenu();");
      out.println("   menu.show();");
      out.println("   afterMenu();");
      out.println(" }");
      out.println("}");
      out.println("   ");

      out.println("</script>");
      String nameForm = this.getFormName();
      if(nameForm == null || "".equals(nameForm)){
        nameForm = "formName";
      }
      if("tempForm".equalsIgnoreCase(nameForm)){
        nameForm.concat("z");
      }
      out.println(
          "<form name='tempForm'><input type='hidden' name='temp' value='-1'/><input type='hidden' name='type' value='o'/></form> <form name='"+nameForm+"'  id = 'treeFormName' >");
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    String tree = getTree();
    try {
      out.write(tree);

      if (getDepth() != null && !"".equalsIgnoreCase(getDepth())) {
        out.println("<script>");
        out.println("unfold(root,null," + getDepth() + ");");
        out.println("</script>");
      }
    }
    catch (IOException ex1) {
      ex1.printStackTrace();
    }
    return this.EVAL_BODY_INCLUDE;
  }

  public int doEndTag() {
    getOut();
    showTree();
        try {
          out.println("</form>");
        } catch (IOException ex) {
        }
    return this.EVAL_PAGE;
  }

  public void showTree() {

  }

  String getTree() {
	  LogUtil.debug(log,"treetag:"+this.pageContext.getRequest().getAttribute("new97Tree"));
   
      return (String) ReqUtil.look(pageContext, "new97Tree", 2);
    
  }

  public String getHref() {
    if (href == null || href.equals("")) {
      return "#";
    }
    else {
      return href;
    }
  }

  public String getHrefend() {
    return hrefLeaf;
  }

  public String getJsPath() {
    if (jsPath == null) {
      return "";
    }
    return jsPath;
  }

  public String getXmlID() {
    return xmlID;
  }

  public String getTreeID() {
    if (treeID == null || treeID.equals("")) {
      return "0";
    }
    return treeID;
  }

  public String getHrefLeaf() {
    if (hrefLeaf == null || hrefLeaf.equals("")) {
      return "#";
    }

    return this.hrefLeaf;
  }

  public String getRootName() {
    if (hrefLeaf == null) {
      return "";
    }
    return rootName;
  }

  public String getDepth() {
    return depth;
  }

  public String getMenuWidth() {
    return menuWidth;
  }

  public String getShowMenu() {
    return showMenu;
  }

  public String getInitMenu() {
    return initMenu;
  }

  public String getNodeType() {
    return nodeType;
  }

  public String getLeafType() {
    return leafType;
  }

  public String getFormName() {
    return formName;
  }

}
*/