package com.spgroup.social.controller.error;

/**
 * @author parmod
 *
 */
public class NotEligibleForFriendsException extends RuntimeException {

	private static final long serialVersionUID = 982243966395720882L;

	public NotEligibleForFriendsException() {
		super("One of the email has blocked other email");
	}

}
