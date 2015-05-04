package com.example.spring.mvc.exception;


/**
 * @author Maulik
 * 
 */
public class CustomGenericException extends Exception {

	private static final long serialVersionUID = 3555707970096485786L;

	private String errCode;
	private String errMsg;

	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "CustomGenericException [errCode=" + errCode + ", errMsg="
				+ errMsg + "]";
	}

}
