/**
 * 
 */
package com.spgroup.social.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author parmod
 *
 */
@JsonInclude(Include.NON_NULL)
public class SubscriptionResponse {
	
	public Boolean success = Boolean.TRUE;
	public Set<String> friends;
	/**
	 * @param success
	 * @param friends
	 */
	public SubscriptionResponse(Set<String> friends) {
		this.friends = friends;
	}
	
	public SubscriptionResponse() {
	}

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the friends
	 */
	public Set<String> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}
	
}
