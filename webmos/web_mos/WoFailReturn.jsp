<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.cattsoft.pub.SysConstants"%>
<%@ page import="com.cattsoft.pub.util.SysConfigData"%>
<HTML>
<HEAD>
<TITLE>ʧ�ܻص�</TITLE>
<base target="_self" />	
<link href="../css/tabdisplaystyle.css" rel="stylesheet" type="text/css">
<style type="text/css">
#box{
	display: none;
	border:1px solid #96A1AB outset;
	border-radius:15px;
	background-color:#F6F6F6;
	text-align: left;
	margin-top:4px;
	margin-left:95px;
	padding-left:1px;
	padding-right:1px;
	padding-top:4px;
	line-height: 100%;
	text-indent: 0em;
	position: absolute;
}

ul{
	margin:0;
	padding:0;
	list-style:none;
}
/*.dropDownList div.dropdown select{display:none;}*/
	
	.dropDownList span{
		font-size:12px;
		display:block;
		width:156px;
		height:19px;
	    background:#FFF;
		float:left;
		line-height:19px;
		overflow:hidden;
		cursor:pointer;
	}

 	#dropDownList1{
 		position:relative;width:100%;	
 	}

	.dropDownList ul{
		margin:0;
		padding:0;
		background:#fff;
		width:226px;
		display:none;
		border-left:solid 1px #5794BF;
		border-bottom:solid 1px #5794BF;
		border-right:solid 1px #5794BF;
	}
	.dropDownList ul li{
		height:20px;
		width:100%;
		padding:2px;
		cursor:pointer;
	}
	.dropDownList ul li.over{
		background:#ccc;
	}
	.dropDownList ul.show{
		display:block;
	}
</style>

<!-- end by liangyx -->

<!-- add by liangyongxing ��div+css+jsʵ��ģ��select�����б�Ĺ��� -->

		<script type="text/javascript" language="javascript"
			src="../js/sorttable.js"></script>
		<script type="text/javascript" language="javascript"
			src="../js/changecol.js"></script>
		<script type="text/javascript" language="javascript"
			src="../js/calendarTime.js"></script>
		<script type="text/javascript" language="javascript"
			src="../js/public.js"></script>
		<script type="text/javascript" language="javascript"
			src="../js/jquery-1.2.6.js"></script>
		<script type="text/javascript" language="javascript"
			src="../js/prototype.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></HEAD>

