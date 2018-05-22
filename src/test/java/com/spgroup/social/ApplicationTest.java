/**
 * 
 */
package com.spgroup.social;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spgroup.social.controller.FriendController;
import com.spgroup.social.controller.SubscriptionController;
import com.spgroup.social.dao.SubscriptionRepository;
import com.spgroup.social.dao.UserRepository;
import com.spgroup.social.service.SubscriptionService;
import com.spgroup.social.service.UserService;

/**
 * @author parmod
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private FriendController friendController;
	
	@Autowired
	private SubscriptionController subscriptionController;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Test
	public void testControllers() {
		assertThat(friendController).isNotNull();
		assertThat(subscriptionController).isNotNull();
	}
	
	@Test
	public void testServices() {
		assertThat(userService).isNotNull();
		assertThat(subscriptionService).isNotNull();
	}
	
	@Test
	public void testRepository() {
		assertThat(userRepository).isNotNull();
		assertThat(subscriptionRepository).isNotNull();
	}

}
