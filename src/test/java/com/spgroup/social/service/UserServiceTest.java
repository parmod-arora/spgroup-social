package com.spgroup.social.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.spgroup.social.dao.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testServices() {
		assertThat(userService).isNotNull();
	}

	@Test
	public void findAllTest() throws Exception {
		List<User> list = userService.findAll();
		assertEquals(list.size(), 20);
	}
	
	@Test
	@Rollback
	public void addFriendTest() throws Exception {
		userService.addFriend("test20@test.com", "test19@test.com");
	}
	
	@Test
	public void allFriendsEmail() throws Exception {
		List<String> emails =userService.allFriendsEmail("test1@test.com");
		assertEquals(emails.size(), 7);
		assertNotEquals(emails.size(), 0);
	}

}