<BODY>
<% String soCat = (String)request.getAttribute("soCat"); %>
<html:form styleId="failForm" action="/tm/WoHandleAction.do?method=woReturn&wonbrString" method="post" >
<table width="100%" align="left">
 <tr>
  <td>

       <fieldset>
              
      <legend>ʧ�ܻص�
      		<input type="hidden" value="<bean:write name='WoHandleForm' property='woNbrAryStr'/>" name="wonbrs"/>
      		<input type="hidden" value="<bean:write name="WoHandleForm" property="soNbr" />" name="returnSoNbrs"/>
      		<input type="hidden" value="<bean:write name="WoHandleForm" property="soSeq" />" name="returnSoSeqs"/>
       </legend> 
			  <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td  bgcolor="9FAAB5"> 
	        <table width="100%" cellspacing="1" >
			
                     <tr bgcolor="#E5E8EC">
                       <td width="35%" height="20" align="right">��&nbsp;��&nbsp;��&nbsp;�룺</td>
                       <td width="65%" colspan="2" bgcolor="E5E8EC" title="<bean:write name="WoHandleForm" property="soNbr" />">
					   <div STYLE="width:200;overflow:hidden;text-overflow:ellipsis"> <nobr><bean:write name="WoHandleForm" property="soNbr" /></nobr></div>
					   </td>
                     </tr>
                     
                      <logic:notEmpty name="WoHandleForm"
									property="failReasonIdList" scope="request">                 				 
                     <tr bgcolor="#E5E8EC">
                       <td align="right" >ʧ&nbsp;��&nbsp;ԭ&nbsp;��</td>
                       <td colspan="2" onmouseover="showReason();" onmouseout="dispareReason();">
					      	<!-- �����ӵ� -->
							<div class="dropDownList">
								<div id="dropDownList1" class="dropdown" style="z-index: 100">
									<html:select  name="WoHandleForm" property="failReasonId" style="width:176;display:none">
								      	<logic:present name="WoHandleForm" property="failReasonIdList">
								      		<html:optionsCollection name="WoHandleForm" property="failReasonIdList"/>
									  	</logic:present>
									</html:select>
									<span id='spanCon'>��ѡ��ʧ��ԭ��</span>
									<img src="../images/select.png" height="19px" width="19px" name="imgId" style="cursor: pointer;"/>
									<ul onclick="getMyTextValue();"></ul>
								</div>
							</div>
							<input type="hidden" value="" id="commonText"/>
							<input type="hidden" value="0" id="rank"/>
							<div id="box" style="display: none;z-index: 10">
					      	</div>
					   </td>
                     </tr>
                      </logic:notEmpty>
                      
                     <!--  
                     <tr bgcolor="#E5E8EC" id="resTr" style="display:none">
                     	<td width="35%" height="20" align="right">�ͷ���Դ��</td>
                     	<td colspan="2"> 
                     		<div style="overflow:auto;height:52px;">
                     			<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="9FAAB5">
                     				<tr bgcolor="#E5E8EC">
                     					<td width="70%" colspan="2" bgcolor="E5E8EC">
                     						<span id='res'></span>
                     					</td>
                     				</tr>
                     			</table>
                     		</div>
                     	</td>
                     </tr>
                     -->
                     <tr bgcolor="#E5E8EC" id="delayFixDateTr" style="display:none">
                     		<td align="right">��װת������(�ɿ�)��</td>
                     		<td> 	<html:text name="WoHandleForm"  property="delayFixCancelDate"
																	style="width:150px;"  
																	onclick="Calendar.display(Calendar.DATE)" />
                     		</td>
                     </tr>
                     <tr bgcolor="#E5E8EC" id="rltdWoTr" style="display:none">
                     		<td align="right">�������룺</td>
                     		<td>
                     			<span id='rltdWo'></span> 
                     		</td>
                     </tr>                     
                     <logic:equal name="WoHandleForm" property="stepWoStaffConfig" value="D">
							<input type="hidden" name="retBy" value="retByCurrent" checked>��ǰ��½Ա��<br>
							<input type="hidden" name="nameConfirm" id="confirmName"/>	
					</logic:equal>
					<!-- ʩ���˶�ѡ��������+�������� -->
										<logic:equal name="WoHandleForm" property="stepWoStaffConfig" value="S">
										<tr bgcolor="#E5E8EC">
											<td align="right" valign="top">
												ʩ&nbsp;&nbsp;��&nbsp;&nbsp;�ˣ�
											</td>
											<td>
											<logic:notEmpty name="WoHandleForm" property="maintAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" >��ǰ��½Ա��<br>
											</logic:notEmpty>
											<logic:empty name="WoHandleForm" property="maintAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" checked>��ǰ��½Ա��<br>
											</logic:empty>
												<input type="radio" name="retBy" value="retByWorkAreaStaff" >������ѡ
													<html:select name="WoHandleForm" property="workAreaStaffId" style='width:100'>
														<logic:present name="WoHandleForm" property="workAreaStaffList">
															<html:optionsCollection name="WoHandleForm" property="workAreaStaffList" />
														</logic:present>
													</html:select>  
													<br>
												 <logic:notEmpty name="WoHandleForm" property="maintAreaStaffList">
													<input type="radio" name="retBy" value="retByMaintAreaStaff" checked>������ѡ
													<html:select name="WoHandleForm" property="maintAreaStaffId" style='width:100'>
														<logic:present name="WoHandleForm" property="maintAreaStaffList">
															<html:optionsCollection name="WoHandleForm" property="maintAreaStaffList" label="name" value="staffId" />
														</logic:present>
													</html:select>  
												</logic:notEmpty>
											</td>
										</tr>
											
										</logic:equal> 
										<!-- ʩ���˶�ѡ���������� -->
										<logic:equal name="WoHandleForm" property="stepWoStaffConfig" value="W">
										<tr bgcolor="#E5E8EC">
											<td align="right" valign="top">
												ʩ&nbsp;��&nbsp;��&nbsp;Ա��
											</td>
											<td>
											<logic:notEmpty name="WoHandleForm" property="workAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" >��ǰ��½Ա��<br>
											</logic:notEmpty>
											<logic:empty name="WoHandleForm" property="workAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" checked>��ǰ��½Ա��<br>
											</logic:empty>
											<logic:notEmpty name="WoHandleForm" property="workAreaStaffList">
												<input type="radio" name="retBy" value="retByWorkAreaStaff" checked>������ѡ
													<html:select name="WoHandleForm" property="workAreaStaffId" style='width:100'>
														<logic:present name="WoHandleForm" property="workAreaStaffList">
															<html:optionsCollection name="WoHandleForm" property="workAreaStaffList" />
														</logic:present>
													</html:select>  
											</logic:notEmpty>
											
											
											</td>
										</tr>
										
										<!-- end by liangyx -->
										
										</logic:equal>
										<!-- ʩ���˶�ѡ���������� -->
										<logic:equal name="WoHandleForm" property="stepWoStaffConfig" value="M">
										<tr bgcolor="#E5E8EC">
											<td align="right" valign="top">
												ʩ&nbsp;&nbsp;��&nbsp;&nbsp;�ˣ�
											</td>
											<td>
											<logic:notEmpty name="WoHandleForm" property="maintAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" >��ǰ��½Ա��<br>
											</logic:notEmpty>
											<logic:empty name="WoHandleForm" property="maintAreaStaffList">
												<input type="radio" name="retBy" value="retByCurrent" checked>��ǰ��½Ա��<br>
											</logic:empty>

												 <logic:notEmpty name="WoHandleForm" property="maintAreaStaffList">
													<input type="radio" name="retBy" value="retByMaintAreaStaff" checked>������ѡ
													<html:select name="WoHandleForm" property="maintAreaStaffId" style='width:100'>
														<logic:present name="WoHandleForm" property="maintAreaStaffList">
															<html:optionsCollection name="WoHandleForm" property="maintAreaStaffList" label="name" value="staffId" />
														</logic:present>
													</html:select>  
												</logic:notEmpty>
												
										</tr>
										</logic:equal>
										
							<!--  
							<div style="overflow:auto;" id="sysConfigId">
  								<input type="hidden" value="123" id="configId"/>
									<tr bgcolor="#E5E8EC">
										<td width="35%" height="20" align="right">
											��&nbsp;ϵ&nbsp;��&nbsp;����
										</td>
										<td>
											<html:text name="WoHandleForm" property="processDesc" style="width:176px;"/>
										</td>
									</tr>
									<tr bgcolor="#E5E8EC" id="delayFixDateTr">
										<td width="35%" height="20" align="right">
											�߱�װ��ʱ�䣺
										</td>
										<td>
											<html:text name="WoHandleForm" value="ת��װʱ��ѡ��߱�װ��ʱ��" property="reworkDate" style="width:176px;color:gray" 
											onclick="clearText();Calendar.display(Calendar.DATE);" 
											onfocus="compareDate()"/>
											
										</td>
									</tr>
							</div>			
							
							-->
				<!-- �ϰ�֤ʵ���� -->
				<input type="hidden" value="<bean:write name='WoHandleForm' property='woSVo.stepId'/>" name="stepId"/>
				<tr bgcolor="#E5E8EC" id="idConfirmTr" style="display:none">
					<td align="right">֤ʵ���ݣ�</td>
					<td>
						<textarea name="" cols="32" rows="2" style="overflow:auto" size="1024">							
						</textarea>
					</td>
				</tr>
			
				<logic:present name="WoHandleForm" property="soFaultExtMVO.customerSatisfactionList">
					<tr bgcolor="#E5E8EC" id="idCustSatisfaction" style="display:none">
						<td align="right">�ͻ�����ȣ�</td>
						<td>
							<html:select name="WoHandleForm" property="soFaultExtMVO.customerSatisfaction" style="width:100">
								<logic:present name="WoHandleForm" property="soFaultExtMVO.customerSatisfactionList">
									<html:optionsCollection name="WoHandleForm" property="soFaultExtMVO.customerSatisfactionList"/>
								</logic:present>
							</html:select>
						</td>
					</tr>
				</logic:present>
					    <tr bgcolor="#E5E8EC">
					   
                <td align="right" valign="top">�� &nbsp;&nbsp;ע��
                    <label></label></td>
                <td><textarea name="surveyInput" cols="31" rows="8" 
                 style="overflow:auto" size="1024"><bean:write name="WoHandleForm" property="remarks" /></textarea></td>
              </tr>
                   
               <logic:present name="WoHandleForm" property="woNotAllowList">
										<logic:notEmpty name="WoHandleForm" property="woNotAllowList">
										<tr bgcolor="#E5E8EC">
											<td align="right" valign="top">
													�޷��ص���
													<label></label>
											</td>
											<td>
												<div style="overflow:auto;width:100%;height:48;" id="listDiv">
										
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
												<td bgcolor="9FAAB5">
												<table width="100%" cellspacing="1">
												<tr bgcolor="#E5E8EC">
												<td width="20%" align="center">������</td>
												<td width="20%" align="center">������</td>
												<td width="60%" align="center">�޷��ص�ԭ��</td>
												</tr>
												<logic:iterate id="vo" name="WoHandleForm" property="woNotAllowList">
												<tr bgcolor="#E5E8EC">
													<td width="20%" align="center">
														<bean:write name="vo" property="soNbr"/>
                                           			 </td>
													<td width="20%" align="center">
														<bean:write name="vo" property="woNbr" />
													</td>
													<td width="60%" align="center">
														<bean:write name="vo" property="remarks" />
													</td>
												</tr>		
												</logic:iterate>
												</table>
												</td>
												</tr>
												</table>
												</div>
											</td>
										</tr>
										</logic:notEmpty>
										</logic:present>
										
										<logic:present name="WoHandleForm" property="woAllowList">
											<logic:notEmpty name="WoHandleForm" property="woAllowList">
												<logic:iterate id="vo" name="WoHandleForm" property="woAllowList">
												<tr>
													<td width="20%" align="center">
														<input type="hidden" name="woAry"
															value='<bean:write name="vo" property="woNbr" />'>
													</td>
												</tr>		
												</logic:iterate>								
       										</logic:notEmpty>
										</logic:present>     
                    
            </table>
	    </td>
	  </tr>
	</table>
	</fieldset>
	
	  <table width="98%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="2" bgcolor="#FFFFFF"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td bgcolor="#ADB7C0">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="33" align="right" bgcolor="#C8CFD9">
              <input type="button" name="confirm" onclick="return ok_close();"  value="ȷ ��" class="button2" id="sureBtn">
              &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
              <input name="Submit32" type="submit" class="button2" onclick='return closeWindow();' value="ȡ ��"> &nbsp;&nbsp;&nbsp;</td>
              <td width="2%" align="right" bgcolor="#C8CFD9">&nbsp;&nbsp;&nbsp;</td>
            </tr>
          </table></td>
        </tr>
      </table>
	
	</td>
  </tr>
 </table>
