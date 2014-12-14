package com.cattsoft.pub;

public class SysConstants {

	//
	public static final String YES = "1";

	public static final String NO = "0";

	// ���ú�ע��
	public static final String USE_YES_STS = "A";

	public static final String USE_NO_STS = "P";

	// ���������˵���ʽ
	public static final String SO_RETURN_TYPE = "1";// 1:������ 0��������

	// ��������
	public static final String STEP_FOR_SO_FINISH = ""; // 

	public static final String ONE = "1";

	// �쳣����
	public static final String EXP_CODE = "EXP_CODE";

	public static final String EXP_MSG = "EXP_MSG";

	/** ****************************************������************************************* */
	// ����״̬
	public static final String SO_WAIT_UPD_CANCEL = "K";// �ȴ�����

	public static final String SO_SUSPEND = "s";// ��װ

	public static final String SO_GIVEWAY = "g";// ����������

	public static final String SO_MODIFY = "h";// �ĵ�������

	public static final String SO_BIDE = "Y";// ��װ

	public static final String SO_PROCESSING = "P";// ����������

	public static final String SO_EXPLORATION = "V";// �⿰

	public static final String SO_RETURN_FAIL = "F";// �˵�������

	public static final String SO_BE_ABOUT_TO = "A";// ����

	public static final String SO_WAIT_CHOICE_PROC = "W";// �ȴ�ѡ������

	public static final String SO_MATCH_FAIL = "M";// ģ��ƥ��ʧ��

	public static final String SO_WAIT_START = "D";// �ȴ���������

	public static final String SO_START_ERROR = "E";// ��������ʧ��

	public static final String SO_FUTILITY = "R";// ʧЧ

	public static final String SO_FINISH = "C";// ʧЧ

	// ��������
	public static final String SO_TYPE_FUTILITY = "1";// ע����

	public static final String SO_TYPE_MODIFY = "2";// �޸ĵ�

	public static final String SO_TYPE_NORMAL = "0";// ������

	public static final String SO_TYPE_FOR_WAIT = "3";// ��װ��

	public static final String SO_TYPE_FOR_AGAIN = "4";// ��װ��

	// �����ص���ʽ
	public static final String WO_RET_SUCCESS = "0";// �����ص�

	public static final String WO_RET_FAIL = "1";// ʧ�ܻص�

	// �����Ĵ���ʽ
	public static final int BIDE_TYPE = 1;// ��װ����ʽ

	// ������ִ�з�ʽ
	public static final String SO_AUTO_EXEC = "A";// �Զ���������

	public static final String SO_UN_AUTO_EXEC = "M";// �˹�ѡ������

	// ����������
	public static final String GROUP_FLAG_FOR_YES = "Y";// ���־

	public static final String GROUP_FLAG_FOR_NO = "N";// �����־

	// �˵������־
	public static final String CANCEL_FLAG_FOR_NO = "1";// ������

	public static final String CANCEL_FLAG_FOR_YES = "0";// ����

	// ���÷�ʽ
	public static final String CALL_FLAG_FOR_JAVA = "J";// JAVA����

	public static final String CALL_FLAG_FOR_PROCDURE = "P";// �洢���̵���

	// ��������״̬
	public static final String SO_LOCK_STS_NO = "N";// δ����

	public static final String SO_LOCK_STS_YES = "Y";// ����

	public static final String SO_LOCK_STS_CANCEL_SO = "H";// ��������

	public static final String SO_LOCK_STS_CHANGE_SO = "G";// �ĵ�����

	public static final String SO_LOCK_STS_DELAY_SO = "S";// ��װ����

	// ���ù������ķ�ʽ
	public static final String CALL_TYPE_FOR_START_PROCESS = "0";// ��������

	public static final String CALL_TYPE_FOR_FAIL_REASON = "1";// ��������

	// ��Ϣ�����־ MSG_FLAG
	public static final String SO_MSG_FLAG_NOT_PROCESS = "0";// 0 ��δ����

	public static final String SO_MSG_FLAG_SUCCESS_PROCESS = "1";// 1 ����ɹ�

	public static final String SO_MSG_FLAG_FAIL_PROCESS = "2";// 2 ����ʧ��

	// SO_RES�����־
	public static final String ASSIGN_FLAG_RES_ASSIGN = "Y";// Y ��Դ�������

	public static final String ASSIGN_FLAG_CRM_ASSIGN = "N";// N ����Я������

