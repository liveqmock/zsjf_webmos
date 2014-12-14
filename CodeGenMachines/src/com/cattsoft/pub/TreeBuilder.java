package com.cattsoft.pub;

import java.util.*;
import org.dom4j.*;
import java.io.*;
import org.dom4j.io.*;
import javax.servlet.http.*;
import org.apache.commons.logging.*;

public class TreeBuilder {
	private static Log log = LogFactory.getLog(TreeBuilder.class);

	public TreeBuilder() {
	}

	public static String buildTree(List lList, List nList) {
		return buildTree(lList, nList, null);
	}

	public static String buildTreeCheckBox(List lList, List nList, String type) {
		String retStr = null;
		if (!"0".equals(type) && !"1".equals(type) && !"2".equals(type)) {
			type = "0";
		}
		retStr = buildTreeCheckBox(lList, nList, null, type);
		return retStr;
	}

	public static String buildTree(List lList, List nList, HttpServletRequest req) {
		Object show = null;
		if (req != null) {
			show = req.getAttribute("showTreeNode");
		}
		Element showElement = null;
		boolean showElementIsNode = false;

		Element root = null;
		List list = lList;
		list.addAll(nList);
		Collections.sort(list);
		Iterator it = list.iterator();
		HashMap map = new HashMap();
		while (it.hasNext()) {
			TreeBean tb = (TreeBean) it.next();
			Element div = null;
			if (tb.getIsNode() != null
					&& (tb.getIsNode().equalsIgnoreCase("y") || tb.getIsNode().equalsIgnoreCase(
							"yes"))) {
				div = buildNode(tb);
				map.put(tb.getId().toString(), div);
			} else {
				div = buildLeaf(tb);
				map.put("leaf_" + tb.getId(), div);
			}
		}

		it = list.iterator();
		while (it.hasNext()) {
			TreeBean tb = (TreeBean) it.next();
			// if (log.isDebugEnabled()) {
			// log.debug("正在 处理 " + tb.getName());
			// }

			Element child = null;
			Element parent = null;
			if (tb.getIsNode() != null
					&& (tb.getIsNode().equalsIgnoreCase("y") || tb.getIsNode().equalsIgnoreCase(
							"yes"))) {
				child = (Element) map.get(tb.getId().toString());
			} else {
				child = (Element) map.get("leaf_" + tb.getId());
			}

			if (tb.getFa() != null) {
				parent = (Element) map.get(tb.getFa().toString());
			}
			/**
			 * 为空时取本身，用于部门处
			 */
			else {
				parent = (Element) map.get(tb.getId().toString());
			}

			if (child != null && parent != null) {
				/**
				 * 增加了根节点的又一种判定条件，即父结点（Fa）为空，这个条件适用于部门
				 */
				if ((tb.getIsNode().equalsIgnoreCase("y"))
						&& (tb.getFa() == null || tb.getId().equals(tb.getFa()))) {
					root = child;
					// if (log.isDebugEnabled()) {
					// log.debug("根节点为：" + tb.getName() + "：：：" + root);
					// }

				} else {
					parent.add(child);
				}
				Element span = (Element) parent.elements("span").get(0);
				if (span.elements("img").size() == 0) {
					Element spanSub = (Element) span.elements("span").get(0);
					Element label = (Element) spanSub.elements("label").get(0);
					String s = label.getText();

					parent.addAttribute("style",
							"padding-left:20;vertical-align:middle;text-align:left;display:none;width:"
									+ s.length() * 50 + "");
					Element span2 = (Element) span.elements("span").get(0);
					span.remove(span2);
					Element img = span.addElement("img");
					img.addAttribute("src", "../images/tree/expand_xp.gif");
					img.addAttribute("onclick", "col(this)");
					span.add(span2);
				}

				if (show != null && tb.equals(show)) {
					showElement = child;
					if (tb.isNode != null
							&& ("y".equalsIgnoreCase(tb.isNode)
									|| "yes".equalsIgnoreCase(tb.isNode) || "true"
									.equalsIgnoreCase(tb.isNode))) {
						showElementIsNode = true;
					} else {
						showElementIsNode = false;
					}
				}

			} else {
				// //System.out.println("_________________"+tb.getName()+"____________________________"+parent);
			}
		}
		root.addAttribute("style", "vertical-align:middle;text-align:left;display:block;width:300");
		root.addAttribute("id", "root");
		root.addAttribute("NOWRAP", "true");
		if (showElement != null) {
			expand(showElement, root, showElementIsNode);
		}

		root.normalize();
		Document dom = DocumentHelper.createDocument();
		dom.add(root);
		StringWriter sw = new StringWriter();
		// * 进行输出

		try {
			OutputFormat of = OutputFormat.createPrettyPrint();
			XMLWriter out = new XMLWriter(sw, of);
			out.write(dom);
			out.close();
		} catch (IOException ex) {
		}

		return sw.toString();
	}

