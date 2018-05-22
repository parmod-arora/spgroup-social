/**
 * 
 */
package com.spgroup.social.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgroup.social.controller.error.UserNotFoundException;
import com.spgroup.social.dao.UserRepository;
import com.spgroup.social.dao.domain.Subscription;
import com.spgroup.social.dao.domain.SubscriptionStatus;
import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubscriptionService subscriptionService;


	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void addFriend(String requestor, String target) {
		User user = findUserByEmail(requestor);
		User friend = findUserByEmail(target);
		makeFriends(user, friend);
		subscriptionService.addSubscription(requestor, target);
	}

	private void makeFriends(User user, User friend) {
		user.getFriends().add(friend);
		friend.getFriends().add(user);
		userRepository.save(user);
	}

	@Override
	public List<String> allFriendsEmail(String user) {
		User userObj = findUserByEmail(user);
		return userObj.getFriends().stream().map(friend -> friend.getEmail()).collect(Collectors.toList());
	}

	@Override
	public List<String> getMutualFriendsEmail(String u1, String u2) {
		User user1 = findUserByEmail(u1);
		User user2 = findUserByEmail(u2);
		List<Long> ids = userRepository.commonfriends(user1.getId(), user2.getId());
		List<User> commonUsers = userRepository.findByIdsIn(ids);
		return commonUsers.stream().map(friend -> friend.getEmail()).collect(Collectors.toList());
	}
	
	@Override
	public User findUserByEmail(String email) throws UserNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		return user.orElseThrow(() -> new UserNotFoundException(email));
	}

	@Override
	public boolean isEligbleForFriendship(String requestor, String target) {
		User user1 = findUserByEmail(requestor);
		User user2 = findUserByEmail(target);
		Subscription subscription = subscriptionService.getSubscriptionEntity(user1, user2);
		if(null != subscription) {
			return subscription.getStatus() != SubscriptionStatus.Block;
		}
		return true;
	}
}
