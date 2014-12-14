package com.cattsoft.pub.util;

import com.cattsoft.pub.config.SysConfig;

public final class Constant {

    /* database type */
    public static final String DB_TYPE_MYSQL = "mysql";

    public static final String DB_TYPE_ORACLE = "oracle";

    public static final String DB_TYPE_DB2 = "db2";

    public static final String DB_TYPE_SYBASE = "sybase";

    public static final String DB_TYPE_SQLSERVER = "sqlserver";

    public static final String DB_TYPE_POSTGRESQL = "postgresql";

    /* connection type */
    public static final String CONN_TYPE_JDBC = "direct";

    public static final String CONN_TYPE_DATASOURCE = "ds";

    /* ejb mode */
    public static final String EJB_LOCAL = "local";

    /* cso status */
    public static final String STS_CSO_NEW = "A";

    /* act level */
    public static final String PRODUCT_LEVEL = "P";

    public static final String CUST_LEVEL = "C";

    public static final String Serv_LEVEL = "S";

    /* common status */
    public static final String STS_IN_USE = "A";

    public static final String STS_HISTORY = "P";

    /* server type status */
    public static final String MAIN_SERVER = "Y";

    public static final String NOT_MAIN_SERVER = "N";

    /* Yes or No flag status */
    public static final String YES = "Y";

    public static final String NO = "N";

    /* 规格类型：销售资源----R；通信服务----C */
    public static final String SPEC_TYPE_RESOURCE = "R";

    public static final String SPEC_TYPE_COMM_SERV_SPEC = "C";

    /* 分页显示页面配置属性 */
    public static final int DEFAULT_PAGE_SIZE = SysConfig.getConfig().getProperty("page.size") == null ? 10
            : Integer.valueOf(SysConfig.getConfig().getProperty("page.size")).intValue();

    /* database sequences */
    public static final String SEQ_CUST_COMPETITOR_PROD_ID = "CUST_COMPETITOR_PROD_ID";// 客户竞争对手产品表

    public static final String SEQ_CUST_DECIDE_PROCESS_ID = "CUST_DECIDE_PROCESS_ID";// 客户决策流程表

    public static final String SEQ_BANK_ID = "BANK_ID";

    public static final String SEQ_CUST_FEEDBACK_ID = "CUST_FEEDBACK_ID";

    public static final String SEQ_BANK_BRANCH_ID = "BANK_BRANCH_ID";

    public static final String SEQ_CUST_VOCA_ID = "CUST_VOCA_ID";// wdx

    public static final String SEQ_PARTY_ID = "PARTY_ID"; // 参与人表

    public static final String SEQ_CUST_ID = "CUST_ID"; // 客户表

    public static final String SEQ_PARTY_ROLE = "PARTY_ROLE"; // 客户与参与人关系表

    public static final String SEQ_CUST_EVENT_ID = "CUST_EVENT_ID";// 客户重大事件表

    public static final String SEQ_PARTY_HIST_ID = "PARTY_HIST_ID";// 参与人历史表

    public static final String SEQ_CUST_HISTORY_ID = "CUST_HISTORY_ID";// 客户历史表

    public static final String SEQ_CUST_EQPT_ID = "CUST_EQPT_ID";// 客户设备主键，序列

    public static final String SEQ_CONTACT_ID = "CONTACT_ID";

    public static final String SEQ_CSO_BUSI_CUST_ID = "CSO_BUSI_CUST_ID"; // 客户受理单经办人

    public static final String SEQ_CSO_ITEM_ID = "CSO_ITEM_ID";// 受理单明细

    public static final String SEQ_CSO_ITEM_CO_ID = "CSO_ITEM_CO_ID";// 受理单明细对应的订单

    public static final String SEQ_CSO_ITEM_ACT_ANALYZE_ID = "CSO_ITEM_ACT_ANALYZE_ID";

    public static final String SEQ_CO_MAX_ID_ID = "CO_MAX_ID";

    public static final String SEQ_CUST_LEVEL_ID = "CUST_LEVEL_ID"; // 客户级别表

    public static final String SEQ_CUST_TYPE_ID = "CUST_TYPE_ID";// 客户类型表

    public static final String SEQ_CUST_REQUIREMENT_ID = "CUST_REQUIREMENT_ID";

    public static final String SEQ_MANAGE_LEVEL_ID = "MANAGE_LEVEL_ID";// 客户管理级别

    public static final String SEQ_CUST_ACCT_NBR = "ACCT_NBR";// 账户表

    public static final String SEQ_CUST_ACCT_HIST_ID = "CUST_ACCT_HIST_ID";// 账户历史表

    public static final String SEQ_ACCT_PAY_CHANNEL_ID = "ACCT_PAY_CHANNEL_ID";// 账户与支付渠道表

    /* add by wugm */
    public static final String SEQ_BUILDING_ID = "BUILDING_ID";