	// SO_RES���ұ�־
	public static final String SO_RES_IS_SELF_YES = "Y";// Y ��

	public static final String SO_RES_IS_SELF_NO = "N";// N �񣬹�����

	// SO SO_SEQ
	public static final String SO_SEQ_DEFAULT = "0";

	// �շ�״̬ PAY_STS C1 Y
	public static final String SO_PAY_STS_YES = "Y";// Y ���շ�

	public static final String SO_PAY_STS_NO = "N";// N δ�շ�

	/** ************************������**************************************************************************** */
	// ����ҵ��״̬
	public static final String BUSI_STS_BIDE = "Y";// ��װ

	public static final String BUSI_STS_NORMAL = "N";// ����

	public static final String BUSI_STS_FAIL = "F";// ʧ�ܻص�

	public static final String BUSI_STS_AUDIT = "A";// �ȴ����

	public static final String BUSI_STS_STAY = "S";// ʧ������

	public static final String BUSI_STS_REMOKE = "K";// �ȴ�����

	public static final String WO_WORK_MODE_MANUAL = "M"; // �˹�

	public static final String WO_WORK_MODE_AUTO = "A"; // �Զ�

	// ��������״̬
	public static final String RUN_STS_PROCESSING = "P";// ������

	public static final String RUN_STS_COMPLETE = "C";// ���

	public static final String RUN_STS_WAIT_PROCESS = "D";// �ȴ�����

	public static final String RUN_STS_WAIT_RETURN = "W";// ׼���ص�

	public static final String RUN_STS_REVOKE = "R";// �Ѿ�����

	public static final String RUN_STS_DISP_FAIL = "I";// ����ʧ��

	// �����־
	public static final String DIRECTION_FORWORD = "0";// ����

	public static final String DIRECTION_INVERT = "1";// ����

	// �˵�ԭ������
	public static final String FAIL_REASON_FOR_FAIL = "A";// ʧ��

	public static final String FAIL_REASON_FOR_EXP = "K";// �⿱

	public static final String FAIL_REASON_FOR_WAIT = "W";// ��װ

	public static final String FAIL_REASON_FOR_OVER = "B";// ����

	// ������˱�־
	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_NEED_AUDIT = "A";// ��Ҫ���

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_WAIT_WITHDRAW = "K";// �ȴ�����

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_RETURN = "F";// ʧ�ܻص�

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_STAY = "S";// ʧ������

	// ���ͨ����־
	public static final String PASS_AUDIT = "Y";// ���ͨ��

	public static final String UN_PASS_AUDIT = "N";// ��˲�ͨ��

	// ϵͳ��ʶ
	public static final String SYSTEM_CRM = "CRM";// �ۺϿͷ�ϵͳ

	public static final String SYSTEM_SPS = "SPS";// ����ͨ

	public static final String SYSTEM_RMS = "RMS";// ��Դϵͳ

	public static final String SYSTEM_NAS = "NAS";// ���缤��ϵͳ

	public static final int DEFAULT_PAGE_SIZE = 15;

	public static final int DEFAULT_PAGE_SIZE_FOR_WORETURN = 50;// ʩ���������ÿҳ��ʾ��¼��

	// ��������
	public static final String TWO = "2";// 

	// ��������
	public static final String WO_TYPE_FOR_RETURN = "B";// �˵�

	public static final String WO_TYPE_FOR_SURVEY = "P"; // �⿱��

	public static final String WO_TYPE_FOR_BIDE = "Y"; // ��װ��

	public static final String WO_TYPE_FOR_NEED_PROC = "H"; // �޵�

	public static final String WO_TYPE_FOR_GO_BACK = "F"; // ׷��

	public static final String WO_TYPE_FOR_NORMAL = "N"; // ������

	// ������־
	public static final String HALT_FLAG_FOR_UN_HALT = "N"; // û������

	// ��̬��־
	public static final String DYN_FLAG_FOR_YES = "Y"; // ��̬

	public static final String DYN_FLAG_FOR_NO = "N"; // �Ƕ�̬

	// ԤԼ��־
	public static final String BOOK_FLAG_FOR_YES = "Y"; // ԤԼ

	public static final String BOOK_FLAG_FOR_NO = "N"; // ��ԤԼ

	// �ɵ���ʽ
	public static final String TABLE_NAME_FOR_EXCH_ID = "E"; // ������

