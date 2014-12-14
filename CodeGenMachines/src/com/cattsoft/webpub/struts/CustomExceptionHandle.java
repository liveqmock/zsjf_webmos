package com.cattsoft.webpub.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
/**
 *
 * Title: �¾���ϵͳstruts�ṹ���Զ����ExceptionHandler<br>
 * Description: ��ExceptionHandler��Ҫ����ϵͳ�Զ�������������action�ｫ���ٲ�׽���󣬶��ڴ˴�ͳһ����<br>
 * Copyright: Copyright (c) 2004<br>
 * Company: CATTSoft<br>
 * @author �����
 * @version 1.0
 */


public class CustomExceptionHandle extends ExceptionHandler {
  public CustomExceptionHandle() {
  }

    private static Log log = LogFactory.getLog(CustomExceptionHandle.class);
    /**
     *
     * @param ex Exception
     * �����Ĵ���
     * @param ae ExceptionConfig
     * ��������
     * @param mapping ActionMapping
     * @param formInstance ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     */
    public ActionForward execute(Exception ex,
                             ExceptionConfig ae,
                             ActionMapping mapping,
                             ActionForm formInstance,
                             HttpServletRequest request,
                             HttpServletResponse response) {
  /*String url=request.getRequestURI();
  request.setAttribute("url",url);*/
  if(ex instanceof SysException) {
      log.debug("SysException:---------------------------"+((SysException)ex).getErrMsg());
      log.debug("SysException OriMsg:---------------------------"+((SysException)ex).getErrMsgOri());
      ((SysException)ex).printDebug();
      request.getSession().setAttribute("errInfo", ex);
      return mapping.findForward("errorSys");
    }else if(ex instanceof AppException) {
        log.debug("AppException:---------------------------"+((AppException)ex).getErrId()+":"+((AppException)ex).getErrMsg());
        request.getSession().setAttribute("errInfo", ex);
        return mapping.findForward("errorApp");
  }
  
  return mapping.findForward("errorSys");
}


}