	public static String buildTreeCheckBox(List lList, List nList, HttpServletRequest req,
			String type) {
		Object show = null;
		if (req != null) {
			show = req.getAttribute("showTreeNode");
		}
		Element showElement = null;
		boolean showElementIsNode = false;

		Element root = null;
		List list = lList;
		list.addAll(nList);
		Collections.sort(list);
		Iterator it = list.iterator();
		HashMap map = new HashMap();
		while (it.hasNext()) {
			TreeBean tb = (TreeBean) it.next();
			Element div = null;
			if (tb.getIsNode() != null
					&& (tb.getIsNode().equalsIgnoreCase("y") || tb.getIsNode().equalsIgnoreCase(
							"yes"))) {
				if ("0".equals(type) || "1".equals(type)) { // 0,1 代表目录的checkbox
					div = buildNodeCheckBox(tb);
				} else {
					div = buildNode(tb);
				}
				map.put(tb.getId().toString(), div);
			} else {
				if ("0".equals(type) || "2".equals(type)) { // 0,2代表叶子的checkbox
					div = buildLeafCheckBox(tb);
				} else {
					div = buildLeaf(tb);
				}
				map.put("leaf_" + tb.getId(), div);
			}
		}

		it = list.iterator();
		while (it.hasNext()) {
			TreeBean tb = (TreeBean) it.next();
			// if (log.isDebugEnabled()) {
			// log.debug("正在 处理 " + tb.getName());
			// }

			Element child = null;
			Element parent = null;
			if (tb.getIsNode() != null
					&& (tb.getIsNode().equalsIgnoreCase("y") || tb.getIsNode().equalsIgnoreCase(
							"yes"))) {
				child = (Element) map.get(tb.getId().toString());
			} else {
				child = (Element) map.get("leaf_" + tb.getId());
			}

			if (tb.getFa() != null) {
				parent = (Element) map.get(tb.getFa().toString());
			}
			/**
			 * 为空时取本身，用于部门处
			 */
			else {
				parent = (Element) map.get(tb.getId().toString());
			}

			if (child != null && parent != null) {
				/**
				 * 增加了根节点的又一种判定条件，即父结点（Fa）为空，这个条件适用于部门
				 */
				if ((tb.getIsNode().equalsIgnoreCase("y"))
						&& (tb.getFa() == null || tb.getId().equals(tb.getFa()))) {
					root = child;
					// if (log.isDebugEnabled()) {
					// log.debug("根节点为：" + tb.getName() + "：：：" + root);
					// }

				} else {
					parent.add(child);
				}
				Element span = (Element) parent.elements("span").get(0);
				if (span.elements("img").size() == 0) {
					Element spanSub = (Element) span.elements("span").get(0);
					Element label = (Element) spanSub.elements("label").get(0);
					String s = label.getText();

					parent.addAttribute("style",
							"padding-left:20;vertical-align:middle;text-align:left;display:none;width:"
									+ s.length() * 50 + "");
					Element span2 = (Element) span.elements("span").get(0);
					span.remove(span2);
					Element input = (Element) span.element("input");
					if (input != null) {
						span.remove(input);
					}
					Element img = span.addElement("img");
					img.addAttribute("src", "../images/tree/expand_xp.gif");
					img.addAttribute("onclick", "col(this)");
					if (input != null) {
						span.add(input);
					}
					span.add(span2);
				}

				if (show != null && tb.equals(show)) {
					showElement = child;
					if (tb.isNode != null
							&& ("y".equalsIgnoreCase(tb.isNode)
									|| "yes".equalsIgnoreCase(tb.isNode) || "true"
									.equalsIgnoreCase(tb.isNode))) {
						showElementIsNode = true;
					} else {
						showElementIsNode = false;
					}
				}

			} else {
				// //System.out.println("_________________"+tb.getName()+"____________________________"+parent);
			}
		}

		root.addAttribute("style", "vertical-align:middle;text-align:left;display:block;width:300");
		root.addAttribute("id", "root");
		root.addAttribute("NOWRAP", "true");
		if (showElement != null) {
			expand(showElement, root, showElementIsNode);
		}

		root.normalize();
		Document dom = DocumentHelper.createDocument();
		dom.add(root);
		StringWriter sw = new StringWriter();
		// * 进行输出

		try {
			OutputFormat of = OutputFormat.createPrettyPrint();
			XMLWriter out = new XMLWriter(sw, of);
			out.write(dom);
			out.close();
		} catch (IOException ex) {
		}

		return sw.toString();
	}

