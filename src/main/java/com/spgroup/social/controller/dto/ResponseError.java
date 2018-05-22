package com.spgroup.social.controller.dto;

/**
 * @author parmod
 *
 */
public class ResponseError {

	private Boolean error = Boolean.TRUE;
	private String msg;

	public ResponseError() {
	}

	public ResponseError(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
