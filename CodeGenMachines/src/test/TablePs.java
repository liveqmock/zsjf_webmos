package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class TablePs {

	public final static String enter_str = "\r";

	private String table_name = "";

	private String package_name = "";

	private String file_save_path = "";

	private Hashtable primaryHash = null;

	public static String tableName = "";

	public static String fileSavePath = "";

	public static String packageName = "";

	public static String fileSaveMame = "";

	public String save = "";

	public static void main(String[] args) {
		//ADD BY 戎恒恩 20110825 这个类是根据表生成对应java文件的类，运行之前配置对应的比如 sp.txt和sp.property文件即可,连接数据库的地址在getCsmConnection方法里面改
		List list = null;
		TablePs t = new TablePs();
		// initial common variable
		// t.file_save_path="D:\\work\\temp\\";//设置保存文件的路径
		// t.table_name="T_OD_Order_End";//要求生成vo/bo的数据库表名
		// t.getPrimary();
		// //生成vo
		// t.package_name = "fhs.resource.vo";
		// t.createVoe();
		// //生成bo
		// t.package_name = "fhs.resource.bo";
		// t.createBoe();
		//
		/**
		 * 使用说明： 初始化 1. fileSavePath:设置保存文件的路径 2. tableName:要求生成vo/bo的数据库表名 3.
		 * packageName:bo/vo上级包的名字，如：packageName=fhs.resource,生成后fhs.resource.vo
		 * 使用：createVoe(className):如果没有参数是系统自动根据表名称生成,如：表T_OD_Order_End为VOEOdOrderEnd
		 * 
		 */
		// "D:\\temp\\", "local_net", "com.cattsoft.sp";
		// String fileName = "wm.property";
		// String fileName = "sg.property";
		// String fileName = "gis.property";
		// String fileName = "im.property";
		// String fileName = "sm.property";
		// String fileName = "tm.property";
		// String fileName = "pm.property";
		// String fileName = "bm.property";
		String fileName = "tm.property";
		// Propties读文件 3个属性一次读
		t.getPara(fileName);
		// t.initial(fileSavePath, tableName, packageName);

		// String fileSaveMame="d:\\temp\\com\\sp.txt";
		// 读一行一行的读txt文件
		System.out.println(fileSaveMame);
		File file = new File(fileSaveMame);

		list = t.readTableList(file);
		// System.out.println("++++++++++++++++++++");
		for (int i = 0; i < list.size(); i++) {

			tableName = list.get(i).toString().trim();
			System.out.println("表名为： " + tableName);
			tableName = tableName.replaceAll("\r", "");
			tableName = tableName.replaceAll("\t", "");
			tableName = tableName.replaceAll("\n", "");
			if (tableName == null && tableName.equals("tableName")) {
				continue;
			}
			// System.out.println(tableName);
			t.initial(fileSavePath, tableName, packageName);
			t.createVoe();
			// System.out.println(fileSavePath);
			t.createBoe();
			t.createDao();

		}
		// 修改后的使用方法

		// t.initial("D:\\temp\\", "local_net", "com.cattsoft.sp");
		//
		// t.createVoe();
		// t.createBoe();
	}

	/**
	 * 初始化
	 * 
	 * @param fileSavePath
	 * @param tableName
	 * @param packageName
	 */
	public void initial(String fileSavePath, String tableName, String packageName) {
		this.file_save_path = fileSavePath;
		this.table_name = tableName;
		this.package_name = packageName;
		this.getPrimary();
		// primaryHash.keySet();
	}

	public void createVoe() {
		// createVoe("VOE" + getClassnameFromTable(this.table_name));
		// System.out.println(getClassnameFromTable(this.table_name)+"SVO");
		createVoe(getClassnameFromTable(this.table_name) + "SVO");

	}

	public void createBoe() {
		createBoe(getClassnameFromTable(this.table_name) + "SDAOImpl");
	}

	public void createDao() {
		createDao(getClassnameFromTable(this.table_name) + "SDAO");
	}

	public void createVoe(String class_name) {

		VOColumn[] cols = this.getColumn(table_name.trim());
		if (cols == null) {
			System.out.println(table_name + "不存在!!!!!!!!");
			return;
		}
		try {

			// ==create file
			String begin_str = "";
			String field_str = "";
			String flag_str = "";
			String get_set_str = "";
			String clear_str = "";
			String clear_all_str = "public void clearAll(){";
			String end_str = "}";

			// ==
			begin_str = "package " + package_name + ".vo;\r";
			begin_str = begin_str + "import java.io.*;\r"
					+ "import com.cattsoft.pub.vo.GenericVO;\r";
			begin_str = begin_str + "import java.util.*;" + enter_str + "import java.sql.Clob;"
					+ enter_str + "import java.sql.Blob;" + enter_str + " /**" + enter_str
					+ "   * " + class_name + enter_str + "   * @author ：白小亮。" + enter_str
					+ "   * @version 1.1  2007-9-23" + enter_str + "   * <p>Company: 大唐软件</p>"
					+ enter_str + "  */" + enter_str;
			begin_str = begin_str + "public class " + class_name + " extends GenericVO {\r";

			// ==第一个字母大写的
			String u_temp = "";
			// ==第一个字母小写的
			// String l_temp = "";
			String lower_col = "";
			//
			String words = "";
			for (int i = 0; i < cols.length; i++) {
				u_temp = this.getField(cols[i].col_name);
				// System.out.println(u_temp);
				words = u_temp.substring(0, 1).toLowerCase() + u_temp.substring(1, u_temp.length());
				// System.out.println("words="+words);
				// l_temp = u_temp.substring(0, 1).toLowerCase() +
				// u_temp.substring(1, u_temp.length());
				lower_col = cols[i].col_name.toLowerCase();

				if (cols[i].col_type.equalsIgnoreCase("DATE")) {
					// ==
					field_str = field_str + "private Date " + words + " = null;\r";

					// ==get and set field
					get_set_str = get_set_str + "public Date get" + u_temp + "(){ \r return "
							+ words + ";\r}\r";
					get_set_str = get_set_str + "public void set" + u_temp + "(Date newValue){ " +

					" \r this." + words + " = newValue;\r " + " flag" + u_temp + " = 1;\r}\r";

					// " \r this." + words + " = words"+";\r}\r ";
				} else if (cols[i].col_type.equalsIgnoreCase("CLOB")) {
					// ==
					field_str = field_str + "private Clob " + words + " = null;\r";

					// ==get and set field
					get_set_str = get_set_str + "public Clob get" + u_temp + "(){ \r return "
							+ words + ";\r}\r";
					get_set_str = get_set_str + "public void set" + u_temp + "(Clob newValue){ "
							+ " \r this." + words + " = newValue;\r " + " flag" + u_temp
							+ " = 1;\r}\r";

					// " \r this." + words + " = words"+";\r}\r ";
				} else if (cols[i].col_type.equalsIgnoreCase("BLOB")) {
					// ==
					field_str = field_str + "private Blob " + words + " = null;\r";

					// ==get and set field
					get_set_str = get_set_str + "public Blob get" + u_temp + "(){ \r return "
							+ words + ";\r}\r";
					get_set_str = get_set_str + "public void set" + u_temp + "(Blob newValue){ "
							+ " \r this." + words + " = newValue;\r " + " flag" + u_temp
							+ " = 1;\r}\r";

					// " \r this." + words + " = words"+";\r}\r ";
				} else {
					// ==
					field_str = field_str + "private String " + words + " = null;\r";

					// ==get and set field
					get_set_str = get_set_str + "public String get" + u_temp + "(){\r return "
							+ words + ";\r}\r";
					get_set_str = get_set_str + "public void set" + u_temp + "(String newValue){ "
							+ "\r this." + words + " = newValue;\r " + " flag" + u_temp
							+ " = 1;\r}\r";

					// "\r this." + words + " = words"+";\r}\r" ;
				}
				// field_str=field_str.replaceAll("null","""");
				// ==get and set flag

				get_set_str = get_set_str + "public int getFlag" + u_temp + "(){ \r return flag"
						+ u_temp + ";\r}\r";

				// ==
				flag_str = flag_str + "private int flag" + u_temp + " = 0;\r";
				// ==
				clear_str = clear_str + "public void clearFlag" + u_temp + "(){\r flag" + u_temp
						+ " = 0 ;\r}\r";
				// ==
				clear_all_str = clear_all_str + " flag" + u_temp + " = 0;\r";
			}

			clear_all_str = clear_all_str + "\r}\r";

			// ==
			writeFile(begin_str + field_str + flag_str + get_set_str + clear_str + clear_all_str
					+ end_str, class_name, "1");

			// writeFile(begin_str + field_str +get_set_str+
			//                   
			// end_str, class_name);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void createBoe(String class_name) {
		// System.out.println("+++++++++++++");

		VOColumn[] cols = this.getColumn(table_name);
		if (cols == null) {
			System.out.println(table_name + "不存在!!!!!!!!");
			return;
		}
		table_name = table_name.toUpperCase();
		try {

			// ==create file
			String begin_str = "";
			String insert_str = "";
			String insert_sql_str = "";
			String update_str = "";
			String delete_str = "";
			String end_str = "}";
			String where_str = "";
			String finkStr = "";
			String list_str = "";
			String addBatch_str = "";
			String unable_str = "";

			// ==
			String voName = getClassnameFromTable(this.table_name);
			String voNe = voName.substring(0, 1).toLowerCase()
					+ voName.substring(1, voName.length());
			// try{
			// voId = this.getField(cols[4].col_name);
			//    			
			// }catch(Exception e){
			// System.out.println(cols[4].col_name+"+++++++++++++");
			// }
			//			
			// String pkId = voId.substring(0, 1).toLowerCase()
			// + voId.substring(1, voId.length());
			begin_str = begin_str + "package " + package_name + ".component.dao.oracleImpl;"
					+ enter_str + "import java.sql.Connection;" + enter_str
					+ "import java.sql.PreparedStatement;" + enter_str
					+ "import java.sql.ResultSet;" + enter_str + "import java.sql.SQLException;"
					+ enter_str + "import java.util.List;" + enter_str
					+ "import java.util.ArrayList;" + enter_str + "import org.apache.log4j.Logger;"
					+ enter_str + "import com.cattsoft.pub.connection.ConnectionFactory;"
					+ enter_str + "import " + package_name + ".component.dao.I"
					+ getClassnameFromTable(this.table_name) + "SDAO;" + enter_str + "import "
					+ package_name + ".vo." + getClassnameFromTable(this.table_name) + "SVO;"
					+ enter_str + "import com.cattsoft.pub.util.JdbcUtil;" + enter_str
					+ "import com.cattsoft.pub.dao.Sql;" + enter_str
					+ "import com.cattsoft.pub.exception.AppException;" + enter_str
					+ "import com.cattsoft.pub.exception.SysException;" + enter_str
					+ "import com.cattsoft.pub.vo.GenericVO;" + enter_str
					+ "import com.cattsoft.pub.util.StringUtil;" + enter_str + " /**" + enter_str
					+ "   * 方法" + class_name + enter_str + "   * <p>Company: 大唐软件</p>" + enter_str
					+ "   * @author ：白小亮。" + enter_str + "   * @version 1.1  2007-9-23" + enter_str
					+ "  */" + enter_str
					+ "public class "
					+ class_name
					+ " implements I"
					+ getClassnameFromTable(this.table_name)
					+ "SDAO"
					+ "{"
					+ enter_str
					+ " "
					+ "   private static Logger log = Logger.getLogger("
					+ class_name
					+ ".class); "
					+ enter_str
					+ "   private static final String UNABLE_STS = \"P\";"
					+ enter_str
					+
					// " private VOE" + getClassnameFromTable(this.table_name) +
					// " voe = null;" + enter_str +
					" " + enter_str + " /**" + enter_str + "   * 增加。" + enter_str
					+ "   * @return String" + enter_str +

					"  */" + enter_str + " public void"
					+ " add(GenericVO vo)throws AppException, SysException {" + enter_str
					+ "         if (vo== null) {" + enter_str
					+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\"); " + enter_str
					+ "       }" + enter_str + "     " + voName + "SVO " + voNe + "=(" + voName
					+ "SVO) vo;" + enter_str;
			String find_str = "";
			// 按主见查询
			find_str = find_str + " /**" + enter_str + "   * 主键查询的SQL。" + enter_str
					+ "   * @return String ： 主键查询的SQL。" + enter_str +

					"  */" + enter_str + " public GenericVO"
					+ " findByPK(GenericVO vo)throws AppException, SysException {" + enter_str

					+ "         if (vo== null) {" + enter_str
					+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\"); " + enter_str
					+ "       }" + enter_str + "     " + voName + "SVO " + voNe + "=(" + voName
					+ "SVO) vo;" + enter_str;
			// List查询 Sql sql = new Sql("select * from Local_Net where 1=1 ");
			list_str = list_str + " /**" + enter_str + "   * 批量查询的SQL。" + enter_str
					+ "   * @return String ： 批量查询的SQL。" + enter_str +

					"  */" + enter_str + " public List"
					+ " findByVO(GenericVO vo) throws AppException, SysException{" + enter_str +

					"         if (vo== null) {" + enter_str
					+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\"); " + enter_str
					+ "       }" + enter_str + "       " + voName + "SVO " + voNe + "=(" + voName
					+ "SVO) vo;" + enter_str;
			// update
			update_str = update_str + " /**" + enter_str + "   * 更新的SQL。" + enter_str
					+ "   * @return String ： 更新的SQL。" + enter_str +

					"  */" + enter_str + " public void"
					+ " update(GenericVO vo)throws AppException, SysException {" + enter_str;
			// addBatch增加
			addBatch_str = addBatch_str + " /**" + enter_str + "   * 批量增加记录。" + enter_str
					+ "   * @return String ： 批量增加的SQL。" + enter_str +

					"  */" + enter_str + " public void"
					+ " addBat(List list)throws AppException, SysException {" + enter_str
					+ "     if (list == null) {" + enter_str
					+ "     throw new AppException(\"100001\", \"缺少DAO操作对象！\");" + enter_str
					+ "           }" + enter_str;
			// addBatch查询
			delete_str = delete_str + " /**" + enter_str + "   * 根据传入参数删除一条或者一批记录。" + enter_str
					+ "   * @return String ： 删除的SQL。" + enter_str + "  */" + enter_str
					+ " public void" + " delete(GenericVO vo)throws AppException, SysException {"
					+ enter_str +

					"         if (vo== null) {" + enter_str
					+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\"); " + enter_str
					+ "       }" + enter_str + "     " + voName + "SVO " + voNe + "=(" + voName
					+ "SVO) vo;" + enter_str;
			// unable查询
			unable_str = unable_str + " /**" + enter_str + "   * 注销一条或者一批" + enter_str
					+ "   * @return String ： 注销一条或者一批的SQL。" + enter_str +

					"  */" + enter_str + " public void"
					+ " unable(GenericVO vo)throws AppException, SysException {" + enter_str +

					"     " + voName + "SVO " + voNe + "=(" + voName + "SVO) vo;" + enter_str;
			// ==第一个字母大写的
			String u_temp = "";
			String rs_str = "";
			String set_str = "";
			// 批量查询的where
			String pl_where_str = "";
			String add_into_str = "";
			String add_where_str = "";
			String pl_add_str = "";
			//
			String find_pk_str = "";
			String pk_str = "";
			// unable方法里的set主键值
			String unable_pk_str = "";
			// findByVO的where条件
			String find_where_str = "";
			// findbypk
			String find_bypk_str = "";
			String updatePstatement = "public String updatePs(){ String msgCode=\"0\";String sql=null; List list=new ArrayList(); VOTransfer vot=null;"
					+ "try{" + "sql=sql+\"update " + table_name + " set \";";
			String ps_where_sql = "";

			for (int i = 0; i < cols.length; i++) {

				u_temp = this.getField(cols[i].col_name);
				// String pkStr=cols[i].col_name;
				String words = this.getField(cols[i].col_name);
				String wordReturn = cols[i].col_name;

				words = words.substring(0, 1).toLowerCase() + words.substring(1, words.length());
				insert_str = insert_str + "//==" + cols[i].col_name + enter_str;
				// update_str = update_str + "//==" + cols[i].col_name +
				// enter_str;
				// where_str = "\" WHERE " + cols[i].col_name + " = \" + vo.get"
				// + u_temp + "() ";
				// finkStr=" "+voNe +".set" + u_temp + "(rs.getString("+i+"));";
				// begin_str=begin_str+finkStr+enter_str;
				// cols[i].col_name = words;

				// -----产生where子句-------begin------
				if (primaryHash != null) {
					int strNbr = 1;
					// System.out.println(primaryHash.keySet());
					if (primaryHash.containsValue(cols[i].col_name)) {

						// System.out.println(primaryHash.keys());
						String sql_where_str = "";
						where_str = where_str + enter_str + "      sql.append(\" "
								+ cols[i].col_name + " = ? and\");";
						if (set_str.equals("")) {
							set_str = set_str + "           ps.setString(" + strNbr + ", " + voNe
									+ ".get" + u_temp + "());" + enter_str;

						} else {
							strNbr = strNbr + 1;
							set_str = set_str + "           ps.setString(" + strNbr + ", " + voNe
									+ ".get" + u_temp + "());" + enter_str;

						}
						// System.out.println(u_temp);
						// begin_str=begin_str+" if ("+voNe+".get"+u_temp+"() ==
						// null"+enter_str+
						// " ||"+ voNe+".get"+u_temp+"().equals(\"\"))
						// {"+enter_str+
						// " throw new AppException(\"100002\",
						// \"缺少对象的主键！\");"+enter_str+
						// " }"+enter_str;
						// list_str=list_str+" if ("+voNe+".get"+u_temp+"() ==
						// null"+enter_str+
						// " ||"+ voNe+".get"+u_temp+"().equals(\"\"))
						// {"+enter_str+
						// " throw new AppException(\"100002\",
						// \"缺少对象的主键！\");"+enter_str+
						// " }"+enter_str;
						// find_str=find_str+" if ("+voNe+".get"+u_temp+"() ==
						// null"+enter_str+
						// " ||"+ voNe+".get"+u_temp+"().equals(\"\"))
						// {"+enter_str+
						// " throw new AppException(\"100002\",
						// \"缺少对象的主键！\");"+enter_str+
						// " }"+enter_str;
						pk_str = pk_str
								+
								// " if ("+voNe+".get"+u_temp+"() ==
								// null"+enter_str+
								// " ||"+ voNe+".get"+u_temp+"().equals(\"\"))
								// {"+enter_str+
								"    if (StringUtil.isBlank(" + voNe + ".get" + u_temp + "())) {"
								+ enter_str
								+ "       throw new AppException(\"100002\", \"缺少对象的主键！\");"
								+ enter_str + "      }" + enter_str;
						unable_pk_str = unable_pk_str + "       unableVo.set" + u_temp + "(" + voNe
								+ ".get" + u_temp + "());" + enter_str;
						if (cols[i].col_type.equalsIgnoreCase("NUMBER")
								|| cols[i].col_type.equalsIgnoreCase("LONG")) {
							find_pk_str = find_pk_str + "if (StringUtil.isBlank(" + voNe + ".get"
									+ u_temp + "())) {" + enter_str + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setLong(\"" + words + "\", " + voNe + ".get" + u_temp
									+ "());" + enter_str + " }" + enter_str + " " + enter_str;
							find_bypk_str = find_bypk_str + "sql.append(\" and " + cols[i].col_name
									+ "=:" + words + "\");" + enter_str + "sql.setLong(\"" + words
									+ "\", " + voNe + ".get" + u_temp + "());" + enter_str +

									" " + enter_str;
						} else if (cols[i].col_type.equalsIgnoreCase("VARCHAR2")
								|| cols[i].col_type.equalsIgnoreCase("CHAR")) {
							find_pk_str = find_pk_str + "if (StringUtil.isBlank(" + voNe + ".get"
									+ u_temp + "())) {" + enter_str + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setString(\"" + words + "\", " + voNe + ".get" + u_temp
									+ "());" + enter_str + " }" + enter_str + " " + enter_str;
							find_bypk_str = find_bypk_str + "sql.append(\" and " + cols[i].col_name
									+ "=:" + words + "\");" + enter_str + "sql.setString(\""
									+ words + "\", " + voNe + ".get" + u_temp + "());" + enter_str +

									" " + enter_str;

						} else if (cols[i].col_type.equalsIgnoreCase("DATE")) {
							find_pk_str = find_pk_str
									+ "if ("
									+ voNe
									+ ".get"
									+ u_temp
									+ "() != null&& !\"\".equals("
									+ voNe
									+ ".get"
									+ u_temp
									+ "())) {"
									+ enter_str
									+
									// "if
									// (StringUtil.isBlank("+voNe+".get"+u_temp+"()))
									// {"+enter_str+
									"sql.append(\" and " + cols[i].col_name + "=:" + words + "\");"
									+ enter_str + "sql.setTimestamp(\"" + words + "\", " + voNe
									+ ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
									+ enter_str;
							find_bypk_str = find_bypk_str + "sql.append(\" and " + cols[i].col_name
									+ "=:" + words + "\");" + enter_str + "sql.setTimestamp(\""
									+ words + "\", " + voNe + ".get" + u_temp + "());" + enter_str +

									" " + enter_str;
						} else {
							find_pk_str = find_pk_str
									+
									// "if ("+voNe+".get"+u_temp+"() != null&&
									// !\"\".equals("+voNe+".get"+u_temp+"()))
									// {"+enter_str+
									"if (StringUtil.isBlank(" + voNe + ".get" + u_temp + "())) {"
									+ enter_str + "sql.append(\" and " + cols[i].col_name + "=:"
									+ words + "\");" + enter_str + "sql.setString(\"" + words
									+ "\", " + voNe + ".get" + u_temp + "());" + enter_str + " }"
									+ enter_str + " " + enter_str;
							find_bypk_str = find_bypk_str + "sql.append(\" and " + cols[i].col_name
									+ "=:" + words + "\");" + enter_str + "sql.setString(\""
									+ words + "\", " + voNe + ".get" + u_temp + "());" + enter_str +

									" " + enter_str;
						}

						// if (cols[i].col_type.equalsIgnoreCase("NUMBER")
						// || cols[i].col_type.equalsIgnoreCase("LONG")) {
						// String sql_where_str="";
						// where_str = where_str+ enter_str +" sql.append(\" " +
						// cols[i].col_name
						// + " = ? and\");";
						// if(set_str.equals("")){
						// set_str= set_str+" ps.setString("+strNbr+", " + voNe
						// + ".get"
						// + u_temp + "());" + enter_str;
						//							
						// }else {
						// strNbr=strNbr+1;
						// set_str= set_str+" ps.setString("+strNbr+", " + voNe
						// + ".get"
						// + u_temp + "());" + enter_str;
						//								
						// }
						//						
						// // if (where_str.equals("")) {
						// //
						// // where_str =" sql.append(\" WHERE " +
						// cols[i].col_name
						// // + " = \" + " + voNe + ".get" + u_temp
						// // + "())";
						// // where_str=sql_where_str;
						// // System.out.println(where_str);
						// // } else {
						// // where_str = where_str+"sql.append( \" and "
						// // + cols[i].col_name + " = \" + " + voNe
						// // + ".get" + u_temp + "() )";
						// //
						// // }
						// //ddd
						// if (ps_where_sql.equals("")) {
						// ps_where_sql = ps_where_sql
						// + " sql=sql+\" where "
						// + cols[i].col_name + "=? \";" + " "
						// + voNe + "=new VOTransfer();" + " "
						// + voNe
						// + ".set(\"date_type\",\"string\");"
						// + " " + voNe + ".set(\"value\",vo.get"
						// + u_temp + "());" + " list.add(" + voNe
						// + ");";
						// } else {
						// ps_where_sql = ps_where_sql
						// + " sql=sql+\" and " + cols[i].col_name
						// + "=? \";" + " " + voNe
						// + "=new VOTransfer();" + " " + voNe
						// + ".set(\"date_type\",\"string\");"
						// + " " + voNe + ".set(\"value\",vo.get"
						// + u_temp + "());" + " list.add(" + voNe
						// + ");";
						// }
						// } else {
						// if (where_str.equals("")) {
						// where_str = "\" WHERE " + cols[i].col_name
						// + " = '\" + " + voNe + ".get" + u_temp
						// + "() +\"'\" ";
						// } else {
						// where_str = where_str + "+ \" and "
						// + cols[i].col_name + " = '\" + " + voNe
						// + ".get" + u_temp + "() +\"'\" ";
						// }
						// }
						//	
						;
					}

				}
				// add增加的条件add_into_str
				add_into_str = add_into_str + wordReturn + ",";
				add_where_str = add_where_str + ":" + words + ",";
				// 批量更新
				// --产生where子句-----end---
				// ==
				if (cols[i].col_type.equalsIgnoreCase("NUMBER")
						|| cols[i].col_type.equalsIgnoreCase("LONG")) {
					finkStr = "           " + voNe + ".set" + u_temp + "(rs.getString(\""
							+ wordReturn + "\"));";
					rs_str = rs_str + finkStr + enter_str;
					// ==insert
					insert_str = insert_str + " if(" + voNe + ".get" + u_temp + "() == null || "
							+ enter_str + "    " + voNe + ".get" + u_temp + "().equals(\"\")){ "
							+ enter_str + "    strFieldValue = \"NULL\"; " + enter_str + " }else{ "
							+ enter_str + "   strFieldValue = " + voNe + ".get" + u_temp + "();  "
							+ enter_str + " } " + enter_str + " sql.append(strFieldValue) + \",\";"
							+ enter_str + enter_str;

					// ==update
					// update_str = update_str + " if(" + voNe + ".getFlag"
					// + u_temp + "() == 1 ){ " + enter_str + " if("
					// + voNe + ".get" + u_temp + "() == null || "
					// + enter_str + " " + voNe + ".get" + u_temp
					// + "().equals(\"\")){ " + enter_str
					// + " strFieldValue = \" " + cols[i].col_name
					// + " = NULL\"; " + enter_str + " }else{ "
					// + enter_str + " strFieldValue = \" "
					// + cols[i].col_name + " = \" + " + voNe + ".get"
					// + u_temp + "(); " + enter_str + " } " + enter_str
					// + " sql.append(strFieldValue) + \",\";" + enter_str
					// + " } " + enter_str + enter_str;
					// 批量更新的where 条件
					pl_where_str = pl_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + "sql.setLong(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;
					// findByVO的where 条件
					find_where_str = find_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "      if (StringUtil.isBlank(" + voNe
							+ ".get" + u_temp + "())) {" + enter_str
							+ "             sql.append(\" and " + cols[i].col_name
							+ " is null \");" + enter_str + "          }" + enter_str
							+ "      else{" + enter_str + "             sql.append(\" and "
							+ cols[i].col_name + "=:" + words + "\");" + enter_str
							+ "             sql.setLong(\"" + words + "\", " + voNe + ".get"
							+ u_temp + "());" + enter_str + "          }" + enter_str + "   }"
							+ enter_str + " " + enter_str;
					// add的增加参数
					pl_add_str = pl_add_str + "      if (StringUtil.isBlank(" + voNe + ".get"
							+ u_temp + "())) {" + enter_str + "      sql.setNullLong(\"" + words
							+ "\");" + enter_str + "     } else {" + enter_str
							+ "    sql.setLong(\"" + words + "\", " + voNe + ".get" + u_temp
							+ "());" + enter_str + "    }" + enter_str + " " + enter_str;

				}
				// //======update PreparedStatement============
				// if (!cols[i].col_type.equalsIgnoreCase("DATE")) {
				// finkStr=" "+voNe +".set" + u_temp +
				// "(rs.getTimestamp("+words+"));";
				// begin_str=begin_str+finkStr+enter_str;
				// updatePstatement = updatePstatement +
				// " if(vo.getFlag" + u_temp + "() == 1 ){ " + enter_str +
				// " sql=sql+\"" + cols[i].col_name + "=?,\";" + enter_str +
				// " vot=new VOTransfer();" + enter_str +
				// " vot.set(\"date_type\",\"string\");" + enter_str +
				// " vot.set(\"value\",vo.get" + u_temp + "());" +
				// enter_str +
				// " list.add(vot);" + enter_str +
				// " } " + enter_str + enter_str;
				// }else{
				// updatePstatement = updatePstatement +
				// " if(vo.getFlag" + u_temp + "() == 1 ){ " + enter_str +
				// " sql=sql+\"" + cols[i].col_name + "=?,\";" + enter_str +
				// " vot=new VOTransfer();" + enter_str +
				// " vot.set(\"date_type\",\"date\");" + enter_str +
				// " vot.set(\"value\",FuncDate.formatDateTime(vo.get" + u_temp
				// + "(),\"-\"));" +
				// enter_str +
				// " list.add(vot);" + enter_str +
				// " } " + enter_str + enter_str;
				// }

				if (cols[i].col_type.equalsIgnoreCase("VARCHAR2")
						|| cols[i].col_type.equalsIgnoreCase("CHAR")) {
					finkStr = "           " + voNe + ".set" + u_temp + "(rs.getString(\""
							+ wordReturn + "\"));";
					rs_str = rs_str + finkStr + enter_str;
					// ==insert
					insert_str = insert_str + " if(" + voNe + ".get" + u_temp + "() == null ){ "
							+ enter_str + "    strFieldValue = \"NULL\"; " + enter_str + " }else{ "
							+ enter_str + "   strFieldValue = \"'\" +" + voNe + ".get" + u_temp
							+ "()+ \"'\";  " + enter_str + " } " + enter_str
							+ " sql.append(strFieldValue)  + \",\";" + enter_str + enter_str;

					// ==update
					// update_str = update_str + " if(" + voNe + ".getFlag"
					// + u_temp + "() == 1 ){ " + enter_str + " if("
					// + voNe + ".get" + u_temp + "() == null ){ "
					// + enter_str + " strFieldValue = \" "
					// + cols[i].col_name + " = NULL\"; " + enter_str
					// + " }else{ " + enter_str + " strFieldValue = \" "
					// + cols[i].col_name + " = '\" + " + voNe + ".get"
					// + u_temp + "()+\"'\" ; " + enter_str + " } "
					// + enter_str + " sql.append(strFieldValue) + \",\";"
					// + enter_str + " } " + enter_str + enter_str;
					// 批量更新的where 条件
					pl_where_str = pl_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setString(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;
					// findByVO的where 条件
					find_where_str = find_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "      if (StringUtil.isBlank(" + voNe
							+ ".get" + u_temp + "())) {" + enter_str
							+ "             sql.append(\" and " + cols[i].col_name
							+ " is null \");" + enter_str + "          }" + enter_str
							+ "      else{" + enter_str + "             sql.append(\" and "
							+ cols[i].col_name + "=:" + words + "\");" + enter_str
							+ "             sql.setString(\"" + words + "\", " + voNe + ".get"
							+ u_temp + "());" + enter_str + "          }" + enter_str + "   }"
							+ enter_str + " " + enter_str;
					// add的增加参数
					pl_add_str = pl_add_str + "      if (StringUtil.isBlank(" + voNe + ".get"
							+ u_temp + "())) {" + enter_str + "      sql.setNullString(\"" + words
							+ "\");" + enter_str + "     } else {" + enter_str
							+ "    sql.setString(\"" + words + "\", " + voNe + ".get" + u_temp
							+ "());" + enter_str + "    }" + enter_str + " " + enter_str;

				}

				if (cols[i].col_type.equalsIgnoreCase("DATE")) {
					finkStr = "           " + voNe + ".set" + u_temp + "(rs.getTimestamp(\""
							+ wordReturn + "\"));";
					rs_str = rs_str + finkStr + enter_str;
					// ==insert
					insert_str = insert_str + " if(" + voNe + ".get" + u_temp + "() == null || "
							+ enter_str + "    " + voNe + ".get" + u_temp + "().equals(\"\")){ "
							+ enter_str + "    strFieldValue = \"NULL\"; " + enter_str + " }else{ "
							+ enter_str + "   strFieldValue = \" to_date('\"+DateUtil.to_char("
							+ voNe + ".get" + u_temp + "())+\"',('YYYY-MM-DD'))\";  " + enter_str
							+ " } " + enter_str + " sql.append(strFieldValue) + \",\";" + enter_str
							+ enter_str;

					// ==update

					// update_str = update_str + " if(" + voNe + ".getFlag"
					// + u_temp + "() == 1 ){ " + enter_str + " if("
					// + voNe + ".get" + u_temp + "() == null || "
					// + enter_str + " " + voNe + ".get" + u_temp
					// + "().equals(\"\")){ " + enter_str
					// + " strFieldValue = \" " + cols[i].col_name
					// + " = NULL\"; " + enter_str + " }else{ "
					// + enter_str + " strFieldValue = \" "
					// + cols[i].col_name
					// + " = to_date('\"+DateUtil.to_char(" + voNe
					// + ".get" + u_temp + "())+\"',('YYYY-MM-DD')) \"; "
					// + enter_str + " } " + enter_str
					// + " sql.append(strFieldValue) + \",\";" + enter_str
					// + " } " + enter_str + enter_str;
					// 批量更新的where 条件
					pl_where_str = pl_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setTimestamp(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;
					// findByVO的where 条件
					find_where_str = find_where_str
							+ "if ("
							+ voNe
							+ ".getFlag"
							+ u_temp
							+ "() == 1) {"
							+ enter_str
							+ "      if ("
							+ voNe
							+ ".get"
							+ u_temp
							+ "() == null) {"
							+ enter_str
							+
							// " if
							// (StringUtil.isBlank("+voNe+".get"+u_temp+"()))
							// {"+enter_str+

							"             sql.append(\" and " + cols[i].col_name + " is null \");"
							+ enter_str + "          }" + enter_str + "      else{" + enter_str
							+ "             sql.append(\" and " + cols[i].col_name + "=:" + words
							+ "\");" + enter_str + "             sql.setTimestamp(\"" + words
							+ "\", " + voNe + ".get" + u_temp + "());" + enter_str + "          }"
							+ enter_str + "   }" + enter_str + " " + enter_str;
					// add的增加参数
					pl_add_str = pl_add_str
							+ "   if ("
							+ voNe
							+ ".get"
							+ u_temp
							+ "() == null) {"
							+ enter_str
							+
							// +" if
							// (StringUtil.isBlank("+voNe+".get"+u_temp+"()))
							// {"+enter_str+
							"      sql.setNullDate(\"" + words + "\");" + enter_str
							+ "     } else {" + enter_str + "    sql.setTimestamp(\"" + words
							+ "\", " + voNe + ".get" + u_temp + "());" + enter_str + "    }"
							+ enter_str + " " + enter_str;

				}
				if (cols[i].col_type.equalsIgnoreCase("Clob")) {
					finkStr = "           " + voNe + ".set" + u_temp + "(rs.getClob(\""
							+ wordReturn + "\"));";
					rs_str = rs_str + finkStr + enter_str;
					// ==insert
					insert_str = insert_str + " if(" + voNe + ".get" + u_temp + "() == null || "
							+ enter_str + "    " + voNe + ".get" + u_temp + "().equals(\"\")){ "
							+ enter_str + "    strFieldValue = \"NULL\"; " + enter_str + " }else{ "
							+ enter_str + "   strFieldValue = \" to_date('\"+DateUtil.to_char("
							+ voNe + ".get" + u_temp + "())+\"',('YYYY-MM-DD'))\";  " + enter_str
							+ " } " + enter_str + " sql.append(strFieldValue) + \",\";" + enter_str
							+ enter_str;

					// ==update

					// update_str = update_str + " if(" + voNe + ".getFlag"
					// + u_temp + "() == 1 ){ " + enter_str + " if("
					// + voNe + ".get" + u_temp + "() == null || "
					// + enter_str + " " + voNe + ".get" + u_temp
					// + "().equals(\"\")){ " + enter_str
					// + " strFieldValue = \" " + cols[i].col_name
					// + " = NULL\"; " + enter_str + " }else{ "
					// + enter_str + " strFieldValue = \" "
					// + cols[i].col_name
					// + " = to_date('\"+DateUtil.to_char(" + voNe
					// + ".get" + u_temp + "())+\"',('YYYY-MM-DD')) \"; "
					// + enter_str + " } " + enter_str
					// + " sql.append(strFieldValue) + \",\";" + enter_str
					// + " } " + enter_str + enter_str;
					// 批量更新的where 条件
					pl_where_str = pl_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setClob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;
					// findByVO的where 条件
					find_where_str = find_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "      if (" + voNe + ".get" + u_temp
							+ "() == null) {" + enter_str + "             sql.append(\" and "
							+ cols[i].col_name + " is null \");" + enter_str + "          }"
							+ enter_str + "      else{" + enter_str
							+ "             sql.append(\" and " + cols[i].col_name + "=:" + words
							+ "\");" + enter_str + "             sql.setClob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + "          }"
							+ enter_str + "   }" + enter_str + " " + enter_str;
					// add的增加参数
					pl_add_str = pl_add_str + "      if (" + voNe + ".get" + u_temp
							+ "() == null) {" + enter_str + "      sql.setNullClob(\"" + words
							+ "\");" + enter_str + "     } else {" + enter_str
							+ "    sql.setClob(\"" + words + "\", " + voNe + ".get" + u_temp
							+ "());" + enter_str + "    }" + enter_str + " " + enter_str;

				}
				if (cols[i].col_type.equalsIgnoreCase("Blob")) {
					finkStr = "           " + voNe + ".set" + u_temp + "(rs.getBlob(\""
							+ wordReturn + "\"));";
					rs_str = rs_str + finkStr + enter_str;
					// ==insert
					insert_str = insert_str + " if(" + voNe + ".get" + u_temp + "() == null || "
							+ enter_str + "    " + voNe + ".get" + u_temp + "().equals(\"\")){ "
							+ enter_str + "    strFieldValue = \"NULL\"; " + enter_str + " }else{ "
							+ enter_str + "   strFieldValue = \" to_date('\"+DateUtil.to_char("
							+ voNe + ".get" + u_temp + "())+\"',('YYYY-MM-DD'))\";  " + enter_str
							+ " } " + enter_str + " sql.append(strFieldValue) + \",\";" + enter_str
							+ enter_str;

					// ==update

					// update_str = update_str + " if(" + voNe + ".getFlag"
					// + u_temp + "() == 1 ){ " + enter_str + " if("
					// + voNe + ".get" + u_temp + "() == null || "
					// + enter_str + " " + voNe + ".get" + u_temp
					// + "().equals(\"\")){ " + enter_str
					// + " strFieldValue = \" " + cols[i].col_name
					// + " = NULL\"; " + enter_str + " }else{ "
					// + enter_str + " strFieldValue = \" "
					// + cols[i].col_name
					// + " = to_date('\"+DateUtil.to_char(" + voNe
					// + ".get" + u_temp + "())+\"',('YYYY-MM-DD')) \"; "
					// + enter_str + " } " + enter_str
					// + " sql.append(strFieldValue) + \",\";" + enter_str
					// + " } " + enter_str + enter_str;
					// 批量更新的where 条件
					pl_where_str = pl_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setBlob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;
					// findByVO的where 条件
					find_where_str = find_where_str + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "      if (" + voNe + ".get" + u_temp
							+ "() == null) {" + enter_str + "             sql.append(\" and "
							+ cols[i].col_name + " is null \");" + enter_str + "          }"
							+ enter_str + "      else{" + enter_str
							+ "             sql.append(\" and " + cols[i].col_name + "=:" + words
							+ "\");" + enter_str + "             sql.setBlob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + "          }"
							+ enter_str + "   }" + enter_str + " " + enter_str;
					// add的增加参数
					pl_add_str = pl_add_str + "      if (" + voNe + ".get" + u_temp
							+ "() == null) {" + enter_str + "      sql.setNullBlob(\"" + words
							+ "\");" + enter_str + "     } else {" + enter_str
							+ "    sql.setBlob(\"" + words + "\", " + voNe + ".get" + u_temp
							+ "());" + enter_str + "    }" + enter_str + " " + enter_str;

				}
			}
			String find_bypk_str1 = "";
			String pk_str1 = "";
			String pl_where_str1 = "";
			for (int i = 0; i < cols.length; i++) {

				u_temp = this.getField(cols[i].col_name);
				// String pkStr=cols[i].col_name;
				String words = this.getField(cols[i].col_name);
				String wordReturn = cols[i].col_name;

				words = words.substring(0, 1).toLowerCase() + words.substring(1, words.length());
				insert_str = insert_str + "//==" + cols[i].col_name + enter_str;

				// -----产生where子句-------begin------
				if (primaryHash != null) {
					int strNbr = 1;
					// System.out.println(primaryHash.keySet());
					if (primaryHash.containsValue(cols[i].col_name)) {

						pk_str1 = pk_str1
								+
								// " if ("+voNe+".get"+u_temp+"() ==
								// null"+enter_str+
								// " ||"+ voNe+".get"+u_temp+"().equals(\"\"))
								// {"+enter_str+
								"    if (StringUtil.isBlank(" + voNe + ".get" + u_temp + "())) {"
								+ enter_str
								+ "       throw new AppException(\"100002\", \"缺少对象的主键！\");"
								+ enter_str + "      }" + enter_str;

						if (cols[i].col_type.equalsIgnoreCase("NUMBER")
								|| cols[i].col_type.equalsIgnoreCase("LONG")) {

							find_bypk_str1 = find_bypk_str1 + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setLong(\"" + words + "\", " + voNe + ".get" + u_temp
									+ "());" + enter_str +

									" " + enter_str;
						} else if (cols[i].col_type.equalsIgnoreCase("VARCHAR2")
								|| cols[i].col_type.equalsIgnoreCase("CHAR")) {

							find_bypk_str1 = find_bypk_str1 + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setString(\"" + words + "\", " + voNe + ".get" + u_temp
									+ "());" + enter_str +

									" " + enter_str;

						} else if (cols[i].col_type.equalsIgnoreCase("DATE")) {

							find_bypk_str1 = find_bypk_str1 + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setTimestamp(\"" + words + "\", " + voNe + ".get"
									+ u_temp + "());" + enter_str +

									" " + enter_str;
						} else {

							find_bypk_str1 = find_bypk_str1 + "sql.append(\" and "
									+ cols[i].col_name + "=:" + words + "\");" + enter_str
									+ "sql.setString(\"" + words + "\", " + voNe + ".get" + u_temp
									+ "());" + enter_str +

									" " + enter_str;
						}
						continue;
					}

				}

				// 批量更新
				// --产生where子句-----end---
				// ==
				if (cols[i].col_type.equalsIgnoreCase("NUMBER")
						|| cols[i].col_type.equalsIgnoreCase("LONG")) {

					// 批量更新的where 条件
					pl_where_str1 = pl_where_str1 + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + "sql.setLong(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;

				}

				if (cols[i].col_type.equalsIgnoreCase("VARCHAR2")
						|| cols[i].col_type.equalsIgnoreCase("CHAR")) {

					// 批量更新的where 条件
					pl_where_str1 = pl_where_str1 + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setString(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;

				}

				if (cols[i].col_type.equalsIgnoreCase("DATE")) {

					// 批量更新的where 条件
					pl_where_str1 = pl_where_str1 + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setTimestamp(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;

				}
				if (cols[i].col_type.equalsIgnoreCase("Clob")) {

					// 批量更新的where 条件
					pl_where_str1 = pl_where_str1 + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setClob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;

				}
				if (cols[i].col_type.equalsIgnoreCase("Blob")) {

					// 批量更新的where 条件
					pl_where_str1 = pl_where_str1 + "if (" + voNe + ".getFlag" + u_temp
							+ "() == 1) {" + enter_str + "sql.append(\"" + cols[i].col_name + "=:"
							+ words + ",\");" + enter_str + " sql.setBlob(\"" + words + "\", "
							+ voNe + ".get" + u_temp + "());" + enter_str + " }" + enter_str + " "
							+ enter_str;

				}

			}
			try {
				add_into_str = add_into_str.substring(0, add_into_str.length() - 1);
				add_where_str = add_where_str.substring(0, add_where_str.length() - 1);

			} catch (Exception e) {
				System.out.println("");
			}

			begin_str = begin_str
					+ pk_str
					// + where_str
					// + enter_str
					// + " sql = sql.substring(0, sql.length() - 1); "
					+ enter_str + "      Connection conn = null;" + enter_str
					+ "      PreparedStatement ps = null;" + enter_str

					+ "Sql sql = new Sql(\"INSERT INTO " + table_name + "(" + add_into_str
					+ ")\");" + enter_str + "sql.append(\" VALUES (" + add_where_str + ")\");"
					+ enter_str + "      try {" + enter_str
					+ "           conn = ConnectionFactory.getConnection();" + enter_str
					+ "           ps = conn.prepareStatement(sql.getSql());" + enter_str
					+ pl_add_str + "           sql.fillParams(ps);" + enter_str
					+ "           sql.log(this.getClass());" + enter_str
					+ "           ps.executeUpdate();" + enter_str

					+ "          } catch (SQLException se) {" + enter_str
					+ "           throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
					+ enter_str + "           } finally {" + enter_str
					+ "                    JdbcUtil.close(ps);" + enter_str + "           }"
					+ enter_str

					+ "  }" + enter_str;

			find_str = find_str + pk_str + enter_str + "       Sql sql = new Sql(\"SELECT "
					+ add_into_str + " FROM " + table_name + " WHERE 1=1  \");" + enter_str
					+ find_bypk_str + enter_str

					+ "      Connection conn = null;" + enter_str
					+ "      PreparedStatement ps = null;" + enter_str
					+ "      ResultSet rs = null;" + enter_str + "      " + voNe + " =null;"
					+ enter_str + "      try {" + enter_str
					+ "           conn = ConnectionFactory.getConnection();" + enter_str
					+ "           ps = conn.prepareStatement(sql.getSql());" + enter_str
					+ "           sql.fillParams(ps);" + enter_str
					+ "           sql.log(this.getClass());" + enter_str
					+ "           rs = ps.executeQuery();" + enter_str + " " + enter_str
					+ "           while (rs.next()) {" + enter_str + "           " + voNe
					+ " = new " + voName + "SVO();" + enter_str + rs_str + "                 }"
					+ enter_str

					+ "           } catch (SQLException se) {" + enter_str
					+ "             throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
					+ enter_str + "           " + enter_str + "           } finally {" + enter_str
					+ "                    JdbcUtil.close(rs,ps);" + enter_str + "           }"
					+ enter_str + "           return " + voNe + ";" + enter_str + "         }"
					+ enter_str;

			// insert_str = insert_str +
			// " sql = sql.substring(0, sql.length() - 1) + \")\"; " +
			// " return sql; }" + enter_str;
			if (primaryHash.size() == cols.length) {
				update_str = update_str + "//关系表默认不生成update" + enter_str + "   }" + enter_str;
			} else {
				update_str = update_str + "         if (vo== null) {" + enter_str
						+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\"); "
						+ enter_str + "       }" + enter_str + "       " + voName + "SVO " + voNe
						+ "=(" + voName + "SVO) vo;" + enter_str + pk_str1

						+ "          Connection conn = null;" + enter_str
						+ "          PreparedStatement ps = null;" + enter_str

						+ "          Sql sql = new Sql(\"UPDATE " + table_name + " SET \");"
						+ enter_str + "     try {" + enter_str

						+ pl_where_str1 + "           	sql.removeSuffix(1);" + enter_str
						+ " sql.append(\" WHERE 1=1 \");" + enter_str + find_bypk_str1

						+ "           conn = ConnectionFactory.getConnection();" + enter_str
						+ "           ps = conn.prepareStatement(sql.getSql());" + enter_str
						+ "           ps = sql.fillParams(ps);" + enter_str
						+ "           sql.log(this.getClass());" + enter_str
						+ "           ps.executeUpdate();" + enter_str + "          " + enter_str

						+ "          } catch (SQLException se) {" + enter_str
						+ "           throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
						+ enter_str + "            } finally {" + enter_str
						+ "                JdbcUtil.close(ps);" + enter_str + "               }"
						+ enter_str + "               " + enter_str

						+ "   }" + enter_str;
			}

			// + " sql = sql.substring(0, sql.length() - 1); \r"
			// + " sql.append(\" where " + cols[4].col_name + "=" + voNe
			// + ".get" + voId + "()\" ); \r" + enter_str
			// + " Connection conn = null;" + enter_str
			// + " PreparedStatement ps = null;" + enter_str
			// + " ResultSet rs = null;" + enter_str + " try {"
			// + enter_str
			// + " conn = ConnectionFactory.getConnection();"
			// + enter_str
			// + " ps = conn. prepareStatement (sql);"
			// + enter_str + " ps.setString(1, " + voNe + ".get"
			// + voId + "());" + enter_str
			// + " rs = ps.executeUpdate();" + enter_str + " "
			// + enter_str + " while (rs.next()) {" + enter_str
			// + " }" + enter_str
			// + " } catch (SQLException se) {" + enter_str
			// +" throw new SysException(\"100003\", \"JDBC操作异常！\", se)" +
			// enter_str
			// + " " + enter_str + " } finally {"
			// + enter_str + " JdbcUtil.close(rs,ps);"
			// + enter_str + " }" + enter_str
			// + " return " + voNe + ";" + enter_str
			// + " }" + enter_str;
			// System.out.println(update_str);
			list_str = list_str + "          List res = new ArrayList();" + enter_str
					+ "          Connection conn = null;" + enter_str
					+ "          PreparedStatement ps = null;" + enter_str
					+ "          ResultSet rs = null;" + enter_str
					+ "          Sql sql = new Sql(\"SELECT " + add_into_str + " FROM "
					+ table_name + " WHERE 1=1 \");" + enter_str + "     try {" + enter_str

					+ find_where_str + "           conn = ConnectionFactory.getConnection();"
					+ enter_str + "           ps = conn.prepareStatement(sql.getSql());"
					+ enter_str + "           ps = sql.fillParams(ps);" + enter_str
					+ "           sql.log(this.getClass());" + enter_str
					+ "           rs = ps.executeQuery();" + enter_str + "          " + enter_str
					+ "          while (rs.next()) {" + enter_str + "           " + voNe
					+ " = new " + voName + "SVO();" + enter_str + rs_str
					+ "               res.add(" + voNe + ");" + enter_str + "              "
					+ enter_str + "              }" + enter_str
					+ "          } catch (SQLException se) {" + enter_str
					+ "           throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
					+ enter_str + "            } finally {" + enter_str
					+ "                JdbcUtil.close(rs,ps);" + enter_str + "               }"
					+ enter_str + "               " + enter_str
					+ "          if(0 == res.size()) res = null;" + enter_str
					+ "          return res;" + enter_str + "   }" + enter_str;
			updatePstatement = updatePstatement
					+ " sql = sql.substring(0, sql.length() - 1) + \")\"; "
					+ ps_where_sql
					+ "this.executeUpdateByPs(sql,list);"
					+ "}catch(Exception e){msgCode=\"1\";MiniLog.error(new Exception(),e);} return msgCode;}";

			delete_str = delete_str + pk_str + "          Connection conn = null;" + enter_str
					+ "          PreparedStatement ps = null;" + enter_str
					+ "       Sql sql = new Sql(\"DELETE FROM " + table_name + " WHERE 1=1  \");"
					+ enter_str + find_bypk_str + enter_str + "      try {" + enter_str
					+ "           conn = ConnectionFactory.getConnection();" + enter_str
					+ "           ps = conn.prepareStatement(sql.getSql());" + enter_str
					+ "           sql.fillParams(ps);" + enter_str
					+ "           sql.log(this.getClass());" + enter_str
					+ "           ps.executeUpdate();" + enter_str + " " + enter_str
					+ "           } catch (SQLException se) {" + enter_str
					+ "           throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
					+ enter_str + "           " + enter_str + "           } finally {" + enter_str
					+ "                    JdbcUtil.close(ps);" + enter_str + "           }"
					+ enter_str

					+ "         }" + enter_str;
			addBatch_str = addBatch_str + "          Connection conn = null;" + enter_str
					+ "          PreparedStatement ps = null;" + enter_str
					+ "Sql sql = new Sql(\"INSERT INTO " + table_name + "(" + add_into_str
					+ ")\");" + enter_str + "sql.append(\" VALUES (" + add_where_str + ")\");"
					+ enter_str + "      try {" + enter_str
					+ "           conn = ConnectionFactory.getConnection();" + enter_str

					+ "           ps = conn.prepareStatement(sql.getSql());" + enter_str
					+ "    for(int i=0;i<list.size();i++){" + enter_str + "       " + voName
					+ "SVO " + voNe + "=(" + voName + "SVO) list.get(i);" + enter_str
					+ "         if (" + voNe + "== null) {" + enter_str
					+ "         throw new AppException(\"100001\", \"缺少DAO操作对象！\");" + enter_str
					+ "       }" + enter_str + pk_str + pl_add_str
					+ "           sql.fillParams(ps);" + enter_str
					+ "           sql.log(this.getClass());" + enter_str
					+ "           sql.clearParameters();" + enter_str + "           ps.addBatch();"
					+ enter_str + "           }" + enter_str + "           " + enter_str
					+ "       ps.executeBatch();" + enter_str
					+ "          } catch (SQLException se) {" + enter_str
					+ "           throw new SysException(\"100003\", \"JDBC操作异常！\", se);"
					+ enter_str + "           } finally {" + enter_str
					+ "                    JdbcUtil.close(ps);" + enter_str + "           }"
					+ enter_str

					+ "  }" + enter_str;
			unable_str = unable_str
			// + " if ("+voNe+ "== null) {" + enter_str +
					// " throw new AppException(\"100001\", \"缺少DAO操作对象！\"); " +
					// enter_str +
					// " }" + enter_str
					// +pk_str
					// +" " + voName + "SVO unableVo=(" + voName + "SVO) vo;"+
					// enter_str
					// +unable_pk_str
					// +" unableVo.setSts(UNABLE_STS);" + enter_str
					// +" " + enter_str
					// +" this.update(unableVo);" + enter_str
					+ "       }" + enter_str;
			// ==
			// writeFile(begin_str + insert_str + update_str + delete_str
			// +updatePstatement+
			// end_str, class_name);
			writeFile(begin_str + find_str + list_str + update_str + addBatch_str + delete_str
					+ unable_str + end_str, class_name, "2");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void createDao(String class_name) {

		class_name = "I" + class_name;

		VOColumn[] cols = this.getColumn(table_name.trim());
		if (cols == null) {
			System.out.println(cols + "不存在!!!!!!!!");
			return;
		}
		try {

			// ==create file
			String begin_str = "";

			begin_str = begin_str + "package " + package_name + ".component.dao;" + enter_str
					+ "import com.cattsoft.pub.dao.ISDAO;" + enter_str + " /**" + enter_str
					+ "   * 方法" + class_name + enter_str + "   * <p>Company: 大唐软件</p>" + enter_str
					+ "   * @author ：白小亮。" + enter_str + "   * @version 1.1  2007-9-23" + enter_str
					+ "  */" + enter_str + "public interface " + class_name + " extends ISDAO{"
					+ enter_str + " " + enter_str + " " + enter_str +

					"       }" + enter_str;
			// System.out.println(class_name);

			// ==
			writeFile(begin_str, class_name, "3");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void writeFile(String file_content, String class_name, String save) {
		try {
			// ==
			String fileNamePath = "";
			String save_path = "";
			if (save.equals("1")) {
				save_path = file_save_path + "vo\\";
				fileNamePath = save_path + class_name + ".java";
			} else if (save.equals("2")) {
				save_path = file_save_path + "component\\dao\\oracleImpl\\";
				fileNamePath = save_path + class_name + ".java";

			} else if (save.equals("3")) {

				save_path = file_save_path + "component\\dao\\";

				fileNamePath = save_path + class_name + ".java";
			} else {
				fileNamePath = file_save_path + class_name + ".java";
			}

			// System.out.println("fileNamePath " +fileNamePath);
			FileWriter fw = new FileWriter(fileNamePath);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(file_content);
			pw.close();
			fw.close();
			System.out.println("=== Create File >> " + fileNamePath);

			// System.out.println("=== Create File >> " + file_save_path
			// + class_name + ".java");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getClassnameFromTable(String tableName) {
		String temp = "";

		// temp = tableName.substring(tableName.indexOf("_") + 1);
		temp = tableName.trim();
		temp = temp.replaceAll("\r", "");
		temp = temp.replaceAll("\t", "");
		temp = temp.replaceAll("\n", "");

		// System.out.println(temp+"++++");
		if (temp != null) {
			tableName = getField(temp);
		} else {
			System.out.println(temp + "不存在");
		}

		return tableName;
	}

	public String getField(String col_name) {
		String temp = "";
		String ret = "";

		int i, j;

		col_name = col_name.toLowerCase();
		i = col_name.indexOf("_");
		while (i > 0) {
			temp = col_name.substring(0, i);
			temp = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length());
			ret = ret + temp;

			col_name = col_name.substring(i + 1, col_name.length());
			i = col_name.indexOf("_");
		}

		// temp = col_name.substring(0, 1).toUpperCase()
		// + col_name.substring(1, col_name.length());
		try {
			if (temp.equals("temp")) {
				return null;
			}
			temp = col_name.substring(0, 1).toUpperCase()
					+ col_name.substring(1, col_name.length());

		} catch (Exception e) {
			System.out.println("temp" + temp);
			e.printStackTrace();

		}
		ret = ret + temp;

		return ret;
	}

	public VOColumn[] getColumn(String tableName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int recordCount = 0;
		String sql = null;

		VOColumn[] cols = null;

		try {
			conn = this.getConnection();

			sql = " select count(*) from user_tab_columns " + " where table_name = UPPER('"
					+ tableName + "')";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				recordCount = rs.getInt(1);
			}

			if (recordCount == 0) {
				System.out.println(tableName + "==no find table!");
				return null;
			} else {
				cols = new VOColumn[recordCount];
			}
			rs.close();
			ps.close();

			sql = " select TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_LENGTH, NULLABLE "
					+ " from user_tab_columns " + " where table_name = UPPER('" + tableName + "') "
					+ " ORDER BY COLUMN_NAME";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			int j = 0;
			while (rs.next()) {
				cols[j] = new VOColumn();
				cols[j].col_name = rs.getString("COLUMN_NAME");
				cols[j].col_type = rs.getString("DATA_TYPE");
				cols[j].data_length = rs.getInt("DATA_LENGTH");
				cols[j].nullable = rs.getString("NULLABLE");
				j++;
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			rs = null;
			ps = null;
			conn = null;
		}

		return cols;
	}

	// 得到当前表的主键信息
	public void getPrimary() {
		Connection conn = getConnection();
		try {
			primaryHash = new Hashtable();
			DatabaseMetaData dm = conn.getMetaData();
			// System.out.println("+++++++++++++++++++++++++++++++++++++");
			ResultSet rs = dm.getPrimaryKeys(null, null, this.table_name.toUpperCase());
			// System.out.println("+++++++++++++++++++++++++++++++++++++");
			while (rs.next()) {

				primaryHash.put(rs.getString(4), rs.getString(4));
				// System.out.println(primaryHash.keySet());
				// System.out.println("++++++++++++++++++++" + rs.getString(4));
			}
			rs.close();
			rs = null;
			conn.close();
			conn = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.getCsmConnection();
	}

	public Connection getCsmConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// String url = "jdbc:oracle:thin:@10.48.66.7:1521:hbcrm";
			// String userid = "spsuser";
			// String passwd = "spsuser";
			
			// String url = "jdbc:oracle:thin:@133.96.30.11:1521:fbzf";
			//河北url
			/*
			String url = "jdbc:oracle:thin:@133.96.30.17:1521:FBKT";
			String userid = "hbspsdev";
			String passwd = "hbspsdev";
			*/
			//zsjf/zsjf_123@60.31.254.52:1521/zsjfdb
			String url = "jdbc:oracle:thin:@60.31.254.52:1521:zsjfdb";
			String userid = "zsjf";
			String passwd = "zsjf_123";
			return DriverManager.getConnection(url, userid, passwd);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Connection getOrderConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// String url = "jdbc:oracle:thin:@192.168.2.52:1521:bccorder";
			// String userid = "bccorder";
			// String passwd = "bccorder";
			String url = "jdbc:oracle:thin:@192.168.2.52:1521:csmtest";
			String userid = "bcccsm";
			String passwd = "bcccsm";

			return DriverManager.getConnection(url, userid, passwd);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public class VOColumn {
		public String col_name = null;

		public String col_type = null;

		public int data_length = -1;

		public String nullable = null;
	}

	// 读配置文件
	public void getPara(String fileName) {

		Properties prop = new Properties();
		try {

			InputStream is = getClass().getResourceAsStream(fileName);
			if (is == null) {
				throw new Exception(fileName + " not found");
			}

			prop.load(is);
			// System.out.println(prop);
			if (is != null)
				is.close();
		} catch (Exception e) {
			System.out.println(e + "file " + fileName + " not found");
		}

		// tableName = prop.getProperty("tableName");
		packageName = prop.getProperty("packageName");
		fileSavePath = prop.getProperty("fileSavePath");

		fileSaveMame = prop.getProperty("fileSaveMame");
		return;

	}

	// 读文件一行一行读
	public List readTableList(File file) {

		List list = new ArrayList();
		int i = 0;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(isr);
			String line = null;

			while ((line = br.readLine()) != null) {

				list.add(line.trim());
				// System.out.println("OK!!!");
				// System.out.println(line);
				i++;
			}
			// System.out.println("++++++++++++++++++++"+list.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