	public static Element buildNode(TreeBean tb) {
		Element div = DocumentHelper.createElement("div");
		/**
		 * 父节点可能为空，增加判定条件
		 */
		if (tb.getFa() == null || tb.getId().equals(tb.getFa())) {
			div.addAttribute("style", "vertical-align:middle;text-align:left;display:block;width:"
					+ tb.getName().length() * 50 + "");
		} else {
			div.addAttribute("style",
					"padding-left:43;vertical-align:middle;text-align:left;display:none;width:"
							+ tb.getName().length() * 50 + "");
		}

		/* 将t中信息加入 */
		div.addAttribute("isNode", "Y");
		div.addAttribute("serial", tb.getId().toString());
		// div.addAttribute("NOWRAP","true");

		Element span = div.addElement("span");
		span.addAttribute("style",
				"cursor:default;text-align:left;color:black;font-size:9pt;margin:0;");
		Element span2 = span.addElement("span");
		span2.addAttribute("onclick", "folder(this,\"" + tb.getId() + "\");getIdAndName(\""
				+ tb.getId() + "\",\"" + tb.getName() + "\")");
		span2.addAttribute("onmouseover", "mouseOver(this)");
		span2.addAttribute("onmouseout", "mouseOut(this)");
		span2.addAttribute("onmousedown", "mouseDown(this)");
		span2.addAttribute("onmouseup", "mouseUp(this)");
		span2.addAttribute("style", "cursor:hand;padding:0;margin-left:-3;text-align:left;");
		Element img = span2.addElement("img");
		img.addAttribute("src", "../images/tree/folderclose.gif");
		Element label = span2.addElement("label");
		label.addAttribute("style", "font-size:9pt;text-align:left;margin-left:-3");
		label.addText(tb.getName());
		return div;
	}

	public static Element buildNodeCheckBox(TreeBean tb) {
		Element div = DocumentHelper.createElement("div");
		/**
		 * 父节点可能为空，增加判定条件
		 */
		if (tb.getFa() == null || tb.getId().equals(tb.getFa())) {
			div.addAttribute("style", "vertical-align:middle;text-align:left;display:block;width:"
					+ tb.getName().length() * 50 + "");
		} else {
			div.addAttribute("style",
					"padding-left:43;vertical-align:middle;text-align:left;display:none;width:"
							+ tb.getName().length() * 50 + "");
		}

		/* 将t中信息加入 */
		div.addAttribute("isNode", "Y");
		div.addAttribute("serial", tb.getId().toString());
		// div.addAttribute("NOWRAP","true");

		Element span = div.addElement("span");
		span.addAttribute("style",
				"cursor:default;text-align:left;color:black;font-size:9pt;margin:0;");
		// 添加checkbox
		Element chek = span.addElement("input");
		chek.addAttribute("type", "checkbox");
		chek.addAttribute("name", "nodeCheckList");
		chek.addAttribute("value", tb.getId() + "");

		Element span2 = span.addElement("span");
		span2.addAttribute("onclick", "folder(this,\"" + tb.getId() + "\")");
		span2.addAttribute("onmouseover", "mouseOver(this)");
		span2.addAttribute("onmouseout", "mouseOut(this)");
		span2.addAttribute("onmousedown", "mouseDown(this)");
		span2.addAttribute("onmouseup", "mouseUp(this)");
		span2.addAttribute("style", "cursor:hand;padding:0;margin-left:-3;text-align:left;");
		Element img = span2.addElement("img");
		img.addAttribute("src", "../images/tree/folderclose.gif");
		Element label = span2.addElement("label");
		label.addAttribute("style", "font-size:9pt;text-align:left;margin-left:-3");
		label.addText(tb.getName());
		return div;
	}

