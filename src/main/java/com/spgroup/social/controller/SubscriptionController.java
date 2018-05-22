/**
 * 
 */
package com.spgroup.social.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spgroup.social.controller.dto.AllSubscriptionRequestDto;
import com.spgroup.social.controller.dto.SubscriptionResponse;
import com.spgroup.social.controller.dto.SubscrptionRequestDto;
import com.spgroup.social.service.SubscriptionService;

/**
 * @author parmod
 *
 */
@RestController
@RequestMapping("/user/subscriptions")
public class SubscriptionController {
	
	private SubscriptionService subscriptionService;
	
	public SubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	@PostMapping("/add")
	public SubscriptionResponse addSubscription(@RequestBody SubscrptionRequestDto request) {
		// @TODO if blocked should not allow
		subscriptionService.addSubscription(request.getRequestor(), request.getTarget());
		return new SubscriptionResponse();
	}
	
	@PostMapping("/block")
	public SubscriptionResponse blockSubscription(@RequestBody SubscrptionRequestDto request) {
		subscriptionService.blockSubscription(request.getRequestor(), request.getTarget());
		return new SubscriptionResponse();
	}
	
	@PostMapping
	public SubscriptionResponse allSubscriptions(@RequestBody AllSubscriptionRequestDto request) {
		Set<String> list= subscriptionService.getAllSubscription(request.getSender(), request.getText());
		return new SubscriptionResponse(list);
	}
		
}
