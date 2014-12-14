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

    /* ������ͣ�������Դ----R��ͨ�ŷ���----C */
    public static final String SPEC_TYPE_RESOURCE = "R";

    public static final String SPEC_TYPE_COMM_SERV_SPEC = "C";

    /* ��ҳ��ʾҳ���������� */
    public static final int DEFAULT_PAGE_SIZE = SysConfig.getConfig().getProperty("page.size") == null ? 10
            : Integer.valueOf(SysConfig.getConfig().getProperty("page.size")).intValue();

    /* database sequences */
    public static final String SEQ_CUST_COMPETITOR_PROD_ID = "CUST_COMPETITOR_PROD_ID";// �ͻ��������ֲ�Ʒ��

    public static final String SEQ_CUST_DECIDE_PROCESS_ID = "CUST_DECIDE_PROCESS_ID";// �ͻ��������̱�

    public static final String SEQ_BANK_ID = "BANK_ID";

    public static final String SEQ_CUST_FEEDBACK_ID = "CUST_FEEDBACK_ID";

    public static final String SEQ_BANK_BRANCH_ID = "BANK_BRANCH_ID";

    public static final String SEQ_CUST_VOCA_ID = "CUST_VOCA_ID";// wdx

    public static final String SEQ_PARTY_ID = "PARTY_ID"; // �����˱�

    public static final String SEQ_CUST_ID = "CUST_ID"; // �ͻ���

    public static final String SEQ_PARTY_ROLE = "PARTY_ROLE"; // �ͻ�������˹�ϵ��

    public static final String SEQ_CUST_EVENT_ID = "CUST_EVENT_ID";// �ͻ��ش��¼���

    public static final String SEQ_PARTY_HIST_ID = "PARTY_HIST_ID";// ��������ʷ��

    public static final String SEQ_CUST_HISTORY_ID = "CUST_HISTORY_ID";// �ͻ���ʷ��

    public static final String SEQ_CUST_EQPT_ID = "CUST_EQPT_ID";// �ͻ��豸����������

    public static final String SEQ_CONTACT_ID = "CONTACT_ID";

    public static final String SEQ_CSO_BUSI_CUST_ID = "CSO_BUSI_CUST_ID"; // �ͻ�������������

    public static final String SEQ_CSO_ITEM_ID = "CSO_ITEM_ID";// ��������ϸ

    public static final String SEQ_CSO_ITEM_CO_ID = "CSO_ITEM_CO_ID";// ��������ϸ��Ӧ�Ķ���

    public static final String SEQ_CSO_ITEM_ACT_ANALYZE_ID = "CSO_ITEM_ACT_ANALYZE_ID";

    public static final String SEQ_CO_MAX_ID_ID = "CO_MAX_ID";

    public static final String SEQ_CUST_LEVEL_ID = "CUST_LEVEL_ID"; // �ͻ������

    public static final String SEQ_CUST_TYPE_ID = "CUST_TYPE_ID";// �ͻ����ͱ�

    public static final String SEQ_CUST_REQUIREMENT_ID = "CUST_REQUIREMENT_ID";

    public static final String SEQ_MANAGE_LEVEL_ID = "MANAGE_LEVEL_ID";// �ͻ���������

    public static final String SEQ_CUST_ACCT_NBR = "ACCT_NBR";// �˻���

    public static final String SEQ_CUST_ACCT_HIST_ID = "CUST_ACCT_HIST_ID";// �˻���ʷ��

    public static final String SEQ_ACCT_PAY_CHANNEL_ID = "ACCT_PAY_CHANNEL_ID";// �˻���֧��������

    /* add by wugm */
    public static final String SEQ_BUILDING_ID = "BUILDING_ID";

    public static final String SEQ_CUST_BUILDING_ID = "CUST_BUILDING_ID";

    public static final String SEQ_ORG_LEADER_ID = "ORG_LEADER_ID";

    public static final String SEQ_CUST_Use_BUILDING_ID = "CUST_Use_BUILDING_ID";

    public static final String SEQ_PAY_CHANNEL_ID = "PAY_CHANNEL_ID";

    public static final String SEQ_PAY_METH_ID = "PAY_METH_ID";

    public static final String SEQ_PARTY_REL_ID = "PARTY_REL_ID"; // ��ɫ��ϵ��

    public static final String SEQ_PARTY_IDENTITY_ID = "PARTY_IDENTITY_ID";// ������֤����

    public static final String SEQ_FILEID = "FILEID";// ���������� ����

    public static final String SEQ_CUST_STANDARD_CODE_ID = "CUST_STANDARD_CODE_ID";// �ͻ���׼����

    public static final String SEQ_CUST_MEMORAN = "CUST_MEMORAN_ID";// �ͻ�������

    public static final String SEQ_LARGESS_ID = "LARGESS_ID";// ��Ʒ���

    // ����

    public static final String SEQ_CUST_VALUE_LEVEL_ID = "CUST_VALUE_LEVEL_ID";// �ͻ���׼����

    // ����

    public static final String SEQ_CHANNEL_TYPE_CTRL_ID = "CHANNEL_TYPE_CTRL_ID";// �������Ϳؼ��������� ����

    public static final String SEQ_EXAMINE_LEVEL_ID = "EXAMINE_LEVEL_ID";// �ͻ����˼������� ����

    public static final String SEQ_COMM_SERV_SPEC_ID = "COMM_SERV_SPEC_ID";// ͨ�ŷ����� ����

    public static final String SEQ_COMM_SERV_SPEC_TREE_ID = "COMM_SERV_SPEC_TREE_ID";// ͨ�ŷ���Ŀ¼��

    public static final String SEQ_TASK_ID = "TASK_ID"; // Ӫ��� ����

    public static final String SEQ_TELCOM_BRAND_ID = "TELCOM_BRAND_ID";// ��ƷƷ������

    public static final String SEQ_PROD_ID = "PROD_ID";// ��Ʒ�ṩ

    public static final String SEQ_PROD_ITEM_ID = "PROD_ITEM_ID";// ��Ʒ�ṩ��������

    public static final String SEQ_PROD_RELATION_ID = "PROD_RELATION_ID";// ��Ʒ�ṩ��ϵ

    public static final String SEQ_PROD_RANGE_ID = "PROD_RANGE_ID";// ��Ʒ�ṩ������Χ����

    public static final String SEQ_PROD_PRICE_PLAN_ID = "PROD_PRICE_PLAN_ID";// ��Ʒ�۸�

    public static final String SEQ_PROD_PRICE_PLAN_RANGE_ID = "PROD_PRICE_PLAN_RANGE_ID";// ��Ʒ�۸񷢲���Χ

    public static final String SEQ_PROD_PRICE_PLAN_REL_ID = "PROD_PRICE_PLAN_REL_ID";// ��Ʒ�۸��ϵ

    public static final String SEQ_PROD_TREE_ID = "PROD_TREE_ID";// ��Ʒ�ṩ��

    public static final String SEQ_PROD_CAT_ID = "PROD_CAT_ID";// ��ƷĿ¼

    public static final String SEQ_PROD_CHG_RULE_CONT_ID = "PROD_CHG_RULE_CONT_ID";// ��Ʒ������򹹳�

    public static final String SEQ_PROD_CHG_RULE_ID = "PROD_CHG_RULE_ID";// ��Ʒ�������

    public static final String SEQ_PROD_CAT_TREE_ID = "PROD_CAT_TREE_ID";// ��ƷĿ¼��

    public static final String SEQ_PROD_PROD_CAT_TREE_ID = "PROD_PROD_CAT_TREE_ID";// ��ƷĿ¼�ڵ�

    public static final String SEQ_PROD_SPEC_ID = "PROD_SPEC_ID";// ��Ʒ���

    public static final String SEQ_PROD_SPEC_ITEM_ID = "PROD_SPEC_ITEM_ID";// ��Ʒ��񹹳�

    public static final String SEQ_PROD_SPEC_PRPTY_VAL_ID = "PROD_SPEC_PRPTY_VAL_ID";// ��Ʒ�������ֵ

    public static final String SEQ_RESOURCE_SPEC_TREE_ID = "RESOURCE_SPEC_TREE_ID";// ������Դ��

    public static final String SEQ_RESOURCE_SPEC_TYPE_ID = "RESOURCE_SPEC_TYPE_ID";// ������Դ���

    public static final String SEQ_RESOURCE_SPEC_REL_ID = "RESOURCE_SPEC_REL_ID";// ������Դ��ϵ

    public static final String SEQ_SPEC_PRPTY_VALUE_INC_ID = "SPEC_PRPTY_VALUE_INC_ID";// ��������ֵ

    public static final String SEQ_SPEC_PRPTY_INC_ID = "SPEC_PRPTY_INC_ID";// ��������

    public static final String SEQ_SPEC_PRPTY_INC_RANGE_ID = "SPEC_PRPTY_INC_RANGE_ID";// �����������÷�Χ

    public static final String SEQ_COMM_SERV_SPEC_CAT_ID = "COMM_SERV_SPEC_CAT_ID";// ͨ�ŷ�������

    public static final String SEQ_COMM_SERV_SPEC_RANGE_ID = "COMM_SERV_SPEC_RANGE_ID";// ͨ�ŷ��񷢲���Χ

    public static final String SEQ_COMM_SERV_SPEC_RS_ID = "COMM_SERV_SPEC_RS_ID";// ͨ�ŷ����������Դ

    public static final String SEQ_COMM_SERV_SPEC_REL_ID = "COMM_SERV_SPEC_REL_ID";// ͨ�ŷ����ϵ

    public static final String SEQ_COMM_SERV_SPEC_PRICE_ID = "COMM_SERV_SPEC_PRICE_ID";// ͨ�ŷ���۸�

    public static final String SEQ_RESOURCE_SPEC_ID = "RESOURCE_SPEC_ID";// ͨ����Դ

    public static final String SEQ_CHARACTERISTIC_ID = "CHARACTERISTIC_ID";// ����

    public static final String SEQ_ENUM_VALUE_ID = "ENUM_VALUE_ID";// ����ֵ

    public static final String SEQ_CUST_GROUP_ID = "CUST_GROUP_ID"; // �ͻ�Ⱥ

    public static final String SEQ_CUST_GROUP_CYCLE_ID = "CUST_GROUP_CYCLE_ID"; // �ͻ�Ⱥ����

    public static final String SEQ_CG_LN_ID = "CG_LN_ID"; // �ͻ�Ⱥ���÷�Χ

    public static final String SEQ_CUST_GROUP_EXEC_ID = "CUST_GROUP_EXEC_ID"; // �ͻ�Ⱥִ�й���

    public static final String SEQ_CUST_GROUP_RULE_ID = "CUST_GROUP_RULE_ID"; // �ͻ�Ⱥ��Ⱥ����

    public static final String SEQ_GROUP_CHARACTER_ID = "GROUP_CHARACTER_ID"; // �ͻ�Ⱥ��������

    public static final String SEQ_MEMBER_ATTR_ID = "MEMBER_ATTR_ID"; // �ͻ�Ⱥ��Ա����

    public static final String SEQ_CUST_GROUP_MEMBER_ID = "CUST_GROUP_MEMBER_ID"; // �ͻ�Ⱥ�����Ŀͻ�

    public static final String SEQ_CUST_MEMBER_INFO_ID = "CUST_MEMBER_INFO_ID"; // �ͻ�Ⱥ��Ա��Ϣ

    public static final String SEQ_INDICATOR_ID = "INDICATOR_ID";  //�ο�����
    
    public static final String SEQ_INDICATOR_APPLY_RANGE_ID = "INDICATOR_APPLY_RANGE_ID";  //�ο�����Ӧ�÷�Χ
    
    public static final String SEQ_EVAL_CYCLE_TYPE_ID = "EVAL_CYCLE_TYPE_ID"; // ������������

    public static final String SEQ_EVAL_TYPE_ID = "EVAL_TYPE_ID"; // ��������

    public static final String SEQ_EVAL_TYPE_LEVEL_ID = "EVAL_TYPE_LEVEL_ID"; // �������ͼ���

    public static final String SEQ_EVAL_RULE_ID = "EVAL_RULE_ID"; // ���۹�������

    public static final String SEQ_EVAL_RULE_DETAIL_ID = "EVAL_RULE_DETAIL_ID"; // ���۹�����ϸ

    public static final String SEQ_EVAL_RULE_SCOPE_ID = "EVAL_RULE_SCOPE_ID"; // �������õ���

    public static final String SEQ_EVAL_RULE_CONDITION_ID = "EVAL_RULE_CONDITION_ID"; // ���۹�������

    public static final String SEQ_TASK_PROD_ID = "TASK_PROD_ID"; // ���Ӧ��Ʒ����

    public static final String SEQ_TASK_CUST_GROUP_ID = "TASK_CUST_GROUP_ID"; // Ӫ����ͻ�Ⱥ����

    public static final String SEQ_TASK_CHANNEL_ID = "TASK_CHANNEL_ID"; // Ӫ�����������

    public static final String SEQ_CHANNEL_ID = "CHANNEL_ID"; // ����

    public static final String SEQ_CHANNEL_ITEM_ID = "CHANNEL_ITEM_ID"; // ChannelItem

    public static final String SEQ_CHANNEL_LEVEL_ID = "CHANNEL_LEVEL_ID"; // ����

    public static final String SEQ_CHANNEL_TYPE_ID = "CHANNEL_TYPE_ID"; // ����

    public static final String SEQ_TASK_REGION_ID = "TASK_REGION_ID"; // Ӫ�������

    public static final String SEQ_PRICE_PLAN_ID = "PRICE_PLAN_ID";// �۸�ƻ�

    public static final String SEQ_TASK_PROD_PRICE_ID = "TASK_PROD_PRICE_ID";// Ӫ�����Ӧ��Ʒ�۸�

    public static final String SEQ_DEMAND_ID = "DEMAND_ID";// �ͻ�����ID

    public static final String SEQ_SELL_LOG_ID = "SELL_LOG_ID";// ����Ӫ������ID

    public static final String SEQ_SELL_ID = "SELL_ID";// ����Ӫ��ID

    public static final String SEQ_INCOME_PLAN_ID = "INCOME_PLAN_ID";// �״ν����ͳ��

    public static final String SEQ_SERV_ACT_ID = "SERV_ACT_ID";// ������

    public static final String SEQ_SERV_ACT_COMP_ID = "SERV_ACT_COMP_ID";// ��Ϸ�����

    public static final String SEQ_SERV_ACT_REL_ID = "SERV_ACT_REL_ID";// ��������ϵ

    public static final String SEQ_BUSINESS_ID = "BUSINESS_ID";// �ͻ�����

    public static final String BUSINESS_TYPE_COMM_SERV = "S";// ����ͨ�ŷ���Ŀͻ���������

    public static final String BUSINESS_TYPE_CUSTOM = "C";// ����ͻ��Ŀͻ���������

    public static final String BUSINESS_TYPE_PRODUCT = "P";// �����Ʒ�Ŀͻ���������

    public static final String SEQ_SO_MAX_ID_ID = "SO_MAX_ID_ID";// ���뵥������

    public static final String SEQ_LOG_ID = "LOG_ID"; // ��½��־

    public static final String SEQ_DEPT_ID = "DEPT_ID";// ��֯�ṹ

    public static final String SEQ_SYS_USER_BAR_ID = "SYS_USER_BAR_ID";// �û���ݷ�ʽ��

    /** ���õĿؼ���װ��ʼ������ */
    public static final String SO_INIT_NEW_DOM = "soInitNewDom";

    /** ���õĿؼ������ʼ������ */
    public static final String SO_INIT_CHG_DOM = "soInitChgDom";

    /** ���ÿؼ����淽�� */
    public static final String SO_SAVE_DOM = "soSaveDom";

    /** ���ÿؼ��������� */
    public static final String SO_COMPLENTE_DOM = "soComplenteDom";

    /** �ؼ��������뿽������ */
    public static final String SO_COPY_DOM = "soCopy";

    public static final String SO_INIT_NEW_PAGE = "soInitNewPage";

    public static final String SO_INIT_CHG_PAGE = "soInitChgPage";

    public static final String SO_RELOAD_PAGE = "soReloadPage";

    public static final String SO_VALIDATE_PAGE = "soValidatePage";

    public static final String SO_SAVE_CHANGE_PAGE = "soSaveChangePage";

    public static final String SO_FORM_TO_VO_PAGE = "soFormToVo";

    /** session */
    /** �����б�����session��soallvo */
    public static final String SESSION_SO_ALL_VO = "soAllVo";

    /** ����ǰ���ɵı�����session��csoNbr */
    public static final String SESSION_CSO_NBR = "CSO_NBR";

    /** ��װ���߱�� */
    public static final String SESSION_ITEM_TYPE = "ITEM_TYPE";

    /** �������� */
    public static final String SESSION_ORDER_ACTION = "ORDER_ACTION";

    /** ϵͳ��½������session����Ϣ */
    public static final String SESSION_SYS_USER_EXTEND = "SYS_USER_EXTEND";
    
    /** ǰһ�ſͻ�������� */
    public static final String SESSION_BFOR_CO_NBR = "beforeCoNbr";

    public static final String SEQ_PARTY_ADDR_ID = "PARTY_ADDR_ID"; // �����˵�ַ

    public static final String SEQ_PARTNER_ID = "PARTNER_ID"; // �������

    public static final String SEQ_CONTRACT_ID = "CONTRACT_ID"; // Э��

    public static final String SEQ_DOCUMENT_ID = "DOCUMENT_ID"; // document

    public static final String SEQ_CONTRACT_PARTY_ID = "CONTRACT_PARTY_ID"; // Э�����

    public static final String SEQ_CONTRACT_RESTRICT_ID = "CONTRACT_RESTRICT_ID";// Э��Υ��Լ��

    public static final String SEQ_CONTRACT_PUNISH_ID = "CONTRACT_PUNISH_ID";// Э��ͷ�
    
    public static final String SEQ_CHANNEL_RESOURCE_ID = "CHANNEL_RESOURCE_ID";//������Դ
    
    /**�ͻ���*/
    public static final String ORDER_TYPE_C = "C";
    
    /**��Ʒ��*/
    public static final String ORDER_TYPE_P = "P";
    
    /**����*/
    public static final String ORDER_TYPE_S = "S";
    
    /**��װ*/
    public static final String ITEM_TYPE_A = "A";
    
    /**���*/
    public static final String ITEM_TYPE_B = "B";
}