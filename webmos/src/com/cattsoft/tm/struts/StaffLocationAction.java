/**
 * 
 */
package com.cattsoft.tm.struts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.xmlbeans.XmlException;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.pub.util.VariableHelper;
import com.cattsoft.sx.delegate.StaffLocationDelegate;
import com.cattsoft.tm.vo.RealPosition;
import com.cattsoft.webpub.util.ReqUtil;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument.REALPOSITIONREQ;
import com.cattsoft.xmlbeans.realposition.REALPOSITIONREQDocument.REALPOSITIONREQ.REALPOSITIONLIST;

/**
 * @author wanghaoc
 * CreateTime 2012-10-8 上午10:55:59
 */
public class StaffLocationAction extends DispatchAction{
	
	private static  List<String>  xmllist= null;//存储数据
	private static  Timer timer = null;//定时器
	private static Boolean numflag=true;
	private static Boolean timerflag=true;
    private  List<String> dolist= new ArrayList<String>();
    private  String requestXml="";
    private static   long timeDleay;
    private static   int doOnceMaxNum;
    private static   int sumitNum;
    
	private static final Logger log = Logger.getLogger(WoHandleAction.class);
	
	public static Timer getTimer() {
		if(timer == null){
			timer = new Timer();
	   }
		return timer;
	}

	public static List<String> getXmllist() {
		if(xmllist == null){
			xmllist = new ArrayList<String>();
	   }
		return xmllist;
	}
	
	public ActionForward addStaffLocation4MOS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException, ServiceException, InterruptedException  {
 		      requestXml = ReqUtil.getRequestStr(request);
		     log.error("requestXml--------"+requestXml);
		     
		      timeDleay= Long.parseLong(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_INTERVAL, null, null, null, null, null));
		      doOnceMaxNum= Integer.parseInt(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_ONCE_MAXNUM, null, null, null, null, null));
		      sumitNum= Integer.parseInt(SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_STAFF_LOCATION_SUBMIT_NUM, null, null, null, null, null));
		      xmllist=StaffLocationAction.getXmllist();
		      
			    xmllist.add(requestXml);
//			   System.out.println("---------------收到请求------"+xmllist.size());
			  devRequestMethod();//分发处理请求方式，直接处理和定时器处理
		return null;
	}
	
	 /**
	  * @author 
	  *封装请求数据，发送位置信息
	  */
	private void equDataForSendRequest() {
			List<String>  list=new ArrayList<String>();
			if(dolist.size()> doOnceMaxNum/sumitNum ){
				//发5个请求, 要判断是否提交成功
				for(int i=0; i<sumitNum; i++){
					 equData(list, i);
					 sendRealPosition(list);
	     		  }
			  }else{
				     list=dolist;
				     sendRealPosition(list); 
	       }
			   resetReqEnroment();
	}
	
	 /**
	  * 请求完成后初始化请求环境。
	  */
	private void resetReqEnroment() {
		dolist.clear();
		   if(timer!=null){
		    	timer.cancel();//使用这个方法退出任务
		    	timer=null;
		   }
		   if(!timerflag){
			   timerflag=true;
		   }
		   if(!numflag){
			   numflag=true;
		   }
	}
	
	 /**
	  * 封装请求数据
	  */
	private void equData(List<String> list,  int i) {
		
		int[] num = devNum(dolist.size());
		if(i==0){
			 for(int j=0; j<num[0];j++){
				 String strbranch = dolist.get(j);
		    	 list.add(strbranch);
			 }
		 }
		 else {
		     for(int j=num[i-1]; j<num[i];j++){
		          String strbranch = dolist.get(j);
		          list.add(strbranch);
		        }
		 }
	}
	/**
	 * 自动签到，将用户定时的位置入库
	 * @param requestXml
	 * @throws Exception 
	 */
	public ActionForward sendAutoSignatureLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		 requestXml = ReqUtil.getRequestStr(request);
		String responseXml = null;	
				    responseXml = StaffLocationDelegate.getDelegate().addAutoSignatureLocation4MOS(requestXml);
				    
				    log.error("responseXml--------获取返回的结果-"+responseXml );
				          
				    
				    if (responseXml!=null) {
				    	ReqUtil.write(response, responseXml.toString());
					}		
					return null;
	}
	 /**
	  * @author 
	  * 发送位置信息，数据入库
	 * @throws ServiceException 
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	  */
	private void sendRealPosition(List<String>  list) {
			String  requestXml;
//			 System.out.println("-------------处理请求前有-------"+xmllist.size());
			//用list拼接xml
			 requestXml=spliceXml(list);
			   log.error("spliceXml---------"+requestXml );
//				 localTest(requestXml);
                String responseXml;
				try {
					    responseXml = StaffLocationDelegate.getDelegate().addStaffLocation4MOS(requestXml);
					    log.error("responseXml--------获取返回的结果-"+responseXml );
					    deleteFromXmllist(list);
//					    System.out.println("-------------处理完后還剩------"+xmllist.size());
					    list.clear();        
					    
				} catch (SysException e) {
					  log.error("入库异常1" );
					e.printStackTrace();
				} catch (AppException e) {
					  log.error("入库异常2" );
					e.printStackTrace();
				}
	}
	
	 /**
	  *本地化測試
	  */