</html:form>
</BODY>
</HTML>
<script>
	<logic:notEmpty name="failMsg" scope="request">
		alert('<bean:write name="failMsg" />');
	</logic:notEmpty>
	//add by liangyx 2013/02/27 start...  ���ӵĶ�ʱ�����⴦�������7�췶Χ�� 
	//���㴫�������ʱ����ȷ����
	function daysBetween(DateOne,DateTwo)  
	{   
	    var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));  
	    var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);  
	    var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));  
	  
	    var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));  
	    var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);  
	    var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));  
	  
	    var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);   
	    return Math.abs(cha);  
	}  
	
	//�õ���ǰϵͳʱ�䣬��2013-2-27��������ʽ���
	function getSystemTime(){
		var myDate = new Date();
	    var myYear = myDate.getFullYear();
	    var myMonth = myDate.getMonth()+1;
	    var myDay = myDate.getDate();
	  	
	    var myTimes = myYear+"-"+myMonth+"-"+myDay;
		return myTimes;
	}
/*
	function compareDate() {
		//�õ��û�ѡ���ʱ�� 
		var userTimes = document.all("reworkDate");
		userDate = userTimes.value.substring(0,10);
		//�õ�ϵͳ��ǰʱ��
        var currentTimes = getSystemTime();
		
		var configIdVar = document.getElementById("configId").value;//�õ�ʡ�� ���֣�jl ���ɣ�nm add by liangyongxing 2013-5-10
		if(configIdVar=="jl"){
			//�ж��Ƿ����7��
        	var days1 = daysBetween(currentTimes,userDate); 
        	if(userDate!="" && days1>7){
        		alert("���߱�װ������ʱ�䡿������Ϊ->\n ��ǰʱ���7��ʱ�䷶Χ�ڣ�");
        		userTimes.value = "";
        	}
		}
	}
	
	function clearText() {
		//����߱�ʱ�䷽���е�����
		var timeText = document.all("reworkDate");
		timeText.style.color = "black";
		if("" != timeText.value) {
			if(timeText.value=="ת��װʱ��ѡ��߱�װ��ʱ��") {
				timeText.style.color = "black";
				timeText.value = "";
			} else {
				timeText.value = "";
				timeText.style.color = "black";
			}
		} 
	}
	function checkText() {
		var timeText = document.all("reworkDate");
		if(""==timeText.value) {
			timeText.style.color = "gray";
			timeText.value = "ת��װʱ��ѡ��߱�װ��ʱ��";
		} else if(timeText.value=="ת��װʱ��ѡ��߱�װ��ʱ��") {
			timeText.style.color = "gray";
		} else {
			timeText.style.color = "black";
		}
	}
	*/
	function showReason(){
		//add by liangyx ��ʾʱ���ж��ַ��Ķ��٣���������div����ٵĻ��Ͱ��չ̶���ʽ��ʾ 
		var hiddenRank = document.getElementById("rank").value;//�õ��û�ѡ��ĵڼ���option��ֵ��value 
		//�õ�option�Ķ���(���� )
		var selectOptions = document.all("failReasonId");
		//alert(selectOptions[1].text);
		document.getElementById("box").style.display="block"; 
		var tooLengthText = selectOptions[hiddenRank].text;
		if(tooLengthText.toString().length>10) {
			document.getElementById("box").style.marginLeft="2px";
		} else {
			document.getElementById("box").style.marginLeft="95px";
		}
		document.getElementById("box").innerHTML = selectOptions[hiddenRank].text;
  	}
  	function dispareReason(){
		document.getElementById("box").style.display="none"; 
  	}
	//end by liangyx ...
