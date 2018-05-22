/**
 * 
 */
package com.spgroup.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spgroup.social.controller.dto.FriendRequest;
import com.spgroup.social.controller.dto.FriendResponse;
import com.spgroup.social.controller.dto.RequestAllFriends;
import com.spgroup.social.controller.error.NotEligibleForFriendsException;
import com.spgroup.social.dao.domain.User;
import com.spgroup.social.service.UserService;

/**
 * @author parmod
 *
 */
@RestController
@RequestMapping("/friends")
public class FriendController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> all() {
		return userService.findAll();
	}
	
	@PostMapping
	public FriendResponse getAllFriends(@RequestBody RequestAllFriends request) {
		List<String> friends = userService.allFriendsEmail(request.getEmail());
		return new FriendResponse(friends, friends.size());
	}

	@PostMapping("/add")
	public FriendResponse addFriend(@RequestBody FriendRequest request) {
		String requestor = request.getFriends().get(0);
		String target = request.getFriends().get(1);
		boolean eligble = userService.isEligbleForFriendship(requestor, target);
		if(!eligble) {
			throw new NotEligibleForFriendsException();
		}
		userService.addFriend(requestor, target);
		return new FriendResponse();
		
	}

	@PostMapping("/common")
	public FriendResponse getCommonFriends(@RequestBody FriendRequest request) {
		List<String> friends = userService.getMutualFriendsEmail(request.getFriends().get(0),
		        request.getFriends().get(1));
		return new FriendResponse(friends, friends.size());
	}

}