//	private void localTest(String requestXml) throws ServiceException,
//			MalformedURLException {
//		String urlStr = "http://192.168.100.233:1991/trms/services/RmsForMosService";
//		 org.apache.axis.client.Service service=new org.apache.axis.client.Service();
//		 Call call;
//		 call = (Call) service.createCall();
//		 call.setTargetEndpointAddress( new java.net.URL(urlStr) );
//		 call.setOperationName( "realPosition" );
//		 try {
//			String	responseXml = (String) call.invoke( new Object[] {requestXml} );
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	 /**
	  *拼接多个xml
	  */
	private String spliceXml(List<String> list) {
		List<RealPosition> positionList = new ArrayList<RealPosition>();
//		spliceXml---------<REAL_POSITION_REQ/>
		//获取多个xml里的信息。
		for(int j=0; j<list.size();j++){
			String xmlString = list.get(j);
	      	REALPOSITIONREQDocument doc;
	    	try {
	    		
				doc = REALPOSITIONREQDocument.Factory.parse(xmlString);
			  	REALPOSITIONREQ req = doc.getREALPOSITIONREQ();
		    	REALPOSITIONLIST[] realPositonList = req.getREALPOSITIONLISTArray();
		    	
		    	if(realPositonList != null && realPositonList.length>0 ){
		     		for (int i=0 ; i<realPositonList.length ;i++){
		     			
	        			Integer terminalId = VariableHelper.getInteger(realPositonList[i].getTERMINALID());
	                    Integer terminalType = VariableHelper.getInteger(realPositonList[i].getTERMINALTYPE());
	                    String  mobileNbr = VariableHelper.getString(realPositonList[i].getMOBILENBR());
	                    Double  longTitude = VariableHelper.getDouble(realPositonList[i].getLONGTITUDE());//经度
	                    Double  laTitude = VariableHelper.getDouble(realPositonList[i].getLATITUDE());//纬度
//	                    Date receiveTime = VariableHelper.getDate(DateUtil.str2DateTime(realPositonList[i].getRECEIVETIME()));		//时间
	                    String receiveTime = VariableHelper.getString(realPositonList[i].getRECEIVETIME());		//时间
	                    Double altitude = VariableHelper.getDouble(realPositonList[i].getALTITUDE());//高度
	                    Double vilocity = VariableHelper.getDouble(realPositonList[i].getVELOCITY());//速度
	                    Double angle =  VariableHelper.getDouble(realPositonList[i].getANGLE());//方向
	                    Integer state = VariableHelper.getInteger(realPositonList[i].getSTATE());//状态
	                  
	                    RealPosition  r = new RealPosition();
	                    r.setTerminalId(terminalId);
	                    r.setTerminalType(terminalType);
	                    r.setMobileNbr(mobileNbr);
	                    r.setLongTitude(longTitude);
	                    r.setLaTitude(laTitude);
	                    r.setReceiveTime(receiveTime);
	                    r.setAltitude(altitude);
	                    r.setVilocity(vilocity);
	                    r.setAngle(angle);
	                    r.setState(state);
	                    positionList.add(r);
	        		}
	        		
	        	}
			} catch (XmlException e) {
		       log.error("------解析xml 出错！" );
				e.printStackTrace();
			}
		}
		//拼接成一个新的xml
		REALPOSITIONREQDocument returnDoc = REALPOSITIONREQDocument.Factory.newInstance();
        REALPOSITIONREQ rmReturn = returnDoc.addNewREALPOSITIONREQ();
        
		for(int k=0;k<positionList.size();k++){
	        REALPOSITIONLIST posList = rmReturn.addNewREALPOSITIONLIST();
			posList.setTERMINALID(getStr(positionList.get(k).getTerminalId()));
			posList.setTERMINALTYPE(getStr(positionList.get(k).getTerminalType()));
			posList.setMOBILENBR(getStr(positionList.get(k).getMobileNbr()));
			posList.setLONGTITUDE(getStr(positionList.get(k).getLongTitude()));
			posList.setLATITUDE(getStr(positionList.get(k).getLaTitude()));
			posList.setALTITUDE(getStr(positionList.get(k).getAltitude()));
			posList.setRECEIVETIME(getStr(positionList.get(k).getReceiveTime()));
			posList.setVELOCITY(getStr(positionList.get(k).getVilocity()));
			posList.setANGLE(getStr(positionList.get(k).getAngle()));
			posList.setSTATE(getStr(positionList.get(k).getState()));
		}
	
	  String  returnString ="<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>"+returnDoc.toString();
		return returnString;
	}	
	/**
	  * 获取属性值
	  */
	private String getStr(Object o){
	   String str="";
		if(o!=null){
			return o.toString();
		}
		return  str;
	}
	
	/**
	  * 从缓存中删除处理过的list
	  */
	private void deleteFromXmllist(List<String> list) {
		for(int k=0; k < list.size();k++){
		 String strbranch = list.get(k);
		 xmllist.remove(strbranch);
		}
	}
	
	 /**
	  * 分配处理请求方式
	  */
	private synchronized  void devRequestMethod(){
		
    		if(xmllist.size()>=doOnceMaxNum && numflag){
//    			 System.out.println("-------------進入数量处理-----"+xmllist.size());
    			timerflag=false;
    			for(int i=xmllist.size()-doOnceMaxNum; i<xmllist.size(); i++){
    				String str=(String)xmllist.get(i);
    				dolist.add(str);
    			}
    			equDataForSendRequest(); 
    		}else{ 
    		//当只要判断个数小于200时，就开始计时，当到一分钟后，再判断个数，和是否再处理中。
    			if(timer==null && timerflag){
    			  timer = StaffLocationAction.getTimer();
    			  timer.schedule(new MyTask(), timeDleay);
    			}
    		}
    	}
		
	 /**
	  * 
	  * 定时处理任务
	  */
    class MyTask extends java.util.TimerTask{
    	@Override
    	public void run() {
    		if(xmllist.size()<doOnceMaxNum ){
    			  numflag=false;	
// 				 System.out.println("-------------時間到開始处理-----"+xmllist.size());
    			for(int i=0; i<xmllist.size(); i++){
    				String str=(String)xmllist.get(i);
    				dolist.add(str);
    			}
    			equDataForSendRequest();
    	      }else{
    	    	   numflag=true;	
    	    	   timer=null;
//   				 System.out.println("-------------時間到但是数量过大重新请求处里---"+xmllist.size());
    	    	   devRequestMethod();
    	       }
    		}
     }		
    /**
	  * @author 
	  * 数据平分
	  */
	 private  int[] devNum(int i) {
		   int[] array1=  new int[sumitNum];
		   for(int j=0 ; j<array1.length; j++){
			   if(j==0){
				   array1[j]=i/sumitNum;
				   i=i-array1[j];
			   }else{
			   array1[j]=i/(sumitNum-j);
			      i=i-array1[j];
			    }
			   if(j>=1){
			   array1[j]=array1[j-1]+array1[j];
			   }
		   }
		return array1;
	  }
	
	public ActionForward getSendLocationInterval(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException, SysException, IOException {
		String sendLocationInterval=SysConfigData.getSysConfigCurValue(SysConstants.SYS_CONFIG_MOS_SEND_LOCATION_INTERVAL, null, null, null, null, null);
		
		if (sendLocationInterval!=null) {
			ReqUtil.write(response, sendLocationInterval.toString());
		}
		return null;
	}
	
	/**
	 * 获得从客户端传入的XML字符串
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getXML(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "UTF-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		return sb.toString();
	}
}