</script>


<!-- add by liangyx 2013/02/27 �����ж��ֹ������Ƿ�Ϊ�պͲ�ͬʡ����ʾ�����ݲ�ͬ���ж�-->
<script type="text/javascript">
var spanCon=document.getElementById('spanCon');
var uls=document.getElementById('dropDownList1').getElementsByTagName('ul')[0];
uls.style.position='absolute';
uls.style.top=spanCon.offsetTop+spanCon.offsetHeight+'px';
uls.style.left=spanCon.offsetLeft+'px';
uls.style.border='1px solid #e5e8ed';



var ____configArray;
function __initDropDownList(configArray){
	
	//��ȡSelect�˵�
	____configArray=configArray;
	var existArray=configArray.split("|");
	for(var i=0;i<existArray.length;i++){
		if(existArray[i].length<1){return;}
		//���ݲ����ֱ��ȡdiv�����ֱ�����¼�
		var parentContainer=document.getElementById(existArray[i]);
		if(!parentContainer){return;}
		//��ȡ�����select���һ�ȡ���е�option
		var selectObj=parentContainer.getElementsByTagName("select");
		if(selectObj.length<1){return;}
		var optionArray=selectObj[0].getElementsByTagName("option");
		//��ȡoption�����ֱ���ӵ�����li
		var optionLength=optionArray.length;
		for(var j=0;j<optionLength;j++){
			//��ȡul���Ա��ܹ������Ŀ
			var ulObj=parentContainer.getElementsByTagName("ul");
			if(ulObj.length<1){return;}
			//��ȡspan���Ա�����ʾ��ǰѡ�����Ŀ
			var spanObj=parentContainer.getElementsByTagName("span");
			var imgId = parentContainer.getElementsByTagName("img");
			if(spanObj.length<1){return;}
			var liObj=document.createElement("li");
			var textNode=document.createTextNode(optionArray[j].firstChild.nodeValue)
			liObj.appendChild(textNode);
			liObj.setAttribute("currentIndex",j);
			//��ÿ��liObj����¼�
			liObj.onclick=function(){
				selectCurrentItem(this.parentNode,this);
			}
			liObj.onmouseover=function(){this.className="over";}
			liObj.onmouseout=function(){this.className="";}
			ulObj[0].appendChild(liObj);
			spanObj[0].onclick=function(event){
				//�����ǰ����ʾ�ģ������أ���֮��Ȼ
				showHiddenUl(this);
			}
			spanObj[0].onmouseover=function(){this.className='over';}
			spanObj[0].onmouseout=function(){this.className="";};
			
			
			imgId[0].onclick=function(event){
				//�����ǰ����ʾ�ģ������أ���֮��Ȼ
				showHiddenUl(this);
			}
			imgId[0].onmouseover=function(){this.className='over';}
			imgId[0].onmouseout=function(){this.className="";};
			
			ulObj[0].onclick=function(){this.className="";}
		}
		parentContainer.onclick=function(event){
			if(!event){event=window.event;}
				//��ֹ�¼�ð��
				event.cancelBubble=true;
				var eventUlObj=this.getElementsByTagName("ul")[0];
				bodyClickHiddenUl(eventUlObj);
		}
	}
}
function selectCurrentItem(ulObj,currentObj){
	var parentObj=ulObj.parentNode;
	var spanObj=parentObj.getElementsByTagName("span")[0];
	spanObj.firstChild.nodeValue=currentObj.firstChild.nodeValue;
	var selectObj=parentObj.getElementsByTagName("select")[0];
	selectObj.selectedIndex=parseInt(currentObj.getAttribute("currentIndex"));
	
	//������ʾ��ʾ���Ч��
	var rankIndex = parseInt(currentObj.getAttribute("currentIndex"));//�õ�ѡ��ĵڼ��� 
	//���õ��Ļ�д���������� 
	var hiddenRank = document.getElementById("rank");
	hiddenRank.value = rankIndex;
}
function showHiddenUl(currentObj){
	var parentNode=currentObj.parentNode;
	var ulObj=parentNode.getElementsByTagName("ul")[0];
	if(ulObj.className==""){
		ulObj.className="show";
	}else{
		ulObj.className="";
	}
}
//���body���򣨷�"�����˵�"�����ز˵�
function addBodyClick(func) {
	var bodyObj=document.getElementsByTagName("body")[0];
	var oldBodyClick = bodyObj.onclick;
		if (typeof bodyObj.onclick != 'function') {
			bodyObj.onclick = func;
		} else {
			bodyObj.onclick = function() {
			oldBodyClick();
			func();
		}
	}
}
//�������е�UL
function bodyClickHiddenUl(eventUlObj){
	var existArray=____configArray.split("|");
	for(var i=0;i<existArray.length;i++){
		if(existArray[i].length<1){return;}
		//Ѱ������UL��������
		var parentContainer=document.getElementById(existArray[i]);
		if(!parentContainer){return;}
		var ulObj=parentContainer.getElementsByTagName("ul");
		if(eventUlObj!=ulObj[0]){
			ulObj[0].className="";
		}
	}
}
var __dropDownList="dropDownList1";
__initDropDownList(__dropDownList);
//����������ȷ�����body�����ʱ��Ҳ�������ز˵�
addBodyClick(bodyClickHiddenUl);
</script>
<!-- end by liangyx -->

