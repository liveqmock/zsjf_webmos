package com.cattsoft.pub;

public class SysConstants {

	//
	public static final String YES = "1";

	public static final String NO = "0";

	// 在用和注销
	public static final String USE_YES_STS = "A";

	public static final String USE_NO_STS = "P";

	// 有无条件退单方式
	public static final String SO_RETURN_TYPE = "1";// 1:无条件 0：有条件

	// 竣工环节
	public static final String STEP_FOR_SO_FINISH = ""; // 

	public static final String ONE = "1";

	// 异常编码
	public static final String EXP_CODE = "EXP_CODE";

	public static final String EXP_MSG = "EXP_MSG";

	/** ****************************************定单类************************************* */
	// 定单状态
	public static final String SO_WAIT_UPD_CANCEL = "K";// 等待撤改

	public static final String SO_SUSPEND = "s";// 缓装

	public static final String SO_GIVEWAY = "g";// 撤销处理中

	public static final String SO_MODIFY = "h";// 改单处理中

	public static final String SO_BIDE = "Y";// 待装

	public static final String SO_PROCESSING = "P";// 正常处理中

	public static final String SO_EXPLORATION = "V";// 外堪

	public static final String SO_RETURN_FAIL = "F";// 退单处理中

	public static final String SO_BE_ABOUT_TO = "A";// 就绪

	public static final String SO_WAIT_CHOICE_PROC = "W";// 等待选择流程

	public static final String SO_MATCH_FAIL = "M";// 模版匹配失败

	public static final String SO_WAIT_START = "D";// 等待启动流程

	public static final String SO_START_ERROR = "E";// 启动流程失败

	public static final String SO_FUTILITY = "R";// 失效

	public static final String SO_FINISH = "C";// 失效

	// 定单类型
	public static final String SO_TYPE_FUTILITY = "1";// 注销单

	public static final String SO_TYPE_MODIFY = "2";// 修改单

	public static final String SO_TYPE_NORMAL = "0";// 正常单

	public static final String SO_TYPE_FOR_WAIT = "3";// 缓装单

	public static final String SO_TYPE_FOR_AGAIN = "4";// 开装单

	// 工单回单方式
	public static final String WO_RET_SUCCESS = "0";// 正常回单

	public static final String WO_RET_FAIL = "1";// 失败回单

	// 撤单的处理方式
	public static final int BIDE_TYPE = 1;// 待装处理方式

	// 定单的执行方式
	public static final String SO_AUTO_EXEC = "A";// 自动启动流程

	public static final String SO_UN_AUTO_EXEC = "M";// 人工选择流程

	// 定单组类型
	public static final String GROUP_FLAG_FOR_YES = "Y";// 组标志

	public static final String GROUP_FLAG_FOR_NO = "N";// 非组标志

	// 退单允许标志
	public static final String CANCEL_FLAG_FOR_NO = "1";// 不允许

	public static final String CANCEL_FLAG_FOR_YES = "0";// 允许

	// 调用方式
	public static final String CALL_FLAG_FOR_JAVA = "J";// JAVA调用

	public static final String CALL_FLAG_FOR_PROCDURE = "P";// 存储过程调用

	// 定单锁定状态
	public static final String SO_LOCK_STS_NO = "N";// 未锁定

	public static final String SO_LOCK_STS_YES = "Y";// 锁定

	public static final String SO_LOCK_STS_CANCEL_SO = "H";// 撤单锁定

	public static final String SO_LOCK_STS_CHANGE_SO = "G";// 改单锁定

	public static final String SO_LOCK_STS_DELAY_SO = "S";// 缓装锁定

	// 调用工作流的方式
	public static final String CALL_TYPE_FOR_START_PROCESS = "0";// 启动流程

	public static final String CALL_TYPE_FOR_FAIL_REASON = "1";// 启动流程

	// 消息处理标志 MSG_FLAG
	public static final String SO_MSG_FLAG_NOT_PROCESS = "0";// 0 尚未处理

	public static final String SO_MSG_FLAG_SUCCESS_PROCESS = "1";// 1 处理成功

	public static final String SO_MSG_FLAG_FAIL_PROCESS = "2";// 2 处理失败

	// SO_RES分配标志
	public static final String ASSIGN_FLAG_RES_ASSIGN = "Y";// Y 资源分配产生