    public static final String SEQ_CUST_BUILDING_ID = "CUST_BUILDING_ID";

    public static final String SEQ_ORG_LEADER_ID = "ORG_LEADER_ID";

    public static final String SEQ_CUST_Use_BUILDING_ID = "CUST_Use_BUILDING_ID";

    public static final String SEQ_PAY_CHANNEL_ID = "PAY_CHANNEL_ID";

    public static final String SEQ_PAY_METH_ID = "PAY_METH_ID";

    public static final String SEQ_PARTY_REL_ID = "PARTY_REL_ID"; // 角色关系表

    public static final String SEQ_PARTY_IDENTITY_ID = "PARTY_IDENTITY_ID";// 参与人证件表

    public static final String SEQ_FILEID = "FILEID";// 附件表主键 序列

    public static final String SEQ_CUST_STANDARD_CODE_ID = "CUST_STANDARD_CODE_ID";// 客户标准编码

    public static final String SEQ_CUST_MEMORAN = "CUST_MEMORAN_ID";// 客户纪念日

    public static final String SEQ_LARGESS_ID = "LARGESS_ID";// 赠品编号

    // 序列

    public static final String SEQ_CUST_VALUE_LEVEL_ID = "CUST_VALUE_LEVEL_ID";// 客户标准编码

    // 序列

    public static final String SEQ_CHANNEL_TYPE_CTRL_ID = "CHANNEL_TYPE_CTRL_ID";// 渠道类型控件关联主键 序列

    public static final String SEQ_EXAMINE_LEVEL_ID = "EXAMINE_LEVEL_ID";// 客户考核级别主键 序列

    public static final String SEQ_COMM_SERV_SPEC_ID = "COMM_SERV_SPEC_ID";// 通信服务编号 主键

    public static final String SEQ_COMM_SERV_SPEC_TREE_ID = "COMM_SERV_SPEC_TREE_ID";// 通信服务目录树

    public static final String SEQ_TASK_ID = "TASK_ID"; // 营销活动 主键

    public static final String SEQ_TELCOM_BRAND_ID = "TELCOM_BRAND_ID";// 产品品牌主键

    public static final String SEQ_PROD_ID = "PROD_ID";// 产品提供

    public static final String SEQ_PROD_ITEM_ID = "PROD_ITEM_ID";// 产品提供构成主键

    public static final String SEQ_PROD_RELATION_ID = "PROD_RELATION_ID";// 产品提供关系

    public static final String SEQ_PROD_RANGE_ID = "PROD_RANGE_ID";// 产品提供发布范围主键

    public static final String SEQ_PROD_PRICE_PLAN_ID = "PROD_PRICE_PLAN_ID";// 产品价格

    public static final String SEQ_PROD_PRICE_PLAN_RANGE_ID = "PROD_PRICE_PLAN_RANGE_ID";// 产品价格发布范围

    public static final String SEQ_PROD_PRICE_PLAN_REL_ID = "PROD_PRICE_PLAN_REL_ID";// 产品价格关系

    public static final String SEQ_PROD_TREE_ID = "PROD_TREE_ID";// 产品提供树

    public static final String SEQ_PROD_CAT_ID = "PROD_CAT_ID";// 产品目录

    public static final String SEQ_PROD_CHG_RULE_CONT_ID = "PROD_CHG_RULE_CONT_ID";// 产品变更规则构成

    public static final String SEQ_PROD_CHG_RULE_ID = "PROD_CHG_RULE_ID";// 产品变更规则

    public static final String SEQ_PROD_CAT_TREE_ID = "PROD_CAT_TREE_ID";// 产品目录树

    public static final String SEQ_PROD_PROD_CAT_TREE_ID = "PROD_PROD_CAT_TREE_ID";// 产品目录节点

    public static final String SEQ_PROD_SPEC_ID = "PROD_SPEC_ID";// 产品规格

    public static final String SEQ_PROD_SPEC_ITEM_ID = "PROD_SPEC_ITEM_ID";// 产品规格构成

    public static final String SEQ_PROD_SPEC_PRPTY_VAL_ID = "PROD_SPEC_PRPTY_VAL_ID";// 产品规格属性值

    public static final String SEQ_RESOURCE_SPEC_TREE_ID = "RESOURCE_SPEC_TREE_ID";// 销售资源树

    public static final String SEQ_RESOURCE_SPEC_TYPE_ID = "RESOURCE_SPEC_TYPE_ID";// 销售资源类别

    public static final String SEQ_RESOURCE_SPEC_REL_ID = "RESOURCE_SPEC_REL_ID";// 销售资源关系

    public static final String SEQ_SPEC_PRPTY_VALUE_INC_ID = "SPEC_PRPTY_VALUE_INC_ID";// 服务属性值

