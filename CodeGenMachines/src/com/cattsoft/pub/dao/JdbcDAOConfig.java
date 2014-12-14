package com.cattsoft.pub.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.ObjectUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.UtilException;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-13 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class JdbcDAOConfig {
	private static Logger log = Logger.getLogger(JdbcDAOConfig.class);

	private String daoConfigFileName = "dao_config.properties";
	
	private String dbDialet = null;

	private String interfaceCatalogPrefix = "com.cattsoft";

	private String[] interfaceCatalogAry = null;
	
	private List jarFiles = new ArrayList();
	
	private String[] jarFilesStrAry = null;

	private int daoMode = 0;

	private static final String DB_DIALET = "db.dialect";

	private static final String INTERFACE_CATALOG_PREFIX = "interface.catalog.prefix";

	private static final String INTERFACE_CATALOG_LIST = "interface.catalog.list";

	private static final String DAO_IMPL_SUFFIX = "Impl";

	private static final String DAO_MODE = "dao.mode";

	public static final int DAO_MODE_DEBUG = 0;

	public static final int DAO_MODE_RUN = 1;
	
	public static final String DAO_JAR = "dao.jar";
	
	

	/**
	 * װ�������ļ����ݣ����ݽӿ��ļ��б�װ��ʵ�����б�
	 * 
	 * @param is
	 * @return Map<String�ӿڵ�ȫ�޶���,Object�ӿڶ�Ӧʵ�����ʵ������>
	 * @throws SysException
	 * @throws AppException
	 * 
	 */
	public Map getDAOImpls(String daoConfPath) throws AppException, SysException {
	
		if(!StringUtil.isBlank(daoConfPath)){
			daoConfigFileName = daoConfPath;
		}
//		װ��DAOʵ�ֵ�����
		InputStream is = null;
		
		LogUtil.debug(log, "��ʼװ�������ļ�:"+daoConfigFileName);
		is = DAOFactory.class.getClassLoader().getResourceAsStream(daoConfigFileName);
		
		if (null == is)
			return null;
		Map DAOImpls = new HashMap();
		this.readProperties(is);
		
		String classPath = "";
		URL url = Thread.currentThread().getContextClassLoader().getResource("/");
		if(url != null){
			classPath = url.getPath();
			LogUtil.debug(log,"ϵͳ·����"+classPath);
		}
		String jarPath = "";
		 
		if(jarFilesStrAry!=null){
			for(int i=0;i<jarFilesStrAry.length;i++){
				if(!StringUtil.isBlank(jarFilesStrAry[i])){
					//jarPath = classPath + jarFilesStrAry[i];
					jarPath = jarFilesStrAry[i];
					LogUtil.debug(log, "��ȡjar�ļ���"+jarPath);
					try {
						JarFile jarFile = new JarFile(jarPath);
						jarFiles.add(jarFile);
						LogUtil.debug(log, "��ȡjar�ļ���"+jarFile);
					} catch (IOException e) {
						LogUtil.debug(log, "��ȡjar�ļ�ʧ�ܣ�"+jarPath);
					}
				}
			}
		}

		// δ����DAO�ӿ�Ŀ¼
		if (null == interfaceCatalogAry)
			return null;

		// ����װ��DAO�ӿ� 
		for (int i = 0; i < interfaceCatalogAry.length; i++) {	
			interfaceCatalogAry[i] = interfaceCatalogPrefix.trim() + interfaceCatalogAry[i].trim();
			LogUtil.debug(log, "װ��DAO����" + interfaceCatalogAry[i]);
			String relativePath =  interfaceCatalogAry[i].replaceAll("\\.", "/");
			
			List interfaceClassNameList = new ArrayList(); 
//			����jar�ļ����������е�DAO�ӿ��ļ����б�
			List interfaceDAOJar = filterJarDAOInterface(relativePath);
			if(interfaceDAOJar != null) {
				interfaceClassNameList.addAll(filterJarDAOInterface(relativePath));
				LogUtil.debug(log, "Jar�ļ����ҵ�dao�ӿ���:"+interfaceClassNameList.size()+"����");
			}else{
				LogUtil.debug(log, "Jar�ļ���δ�ҵ�dao�ӿ��࣡");
			}
			
			//LogUtil.debug(log,"�ļ����·����"+ relativePath);
			URL pathUrl = JdbcDAOConfig.class.getResource("/" + relativePath);
			if (null != pathUrl) {
				String path = pathUrl.getPath();
				//LogUtil.debug(log,"�ļ�����·����"+ path);
				File daoPackage = new File(path);
				// ����Ŀ¼
				/*if (!daoPackage.isDirectory()) {
					throw new AppException("", "����dao_conAfig.properties�����ļ���DAO��������!");
				}*/
				// ��ȡdao�ӿ��ļ�
				File[] daoInterfaceFiles = daoPackage.listFiles(new DAOInterfaceFilter());
	
				if (null == daoInterfaceFiles || daoInterfaceFiles.length == 0) {
					LogUtil.debug(log, "δ�ҵ�Ҫװ�ص�DAO����");
					continue;
				}
	
				// LogUtil.debug(log,daoInterfaceFiles[0].getName());
				// �ҵ�ǰdialect��Ӧ��DAOʵ�ְ�
				String str = "/" + dbDialet + DAO_IMPL_SUFFIX;
				File dialectImplPackage = new File(daoPackage + str);
				// LogUtil.debug(log, daoPackage + str);
				if (!dialectImplPackage.isDirectory()) {
					throw new AppException("", "�Ҳ���dao����" + DB_DIALET + "��Ӧ��DAOʵ�ְ�!");
				}
				
				for(int k=0;k<daoInterfaceFiles.length;k++){
					interfaceClassNameList.add(daoInterfaceFiles[k].getName());
				}		
			}
			
//			 ����DAO�ӿ�ȥװ��DAOʵ����
			Map interfaceDAOImpl = loadDAOImpl(interfaceCatalogAry[i],interfaceClassNameList);
			if(interfaceDAOImpl != null){
				DAOImpls.putAll(interfaceDAOImpl);
			}
			
		}
		
		
		
		
		
		return DAOImpls;
	}
	
	
	/**
	 * ����jar�ļ����������е�DAO�ӿ��ļ����б�
	 * @param relativePath
	 * @return
	 */
	public List filterJarDAOInterface(String relativePath){
		if(jarFiles == null || jarFiles.size()==0){
			return null;
		}
		
		List interfaceClassNameList = new ArrayList();
		for(int i=0;i<jarFiles.size();i++){
			JarFile jfile = (JarFile)jarFiles.get(i);
			Enumeration enu = jfile.entries();
			while(enu.hasMoreElements()){
				JarEntry entry = (JarEntry)enu.nextElement();
				String realName = entry.getName();
				String files[] = realName.split(relativePath+"/");
				//ƥ�䲻��
				if(files == null || files.length == 1) continue;
				//��dao�ӿڰ��µ�����
				if(!StringUtil.isBlank(files[1]) && files[1].indexOf("/") == -1){
					String last5Chars = files[1].substring(files[1].length()-6);
//					��class�ļ����ǽӿ���(I��ͷ)
					if(".class".equals(last5Chars.toLowerCase())){
						if('I' == files[1].charAt(0)){
							interfaceClassNameList.add(files[1]);
							//LogUtil.debug(log, "jarfile:"+files[1].substring(0,files[1].length()-6));
						}
					}
				}
				
			}
		}
		
		return interfaceClassNameList;
	}
	
	
	/**
	 * ����DAO�ӿ��ļ�װ�ض�Ӧ��DAOʵ����
	 * @param interfaceCatalog
	 * @param interfaceClassNameList<String>
	 * @return
	 */
	private Map loadDAOImpl(String interfaceCatalog,List interfaceClassNameList){
		//δ�ҵ��ӿ���
		if(interfaceClassNameList == null || interfaceClassNameList.size() == 0){
			return null;
		}
		//LogUtil.debug(log, "װ��daoʵ��...");
		Map DAOImpls = new HashMap();
		String aDAOInterface = null;
		String DAOInterfacePrefix = interfaceCatalog + ".";
		String DAOImplPrefix = interfaceCatalog + "." + dbDialet + DAO_IMPL_SUFFIX + ".";
		String DAOInterfaceName;
		String DAOImplName = null;
		int countDao = 0;
		for (int j = 0; j < interfaceClassNameList.size(); j++) {
			aDAOInterface = (String)interfaceClassNameList.get(j);

			// �ӿ�����ʵ����
			DAOInterfaceName = DAOInterfacePrefix + aDAOInterface;
			DAOImplName = DAOImplPrefix + aDAOInterface.substring(1);// ȥ���ӿڱ�ʶ��I��

			// ȥ�������.class
			try {
				DAOInterfaceName = StringUtil.removeSuffix(DAOInterfaceName, ".class");
				DAOImplName = StringUtil.removeSuffix(DAOImplName, ".class");

				//LogUtil.debug(log, "DAO�ӿ�����:"+DAOInterfaceName);
				//LogUtil.debug(log, "DAOʵ������:"+DAOImplName);
				// ʵ�����Ƽ���Impl��׺
				DAOImplName = DAOImplName + DAO_IMPL_SUFFIX;
				Object impl = ObjectUtil.createByName(DAOImplName);
				// LogUtil.debug(log, "�ɹ�װ��DAO:"+DAOImplName);
				// LogUtil.debug(log, "map key:"+DAOInterfaceName);
				DAOImpls.put(DAOInterfaceName, impl);
				countDao++;
			} catch (UtilException e) {
				LogUtil.error(log, DAOImplName + "�ļ�װ�ش���!"+e.getMessage());
				continue;
			}
		}
		LogUtil.debug(log, "�ɹ�װ��" + interfaceCatalog + "��DAOʵ��" + countDao + "����");
		return DAOImpls;
	}

	/**
	 * ��ȡ�����ļ�����
	 * 
	 * @param is
	 * @throws AppException
	 * @throws SysException
	 */
	public void readProperties(InputStream is) throws AppException, SysException {
		if (null == is)
			throw new AppException("", "ϵͳδ��ȡ��DAO��ʼ�����ã�");
		Properties config = new Properties();
		try {
			config.load(is);
		} catch (IOException e) {
			LogUtil.error(log, e.getMessage());
			throw new AppException("", "ϵͳװ��DAO�����ļ�ʧ�ܣ�");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LogUtil.error(log, e.getMessage());
					throw new SysException("", "ϵͳ�ر����ö�ȡ���ƴ���", e);
				}
			}
		}

		this.dbDialet = (String) config.get(DB_DIALET);
		String daoModeStr = (String) config.get(DAO_MODE);
		this.daoMode = Integer.parseInt(daoModeStr.trim());
		this.interfaceCatalogPrefix = (String) config.get(INTERFACE_CATALOG_PREFIX);
		String interfaceCatalogListStr = (String) config.get(INTERFACE_CATALOG_LIST);
		interfaceCatalogAry = interfaceCatalogListStr.split(",");
		//��jar.file����
		String jarFilesStr = config.getProperty(DAO_JAR);
		if(!StringUtil.isBlank(jarFilesStr)){
			this.jarFilesStrAry = jarFilesStr.trim().split(",");
		}
		LogUtil.debug(log, "dbDialet:" + dbDialet);
		LogUtil.debug(log, "interfaceCatalogPrefix:" + interfaceCatalogPrefix);
		LogUtil.debug(log, "interfaceCatalogListStr:" + interfaceCatalogListStr);
	}

	public static void main(String[] args) throws Exception {
		// String str =
		// JdbcDAOConfig.class.getResource("/dao_config/dao_config.properties").getPath();
		// File file = new File(str);
		String temp = "com.cattsoft.tm.component.dao";

		// System.out.println("----"+JdbcDAOConfig.class.getResource("/dao_config"));

		System.out.print(temp.replaceAll("\\.", "/"));
	}

	public int getDaoMode() {
		return daoMode;
	}

	public void setDaoMode(int daoMode) {
		this.daoMode = daoMode;
	}

}
