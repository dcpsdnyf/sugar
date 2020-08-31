package com.sugar.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends GenericException {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(BusinessException.class);

    private BusinessException() {
    	
    }
    
    public BusinessException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        this.writeBusinessException();
    }

    public BusinessException(String errorCode, String[] keyInfos) {
        super(errorCode);
        this.errorCode = errorCode;
        this.writeBusinessException();
    }

    public BusinessException(String errorCode, String keyInfo) {
        super(errorCode, keyInfo);
        this.errorCode = errorCode;
        this.writeBusinessException();
    }

    public BusinessException(String errorCode, String errorMessage, boolean notransfer) {
        super(errorCode);
        this.errorCode = errorCode;
        this.writeBusinessException();
    }

    private void writeBusinessException() {
        log.error("业务异常编码：" + this.getErrorCode());
        log.error("业务异常信息：" + this.getErrorMessage());
    }
    
    public static BusinessException buildSimple(String errorMessage) {
    	BusinessException e=new BusinessException();
    	e.setErrorMessage(errorMessage);
    	return e;
    }
}