	public static final String ASSIGN_FLAG_CRM_ASSIGN = "N";// N 上游携带数据

	// SO_RES自我标志
	public static final String SO_RES_IS_SELF_YES = "Y";// Y 是

	public static final String SO_RES_IS_SELF_NO = "N";// N 否，关联的

	// SO SO_SEQ
	public static final String SO_SEQ_DEFAULT = "0";

	// 收费状态 PAY_STS C1 Y
	public static final String SO_PAY_STS_YES = "Y";// Y 已收费

	public static final String SO_PAY_STS_NO = "N";// N 未收费

	/** ************************工单类**************************************************************************** */
	// 工单业务状态
	public static final String BUSI_STS_BIDE = "Y";// 待装

	public static final String BUSI_STS_NORMAL = "N";// 正常

	public static final String BUSI_STS_FAIL = "F";// 失败回单

	public static final String BUSI_STS_AUDIT = "A";// 等待审核

	public static final String BUSI_STS_STAY = "S";// 失败滞留

	public static final String BUSI_STS_REMOKE = "K";// 等待撤改

	public static final String WO_WORK_MODE_MANUAL = "M"; // 人工

	public static final String WO_WORK_MODE_AUTO = "A"; // 自动

	// 工单过程状态
	public static final String RUN_STS_PROCESSING = "P";// 处理中

	public static final String RUN_STS_COMPLETE = "C";// 完成

	public static final String RUN_STS_WAIT_PROCESS = "D";// 等待处理

	public static final String RUN_STS_WAIT_RETURN = "W";// 准备回单

	public static final String RUN_STS_REVOKE = "R";// 已经作废

	public static final String RUN_STS_DISP_FAIL = "I";// 调度失败

	// 方向标志
	public static final String DIRECTION_FORWORD = "0";// 正向

	public static final String DIRECTION_INVERT = "1";// 反向

	// 退单原因类型
	public static final String FAIL_REASON_FOR_FAIL = "A";// 失败

	public static final String FAIL_REASON_FOR_EXP = "K";// 外勘

	public static final String FAIL_REASON_FOR_WAIT = "W";// 待装

	public static final String FAIL_REASON_FOR_OVER = "B";// 超期

	// 工单审核标志
	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_NEED_AUDIT = "A";// 需要审核

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_WAIT_WITHDRAW = "K";// 等待撤改

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_RETURN = "F";// 失败回单

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_STAY = "S";// 失败滞留

	// 审核通过标志
	public static final String PASS_AUDIT = "Y";// 审核通过

	public static final String UN_PASS_AUDIT = "N";// 审核不通过

	// 系统标识
	public static final String SYSTEM_CRM = "CRM";// 综合客服系统

	public static final String SYSTEM_SPS = "SPS";// 服务开通

	public static final String SYSTEM_RMS = "RMS";// 资源系统

	public static final String SYSTEM_NAS = "NAS";// 网络激活系统

	public static final int DEFAULT_PAGE_SIZE = 15;

	public static final int DEFAULT_PAGE_SIZE_FOR_WORETURN = 50;// 施工处理界面每页显示记录数

	// 环节类型
	public static final String TWO = "2";// 

	// 工单类型
	public static final String WO_TYPE_FOR_RETURN = "B";// 退单

	public static final String WO_TYPE_FOR_SURVEY = "P"; // 外勘单

	public static final String WO_TYPE_FOR_BIDE = "Y"; // 待装单

	public static final String WO_TYPE_FOR_NEED_PROC = "H"; // 崔单

	public static final String WO_TYPE_FOR_GO_BACK = "F"; // 追单

	public static final String WO_TYPE_FOR_NORMAL = "N"; // 正常单

	// 锁定标志
	public static final String HALT_FLAG_FOR_UN_HALT = "N"; // 没有锁定

	// 动态标志
	public static final String DYN_FLAG_FOR_YES = "Y"; // 动态

	public static final String DYN_FLAG_FOR_NO = "N"; // 非动态

	// 预约标志
	public static final String BOOK_FLAG_FOR_YES = "Y"; // 预约

	public static final String BOOK_FLAG_FOR_NO = "N"; // 非预约