    public static final String SEQ_SPEC_PRPTY_INC_ID = "SPEC_PRPTY_INC_ID";// 服务属性

    public static final String SEQ_SPEC_PRPTY_INC_RANGE_ID = "SPEC_PRPTY_INC_RANGE_ID";// 服务属性适用范围

    public static final String SEQ_COMM_SERV_SPEC_CAT_ID = "COMM_SERV_SPEC_CAT_ID";// 通信服务种类

    public static final String SEQ_COMM_SERV_SPEC_RANGE_ID = "COMM_SERV_SPEC_RANGE_ID";// 通信服务发布范围

    public static final String SEQ_COMM_SERV_SPEC_RS_ID = "COMM_SERV_SPEC_RS_ID";// 通信服务包含的资源

    public static final String SEQ_COMM_SERV_SPEC_REL_ID = "COMM_SERV_SPEC_REL_ID";// 通信服务关系

    public static final String SEQ_COMM_SERV_SPEC_PRICE_ID = "COMM_SERV_SPEC_PRICE_ID";// 通信服务价格

    public static final String SEQ_RESOURCE_SPEC_ID = "RESOURCE_SPEC_ID";// 通信资源

    public static final String SEQ_CHARACTERISTIC_ID = "CHARACTERISTIC_ID";// 属性

    public static final String SEQ_ENUM_VALUE_ID = "ENUM_VALUE_ID";// 属性值

    public static final String SEQ_CUST_GROUP_ID = "CUST_GROUP_ID"; // 客户群

    public static final String SEQ_CUST_GROUP_CYCLE_ID = "CUST_GROUP_CYCLE_ID"; // 客户群周期

    public static final String SEQ_CG_LN_ID = "CG_LN_ID"; // 客户群适用范围

    public static final String SEQ_CUST_GROUP_EXEC_ID = "CUST_GROUP_EXEC_ID"; // 客户群执行过程

    public static final String SEQ_CUST_GROUP_RULE_ID = "CUST_GROUP_RULE_ID"; // 客户群分群规则

    public static final String SEQ_GROUP_CHARACTER_ID = "GROUP_CHARACTER_ID"; // 客户群总体特征

    public static final String SEQ_MEMBER_ATTR_ID = "MEMBER_ATTR_ID"; // 客户群成员属性

    public static final String SEQ_CUST_GROUP_MEMBER_ID = "CUST_GROUP_MEMBER_ID"; // 客户群包含的客户

    public static final String SEQ_CUST_MEMBER_INFO_ID = "CUST_MEMBER_INFO_ID"; // 客户群成员信息

    public static final String SEQ_INDICATOR_ID = "INDICATOR_ID";  //参考因素
    
    public static final String SEQ_INDICATOR_APPLY_RANGE_ID = "INDICATOR_APPLY_RANGE_ID";  //参考因素应用范围
    
    public static final String SEQ_EVAL_CYCLE_TYPE_ID = "EVAL_CYCLE_TYPE_ID"; // 评价周期类型

    public static final String SEQ_EVAL_TYPE_ID = "EVAL_TYPE_ID"; // 评价类型

    public static final String SEQ_EVAL_TYPE_LEVEL_ID = "EVAL_TYPE_LEVEL_ID"; // 评价类型级别

    public static final String SEQ_EVAL_RULE_ID = "EVAL_RULE_ID"; // 评价管理规则

    public static final String SEQ_EVAL_RULE_DETAIL_ID = "EVAL_RULE_DETAIL_ID"; // 评价规则明细

    public static final String SEQ_EVAL_RULE_SCOPE_ID = "EVAL_RULE_SCOPE_ID"; // 评价适用地区

    public static final String SEQ_EVAL_RULE_CONDITION_ID = "EVAL_RULE_CONDITION_ID"; // 评价规则条件

    public static final String SEQ_TASK_PROD_ID = "TASK_PROD_ID"; // 活动对应产品主键

    public static final String SEQ_TASK_CUST_GROUP_ID = "TASK_CUST_GROUP_ID"; // 营销活动客户群主键

    public static final String SEQ_TASK_CHANNEL_ID = "TASK_CHANNEL_ID"; // 营销活动发布渠道

    public static final String SEQ_CHANNEL_ID = "CHANNEL_ID"; // 渠道

    public static final String SEQ_CHANNEL_ITEM_ID = "CHANNEL_ITEM_ID"; // ChannelItem

    public static final String SEQ_CHANNEL_LEVEL_ID = "CHANNEL_LEVEL_ID"; // 渠道

    public static final String SEQ_CHANNEL_TYPE_ID = "CHANNEL_TYPE_ID"; // 渠道

    public static final String SEQ_TASK_REGION_ID = "TASK_REGION_ID"; // 营销活动区域

    public static final String SEQ_PRICE_PLAN_ID = "PRICE_PLAN_ID";// 价格计划

