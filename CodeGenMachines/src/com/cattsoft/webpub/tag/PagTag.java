package com.cattsoft.webpub.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.pub.util.PagView;

/**
 *
 * <p>Title: �¾���ϵͳ</p>
 * <p>Description: �¾���ϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: CATTSoft</p>
 * @author shijian
 * @version 1.1�ӶԻس�����Ӧ
 */
public class PagTag extends BodyTagSupport {
	private static Log log = LogFactory.getLog(PagTag.class);

	public PagTag() {
	}

	PagView pv = null;

	int count = -1; //�ܼ�¼��

	int pagSize = -1; //ÿҳ��ʾ��¼��

	int pagNo = -1; //ҳ����

	int pagCount = -1; ///////////ҳ��

	JspWriter out = null;

	String requestURI = null;

	String requestUri = null;

	public String jsPath = null;

	String name = null;

	private int formNo = 0;

	public PageContext getPageContext() {
		return this.pageContext;
	}

	public void initParameters() throws JspException {
		
		pv = (PagView) this.pageContext.getRequest().getAttribute(name);
		if (pv == null) {
			pv = (PagView) this.pageContext.getSession().getAttribute(name);	
		}
		//pv = (PagView) RequestUtils.lookup(pageContext, name, "session");
		String contextPath = ((HttpServletRequest) this.pageContext
				.getRequest()).getContextPath();
		String URL = ((HttpServletRequest) this.pageContext.getRequest())
				.getRequestURI();
		String servletURL = ((HttpServletRequest) this.pageContext.getRequest())
				.getServletPath();
		String pathInfo = ((HttpServletRequest) this.pageContext.getRequest())
				.getPathInfo();
		log.debug("��õ���ҳ��ַ:" + URL);
		log.debug("��õ���ҳ��ַservletURL:" + servletURL);
		log.debug("��õ���ҳ��ַgetPathInfo:" + pathInfo);
		log.debug(contextPath);
		setRequestURI(requestURI);
	    if(pv==null){
	    	pv = new PagView();
	    	pv.setCount(0);
	    	pv.setPagCount(0);
	    	pv.setPagNo(0);
	    	pv.setPagSize(0);
	    } 
		count = pv.getCount();
		pagCount = pv.getPagCount();
		pagNo = pv.getPagNo();
		pagSize = pv.getPagSize();

		log.debug("pagSize:" + pagSize);
		log.debug("requestURL" + requestURI);
		if (requestURI != null) {
			requestUri = requestURI;
		}
		/**
		 * fuheping ��ҳ�洩��pagsize
		 */
/*		if (pagSize > 0) {
			requestUri = requestUri + "&pagSize=" + pagSize;
		} else {
			HttpServletRequest req = (HttpServletRequest) this.pageContext
					.getRequest();
			pagSize = req.getParameter("pagSize") == null ? -1 : Integer
					.parseInt(req.getParameter("pagSize"));
		}
		if (pagSize < 0) {
			log.debug("pagSizeû��ֵ!!");
		}*/
		/*add by wwwer1 200501130*/
/*		 HttpServletRequest req = (HttpServletRequest) this.pageContext
				.getRequest();
		Map map = req.getParameterMap();
		if (map != null) {
			Set set = map.keySet();
			if (set != null && !set.isEmpty()) {
				Iterator it = set.iterator();
				while (it.hasNext()) {
					Object key = it.next();
					if (key.toString().equals("pagSize"))
						continue;
					String[] valueArr = (String[]) map.get(key);
					String value = valueArr[0]; //���ڲ�ѯʱ������ֿؼ�����
					if(!(key.equals("pageNo")||key.equals("pagSize")))
						if(value!=null&&!value.equals("null"))
							requestUri = requestUri + "&" + key + "=" + value;
						else
							requestUri = requestUri + "&" + key + "=";
				}
			}
		}*/
		System.out.println("pagCount:" + pagCount);
		System.out.println("pagNo:" + pagNo);
		System.out.println("count:" + pagSize);
		log.debug("requestUri:" + requestUri);
	}