	// 派单方式
	public static final String TABLE_NAME_FOR_EXCH_ID = "E"; // 按局向

	public static final String TABLE_NAME_FOR_LOCAL_NET_ID = "L"; // 按本地网

	public static final String TABLE_NAME_FOR_AREA_ID = "A"; // 按服务区

	// 动作类型
	public static final String ACT_TYPE_FOR_LOAD = "A"; // 装

	public static final String ACT_TYPE_FOR_REMOVE = "R"; // 拆

	// 主从单标志
	public static final String MAIN_FLAG_FOR_MAIN = "M"; // 主单

	public static final String MAIN_FLAG_FOR_SUITE = "S"; // 从单

	// 完整性标志
	public static final String FULL_FLAG_FOR_ALL = "C"; // 从单

	// 预约通知方式
	public static final String NOTIFY_FLAG_FOR_YES = "Y"; // 已经通知

	public static final String NOTIFY_FLAG_FOR_NO = "N"; // 未通知

	// 合单标志
	public static final String MERG_FLAG_FOR_ALREADY_MERGE = "Y"; // 已经合单

	public static final String MERG_FLAG_FOR_NO_MERGE = "N"; // 还没有合单

	public static final String MERG_FLAG_FOR_NO_NEED_MERGE = "W"; // 不需合单

	// 工单处理标志

	public static final String MSG_FLAG_NO_PROCESS_ = "0"; // 没有处理

	public static final String MSG_FLAG_PROCESS_SUCCESS = "1"; // 处理成功

	public static final String MSG_FLAG_PROCESS_FAIL = "2"; // 处理失败
	
	
	public static final String WO_RET_CODE_SUCCESS = "1";//成功回单
	
	public static final String WO_RET_CODE_FAIL = "0";//成功回单	
	
	

	/** *************************开通配置类*********************************** */

	// 环节类型
	public static final String STEP_TYPE_FOR_SYSTEM = "SC"; // 系统活动

	public static final String STEP_TYPE_FOR_ACCEPT = "SO"; // 受理

	public static final String STEP_TYPE_FOR_SERVICE_DEVISE = "SD"; // 服务设计

	public static final String STEP_TYPE_FOR_RESOUSE_ALLOCATE = "RA"; // 资源分配

	public static final String STEP_TYPE_FOR_SERVICE_CONFIG = "SP"; // 服务配置

	public static final String STEP_TYPE_FOR_SERVICE_ACTIVE = "SA"; // 服务激活

	// 环节游离标志
	public static final String PLUS_FLAG_FOR_NORMAL = "0"; // 正常

	public static final String PLUS_FLAG_FOR_UN_NORMAL = "1"; // 非正常

	// 环节类型
	public static final String PLUS_TYPE_FOR_SURVEY = "E"; // 外堪

	public static final String PLUS_TYPE_FOR_BIDE = "W"; // 待装

	// 合单标志
	public static final String MERG_FLAG_FOR_NEED = "Y"; // 需要合单

	public static final String MERG_FLAG_FOR_UN_NEED = "N"; // 不合单

	// 匹配类型 MATCH_TYPE

	public static final String MATCH_TYPE_BUSI_RULE = "R";// R 业务规则

	public static final String MATCH_TYPE_SYS_ITEM = "P";// P 系统元素

	// 运算符 MATCH_OPERATOR
	public static final String MATCH_OPERATOR_EQUAL = "=";// = 等于，

	public static final String MATCH_OPERATOR_UNEQUAL = "!=";// != 不等于，

	public static final String MATCH_OPERATOR_MORE_THAN = ">";// > 大于，

	public static final String MATCH_OPERATOR_MORE_THAN_AND_EQUAL = ">=";// >=大于等于，

	public static final String MATCH_OPERATOR_LESS_THAN = "<";// < 小于，

	public static final String MATCH_OPERATOR_LESS_THAN_AND_EQUAL = "<=";// <=小于等于

	public static final String MATCH_OPERATOR_INCLUDE = "IN";// IN 包含，

	public static final String MATCH_OPERATOR_NOT_INCLUDE = "NOT IN";// NOT

	// 适用定单模板匹配 FOR_SO_MATCH C1 NULL Y Y 适用N 不适用
	public static final String FOR_SO_MATCH_YES = "Y";