    public static final String SEQ_TASK_PROD_PRICE_ID = "TASK_PROD_PRICE_ID";// 营销活动对应产品价格

    public static final String SEQ_DEMAND_ID = "DEMAND_ID";// 客户需求ID

    public static final String SEQ_SELL_LOG_ID = "SELL_LOG_ID";// 主动营销操作ID

    public static final String SEQ_SELL_ID = "SELL_ID";// 主动营销ID

    public static final String SEQ_INCOME_PLAN_ID = "INCOME_PLAN_ID";// 首次解决率统计

    public static final String SEQ_SERV_ACT_ID = "SERV_ACT_ID";// 服务动作

    public static final String SEQ_SERV_ACT_COMP_ID = "SERV_ACT_COMP_ID";// 组合服务动作

    public static final String SEQ_SERV_ACT_REL_ID = "SERV_ACT_REL_ID";// 服务动作关系

    public static final String SEQ_BUSINESS_ID = "BUSINESS_ID";// 客户服务

    public static final String BUSINESS_TYPE_COMM_SERV = "S";// 面向通信服务的客户服务类型

    public static final String BUSINESS_TYPE_CUSTOM = "C";// 面向客户的客户服务类型

    public static final String BUSINESS_TYPE_PRODUCT = "P";// 面向产品的客户服务类型

    public static final String SEQ_SO_MAX_ID_ID = "SO_MAX_ID_ID";// 申请单最大序号

    public static final String SEQ_LOG_ID = "LOG_ID"; // 登陆日志

    public static final String SEQ_DEPT_ID = "DEPT_ID";// 组织结构

    public static final String SEQ_SYS_USER_BAR_ID = "SYS_USER_BAR_ID";// 用户快捷方式表

    /** 调用的控件新装初始化方法 */
    public static final String SO_INIT_NEW_DOM = "soInitNewDom";

    /** 调用的控件变更初始化方法 */
    public static final String SO_INIT_CHG_DOM = "soInitChgDom";

    /** 调用控件保存方法 */
    public static final String SO_SAVE_DOM = "soSaveDom";

    /** 调用控件竣工方法 */
    public static final String SO_COMPLENTE_DOM = "soComplenteDom";

    /** 控件串行申请拷贝方法 */
    public static final String SO_COPY_DOM = "soCopy";

    public static final String SO_INIT_NEW_PAGE = "soInitNewPage";

    public static final String SO_INIT_CHG_PAGE = "soInitChgPage";

    public static final String SO_RELOAD_PAGE = "soReloadPage";

    public static final String SO_VALIDATE_PAGE = "soValidatePage";

    public static final String SO_SAVE_CHANGE_PAGE = "soSaveChangePage";

    public static final String SO_FORM_TO_VO_PAGE = "soFormToVo";

    /** session */
    /** 受理中保存在session的soallvo */
    public static final String SESSION_SO_ALL_VO = "soAllVo";

    /** 受理前生成的保存在session的csoNbr */
    public static final String SESSION_CSO_NBR = "CSO_NBR";

    /** 新装或者变更 */
    public static final String SESSION_ITEM_TYPE = "ITEM_TYPE";

    /** 受理动作 */
    public static final String SESSION_ORDER_ACTION = "ORDER_ACTION";

    /** 系统登陆保存在session的信息 */
    public static final String SESSION_SYS_USER_EXTEND = "SYS_USER_EXTEND";
    
    /** 前一张客户订单编号 */
    public static final String SESSION_BFOR_CO_NBR = "beforeCoNbr";

    public static final String SEQ_PARTY_ADDR_ID = "PARTY_ADDR_ID"; // 参与人地址

    public static final String SEQ_PARTNER_ID = "PARTNER_ID"; // 合作伙伴

    public static final String SEQ_CONTRACT_ID = "CONTRACT_ID"; // 协议

    public static final String SEQ_DOCUMENT_ID = "DOCUMENT_ID"; // document

    public static final String SEQ_CONTRACT_PARTY_ID = "CONTRACT_PARTY_ID"; // 协议各方

    public static final String SEQ_CONTRACT_RESTRICT_ID = "CONTRACT_RESTRICT_ID";// 协议违例约束

    public static final String SEQ_CONTRACT_PUNISH_ID = "CONTRACT_PUNISH_ID";// 协议惩罚
    
    public static final String SEQ_CHANNEL_RESOURCE_ID = "CHANNEL_RESOURCE_ID";//渠道资源
    
    /**客户级*/
    public static final String ORDER_TYPE_C = "C";
    
    /**产品级*/
    public static final String ORDER_TYPE_P = "P";
    
    /**服务级*/
    public static final String ORDER_TYPE_S = "S";
    
    /**新装*/
    public static final String ITEM_TYPE_A = "A";
    
    /**变更*/
    public static final String ITEM_TYPE_B = "B";
}