<script language="javascript">
 function closeWindow(){
        parent.window.returnValue = "yes";
		window.close();
		return false;
	}
	
	 function showFail(){
tr.style.display="block"
	}
		 function unshowFail(){
tr.style.display="none"
	}

	//������Ϣ
function ok_close() {	
  	if(document.all("surveyInput") == null) {
    	return false;
  	}
  	
  	//add by liangyx 2013/02/27 start...  ����У���ֹ�������������֤ 
  	var radioName = document.getElementById("raidoName");
  	if(radioName!=null){
  		if(radioName.checked==true){
		  	var names = document.all("woStaffName");
			if(names.value==""){
				alert("ѡ���ֹ�����������д���ݲ��ܽ����ύ!");
				names.focus();
				return false;
			}
		} else {
			var names = document.all("woStaffName");
			names.value="";
		}
  	}
	//end by liangyongxing 
	
	var wonbrs = document.getElementById("wonbrs").value;
 	//�����ص����ͷ���Դ������ͬʱ����
 	var resArys = getChbArray("resAry");
 	if(resArys != null && wonbrs.split(',').length > 1){
 		confirm("�����ص����Զ��ͷ���Դ������ͬʱ������");
 		window.close(); 		
 	}else{
	 	//��������������Դ���û����򲻿����Զ��ͷ���Դ����Ҫ�˹�����
		if(resArys != null){
			var url = "../AjaxServlet?method=ajaxIsHaveResStep";
			var params = "soNbr=" + document.getElementById("returnSoNbrs").value;;
			var myAjax = new Ajax.Request(url, {method:"get", parameters:params, onComplete:processResponse, asynchronous:false});
	 	}
 	}
 	var remarks = Trim(document.all("surveyInput").value)  ;	
 	 
     remarks = remarks.replace(new RegExp("&","gm"),"��") ;	
     remarks = remarks.replace(new RegExp("#","gm"),"��") ;	
   �� 
	if (remarks.length > 1024)
	{
		alert("��Ϣ�������뾫����Ϣ���ݣ���������Ϊ1024"); 
		return false;
	}
	
	 if(undefined!=document.all("failReasonId")){
	 	var selValue=document.all("failReasonId").value;
	 	for(var i=0;i<document.all.failReasonId.options.length;i++){
			if(document.all.failReasonId.options[i].value==selValue)
				var failReason=document.all.failReasonId.options[i].text;
		}
		if (!confirm("��ȷ��ʧ��ԭ��Ϊ ��\n" + failReason ))
		{
			return false;
		}
	 }
     
	var sureBtn = document.getElementById("sureBtn");
	sureBtn.disabled = true;
	var delayFixDate = document.getElementById("delayFixCancelDate");
			var url = "WoHandleAction.do?method=woReturn&woNbrAryStr="+wonbrs+"&returnType=1&remarks="+remarks+"&soCat="+<%=soCat%>;
			if (delayFixDate!=null){
 		       url+="&delayFixDate="+delayFixDate;
 		    }
			if(undefined!=document.all("failReasonId")){
				var failReasonId = document.all("failReasonId").value;
				if(failReasonId!=null||Trim(failReasonId)!=""){
					url = url+"&failReasonId="+failReasonId;
				}
			}
			document.failForm.action=url;
	   	 	document.failForm.submit();
}


