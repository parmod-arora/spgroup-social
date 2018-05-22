package com.spgroup.social.controller.dto;

/**
 * @author parmod
 *
 */
public class SubscrptionRequestDto {
	private String requestor;
	private String target;

	/**
	 * @return the requestor
	 */
	public String getRequestor() {
		return requestor;
	}

	/**
	 * @param requestor
	 *            the requestor to set
	 */
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @param requestor
	 * @param target
	 */
	public SubscrptionRequestDto(String requestor, String target) {
		this.requestor = requestor;
		this.target = target;
	}
	
	public SubscrptionRequestDto() {
	}

}