	public static final String FOR_SO_MATCH_NO = "N";

	// 开关标志
	public static final String OPEN_FLAG_OPEN = "O";// O 启用，打开

	public static final String OPEN_FLAG_CLOSE = "C";// C 禁用，关闭

	/** *******************施工处理页面*************************************************** */
	// 施工处理页面
	public static final String Wo_BACK = "WoReturn";// 回单页面

	public static final String WO_FETCH = "WoFetchUnBook";// 领单页面

	public static final String WO_PRESS = "WoPress";// 催单页面

	public static final String WO_NOT_DUE = "WoFetchBook";// 预约页面

	public static final String WO_EXCEPTION = "WoException";// 异常工单页面

	/** **************************sysconfig配置的类型******************************************* */
	// sysconfig配置的类型
	public static final String SYS_CONFIG_TYPE_PROVINCE = "G";// 全省统一的类型

	public static final String SYS_CONFIG_TYPE_LOCALNET = "L";// 本地网统一的类型

	public static final String SYS_CONFIG_TYPE_AREA = "A";// 服务区统一的类型

	public static final String SYS_CONFIG_TYPE_WORKAREA = "W";// 工作区统一

	public static final String SYS_CONFIG_TYPE_EXCH = "E";// 局向统一

	/** ************************************************SEQ********************************************* */

	// SEQ
	public static final String SO_TEMPLATE_ID_SEQ = "SO_TEMPLATE_ID";

	public static final String INTER_CALL_CONFIG_ID_SEQ = "INTER_CALL_CONFIG_ID";

	public static final String SO_MATCH_ID_SEQ = "SO_MATCH_ID";

	public static final String SO_PROCESS_ID_SEQ = "SO_PROCESS_ID";

	public static final String FAIL_REASON_ID_SEQ = "FAIL_REASON_ID";// 异常原因配置

	public static final String STEP_REASON_ID_SEQ = "STEP_REASON_ID";

	public static final String COLLAB_RULE_ID_SEQ = "COLLAB_RULE_ID";// 协同规则序列

	public static final String COLLAB_RULE_BUSI_ID_SEQ = "COLLAB_RULE_BUSI_ID";// 协同规则业务序列

	public static final String WORK_TYPE_ID_SEQ = "WORK_TYPE_ID";// 工区类型序列

	public static final String WO_HANDLE_CUSTOM_SEQ = "WO_HANDLE_CUSTOM";// 施工处理界面定制序列

	public static final String QUERY_CONFIG_ID_SEQ = "QUERY_CONFIG_ID";// 查询条件

	public static final String INTER_SERVICE_ORDER_ID_SEQ = "INTER_SERVICE_ORDER_ID";// 服务定单接口表序列

	public static final String PROCESS_COLLAB_RULE_ID_SEQ = "PROCESS_COLLAB_RULE_ID";// 流程协同规则编号

	public static final String STEP_COLLAB_RULE_ID_SEQ = "STEP_COLLAB_RULE_ID";// 环节协同规则编号

	public static final String SO_BOOK_ID_SEQ = "SO_BOOK_ID";// 定单预约编号

	public static final String SO_CHARGE_ID_SEQ = "SO_CHARGE_ID";// 定单费用信息编号

	public static final String WO_NBR_SEQ = "WO_NBR";// 工单号码

	public static final String CUST_ORDER_ITEM_ID_SEQ = "CUST_ORDER_ITEM_ID";// 客户订单明细

	public static final String CUST_ORDER_BUSINESS_ID_SEQ = "CUST_ORDER_BUSINESS_ID";// 客户订单与服务定单关系

	public static final String SO_SI_GROUP_MEMBER_ID_SEQ = "SO_SI_GROUP_MEMBER_ID";// 定单服务实例组成员

	public static final String SO_SI_GROUP_ID_SEQ = "SO_SI_GROUP_ID";// 定单服务实例组

	public static final String SO_RELA_ID_SEQ = "SO_RELA_ID";// 定单关联信息

	public static final String SO_MAIN_PROD_ID_SEQ = "SO_MAIN_PROD_ID";// 定单主产品信息

	public static final String SO_PRICE_PLAN_ID_SEQ = "SO_PRICE_PLAN_ID";// 定单价格计划编号

