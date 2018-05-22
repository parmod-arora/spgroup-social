/**
 * 
 */
package com.spgroup.social.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spgroup.social.controller.error.UserNotFoundException;
import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
@Transactional(readOnly=true)
@Service
public interface UserService {

	public List<User> findAll();
	
	@Transactional(readOnly=false)
	public void addFriend(String user, String friend);

	public List<String> allFriendsEmail(String email);
	
	public List<String> getMutualFriendsEmail(String user1, String user2);
	
	public User findUserByEmail(String email) throws UserNotFoundException;

	public boolean isEligbleForFriendship(String requestor, String target);

}