	public static final String TABLE_NAME_FOR_LOCAL_NET_ID = "L"; // ��������

	public static final String TABLE_NAME_FOR_AREA_ID = "A"; // ��������

	// ��������
	public static final String ACT_TYPE_FOR_LOAD = "A"; // װ

	public static final String ACT_TYPE_FOR_REMOVE = "R"; // ��

	// ���ӵ���־
	public static final String MAIN_FLAG_FOR_MAIN = "M"; // ����

	public static final String MAIN_FLAG_FOR_SUITE = "S"; // �ӵ�

	// �����Ա�־
	public static final String FULL_FLAG_FOR_ALL = "C"; // �ӵ�

	// ԤԼ֪ͨ��ʽ
	public static final String NOTIFY_FLAG_FOR_YES = "Y"; // �Ѿ�֪ͨ

	public static final String NOTIFY_FLAG_FOR_NO = "N"; // δ֪ͨ

	// �ϵ���־
	public static final String MERG_FLAG_FOR_ALREADY_MERGE = "Y"; // �Ѿ��ϵ�

	public static final String MERG_FLAG_FOR_NO_MERGE = "N"; // ��û�кϵ�

	public static final String MERG_FLAG_FOR_NO_NEED_MERGE = "W"; // ����ϵ�

	// ���������־

	public static final String MSG_FLAG_NO_PROCESS_ = "0"; // û�д���

	public static final String MSG_FLAG_PROCESS_SUCCESS = "1"; // ����ɹ�

	public static final String MSG_FLAG_PROCESS_FAIL = "2"; // ����ʧ��
	
	
	public static final String WO_RET_CODE_SUCCESS = "1";//�ɹ��ص�
	
	public static final String WO_RET_CODE_FAIL = "0";//�ɹ��ص�	
	
	

	/** *************************��ͨ������*********************************** */

	// ��������
	public static final String STEP_TYPE_FOR_SYSTEM = "SC"; // ϵͳ�

	public static final String STEP_TYPE_FOR_ACCEPT = "SO"; // ����

	public static final String STEP_TYPE_FOR_SERVICE_DEVISE = "SD"; // �������

	public static final String STEP_TYPE_FOR_RESOUSE_ALLOCATE = "RA"; // ��Դ����

	public static final String STEP_TYPE_FOR_SERVICE_CONFIG = "SP"; // ��������

	public static final String STEP_TYPE_FOR_SERVICE_ACTIVE = "SA"; // ���񼤻�

	// ���������־
	public static final String PLUS_FLAG_FOR_NORMAL = "0"; // ����

	public static final String PLUS_FLAG_FOR_UN_NORMAL = "1"; // ������

	// ��������
	public static final String PLUS_TYPE_FOR_SURVEY = "E"; // �⿰

	public static final String PLUS_TYPE_FOR_BIDE = "W"; // ��װ

	// �ϵ���־
	public static final String MERG_FLAG_FOR_NEED = "Y"; // ��Ҫ�ϵ�

	public static final String MERG_FLAG_FOR_UN_NEED = "N"; // ���ϵ�

	// ƥ������ MATCH_TYPE

	public static final String MATCH_TYPE_BUSI_RULE = "R";// R ҵ�����

	public static final String MATCH_TYPE_SYS_ITEM = "P";// P ϵͳԪ��

	// ����� MATCH_OPERATOR
	public static final String MATCH_OPERATOR_EQUAL = "=";// = ���ڣ�

	public static final String MATCH_OPERATOR_UNEQUAL = "!=";// != �����ڣ�

	public static final String MATCH_OPERATOR_MORE_THAN = ">";// > ���ڣ�

	public static final String MATCH_OPERATOR_MORE_THAN_AND_EQUAL = ">=";// >=���ڵ��ڣ�

	public static final String MATCH_OPERATOR_LESS_THAN = "<";// < С�ڣ�

	public static final String MATCH_OPERATOR_LESS_THAN_AND_EQUAL = "<=";// <=С�ڵ���

	public static final String MATCH_OPERATOR_INCLUDE = "IN";// IN ������

	public static final String MATCH_OPERATOR_NOT_INCLUDE = "NOT IN";// NOT

	// ���ö���ģ��ƥ�� FOR_SO_MATCH C1 NULL Y Y ����N ������
	public static final String FOR_SO_MATCH_YES = "Y";

	public static final String FOR_SO_MATCH_NO = "N";