	public static final String SO_SUB_PROD_ID_SEQ = "SO_SUB_PROD_ID";// 定单附属产品信息编号

	public static final String SO_ACC_NBR_ID_SEQ = "SO_ACC_NBR_ID";// 定单号码实例编号

	public static final String SO_ADDR_ID_SEQ = "SO_ADDR_ID";// 定单地址编号

	public static final String SO_EQPT_PROD_ID_SEQ = "SO_EQPT_PROD_ID";// 定单终端设备信息编号

	public static final String SO_EQPT_PRPTY_ID_SEQ = "SO_EQPT_PRPTY_ID";// 定单终端设备属性信息编号

	public static final String SO_MAIN_PROD_PRPTY_ID_SEQ = "SO_MAIN_PROD_PRPTY_ID";// 定单主产品属性信息编号

	public static final String SO_MAIN_PROD_PRPTY_EXT_ID_SEQ = "SO_MAIN_PROD_PRPTY_EXT_ID";// 主产品属性扩展编号

	public static final String SO_SUB_PROD_PRPTY_ID_SEQ = "SO_SUB_PROD_PRPTY_ID";// 定单附属产品属性信息编号

	public static final String SO_SUB_PROD_PRPTY_EXT_ID_SEQ = "SO_SUB_PROD_PRPTY_EXT_ID";// 定单附属产品属性扩展编号

	public static final String SO_PROD_PAUSE_ID_SEQ = "SO_PROD_PAUSE_ID";// 定单产品停复信息编号

	public static final String SO_CUST_ID_SEQ = "SO_CUST_ID";// 定单客户信息编号

	public static final String WO_HANDLE_SEQ = "WO_HANDLE_ID";// 工单操作记录表

	public static final String MSG_ID_SEQ = "MSG_ID";// 定单匹配消息 SO_MSG_CENTER

	public static final String ACTION_LOG_SEQ = "ACTION_ID";// 定单匹配消息

	public static final String INTER_MSG_CENTER_ID_SEQ = "INTER_MSG_ID";// 定单解析消息表

	public static final String STEP_COLLAB_INST_ID_SEQ = "STEP_COLLAB_INST_ID";// 环节协调规则实例编号

	public static final String PROCESS_COLLAB_INST_ID_SEQ = "PROCESS_COLLAB_INST_ID";// 流程协调规则实例编号

	public static final String SO_SI_GROUP_MEM_PRPTY_ID_SEQ = "SO_SI_GROUP_MEM_PRPTY_ID";// 定单服务实例组成员属性编号

	public static final String SO_RES_ID_SEQ = "SO_RES_ID";// 定单资源实例编号

	public static final String RES_NWKSEG_ID_SEQ = "RES_NWKSEG_ID";// 资源网段编号

	public static final String XMLHEADER_SERIALNO_FOR_RMS_SEQ = "XMLHEADER_SERIALNO_FOR_RMS";// 资源接口操作序列

	public static final String SO_NBR_SEQ = "SO_NBR";// 定单号码

	public static final String SO_IP_ADDR_ID_SEQ = "SO_IP_ADDR_ID";// IP地址信息编号

	public static final String SO_USERNAME_ID_SEQ = "SO_USERNAME_ID";// 定单帐户密码编号

	/** *******************工作流接口参数*********************************** */
	// 事件
	public static final String PROC_START = "PROC_START";

	public static final String PROC_PAUSE = "PROC_PAUSE";

	public static final String PROC_CANCEL = "PROC_CANCEL";

	public static final String PROC_CONTINUE = "PROC_CONTINUE";

	public static final String WORKITEM_SUCCESS = "WORKITEM_SUCCESS";

	public static final String WORKITEM_FAIL = "WORKITEM_FAIL";

	// 过程关系类型
	public static final String RELA_TYPE_FOR_MODIFY = "3";

	public static final String RELA_TYPE_FOR_REMOKE = "4";

	// 工作流返回结果定义
	public static final String RET_CODE_DO_SUCCESSED = "0";// 处理成功 （包括工作项和流程）

	// 流程类

	public static final String RET_CODE_PROC_INEXIST = "1";// 流程不存在

	// 工作项类
	public static final String RET_CODE_STOP_CURRENT_STEP = "2";// 停留当前环节（异常处理类型为滞留当前环节）

