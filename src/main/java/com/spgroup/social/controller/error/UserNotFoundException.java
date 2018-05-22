package com.spgroup.social.controller.error;

/**
 * @author parmod
 *
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 982243966395720882L;
	
	public UserNotFoundException(String email) {
		super("User Not found "+ email);
	}
}