function processResponse(originalRequest) {
	//alert("originalRequest.responseText = " + originalRequest.responseText)
	if ("false"!=originalRequest.responseText) {
		if(!confirm(originalRequest.responseText+"��Դ�Ǻ󲹵ģ����ں󲹻����˹��ͷţ��Ƿ�����ص���"))
 		window.close();
	}
}

function getSourceList(failReasonId, checkboxName, checkboxName1) {
	//add by liangyx 2013/03/01
	var names = document.all("failReasonId");
	var reasonText = document.getElementById("commonText");
	for(var i=0;i<names.length;i++){
		if(failReasonId==names.options[i].value) {
			reasonText.value = names.options[i].text;
		}
	}
	
	//add by Baixd 11/06/09
	var vStepId = document.all.failForm("stepId").value;
	if(vStepId != null && vStepId != "" && "SP3058" == vStepId){
		//֤ʵ������ʱ������ʾ
		//document.getElementById("idConfirmTr").style.display="block";
		document.getElementById("idCustSatisfaction").style.display="block";
	}
	
	if(failReasonId == ''){
		//��ʼҳ��ʹ��
		if(undefined!=document.all("failReasonId")){
			failReasonId = document.getElementById('failReasonId').value;
		}else{
			return;
		}
	}
	if(failReasonId != '20003001' && failReasonId != '20003002' && failReasonId != '20003003'){
		var rltdWoTr = document.getElementById('rltdWoTr');
		rltdWoTr.style.display="none"; 
	}
	if(failReasonId == '20003003' ){//��װ
		var delayFixDateTr = document.getElementById('delayFixDateTr');
		delayFixDateTr.style.display="block"; 
	} 
	
	//alert("failReasonId = " + failReasonId);
	var wonbrs = document.getElementById("wonbrs").value;
	var returnSoNbrs = document.getElementById("returnSoNbrs").value;
	var soNbrs = returnSoNbrs.split(',');
	var woNbr=wonbrs.split(',');
	var url = "WoHandleAction.do?method=getResourceList";
	var params = "failReasonId=" + failReasonId  + "&checkboxName=" + checkboxName + "&soNbr=" + soNbrs[0]+"&woNbr="+woNbr[0];
	var myAjax = new Ajax.Request(url, {method:"get", parameters:params, onComplete:showResponse, asynchronous:true});
	if (failReasonId == '20003001' || failReasonId == '20003002'||failReasonId == '20003003' ) {
		// alert("hi" + failReasonId);
		var url1 = "WoHandleAction.do?method=getRelatedWoList";
		params = "failReasonId=" + failReasonId  + "&checkboxName=" + checkboxName1 + "&woNbrAryStr="+wonbrs;
		var myAjax1 = new Ajax.Request(url1, {method:"get", parameters:params, onComplete:showResponse1, asynchronous:true});
	}
	
}
	