	public static final String RET_CODE_EXCEPTION_PROCE_INEXIST = "3";// 查询不到异常流程

	public static final String RET_CODE_RETURN_START_SYSTEM = "4"; // 返回发起系统（异常流程处理类型为回退到发起系统）

	public static final String RET_CODE_REVERSE_WORKITEM_NOFAILED = "5";// 反向工作项不能失败回单

	public static final String RET_CODE_REVERSE_EXEC_SUCCESSFUL = "6";// 当前工作项已经成功执行，不能够再次回单。

	// 时时标志
	public static final String REAL_TIME = "1";// 时时

	public static final String UN_REAL_TIME = "0";// 时时

	// 查询条件的页面数设置
	public static final String ROWS_PER_PAGE = "20";

	// 服务开通返回工作流参数说明
	public static final String EXEC_SUCCESS = "EXECUTE_OK"; // 执行成功

	public static final String DISPATCH_SUCCESS = "DISPATCH_OK"; // 派发成功

	/** *******************CRM接口参数*********************************** */
	// 新旧标志 NO_FLAG
	public static final String NO_FLAG_NEW = "A";// A 新

	public static final String NO_FLAG_OLD = "P";// P 旧

	// 客户来源 CUST_SOURCE
	public static final String CUST_SOURCE_BY_SELF = "A";// A 自我发展

	public static final String CUST_SOURCE_BY_RIVAL = "B";// B 竞争对手

	// 社区经理确认标志 CONFIG_FLAG
	public static final String CONFIG_FLAG_YES = "0";// 0:没有确认

	public static final String CONFIG_FLAG_NO = "1";// 1:已经确认

	// 预约变更次数 BOOK_COUNT
	public static final String BOOK_COUNT_DEFAULT = "1";

	// 客户订单（CUST_ORDER）状态 STS
	public static final String CUST_ORDER_STS_NEW = "A";// A 新建

	public static final String CUST_ORDER_STS_ACC_ING = "B";// B 受理中

	public static final String CUST_ORDER_STS_ACC_ED = "C";// C 已受理

	public static final String CUST_ORDER_STS_DISUSE = "D";// D 作废

	public static final String CUST_ORDER_STS_FINISH = "E";// E 已竣工

	public static final String CUST_ORDER_STS_SEPARATE = "R";// R 离包

	// 客户订单与服务定单关系（CUST_ORDER_BUSINESS）
	public static final String CUST_ORDER_BUSINESS_USE = "A";// 再用

	public static final String CUST_ORDER_BUSINESS_UNUSE = "D";// 作废

	public static final String CUST_ORDER_BUSINESS_SEPARATE = "R";// 离包

	// 定单接收状态（inter_serviece_ORDER 状态 ）
	public static final String STS_ACCEPT_SUCCESS = "A";// 定单接收成功

	public static final String STS_ANALYSIS_LOCK = "B";// 定单解析锁定

	public static final String STS_AFREASH_LOCK = "F";// 定单解析锁定

	public static final String STS_ANALYSIS_SUCCESS = "C";// 定单解析成功

	public static final String STS_ANALYSIS_FAIL = "D";// 定单解析失败

	public static final String STS_ERROR = "Z";// 数据错误返回CRM成功

	public static final String STS_RETURN_ERROR = "Y";// 数据错误返回CRM失败

	// 客户订单明细订购类型 ITEM_TYPE
	public static final String ITEM_TYPE_PROD_NEW = "A";// A 产品新购

	public static final String ITEM_TYPE_SERV_CHANGE = "B";// B 服务变更

	// 自我标志
	public static final String IS_SELF_YES = "Y";// Y 是

	public static final String IS_SELF_NO = "N";// N 否，关联的

	// 人工施工岗类型
	public static final String MAN_WORK_TYPE_ID = "6";// Y 是

	// isSelf 0:关联实例 1:实例本身 2:改前产品实例
	public static final String IS_SELF_REL = "0";

	public static final String IS_SELF_SEL = "1";

	public static final String IS_SELF_BEF = "2";

	// 变更标志 Y 有变更 N 未变更
	public static final String CHANGED_FLAG_YES = "Y";

	public static final String CHANGED_FLAG_NO = "N";

