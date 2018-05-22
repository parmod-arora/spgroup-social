package com.spgroup.social.controller.dto;

/**
 * @author parmod
 *
 */
public class AllSubscriptionRequestDto {
	private String sender;
	private String text;

	/**
	 * @param sender
	 * @param text
	 */
	public AllSubscriptionRequestDto(String sender, String text) {
		super();
		this.sender = sender;
		this.text = text;
	}
	public AllSubscriptionRequestDto() {
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
