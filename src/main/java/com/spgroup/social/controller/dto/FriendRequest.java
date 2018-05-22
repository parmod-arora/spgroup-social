package com.spgroup.social.controller.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author parmod
 *
 */

public class FriendRequest {
	private List<String> friends = new ArrayList<String>();

	public FriendRequest() {
	}

	/**
	 * @return the friends
	 */
	public List<String> getFriends() {
		return friends;
	}

	/**
	 * @param friends
	 *            the friends to set
	 */
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
}