	// 主副标志 IS_MAIN Y 主产品 N 附属产品
	public static final String IS_MAIN_YES = "Y";

	public static final String IS_MAIN_NO = "N";

	// 定单接收状态
	public static final String SO_ANALYSIS_SECCESS = "C";

	public static final String SO_ANALYSIS_FAIL = "D";

	// 定单类型
	public static final String RELATED_TYPE_FUTILITY = "1";// 注销单

	public static final String RELATED_TYPE_MODIFY = "2";// 修改单

	public static final String RELATED_TYPE_NORMOY = "0";// 正常单

	public static final String RELATED_TYPE_FOR_WAIT = "3";// 缓装单

	public static final String RELATED_TYPE_FOR_AGAIN = "4";// 开装单

	// 定单返回给CRM结果状态
	public static final String RESULT_CODE_SUCCESS = "0";// 成功

	public static final String RESULT_CODE_FAIL = "1";// 失败

	// 撤单，改单结果
	public static final String AUDIT_PASS = "0";// 成功

	public static final String AUDIT_UN_PASS = "1";// 失败

	// 回传CRM订单返回类型

	public static final String SO_RETURN_TYPE_FINISH = "C";// 竣工返回

	public static final String SO_RETURN_TYPE_BACK = "T";// 退单返回

	public static final String SO_RETURN_TYPE_FAIL = "F";// 解析失败返回

	public static final String SO_RETURN_TYPE_REMOVE = "E";// 撤单完成返回

	// 撤单类型
	public static final String EXPT_TYPE_SO_MODIFY = "2";// 修改单

	public static final String EXPT_TYPE_FUTILITY = "1";// 注销单

	public static final String EXPT_TYPE_RE_RECEIVE = "6";// 重发单

	public static final String EXPT_TYPE_RELE_RES = "7";// 资源释放

	/** *********************************资源接口***************************************** */
	// 接口编码(_EID)
	public static final String EID_RES_SO_SYNC_SERV_REQ = "RES_SO_SYNC_SERV_REQ";// 定单同步请求

	public static final String EID_RES_SO_SYNC_SERV_RESP = "RES_SO_SYNC_SERV_RESP";// 定单同步返回

	public static final String EID_RES_DSGN_SERV_REQ = "RES_DSGN_SERV_REQ";// 服务设计请求

	public static final String EID_RES_DSGN_SERV_RESP = "RES_DSGN_SERV_RESP";// 服务设计返回

	public static final String EID_RES_QRY_SERV_REQ = "RES_QRY_SERV_REQ";// 查询资源服务请求

	public static final String EID_RES_ASGN_SERV_REQ = "RES_ASGN_SERV_REQ";// 分配资源服务请求

	public static final String EID_RES_CNL_SERV_REQ = "RES_CNL_SERV_REQ";// 撤除资源服务请求

	public static final String EID_RES_SO_REVERSE_REQ = "RES_SO_REVERSE_REQ";// 定单反向请求

	public static final String EID_RES_ASGN_SERV_RESP = "RES_ASGN_SERV_RESP";// 分配资源服务返回

	public static final String EID_RES_ARC_SERV_REQ = "RES_ARC_SERV_REQ";// 归档服务请求

	public static final String EID_RES_ARC_SERV_RESP = "RES_ARC_SERV_RESP";// 归档服务返回

	public static final String EID_RES_CHECK_REQ = "RES_CHECK_REQ";// 资源质检请求

	public static final String EID_RES_CHECK_RESP = "RES_CHECK_RESP";// 资源质检返回

	// 接口标识funcode

	public static final String FUNCODE_SO_SYNC_REQUEST = "soSyncRequest"; // 服务定单同步请求

	public static final String FUNCODE_SO_SYNC_RESPONSE = "soSyncResponse"; // 服务定单同步返回

	public static final String FUNCODE_RES_QUERY_REQUEST = "resQueryRequest"; // 资源服务查询请求

	public static final String FUNCODE_RES_ASSIGN_REQUEST = "resAssignRequest";// 资源服务配置请求

	public static final String FUNCODE_RES_ASSIGN_RESPONSE = "resAssignResponse"; // 资源服务配置反回