	public static Element buildLeaf(TreeBean tb) {
		Element div = DocumentHelper.createElement("div");
		div.addAttribute("isNode", "N");
		div.addAttribute("serial", tb.getId().toString());
		// if (log.isDebugEnabled()) {
		// log.debug(" tb name: " + tb.getName());
		// }

		div.addAttribute("style",
				"padding-left:43;vertical-align:middle;text-align:left;display:none;width:"
						+ tb.getName().length() * 50 + "");
		// div.addAttribute("NOWRAP","true");

		Element span = div.addElement("span");
		span.addAttribute("style",
				"cursor:default;text-align:left;color:black;font-size:9pt;margin:0;");
		Element span2 = span.addElement("span");
		span2.addAttribute("onclick", "file(this,\"" + tb.getValue() + "\");getIdAndName(\""
				+ tb.getId() + "\",\"" + tb.getName() + "\")");
		// log.debug("leaf value is "+tb.getValue());
		span2.addAttribute("onmouseover", "mouseOver(this)");
		span2.addAttribute("onmouseout", "mouseOut(this)");
		span2.addAttribute("onmousedown", "mouseDown(this)");
		span2.addAttribute("onmouseup", "mouseUp(this)");
		span2.addAttribute("style", "cursor:hand;padding:0;margin-left:-3;text-align:left;");
		Element img = span2.addElement("img");
		img.addAttribute("src", "../images/tree/ball.gif");
		Element label = span2.addElement("label");
		label.addAttribute("style", "font-size:9pt;text-align:left;margin-left:-3");
		label.addText(tb.getName());
		return div;
	}

	public static Element buildLeafCheckBox(TreeBean tb) {
		Element div = DocumentHelper.createElement("div");
		div.addAttribute("isNode", "N");
		div.addAttribute("serial", tb.getId().toString());
		// if (log.isDebugEnabled()) {
		// log.debug(" tb name: " + tb.getName());
		// }

		div.addAttribute("style",
				"padding-left:43;vertical-align:middle;text-align:left;display:none;width:"
						+ tb.getName().length() * 50 + "");
		// div.addAttribute("NOWRAP","true");

		Element span = div.addElement("span");
		span.addAttribute("style",
				"cursor:default;text-align:left;color:black;font-size:9pt;margin:0;");

		// 添加checkbox
		Element chek = span.addElement("input");
		chek.addAttribute("type", "checkbox");
		chek.addAttribute("name", "leafCheckList");
		chek.addAttribute("value", tb.getId() + "");

		Element span2 = span.addElement("span");
		span2.addAttribute("onclick", "file(this,\"" + tb.getValue() + "\")");
		span2.addAttribute("onmouseover", "mouseOver(this)");
		span2.addAttribute("onmouseout", "mouseOut(this)");
		span2.addAttribute("onmousedown", "mouseDown(this)");
		span2.addAttribute("onmouseup", "mouseUp(this)");
		span2.addAttribute("style", "cursor:hand;padding:0;margin-left:-3;text-align:left;");
		Element img = span2.addElement("img");
		img.addAttribute("src", "../images/tree/ball.gif");
		Element label = span2.addElement("label");
		label.addAttribute("style", "font-size:9pt;text-align:left;margin-left:-3");
		label.addText(tb.getName());
		return div;
	}

	public static void expand(Element showNode, Element root, boolean showElementIsNode) {
		Element parent = null;
		Element show = showNode;
		if (showElementIsNode) {
			expand(show);
		}
		while (show != root) {
			parent = show.getParent();
			expand(parent);
			show = parent;
		}
	}

	public static void expand(Element p) {
		List list = p.elements("div");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Element elt = (Element) it.next();
			String style = elt.attribute("style").getValue();
			elt.addAttribute("style", style.replaceAll("display:none", "display:block"));
		}
		List spanList = p.elements("span");
		if (spanList != null && spanList.size() > 0) {
			List imgList = ((Element) (p.elements("span").get(0))).elements("img");

			if (imgList != null && imgList.size() > 0) {
				Element img = (Element) (((Element) (p.elements("span").get(0))).elements("img")
						.get(0));
				img.addAttribute("src", "../images/tree/collapse_xp.gif");
			}
		}
	}

}
