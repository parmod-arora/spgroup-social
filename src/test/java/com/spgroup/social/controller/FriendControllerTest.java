package com.spgroup.social.controller;

import static org.mockito.BDDMockito.given;
//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
//import java.util.regex.Matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spgroup.social.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(FriendController.class)
public class FriendControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Test
	public void getAllFriendsTest() throws Exception {
		String response[] = { "A", "B" };
		String request = "{ \"email\" : \"test@test.com\"}";
		given(this.userService.allFriendsEmail("test@test.com")).willReturn(Arrays.asList(response));
		mvc.perform(MockMvcRequestBuilders.post("/friends")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.success").value("true"))
				.andExpect(jsonPath("$.friends[0]").value("A"))
				.andExpect(jsonPath("$.friends[1]").value("B"));
	}
	
	@Test
	public void commonFriendTest() throws Exception {
		String response[] = { "test1@test.com" };
		String request = "{ \"friends\" : [\"request@test.com\", \"friend@test.com\"]}";
		given(this.userService.getMutualFriendsEmail("request@test.com", "friend@test.com")).willReturn(Arrays.asList(response));
		mvc.perform(MockMvcRequestBuilders.post("/friends/common")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.success").value("true"))
		        .andExpect(jsonPath("$.friends[0]").value("test1@test.com"));
	}
	
	@Test
	public void addFriendTest() throws Exception {
		String request = "{ \"friends\" : [\"request@test.com\", \"friend@test.com\"]}";
		given(this.userService.isEligbleForFriendship("request@test.com", "friend@test.com")).willReturn(false);
		mvc.perform(MockMvcRequestBuilders.post("/friends/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request)
				.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.error").value("true"));
	}

}