	public static final String FUNCODE_RES_ASSIGN_CANCEL_REQUEST = "resAssignCancelRequest";// 资源服务配置取消请求

	public static final String FUNCODE_RES_SO_REVERSE_REQUEST = "soReverseRequest";// 撤除资源请求

	public static final String FUNCODE_RES_DISIGN_REQUEST = "resDesignRequest"; // 资源服务设计请求

	public static final String FUNCODE_RES_DESIGN_RESPONSE = "resDesignResponse";// 资源服务设计返回

	public static final String FUNCODE_RES_ARCHIVE_REQUEST = "resArchiveRequest"; // 资源归档请求

	public static final String FUNCODE_RES_ARCHIVE_RESPONSE = "resArchiveResponse";// 资源归档返回

	public static final String FUNCODE_RES_CHECK_REQUEST = "resCheckRequest";// 资源质检请求

	public static final String FUNCODE_RES_CHECK_RESPONSE = "resCheckResponse"; // 资源质检反回

	// 认证用户
	public static final String RES_SECURITY_PRINCIPAL = "admin"; // 用户

	// 认证密码
	public static final String RES_SECURITY_CREDENTIALS = "qazwsxedc";// 密码

	// 通讯方式
	public static final String EVENT_TYPE_FOR_SYNC = "SYNC"; // 同步

	public static final String EVENT_TYPE_FOR_ASYN = "ASYN"; // 异步

	//
	public static final String APPLICATION_SYSTEM = "SPS"; // 服务开通系统

	// 资源返回编码
	public static final String RES_RESULT_CODE_SUCCESS = "0"; // 调用成功

	// 操作类型
	public static final String ACT_TYPE_ASSIGN = "A"; // 资源分配

	public static final String ACT_TYPE_QUERY = "Q"; // 资源查询

	public static final String ACT_TYPE_CANCEL = "C"; // 资源撤销

	// AZ标志转码
	public static final String AZ_FLAG_TYPE_A = "1";// 对应AZ_FLAG 的A端

	public static final String AZ_FLAG_TYPE_Z = "2";// 对应AZ_FLAG的Z端

	// AZ_FLAGAZ端标志
	public static final String AZ_FLAG_A = "A";// A端

	public static final String AZ_FLAG_Z = "Z";// Z端

	/** *******************工单打印参数*********************************** */

	public static final float PAGELENGTH = 297;// 页面长度 单位mm

	public static final float PAGEWIDTH = 210;// 页面宽度 单位mm

	/** *********************SQL查询状态参数*************************************** */

	public static final String STATUS_HIS = "_HIS";// 查询历史表

	public static final String STATUS_ARC = "_ARC";// 查询归档表

	/** ***********************操作类型id************************************************** */
	public static final String OFTEN_BACK_HANDLE_ID = "220049";// 回单正常回单

	public static final String FAIL_BACK_HANDLE_ID = "220050"; // 回单失败回单

	// public static final String DUE_APPLY_HANDLE_ID = ""; // 领单预约申请

	// public static final String DUE_MODIFY_HANDLE_ID = ""; // 领单预约修改

	public static final String SECOND_ASSIGN_HANDLE_ID = "220051"; // 领单二次派发

	public static final String FETCH_HANDLE_ID = "220052"; // 领单

	// public static final String VIEW_UNION_HANDLE_ID = ""; // 催单查看关联单

	public static final String EXCEPTION_OFTEN_BACK_HANDLE_ID = "220053"; // 异常工单正常回单

	public static final String EXCEPTION_FAIL_BACK_HANDLE_ID = "220054"; // 异常工单失败回单

	public static final String EXCEPTION_RESDO_HANDLE_ID = "220055"; // 异常工单异常重发

	public static final String DUE_HANDLE_ID = "220056"; // 预约未到期工单预约

	public static final String SO_MATCH_PROCESS_FAIL = "0"; // 定单匹配处理失败

	public static final String SO_MATCH_PROCESS_SUCCESS = "1";// 定单匹配处理成功

	// --------------------------系统context环境
	public static final String CONTEXT_WFS = "wfs";// context-config.xml中工作流环境配置

	public static final String CONTEXT_RMS = "rms";// context-config.xml中资源环境配置

	public static final String CONTEXT_NAI = "nai";// context-config.xml中资源环境配置

}
