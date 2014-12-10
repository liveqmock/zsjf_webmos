//=========================================================
//  author William  QQ: 22967225
//  create date 2005-12-2
//  version 1.0
//=========================================================

//an pinyin shou zi mu pai xu
var key2code = {65:"a",66:"b",67:"c",68:"d",69:"e",70:"f",71:"g",72:"h",73:"i",74:"j", 
75:"k",76:"l",77:"m",78:"n",79:"o",80:"p",81:"q",82:"r",83:"s",84:"t", 
85:"u",86:"v",87:"w",88:"x",89:"y",90:"z",49:"1",50:"2",51:"3",52:"4", 
53:"5",54:"6",55:"7",56:"8",57:"9",48:"0" 
}; 

var spell = {0xB0A1:"a", 0xB0A3:"ai", 0xB0B0:"an", 0xB0B9:"ang", 0xB0BC:"ao", 0xB0C5:"ba", 0xB0D7:"bai", 0xB0DF:"ban", 

0xB0EE:"bang", 0xB0FA:"bao", 0xB1AD:"bei", 0xB1BC:"ben", 0xB1C0:"beng", 0xB1C6:"bi", 0xB1DE:"bian", 0xB1EA:"biao", 

0xB1EE:"bie", 0xB1F2:"bin", 0xB1F8:"bing", 0xB2A3:"bo", 0xB2B8:"bu", 0xB2C1:"ca", 0xB2C2:"cai", 0xB2CD:"can", 0xB2D4:"cang", 

0xB2D9:"cao", 0xB2DE:"ce", 0xB2E3:"ceng", 0xB2E5:"cha", 0xB2F0:"chai", 0xB2F3:"chan", 0xB2FD:"chang", 0xB3AC:"chao", 

0xB3B5:"che", 0xB3BB:"chen", 0xB3C5:"cheng", 0xB3D4:"chi", 0xB3E4:"chong", 0xB3E9:"chou", 0xB3F5:"chu", 0xB4A7:"chuai", 

0xB4A8:"chuan", 0xB4AF:"chuang", 0xB4B5:"chui", 0xB4BA:"chun", 0xB4C1:"chuo", 0xB4C3:"ci", 0xB4CF:"cong", 0xB4D5:"cou", 

0xB4D6:"cu", 0xB4DA:"cuan", 0xB4DD:"cui", 0xB4E5:"cun", 0xB4E8:"cuo", 0xB4EE:"da", 0xB4F4:"dai", 0xB5A2:"dan", 

0xB5B1:"dang", 0xB5B6:"dao", 0xB5C2:"de", 0xB5C5:"deng", 0xB5CC:"di", 0xB5DF:"dian", 0xB5EF:"diao", 0xB5F8:"die", 

0xB6A1:"ding", 0xB6AA:"diu", 0xB6AB:"dong", 0xB6B5:"dou", 0xB6BC:"du", 0xB6CB:"duan", 0xB6D1:"dui", 0xB6D5:"dun", 

0xB6DE:"duo", 0xB6EA:"e", 0xB6F7:"en", 0xB6F8:"er", 0xB7A2:"fa", 0xB7AA:"fan", 0xB7BB:"fang", 0xB7C6:"fei", 0xB7D2:"fen", 

0xB7E1:"feng", 0xB7F0:"fo", 0xB7F1:"fou", 0xB7F2:"fu", 0xB8C1:"ga", 0xB8C3:"gai", 0xB8C9:"gan", 0xB8D4:"gang", 0xB8DD:"gao", 

0xB8E7:"ge", 0xB8F8:"gei", 0xB8F9:"gen", 0xB8FB:"geng", 0xB9A4:"gong", 0xB9B3:"gou", 0xB9BC:"gu", 0xB9CE:"gua", 

0xB9D4:"guai", 0xB9D7:"guan", 0xB9E2:"guang", 0xB9E5:"gui", 0xB9F5:"gun", 0xB9F8:"guo", 0xB9FE:"ha", 0xBAA1:"hai", 

0xBAA8:"han", 0xBABB:"hang", 0xBABE:"hao", 0xBAC7:"he", 0xBAD9:"hei", 0xBADB:"hen", 0xBADF:"heng", 0xBAE4:"hong", 

0xBAED:"hou", 0xBAF4:"hu", 0xBBA8:"hua", 0xBBB1:"huai", 0xBBB6:"huan", 0xBBC4:"huang", 0xBBD2:"hui", 0xBBE7:"hun", 

0xBBED:"huo", 0xBBF7:"ji", 0xBCCE:"jia", 0xBCDF:"jian", 0xBDA9:"jiang", 0xBDB6:"jiao", 0xBDD2:"jie", 0xBDED:"jin", 

0xBEA3:"jing", 0xBEBC:"jiong", 0xBEBE:"jiu", 0xBECF:"ju", 0xBEE8:"juan", 0xBEEF:"jue", 0xBEF9:"jun", 0xBFA6:"ka", 

0xBFAA:"kai", 0xBFAF:"kan", 0xBFB5:"kang", 0xBFBC:"kao", 0xBFC0:"ke", 0xBFCF:"ken", 0xBFD3:"keng", 0xBFD5:"kong", 

0xBFD9:"kou", 0xBFDD:"ku", 0xBFE4:"kua", 0xBFE9:"kuai", 0xBFED:"kuan", 0xBFEF:"kuang", 0xBFF7:"kui", 0xC0A4:"kun", 

0xC0A8:"kuo", 0xC0AC:"la", 0xC0B3:"lai", 0xC0B6:"lan", 0xC0C5:"lang", 0xC0CC:"lao", 0xC0D5:"le", 0xC0D7:"lei", 

0xC0E2:"leng", 0xC0E5:"li", 0xC1A9:"lia", 0xC1AA:"lian", 0xC1B8:"liang", 0xC1C3:"liao", 0xC1D0:"lie", 0xC1D5:"lin", 

0xC1E1:"ling", 0xC1EF:"liu", 0xC1FA:"long", 0xC2A5:"lou", 0xC2AB:"lu", 0xC2BF:"lv", 0xC2CD:"luan", 0xC2D3:"lue", 

0xC2D5:"lun", 0xC2DC:"luo", 0xC2E8:"ma", 0xC2F1:"mai", 0xC2F7:"man", 0xC3A2:"mang", 0xC3A8:"mao", 0xC3B4:"me", 0xC3B5:"mei", 

0xC3C5:"men", 0xC3C8:"meng", 0xC3D0:"mi", 0xC3DE:"mian", 0xC3E7:"miao", 0xC3EF:"mie", 0xC3F1:"min", 0xC3F7:"ming", 

0xC3FD:"miu", 0xC3FE:"mo", 0xC4B1:"mou", 0xC4B4:"mu", 0xC4C3:"na", 0xC4CA:"nai", 0xC4CF:"nan", 0xC4D2:"nang", 0xC4D3:"nao", 

0xC4D8:"ne", 0xC4D9:"nei", 0xC4DB:"nen", 0xC4DC:"neng", 0xC4DD:"ni", 0xC4E8:"nian", 0xC4EF:"niang", 0xC4F1:"niao", 

0xC4F3:"nie", 0xC4FA:"nin", 0xC4FB:"ning", 0xC5A3:"niu", 0xC5A7:"nong", 0xC5AB:"nu", 0xC5AE:"nv", 0xC5AF:"nuan", 

0xC5B0:"nue", 0xC5B2:"nuo", 0xC5B6:"o", 0xC5B7:"ou", 0xC5BE:"pa", 0xC5C4:"pai", 0xC5CA:"pan", 0xC5D2:"pang", 0xC5D7:"pao", 

0xC5DE:"pei", 0xC5E7:"pen", 0xC5E9:"peng", 0xC5F7:"pi", 0xC6AA:"pian", 0xC6AE:"piao", 0xC6B2:"pie", 0xC6B4:"pin", 

0xC6B9:"ping", 0xC6C2:"po", 0xC6CB:"pu", 0xC6DA:"qi", 0xC6FE:"qia", 0xC7A3:"qian", 0xC7B9:"qiang", 0xC7C1:"qiao", 

0xC7D0:"qie", 0xC7D5:"qin", 0xC7E0:"qing", 0xC7ED:"qiong", 0xC7EF:"qiu", 0xC7F7:"qu", 0xC8A6:"quan", 0xC8B1:"que", 

0xC8B9:"qun", 0xC8BB:"ran", 0xC8BF:"rang", 0xC8C4:"rao", 0xC8C7:"re", 0xC8C9:"ren", 0xC8D3:"reng", 0xC8D5:"ri", 

0xC8D6:"rong", 0xC8E0:"rou", 0xC8E3:"ru", 0xC8ED:"ruan", 0xC8EF:"rui", 0xC8F2:"run", 0xC8F4:"ruo", 0xC8F6:"sa", 

0xC8F9:"sai", 0xC8FD:"san", 0xC9A3:"sang", 0xC9A6:"sao", 0xC9AA:"se", 0xC9AD:"sen", 0xC9AE:"seng", 0xC9AF:"sha", 

0xC9B8:"shai", 0xC9BA:"shan", 0xC9CA:"shang", 0xC9D2:"shao", 0xC9DD:"she", 0xC9E9:"shen", 0xC9F9:"sheng", 0xCAA6:"shi", 

0xCAD5:"shou", 0xCADF:"shu", 0xCBA2:"shua", 0xCBA4:"shuai", 0xCBA8:"shuan", 0xCBAA:"shuang", 0xCBAD:"shui", 0xCBB1:"shun", 

0xCBB5:"shuo", 0xCBB9:"si", 0xCBC9:"song", 0xCBD1:"sou", 0xCBD4:"su", 0xCBE1:"suan", 0xCBE4:"sui", 0xCBEF:"sun", 

0xCBF2:"suo", 0xCBFA:"ta", 0xCCA5:"tai", 0xCCAE:"tan", 0xCCC0:"tang", 0xCCCD:"tao", 0xCCD8:"te", 0xCCD9:"teng", 0xCCDD:"ti", 

0xCCEC:"tian", 0xCCF4:"tiao", 0xCCF9:"tie", 0xCCFC:"ting", 0xCDA8:"tong", 0xCDB5:"tou", 0xCDB9:"tu", 0xCDC4:"tuan", 

0xCDC6:"tui", 0xCDCC:"tun", 0xCDCF:"tuo", 0xCDDA:"wa", 0xCDE1:"wai", 0xCDE3:"wan", 0xCDF4:"wang", 0xCDFE:"wei", 

0xCEC1:"wen", 0xCECB:"weng", 0xCECE:"wo", 0xCED7:"wu", 0xCEF4:"xi", 0xCFB9:"xia", 0xCFC6:"xian", 0xCFE0:"xiang", 

0xCFF4:"xiao", 0xD0A8:"xie", 0xD0BD:"xin", 0xD0C7:"xing", 0xD0D6:"xiong", 0xD0DD:"xiu", 0xD0E6:"xu", 0xD0F9:"xuan", 

0xD1A5:"xue", 0xD1AB:"xun", 0xD1B9:"ya", 0xD1C9:"yan", 0xD1EA:"yang", 0xD1FB:"yao", 0xD2AC:"ye", 0xD2BB:"yi", 0xD2F0:"yin", 

0xD3A2:"ying", 0xD3B4:"yo", 0xD3B5:"yong", 0xD3C4:"you", 0xD3D9:"yu", 0xD4A7:"yuan", 0xD4BB:"yue", 0xD4C5:"yun", 

0xD4D1:"za", 0xD4D4:"zai", 0xD4DB:"zan", 0xD4DF:"zang", 0xD4E2:"zao", 0xD4F0:"ze", 0xD4F4:"zei", 0xD4F5:"zen", 

0xD4F6:"zeng", 0xD4FA:"zha", 0xD5AA:"zhai", 0xD5B0:"zhan", 0xD5C1:"zhang", 0xD5D0:"zhao", 0xD5DA:"zhe", 0xD5E4:"zhen", 

0xD5F4:"zheng", 0xD6A5:"zhi", 0xD6D0:"zhong", 0xD6DB:"zhou", 0xD6E9:"zhu", 0xD7A5:"zhua", 0xD7A7:"zhuai", 0xD7A8:"zhuan", 

0xD7AE:"zhuang", 0xD7B5:"zhui", 0xD7BB:"zhun", 0xD7BD:"zhuo", 0xD7C8:"zi", 0xD7D7:"zong", 0xD7DE:"zou", 0xD7E2:"zu", 

0xD7EA:"zuan", 0xD7EC:"zui", 0xD7F0:"zun", 0xD7F2:"zuo"}; 
var spellArray = new Array(); 
var pn = "" ;
//huo qu han zi pinyin
function pinyin(char){ 
if (!char.charCodeAt(0) ||char.charCodeAt(0) < 1328) return char; 
if (spellArray[char.charCodeAt(0)]) return spellArray[char.charCodeAt(0)]; 
execScript("ascCode=hex(asc(\""+char+"\"))", "vbscript"); 
ascCode = eval("0x"+ascCode); 
if (!(ascCode>0xB0A0 && ascCode<0xD7FC)) return char; 
for (var i=ascCode; (!spell[i] && i>0);) i-- ;
return spell[i]; 
} 
//an pin zi shou zi mu pai xu diao yong fang fa
function toPinyinShengmu(str){ 
  var pStr = "" ;
  for (var i=0; i<str.length; i++){ 
   if (str.charAt(i) == "\n") pStr += ""; 
   else pStr += pinyin(str.charAt(i)).charAt(0) ; 
  } 
return pStr 
} 
//column index for sort
var indexCol;
function arrayCompare(array1, array2) {
  //alert(array1.length+"--"+array1[indexCol]);
    if (toPinyinShengmu(array1[indexCol]) < toPinyinShengmu(array2[indexCol])) {
		return -1;
	}
	if (toPinyinShengmu(array1[indexCol]) > toPinyinShengmu(array2[indexCol])) {
		return 1;
	}	
	return 0;
}
function arrayCompareNumber(array1, array2) {   
	if (parseInt(array1[indexCol]) < parseInt(array2[indexCol])) {
		return -1;
	}
	if (parseInt(array1[indexCol]) > parseInt(array2[indexCol])) {
		return 1;
	}
	return 0;
}
function arrayCompareDatetime(array1, array2) {
	if (str2date(array1[indexCol]) < str2date(array2[indexCol])) {
		return -1;
	}
	if (str2date(array1[indexCol]) > str2date(array2[indexCol])) {
		return 1;
	}
	return 0;
}
function arrayCompareDatetimeRev(array1, array2) {
	if (str2date(array1[indexCol]) < str2date(array2[indexCol])) {
		return 1;
	}
	if (str2date(array1[indexCol]) > str2date(array2[indexCol])) {
		return -1;
	}
	return 0;
}
function str2date(str) {
	var d = null;
	var reg = /^(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;
	if (arr = str.match(reg)) {
		d = new Date(Number(arr[1]), Number(arr[2]) - 1, Number(arr[3]), Number(arr[4]), Number(arr[5]), Number(arr[6]));
	}
	return d;
}
function date2str(d) {
	var ret = d.getFullYear() + "-";
	ret += ("00" + (d.getMonth() + 1)).slice(-2) + "-";
	ret += ("00" + d.getDate()).slice(-2) + " ";
	ret += ("00" + d.getHours()).slice(-2) + ":";
	ret += ("00" + d.getMinutes()).slice(-2) + ":";
	ret += ("00" + d.getSeconds()).slice(-2) + ".";
	return ret;
}
function arrayCompareRev(array1, array2) {

   if (toPinyinShengmu(array1[indexCol]) < toPinyinShengmu(array2[indexCol])) {
		return 1;
	}
	if (toPinyinShengmu(array1[indexCol]) > toPinyinShengmu(array2[indexCol])) {
		return -1;
	}	
	
	return 0;
}
function arrayCompareNumberRev(array1, array2) {
	if (parseInt(array1[indexCol]) < parseInt(array2[indexCol])) {
		return 1;
	}
	if (parseInt(array1[indexCol]) > parseInt(array2[indexCol])) {
		return -1;
	}
	return 0;
}
 
 //define a 2-dimension array 
function BiArray(rows, cols) {
  
  	//simulate multidimension array
	this.rows = rows;
	this.cols = cols;
  
  	//construct array
	var lines = new Array(rows);
	for (var i = 0; i < lines.length; i++) {
		lines[i] = new Array(2 * cols);
	}
	this.setElement = function (i, j, showValue, realValue) {
		lines[i][j] = showValue;
		lines[i][cols + j] = realValue;
	};
	this.getElement = function (i, j) {
		return lines[i][cols + j];
	};
	this.getLine = function (i) {
		return lines[i];
	};
	this.sortLine = function (j) {
		indexCol = j;
		lines.sort(arrayCompare);
	};
	this.sortLineByNumber = function (j) {
	    alert(j);
		indexCol = j;
		lines.sort(arrayCompareNumber);
	};
	this.sortLineRev = function (j) {
		indexCol = j;
		lines.sort(arrayCompareRev);
	};
	this.sortLineByNumberRev = function (j) {
		indexCol = j;
		lines.sort(arrayCompareNumberRev);
	};
	this.sortLineByDatetime = function (j) {
		indexCol = j;
		lines.sort(arrayCompareDatetime);
	};
	this.sortLineByDatetimeRev = function (j) {
		indexCol = j;
		lines.sort(arrayCompareDatetimeRev);
	};
	this.toString = function () {
		var rst = "";
		for (var i = 0; i < lines.length; i++) {
			for (var j = 0; j < lines[i].length; j++) {
				rst += lines[i][j];
				rst += "\t";
			}
			rst += "\n";
		}
		return rst;
	};
} // end of BiArray define
 
 //ascending or descending 
var asce = true;
var flag = true;
function sortTableInRange(tableId, sortCol, compareType, startRow, endRow, startCol, endCol) {
	try {	    
		var table = document.getElementById(tableId);
   		// get all row object of the table
		var objRows = table.getElementsByTagName("tr");
		
		//add by caizhicun
		if(flag){
				for (var k=0;k<objRows.length; k++){
					var atd='TD'+ k;
			   	 	atd = document.createElement("TD");
			    	atd.style.width="0px";
					objRows[k].appendChild(atd);
				}
				flag = false;
		}
		//add by caizhicun
		
   		//alert(objRows.length);
		endRow = (endRow < objRows.length ? endRow : objRows.length);
		var sortRows = endRow - startRow + 1;
   		//alert("sortRows "+sortRows);
		if (sortRows < 2) { //only one line,don't sort
			return;
		}
		endCol = (endCol < objRows[1].getElementsByTagName("td").length ? endCol : objRows[1].getElementsByTagName("td").length);
		

 	 	// column number of sort
   		//var cols = objRows[1].childNodes.length;
		var cols = endCol - startCol + 1;
    
   		// define a array to store table cell and sort them
		var tabData = new BiArray(sortRows, cols);
		var ari = 0;
   		// retrived table cell data save to array
		for (i = startRow - 1; i < endRow; i++) {
    		//retrived all <td> cell
			var cells1 = objRows[i].getElementsByTagName("td");
			var arj = 0;
			var itemValue;  //  the data can been seen in HTML. for example: <td> <A HREF="">XXX  </A> </td>  .  itemValue="XXX"
			var showItemValue;   //  the actual data in HTML. for example:<td> <A HREF="">XXX  </A> </td>  .  showItemValue="<A HREF= >XXX  </A>"
			for (var j = startCol - 1; j < endCol; j++) {
				showItemValue = cells1.item(j).innerHTML;
				var cells3 = cells1.item(j).getElementsByTagName("label");     //<td> <label>XXX  </label> </td>
				if (cells3.length == 0) {
					var cells = cells1.item(j).getElementsByTagName("A");    //<td> <A HREF="">XXX  </A> </td>
					if (cells.length == 0) {
						cells = cells1.item(j).getElementsByTagName("div");   //<td> <DIV>XXX  </DIV> </td>
						if (cells.length == 0) {
							cells = cells1;
							itemValue = cells.item(j).innerHTML;
						} else {
							var cells2 = cells.item(0).getElementsByTagName("nobr");  //<td> <NOBR>XXX  </NOBR> </td>
							if (cells2.length == 0) {
								itemValue = cells.item(0).innerHTML;
							} else {
								itemValue = cells2.item(0).innerHTML;
							}
						}
					} else {
						cells = cells1.item(j).getElementsByTagName("A");
						itemValue = cells.item(0).innerHTML;
					}
				} else {
					itemValue = cells3.item(0).innerHTML;
				}
				tabData.setElement(ari, arj, itemValue, showItemValue);
				arj++;
			}
		
			//add by caizhicun
				//showItemValue=objRows[i].style.backgroundColor;
				showItemValue=objRows[i].bgColor;
				//itemValue=objRows[i].style.backgroundColor;
				itemValue=objRows[i].bgColor;
				tabData.setElement(ari, endCol-1, itemValue, showItemValue);
			//add by caizhicun
			ari++;
		}
		if (asce) {
			if (compareType == "n" || compareType == "N") {
				tabData.sortLine(sortCol - startCol);
			} else {
				if (compareType == "s" || compareType == "S") {
					tabData.sortLine(sortCol - startCol);
				} else {
					if (compareType == "d" || compareType == "D") {
						tabData.sortLineByDatetime(sortCol - startCol);
					}
				}
			}
			asce = false;
		} else {
			if (compareType == "n" || compareType == "N") {
				tabData.sortLineRev(sortCol - startCol);
			} else {
				if (compareType == "s" || compareType == "S") {
					tabData.sortLineRev(sortCol - startCol);
				} else {
					if (compareType == "d" || compareType == "D") {
						tabData.sortLineByDatetimeRev(sortCol - startCol);
					}
				}
			}
			asce = true;
		}
		ari = 0;
   		//update table data with array
		for (i = startRow - 1; i < endRow; i++) {
    		//retrived all <td> cell
			var cells = objRows[i].getElementsByTagName("td");
			arj = 0;
			for (var j = startCol - 1; j < endCol-1; j++) {
				cells.item(j).innerHTML = tabData.getElement(ari, arj);
				var cells4 = cells.item(j).getElementsByTagName("label"); 
				if(cells4.length == 0){
					var cells5 = cells.item(j).getElementsByTagName("A");
						if (cells5.length == 0){
							 var cells6 = cells.item(j).getElementsByTagName("div");
							   if (cells6.length == 0){
							   		cells.item(j).title=""; 
							   }else{
							   			var cells7 = cells.item(j).getElementsByTagName("nobr"); 
							          		if (cells7.length == 0) {
								           	 	cells.item(j).title=cells6.item(0).innerHTML;
						      	           } else {
								          	 	cells.item(j).title=cells7.item(0).innerHTML;
							               }
							   		}
						}else{
							cells.item(j).title=""; 
						}
				}else{
					cells.item(j).title=cells4.item(0).innerHTML; 
					
				}
				arj++;
			}
			
			objRows[i].style.backgroundColor=tabData.getElement(ari, endCol-1);
			objRows[i].bgColor=tabData.getElement(ari, endCol-1);
			ari++;
		}
	}
	catch (e) {
		alert(e);
	}
}
function sortTable(tableId, sortCol, compareType) {
	try {
		var table = document.getElementById(tableId);
   		// get all row object of the table
		var objRows = table.getElementsByTagName("tr");
   		//alert(objRows.length);
		var endRows = objRows.length;
		if (endRows < 2) { //only one line,don't sort
			return;
		}
   
   		// column number of table
		var cols = objRows[1].getElementsByTagName("td").length;
		sortTableInRange(tableId, sortCol, compareType, 2, endRows, 1, cols);
	}
	catch (e) {
		alert(e);
	}
}
function sortTable(tableId, sortCol, compareType, endRows) {
	try {
		var table = document.getElementById(tableId);
   		// get all row object of the table
		var objRows = table.getElementsByTagName("tr");
		//add by liyaquan
		if(objRows.length<2){
			return;
		}
   		//alert(objRows.length);
   
   
   		//var endRows = objRows.length;
		if (endRows < 2) { //only one line,don't sort
			return;
		}
   
   		// column number of table
		var cols = objRows[1].getElementsByTagName("td").length;
		sortTableInRange(tableId, sortCol, compareType, 2, endRows, 1, cols);
	}
	catch (e) {
		alert(e);
	}
}
 
 //��ͨ���
function sortTableSTS(tableId, sortCol, compareType, startRows, endRows) {
	try {
		var table = document.getElementById(tableId);
   		// get all row object of the table
		var objRows = table.getElementsByTagName("tr");
   		//alert(objRows.length);
		var endRows = objRows.length;
		if (endRows < 2) { //only one line,don't sort
			return;
		}
   
   		// column number of table
		var cols = objRows[1].getElementsByTagName("td").length;
   		//alert(cols);
		for (var i = 2; i < startRows; i++) {
			endRows++;
			cols++;
		}
		sortTableInRangeSTS(tableId, sortCol, compareType, startRows, endRows, 1, cols);
	}
	catch (e) {
		alert(e);
	}
}
 
 //��ͨ���
function sortTableInRangeSTS(tableId, sortCol, compareType, startRow, endRow, startCol, endCol) {
	try {
		var table = document.getElementById(tableId);
   		// get all row object of the table
		var objRows = table.getElementsByTagName("tr");
   		//alert(objRows.length);
		endRow = (endRow < objRows.length ? endRow : objRows.length);
		var sortRows = endRow - startRow + 1;
   		//alert("sortRows "+sortRows);
		if (sortRows < 2) { //only one line,don't sort
			return;
		}

		endCol = (endCol < objRows[1].getElementsByTagName("td").length ? endCol : objRows[1].getElementsByTagName("td").length);
		endCol = endCol + startRow - 2;

   		// column number of sort
   		//var cols = objRows[1].childNodes.length;
		var cols = endCol - startCol + 1;
    
   
    
   		// define a array to store table cell and sort them
		var tabData = new BiArray(sortRows, cols);
		var ari = 0;
  		// retrived table cell data save to array
		for (i = startRow - 1; i < endRow; i++) {
    		//retrived all <td> cell
			var cells1 = objRows[i].getElementsByTagName("td");
			var arj = 0;
			var itemValue;  //  the data can been seen in HTML. for example: <td> <A HREF="">XXX  </A> </td>  .  itemValue="XXX"
			var showItemValue;   //  the actual data in HTML. for example:<td> <A HREF="">XXX  </A> </td>  .  showItemValue="<A HREF= >XXX  </A>"
			for (var j = startCol - 1; j < endCol; j++) {
				showItemValue = cells1.item(j).innerHTML;
				var cells3 = cells1.item(j).getElementsByTagName("label");     //<td> <label>XXX  </label> </td>
				if (cells3.length == 0) {
					var cells = cells1.item(j).getElementsByTagName("A");    //<td> <A HREF="">XXX  </A> </td>
					if (cells.length == 0) {
						cells = cells1.item(j).getElementsByTagName("div");   //<td> <DIV>XXX  </DIV> </td>
						if (cells.length == 0) {
							cells = cells1;
							itemValue = cells.item(j).innerHTML;
						} else {
							var cells2 = cells.item(0).getElementsByTagName("nobr");  //<td> <NOBR>XXX  </NOBR> </td>
							if (cells2.length == 0) {
								itemValue = cells.item(0).innerHTML;
							} else {
								itemValue = cells2.item(0).innerHTML;
							}
						}
					} else {
						cells = cells1.item(j).getElementsByTagName("A");
						itemValue = cells.item(0).innerHTML;
					}
				} else {
					itemValue = cells3.item(0).innerHTML;
				}
				tabData.setElement(ari, arj, itemValue, showItemValue);
				arj++;
			}
			ari++;
		}
		if (asce) {
			if (compareType == "n" || compareType == "N") {
				tabData.sortLineByNumber(sortCol - startCol);
			} else {
				if (compareType == "s" || compareType == "S") {
					tabData.sortLine(sortCol - startCol);
				} else {
					if (compareType == "d" || compareType == "D") {
						tabData.sortLineByDatetime(sortCol - startCol);
					}
				}
			}
			asce = false;
		} else {
			if (compareType == "n" || compareType == "N") {
				tabData.sortLineByNumberRev(sortCol - startCol);
			} else {
				if (compareType == "s" || compareType == "S") {
					tabData.sortLineRev(sortCol - startCol);
				} else {
					if (compareType == "d" || compareType == "D") {
						tabData.sortLineByDatetimeRev(sortCol - startCol);
					}
				}
			}
			asce = true;
		}
		ari = 0;
   		//update table data with array
		for (i = startRow - 1; i < endRow; i++) {
    		//retrived all <td> cell
			var cells = objRows[i].getElementsByTagName("td");
			arj = 0;
			for (var j = startCol - 1; j < endCol; j++) {
				cells.item(j).innerHTML = tabData.getElement(ari, arj);
				arj++;
			}
			ari++;
		}
	}
	catch (e) {
		alert(e);
	}
}