	// ���ر�־
	public static final String OPEN_FLAG_OPEN = "O";// O ���ã���

	public static final String OPEN_FLAG_CLOSE = "C";// C ���ã��ر�

	/** *******************ʩ������ҳ��*************************************************** */
	// ʩ������ҳ��
	public static final String Wo_BACK = "WoReturn";// �ص�ҳ��

	public static final String WO_FETCH = "WoFetchUnBook";// �쵥ҳ��

	public static final String WO_PRESS = "WoPress";// �ߵ�ҳ��

	public static final String WO_NOT_DUE = "WoFetchBook";// ԤԼҳ��

	public static final String WO_EXCEPTION = "WoException";// �쳣����ҳ��

	/** **************************sysconfig���õ�����******************************************* */
	// sysconfig���õ�����
	public static final String SYS_CONFIG_TYPE_PROVINCE = "G";// ȫʡͳһ������

	public static final String SYS_CONFIG_TYPE_LOCALNET = "L";// ������ͳһ������

	public static final String SYS_CONFIG_TYPE_AREA = "A";// ������ͳһ������

	public static final String SYS_CONFIG_TYPE_WORKAREA = "W";// ������ͳһ

	public static final String SYS_CONFIG_TYPE_EXCH = "E";// ����ͳһ

	/** ************************************************SEQ********************************************* */

	// SEQ
	public static final String SO_TEMPLATE_ID_SEQ = "SO_TEMPLATE_ID";

	public static final String INTER_CALL_CONFIG_ID_SEQ = "INTER_CALL_CONFIG_ID";

	public static final String SO_MATCH_ID_SEQ = "SO_MATCH_ID";

	public static final String SO_PROCESS_ID_SEQ = "SO_PROCESS_ID";

	public static final String FAIL_REASON_ID_SEQ = "FAIL_REASON_ID";// �쳣ԭ������

	public static final String STEP_REASON_ID_SEQ = "STEP_REASON_ID";

	public static final String COLLAB_RULE_ID_SEQ = "COLLAB_RULE_ID";// Эͬ��������

	public static final String COLLAB_RULE_BUSI_ID_SEQ = "COLLAB_RULE_BUSI_ID";// Эͬ����ҵ������

	public static final String WORK_TYPE_ID_SEQ = "WORK_TYPE_ID";// ������������

	public static final String WO_HANDLE_CUSTOM_SEQ = "WO_HANDLE_CUSTOM";// ʩ��������涨������

	public static final String QUERY_CONFIG_ID_SEQ = "QUERY_CONFIG_ID";// ��ѯ����

	public static final String INTER_SERVICE_ORDER_ID_SEQ = "INTER_SERVICE_ORDER_ID";// ���񶨵��ӿڱ�����

	public static final String PROCESS_COLLAB_RULE_ID_SEQ = "PROCESS_COLLAB_RULE_ID";// ����Эͬ������

	public static final String STEP_COLLAB_RULE_ID_SEQ = "STEP_COLLAB_RULE_ID";// ����Эͬ������

	public static final String SO_BOOK_ID_SEQ = "SO_BOOK_ID";// ����ԤԼ���

	public static final String SO_CHARGE_ID_SEQ = "SO_CHARGE_ID";// ����������Ϣ���

	public static final String WO_NBR_SEQ = "WO_NBR";// ��������

	public static final String CUST_ORDER_ITEM_ID_SEQ = "CUST_ORDER_ITEM_ID";// �ͻ�������ϸ

	public static final String CUST_ORDER_BUSINESS_ID_SEQ = "CUST_ORDER_BUSINESS_ID";// �ͻ���������񶨵���ϵ

	public static final String SO_SI_GROUP_MEMBER_ID_SEQ = "SO_SI_GROUP_MEMBER_ID";// ��������ʵ�����Ա

	public static final String SO_SI_GROUP_ID_SEQ = "SO_SI_GROUP_ID";// ��������ʵ����

	public static final String SO_RELA_ID_SEQ = "SO_RELA_ID";// ����������Ϣ

	public static final String SO_MAIN_PROD_ID_SEQ = "SO_MAIN_PROD_ID";// ��������Ʒ��Ϣ

	public static final String SO_PRICE_PLAN_ID_SEQ = "SO_PRICE_PLAN_ID";// �����۸�ƻ����

	public static final String SO_SUB_PROD_ID_SEQ = "SO_SUB_PROD_ID";// ����������Ʒ��Ϣ���

	public static final String SO_ACC_NBR_ID_SEQ = "SO_ACC_NBR_ID";// ��������ʵ�����

	public static final String SO_ADDR_ID_SEQ = "SO_ADDR_ID";// ������ַ���

	public static final String SO_EQPT_PROD_ID_SEQ = "SO_EQPT_PROD_ID";// �����ն��豸��Ϣ���

	public static final String SO_EQPT_PRPTY_ID_SEQ = "SO_EQPT_PRPTY_ID";// �����ն��豸������Ϣ���

	public static final String SO_MAIN_PROD_PRPTY_ID_SEQ = "SO_MAIN_PROD_PRPTY_ID";// ��������Ʒ������Ϣ���

	public static final String SO_MAIN_PROD_PRPTY_EXT_ID_SEQ = "SO_MAIN_PROD_PRPTY_EXT_ID";// ����Ʒ������չ���

	public static final String SO_SUB_PROD_PRPTY_ID_SEQ = "SO_SUB_PROD_PRPTY_ID";// ����������Ʒ������Ϣ���

	public static final String SO_SUB_PROD_PRPTY_EXT_ID_SEQ = "SO_SUB_PROD_PRPTY_EXT_ID";// ����������Ʒ������չ���

	public static final String SO_PROD_PAUSE_ID_SEQ = "SO_PROD_PAUSE_ID";// ������Ʒͣ����Ϣ���

	public static final String SO_CUST_ID_SEQ = "SO_CUST_ID";// �����ͻ���Ϣ���

	public static final String WO_HANDLE_SEQ = "WO_HANDLE_ID";// ����������¼��

	public static final String MSG_ID_SEQ = "MSG_ID";// ����ƥ����Ϣ SO_MSG_CENTER

	public static final String ACTION_LOG_SEQ = "ACTION_ID";// ����ƥ����Ϣ

	public static final String INTER_MSG_CENTER_ID_SEQ = "INTER_MSG_ID";// ����������Ϣ��

	public static final String STEP_COLLAB_INST_ID_SEQ = "STEP_COLLAB_INST_ID";// ����Э������ʵ�����

	public static final String PROCESS_COLLAB_INST_ID_SEQ = "PROCESS_COLLAB_INST_ID";// ����Э������ʵ�����

	public static final String SO_SI_GROUP_MEM_PRPTY_ID_SEQ = "SO_SI_GROUP_MEM_PRPTY_ID";// ��������ʵ�����Ա���Ա��

	public static final String SO_RES_ID_SEQ = "SO_RES_ID";// ������Դʵ�����

	public static final String RES_NWKSEG_ID_SEQ = "RES_NWKSEG_ID";// ��Դ���α��

	public static final String XMLHEADER_SERIALNO_FOR_RMS_SEQ = "XMLHEADER_SERIALNO_FOR_RMS";// ��Դ�ӿڲ�������

	public static final String SO_NBR_SEQ = "SO_NBR";// ��������

	public static final String SO_IP_ADDR_ID_SEQ = "SO_IP_ADDR_ID";// IP��ַ��Ϣ���

	public static final String SO_USERNAME_ID_SEQ = "SO_USERNAME_ID";// �����ʻ�������

	/** *******************�������ӿڲ���*********************************** */
	// �¼�
	public static final String PROC_START = "PROC_START";

	public static final String PROC_PAUSE = "PROC_PAUSE";

	public static final String PROC_CANCEL = "PROC_CANCEL";

	public static final String PROC_CONTINUE = "PROC_CONTINUE";

	public static final String WORKITEM_SUCCESS = "WORKITEM_SUCCESS";

	public static final String WORKITEM_FAIL = "WORKITEM_FAIL";

	// ���̹�ϵ����
	public static final String RELA_TYPE_FOR_MODIFY = "3";

	public static final String RELA_TYPE_FOR_REMOKE = "4";

	// ���������ؽ������
	public static final String RET_CODE_DO_SUCCESSED = "0";// ����ɹ� ����������������̣�

	// ������

	public static final String RET_CODE_PROC_INEXIST = "1";// ���̲�����

	// ��������
	public static final String RET_CODE_STOP_CURRENT_STEP = "2";// ͣ����ǰ���ڣ��쳣��������Ϊ������ǰ���ڣ�

	public static final String RET_CODE_EXCEPTION_PROCE_INEXIST = "3";// ��ѯ�����쳣����

	public static final String RET_CODE_RETURN_START_SYSTEM = "4"; // ���ط���ϵͳ���쳣���̴�������Ϊ���˵�����ϵͳ��

	public static final String RET_CODE_REVERSE_WORKITEM_NOFAILED = "5";// ���������ʧ�ܻص�

	public static final String RET_CODE_REVERSE_EXEC_SUCCESSFUL = "6";// ��ǰ�������Ѿ��ɹ�ִ�У����ܹ��ٴλص���

	// ʱʱ��־
	public static final String REAL_TIME = "1";// ʱʱ

	public static final String UN_REAL_TIME = "0";// ʱʱ

	// ��ѯ������ҳ��������
	public static final String ROWS_PER_PAGE = "20";

	// ����ͨ���ع���������˵��
	public static final String EXEC_SUCCESS = "EXECUTE_OK"; // ִ�гɹ�

	public static final String DISPATCH_SUCCESS = "DISPATCH_OK"; // �ɷ��ɹ�

	/** *******************CRM�ӿڲ���*********************************** */
	// �¾ɱ�־ NO_FLAG
	public static final String NO_FLAG_NEW = "A";// A ��

	public static final String NO_FLAG_OLD = "P";// P ��

	// �ͻ���Դ CUST_SOURCE
	public static final String CUST_SOURCE_BY_SELF = "A";// A ���ҷ�չ

	public static final String CUST_SOURCE_BY_RIVAL = "B";// B ��������

	// ��������ȷ�ϱ�־ CONFIG_FLAG
	public static final String CONFIG_FLAG_YES = "0";// 0:û��ȷ��

	public static final String CONFIG_FLAG_NO = "1";// 1:�Ѿ�ȷ��

	// ԤԼ������� BOOK_COUNT
	public static final String BOOK_COUNT_DEFAULT = "1";

	// �ͻ�������CUST_ORDER��״̬ STS
	public static final String CUST_ORDER_STS_NEW = "A";// A �½�

	public static final String CUST_ORDER_STS_ACC_ING = "B";// B ������

	public static final String CUST_ORDER_STS_ACC_ED = "C";// C ������

	public static final String CUST_ORDER_STS_DISUSE = "D";// D ����

	public static final String CUST_ORDER_STS_FINISH = "E";// E �ѿ���

	public static final String CUST_ORDER_STS_SEPARATE = "R";// R ���

	// �ͻ���������񶨵���ϵ��CUST_ORDER_BUSINESS��
	public static final String CUST_ORDER_BUSINESS_USE = "A";// ����

	public static final String CUST_ORDER_BUSINESS_UNUSE = "D";// ����

	public static final String CUST_ORDER_BUSINESS_SEPARATE = "R";// ���

	// ��������״̬��inter_serviece_ORDER ״̬ ��
	public static final String STS_ACCEPT_SUCCESS = "A";// �������ճɹ�

	public static final String STS_ANALYSIS_LOCK = "B";// ������������

	public static final String STS_AFREASH_LOCK = "F";// ������������

	public static final String STS_ANALYSIS_SUCCESS = "C";// ���������ɹ�

	public static final String STS_ANALYSIS_FAIL = "D";// ��������ʧ��

	public static final String STS_ERROR = "Z";// ���ݴ��󷵻�CRM�ɹ�

	public static final String STS_RETURN_ERROR = "Y";// ���ݴ��󷵻�CRMʧ��

	// �ͻ�������ϸ�������� ITEM_TYPE
	public static final String ITEM_TYPE_PROD_NEW = "A";// A ��Ʒ�¹�

	public static final String ITEM_TYPE_SERV_CHANGE = "B";// B ������

	// ���ұ�־
	public static final String IS_SELF_YES = "Y";// Y ��

	public static final String IS_SELF_NO = "N";// N �񣬹�����

	// �˹�ʩ��������
	public static final String MAN_WORK_TYPE_ID = "6";// Y ��

	// isSelf 0:����ʵ�� 1:ʵ������ 2:��ǰ��Ʒʵ��
	public static final String IS_SELF_REL = "0";

	public static final String IS_SELF_SEL = "1";

	public static final String IS_SELF_BEF = "2";

	// �����־ Y �б�� N δ���
	public static final String CHANGED_FLAG_YES = "Y";

	public static final String CHANGED_FLAG_NO = "N";