	public int doStartTag() {
		getOut();
		log.debug("����doStartTag()!");
		try {
		     initParameters();
			if (this.pagCount > 0) {
				out.println("<script>");
				out.println(" function showbusiAnimate(){");
				out.println(" try{");
				out.println("  parent.busiAnimate.style.display ='';");
				out.println(" }catch(e){ ");
				out.println(" try{");
				out.println(" busiAnimate.style.display ='';");
				out.println(" }catch(e){} }}");
				out.println("function Isnumber(In_Str){");
				out.println("StrLen=In_Str.length;");
				out.println("var	Ret_Value = true;");
				out.println("for (i=0; i<StrLen; i++)        {");
				out.println("FirstCha = escape(In_Str.charAt(i));");
				out.println("if ((FirstCha < '0') || (FirstCha > '9')){");
				out.println("Ret_Value = false;");
				out.println("break;");
				out.println("}");

				out.println("}");
				out.println("return Ret_Value;");
				out.println("}");
				out.println("function goPage(no){");
				out.println("showbusiAnimate();");
				if (formNo != 0) {
					out.println("document.forms[" + formNo + "].pageNo.value=no");
					out.println("document.forms[" + formNo + "].action='" + requestUri+"'");					
					out.println("document.forms[" + formNo + "].submit();");
				} else {
					out.println("document.forms[0].pageNo.value=no");
					out.println("document.forms[0].action='" + requestUri+"'");
					out.println("document.forms[0].submit();");
				}
				out.println("}");
				out.println("function gotoPage(){");
				if (formNo != 0) {
					out.println(" var no = document.forms[" + formNo+ "].pageNo.value;");
					out.println("var pagCount = document.forms[" + formNo+ "].pagCount.value;");
					out.println("var pagSize = document.forms[" + formNo+ "].pagSize.value;");
				} else {
					out.println(" var no = document.forms[0].pageNo.value;");
					out.println("var pagCount = document.forms[0].pagCount.value;");
					out.println("var pagSize = document.forms[0].pagSize.value;");
				}
				out.println("if (no=='') {");
				out.println("alert('������ҳ��!');");
				out.println("return false;");
				out.println("}");
				out.println("if (!Isnumber(no)) {alert('�������Ϊ����');return false;}");
				out.println("if (!Isnumber(pagSize)) {alert('�������Ϊ����');return false;}");
				out.println("if (parseInt(no)>parseInt(pagCount)) {");
				out.println("alert('����ֵ����С����ҳ��');");
				out.println("return false;");
				out.println("}");
				out.println("if (no<1) {");
				out.println("alert('����ֵ�������0');");
				out.println("return false;");
				out.println("}");
				out.println("if (pagSize<1) {");
				out.println("alert('����ֵ�������0');");
				out.println("return false;");
				out.println("}");
				out.println("if (pagSize>100) {");
				out.println("alert('ÿҳ��ʾ������̫�࣬���ܳ���100��');");
				out.println("return false;");
				out.println("}");				
				out.println(" ");
				out.println("showbusiAnimate();");
				if (formNo != 0) {
					out.println("document.forms[" + formNo + "].action='" + requestUri+"'");
					out.println("document.forms[" + formNo + "].submit();");
				} else {
					out.println("document.forms[0].action='" + requestUri+"'");
					out.println("document.forms[0].submit();");
				}
				out.println("}");
				out.println("</script>");
				int begin = ((pagNo - 1) * pagSize + 1);
				int end;
				if (count > pagNo * pagSize) {
					end = pagNo * pagSize;
				} else {
					end = count;
				}
				if (begin < 0)
					begin = 0;

				if (pagNo > 1) {
					out.print("[");
					out.print("<a onclick='goPage(1)' style=cursor:hand>"
							+ "��ҳ" + "</a>");
					out.print("/");
					out.print("<a onclick='goPage(" + (pagNo - 1)
							+ ")' style=cursor:hand>" + "ǰһҳ" + "</a>");
					out.print("]");
				} else {
					out.print("[��ҳ/ǰһҳ]");
				}
				out.print("&nbsp");
				if (pagNo < pagCount) {
					out.print("[");
					out.print("<a onclick='goPage(" + (pagNo + 1)
							+ ")' style=cursor:hand>" + "��һҳ" + "</a>");
					out.print("/");
					out.print("<a onclick='goPage(" + pagCount
							+ ")' style=cursor:hand>" + "βҳ" + "</a>");
					out.print("]");
				} else {
					out.print("[��һҳ/βҳ]");
				}
				out.println("<input type='hidden' name='begin' value='" + begin
						+ "'>");
				out.println("<input type='hidden' name='end' value='" + end
						+ "'>");
				out.println("<input type='hidden' name='count' value='" + count
						+ "'>");
				out.println("<input type='hidden' name='pagCount' value='"
						+ pagCount + "'>");
				out.print("��ʾ��" + begin + "��" + end + "��");
				out.print("&nbsp");
				out.print("��" + count + "��");
				
				out.print("&nbsp");
				out.print("ÿҳ��ʾ");
				if (formNo != 0) {
					out.print("<input type='text' name='pagSize' size='2' onkeydown='if(event.keyCode==13) {event.returnValue = false;document.forms["
									+ formNo + "].goButton.onclick();}'");
				} else {
					out.print("<input type='text' name='pagSize' size='2' onkeydown='if(event.keyCode==13) {event.returnValue = false;document.forms[0].goButton.onclick();}'");
				}
				out.print(" value='" + pagSize + "' >");
				out.print("��");
				out.print("&nbsp");
				out.print("��" + pagCount + "ҳ");
				out.print("&nbsp");
				out.print("��");
				if (formNo != 0) {
					out.print("<input type='text' name='pageNo' size='2' onkeydown='if(event.keyCode==13) {event.returnValue = false;document.forms["
									+ formNo + "].goButton.onclick();}'");
				} else {
					out.print("<input type='text' name='pageNo' size='2' onkeydown='if(event.keyCode==13) {event.returnValue = false;document.forms[0].goButton.onclick();}'");
				}
				out.print(" value='" + pagNo + "' >");
				out.print("ҳ");
				out.print("&nbsp");
				out.print("<input type='button' onclick='gotoPage()' style='cursor:hand' name='goButton' value='GO!'>");
			} else {
				out.print("��ǰ��ѯ���û������!");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JspException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() {

		return this.SKIP_BODY;
	}

	/**
	 * Utility method. Write a string to the default out
	 * @param string String
	 * @throws JspTagException if an IOException occurs
	 */
	public void write(String string) throws JspTagException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.write(string);
		} catch (IOException e) {
			throw new JspTagException("Writer Exception: " + e.getMessage());
		}
	}

	/**
	 * Utility method. Write a string to the default out
	 * @param buffer StringBuffer
	 * @throws JspTagException if an IOException occurs
	 */
	public void write(StringBuffer buffer) throws JspTagException {
		this.write(buffer.toString());
	}

	public JspWriter getOut() {
		if (out == null) {
			out = pageContext.getOut();
		}
		return out;
	}

	public PagView getPv() {
		return pv;
	}

	public void setPv(PagView pv) {
		this.pv = pv;
	}

	public String getJsPath() {
		if (jsPath == null) {
			return "";
		}
		return jsPath;
	}

	/**
	 * setter for the "requestURI" attribute. Context path is automatically added to path starting with "/".
	 * @param value base URI for creating links
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPagSize() {
		return pagSize;
	}

	public void setPagSize(int pagSize) {
		this.pagSize = pagSize;
	}

	public int getPagNo() {
		return pagNo;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public void setPagCount(int pagCount) {
		this.pagCount = pagCount;
	}

	public void setOut(JspWriter out) {
		this.out = out;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public void setJsPath(String jsPath) {
		this.jsPath = jsPath;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPagNo(int pagNo) {
		this.pagNo = pagNo;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public int getFormNo() {
		return formNo;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public void setFormNo(int formNo) {
		this.formNo = formNo;
	}

}