function showResponse(originalRequest){
	var resHTML = originalRequest.responseText;
	//alert("resHTML="+resHTML);
	if(resHTML != ""){
		var resTr = document.getElementById('resTr');
		resTr.style.display="block"; 
	}else{
		var resTr = document.getElementById('resTr');
		resTr.style.display="none"; 
	}
	var cb = document.getElementById('res');
	cb.innerHTML=resHTML;
}

function showResponse1(originalRequest){
	var resHTML = originalRequest.responseText;
	//alert("resHTML="+resHTML);
	if(resHTML != ""){
		var rltdWoTr = document.getElementById('rltdWoTr');
		rltdWoTr.style.display="block"; 
	}else{
		var rltdWoTr = document.getElementById('rltdWoTr');
		rltdWoTr.style.display="none"; 
	}
	var cb = document.getElementById('rltdWo');
	cb.innerHTML=resHTML;
}

<%
	String mode = SysConfigData.getSysConfigCurValue(
		SysConstants.SYS_CONFIG_FLEX_WEBSTART, null, null, null, null,null);
	if(mode == null || "".equals(mode.trim())){
		mode = "FLEX";
	}
%>
var procShowMode = "<%=mode %>";
function failDoFlagResponse(originalRequest){
	var failDoFlag = originalRequest.responseText;
	var returnValue;
	if("M"==failDoFlag){//�쳣�����־Ϊ���쳣�˹�����
		var soNbr = document.getElementById("returnSoNbrs").value;
		var soSeq = document.getElementById("returnSoSeqs").value;
		var url = "../wm/flexAction.do?method=init&type=failForward&soNbr="+soNbr+"&soSeq="+soSeq;
        if(procShowMode == "WEBSTART"){
        	url = "../wm/AppletAction.do?method=init&type=failForward&soNbr="+soNbr+"&soSeq="+soSeq;
        }
		returnValue = window.showModalDialog(url, window,"dialogHeight: 568px; dialogWidth: 850px; center: yes; help: no;status:no;title:no;scroll:no");
		if(returnValue == undefined){
			alert("��ѡ���ʧ��ԭ����Ҫ�˹����ȣ���ѡ���쳣���˵��Ļ��");
			return;
		}
	} 
	var wonbrs = document.getElementById("wonbrs").value;
	var remarks = Trim(document.all("surveyInput").value)  ;	
    remarks = remarks.replace(new RegExp("&","gm"),"��") ;	
    remarks = remarks.replace(new RegExp("#","gm"),"��") ;	
	var url = "WoHandleAction.do?method=woReturn&woNbrAryStr="+wonbrs+"&returnType=1&remarks="+remarks;
	if(undefined!=document.all("failReasonId")){
		var failReasonId = document.all("failReasonId").value;
	}else{
		return;
	}
	var failReasonId = document.all("failReasonId").value;
	if(failReasonId!=null||Trim(failReasonId)!=""){
		url = url+"&failReasonId="+failReasonId;
	}
	if(returnValue != undefined && failReasonId!=null && Trim(returnValue) != ''){
		url = url+"&procNodeId="+returnValue;
	}
	document.failForm.action=url;
    document.failForm.submit();
}
</script>   