	// ������־ IS_MAIN Y ����Ʒ N ������Ʒ
	public static final String IS_MAIN_YES = "Y";

	public static final String IS_MAIN_NO = "N";

	// ��������״̬
	public static final String SO_ANALYSIS_SECCESS = "C";

	public static final String SO_ANALYSIS_FAIL = "D";

	// ��������
	public static final String RELATED_TYPE_FUTILITY = "1";// ע����

	public static final String RELATED_TYPE_MODIFY = "2";// �޸ĵ�

	public static final String RELATED_TYPE_NORMOY = "0";// ������

	public static final String RELATED_TYPE_FOR_WAIT = "3";// ��װ��

	public static final String RELATED_TYPE_FOR_AGAIN = "4";// ��װ��

	// �������ظ�CRM���״̬
	public static final String RESULT_CODE_SUCCESS = "0";// �ɹ�

	public static final String RESULT_CODE_FAIL = "1";// ʧ��

	// �������ĵ����
	public static final String AUDIT_PASS = "0";// �ɹ�

	public static final String AUDIT_UN_PASS = "1";// ʧ��

	// �ش�CRM������������

	public static final String SO_RETURN_TYPE_FINISH = "C";// ��������

	public static final String SO_RETURN_TYPE_BACK = "T";// �˵�����

	public static final String SO_RETURN_TYPE_FAIL = "F";// ����ʧ�ܷ���

	public static final String SO_RETURN_TYPE_REMOVE = "E";// ������ɷ���

	// ��������
	public static final String EXPT_TYPE_SO_MODIFY = "2";// �޸ĵ�

	public static final String EXPT_TYPE_FUTILITY = "1";// ע����

	public static final String EXPT_TYPE_RE_RECEIVE = "6";// �ط���

	public static final String EXPT_TYPE_RELE_RES = "7";// ��Դ�ͷ�

	/** *********************************��Դ�ӿ�***************************************** */
	// �ӿڱ���(_EID)
	public static final String EID_RES_SO_SYNC_SERV_REQ = "RES_SO_SYNC_SERV_REQ";// ����ͬ������

	public static final String EID_RES_SO_SYNC_SERV_RESP = "RES_SO_SYNC_SERV_RESP";// ����ͬ������

	public static final String EID_RES_DSGN_SERV_REQ = "RES_DSGN_SERV_REQ";// �����������

	public static final String EID_RES_DSGN_SERV_RESP = "RES_DSGN_SERV_RESP";// ������Ʒ���

	public static final String EID_RES_QRY_SERV_REQ = "RES_QRY_SERV_REQ";// ��ѯ��Դ��������

	public static final String EID_RES_ASGN_SERV_REQ = "RES_ASGN_SERV_REQ";// ������Դ��������

	public static final String EID_RES_CNL_SERV_REQ = "RES_CNL_SERV_REQ";// ������Դ��������

	public static final String EID_RES_SO_REVERSE_REQ = "RES_SO_REVERSE_REQ";// ������������

	public static final String EID_RES_ASGN_SERV_RESP = "RES_ASGN_SERV_RESP";// ������Դ���񷵻�

	public static final String EID_RES_ARC_SERV_REQ = "RES_ARC_SERV_REQ";// �鵵��������

	public static final String EID_RES_ARC_SERV_RESP = "RES_ARC_SERV_RESP";// �鵵���񷵻�

	public static final String EID_RES_CHECK_REQ = "RES_CHECK_REQ";// ��Դ�ʼ�����

	public static final String EID_RES_CHECK_RESP = "RES_CHECK_RESP";// ��Դ�ʼ췵��

	// �ӿڱ�ʶfuncode

	public static final String FUNCODE_SO_SYNC_REQUEST = "soSyncRequest"; // ���񶨵�ͬ������

	public static final String FUNCODE_SO_SYNC_RESPONSE = "soSyncResponse"; // ���񶨵�ͬ������

	public static final String FUNCODE_RES_QUERY_REQUEST = "resQueryRequest"; // ��Դ�����ѯ����

	public static final String FUNCODE_RES_ASSIGN_REQUEST = "resAssignRequest";// ��Դ������������

	public static final String FUNCODE_RES_ASSIGN_RESPONSE = "resAssignResponse"; // ��Դ�������÷���

	public static final String FUNCODE_RES_ASSIGN_CANCEL_REQUEST = "resAssignCancelRequest";// ��Դ��������ȡ������

	public static final String FUNCODE_RES_SO_REVERSE_REQUEST = "soReverseRequest";// ������Դ����

	public static final String FUNCODE_RES_DISIGN_REQUEST = "resDesignRequest"; // ��Դ�����������

	public static final String FUNCODE_RES_DESIGN_RESPONSE = "resDesignResponse";// ��Դ������Ʒ���

	public static final String FUNCODE_RES_ARCHIVE_REQUEST = "resArchiveRequest"; // ��Դ�鵵����

	public static final String FUNCODE_RES_ARCHIVE_RESPONSE = "resArchiveResponse";// ��Դ�鵵����

	public static final String FUNCODE_RES_CHECK_REQUEST = "resCheckRequest";// ��Դ�ʼ�����

	public static final String FUNCODE_RES_CHECK_RESPONSE = "resCheckResponse"; // ��Դ�ʼ췴��

	// ��֤�û�
	public static final String RES_SECURITY_PRINCIPAL = "admin"; // �û�

	// ��֤����
	public static final String RES_SECURITY_CREDENTIALS = "qazwsxedc";// ����

	// ͨѶ��ʽ
	public static final String EVENT_TYPE_FOR_SYNC = "SYNC"; // ͬ��

	public static final String EVENT_TYPE_FOR_ASYN = "ASYN"; // �첽

	//
	public static final String APPLICATION_SYSTEM = "SPS"; // ����ͨϵͳ

	// ��Դ���ر���
	public static final String RES_RESULT_CODE_SUCCESS = "0"; // ���óɹ�

	// ��������
	public static final String ACT_TYPE_ASSIGN = "A"; // ��Դ����

	public static final String ACT_TYPE_QUERY = "Q"; // ��Դ��ѯ

	public static final String ACT_TYPE_CANCEL = "C"; // ��Դ����

	// AZ��־ת��
	public static final String AZ_FLAG_TYPE_A = "1";// ��ӦAZ_FLAG ��A��

	public static final String AZ_FLAG_TYPE_Z = "2";// ��ӦAZ_FLAG��Z��

	// AZ_FLAGAZ�˱�־
	public static final String AZ_FLAG_A = "A";// A��

	public static final String AZ_FLAG_Z = "Z";// Z��

	/** *******************������ӡ����*********************************** */

	public static final float PAGELENGTH = 297;// ҳ�泤�� ��λmm

	public static final float PAGEWIDTH = 210;// ҳ���� ��λmm

	/** *********************SQL��ѯ״̬����*************************************** */

	public static final String STATUS_HIS = "_HIS";// ��ѯ��ʷ��

	public static final String STATUS_ARC = "_ARC";// ��ѯ�鵵��

	/** ***********************��������id************************************************** */
	public static final String OFTEN_BACK_HANDLE_ID = "220049";// �ص������ص�

	public static final String FAIL_BACK_HANDLE_ID = "220050"; // �ص�ʧ�ܻص�

	// public static final String DUE_APPLY_HANDLE_ID = ""; // �쵥ԤԼ����

	// public static final String DUE_MODIFY_HANDLE_ID = ""; // �쵥ԤԼ�޸�

	public static final String SECOND_ASSIGN_HANDLE_ID = "220051"; // �쵥�����ɷ�

	public static final String FETCH_HANDLE_ID = "220052"; // �쵥

	// public static final String VIEW_UNION_HANDLE_ID = ""; // �ߵ��鿴������

	public static final String EXCEPTION_OFTEN_BACK_HANDLE_ID = "220053"; // �쳣���������ص�

	public static final String EXCEPTION_FAIL_BACK_HANDLE_ID = "220054"; // �쳣����ʧ�ܻص�

	public static final String EXCEPTION_RESDO_HANDLE_ID = "220055"; // �쳣�����쳣�ط�

	public static final String DUE_HANDLE_ID = "220056"; // ԤԼδ���ڹ���ԤԼ

	public static final String SO_MATCH_PROCESS_FAIL = "0"; // ����ƥ�䴦��ʧ��

	public static final String SO_MATCH_PROCESS_SUCCESS = "1";// ����ƥ�䴦��ɹ�

	// --------------------------ϵͳcontext����
	public static final String CONTEXT_WFS = "wfs";// context-config.xml�й�������������

	public static final String CONTEXT_RMS = "rms";// context-config.xml����Դ��������

	public static final String CONTEXT_NAI = "nai";// context-config.xml����Դ��������

}
