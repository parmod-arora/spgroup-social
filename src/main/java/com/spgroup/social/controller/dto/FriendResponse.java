package com.spgroup.social.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author parmod
 *
 */
@JsonInclude(Include.NON_NULL)
public class FriendResponse {

	private Boolean success = Boolean.TRUE;
	private List<String> friends;
	private Integer count;
	private String msg;

	/**
	 * @param success
	 */
	public FriendResponse() {
	}

	/**
	 * @param success
	 * @param friends
	 */
	public FriendResponse(List<String> friends) {
		this.friends = friends;
	}

	/**
	 * @param success
	 * @param friends
	 * @param count
	 */
	public FriendResponse(List<String> friends, Integer count) {
		this.friends = friends;
		this.count = count;
	}
	
	public FriendResponse(String msg, Boolean status) {
		this.success= status;
		this.msg=msg;
	}

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the friends
	 */
	public List<String> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
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
