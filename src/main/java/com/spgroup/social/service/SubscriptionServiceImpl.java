package com.spgroup.social.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgroup.social.AppConstants;
import com.spgroup.social.dao.SubscriptionRepository;
import com.spgroup.social.dao.domain.Subscription;
import com.spgroup.social.dao.domain.SubscriptionStatus;
import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private UserService userService;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public void addSubscription(String userEmail, String subscribedToEmail) {
		User user = userService.findUserByEmail(userEmail);
		User subscribedTo = userService.findUserByEmail(subscribedToEmail);
		subscriptionRepository.save(new Subscription(user, subscribedTo, SubscriptionStatus.Active));
	}

	@Override
	public void blockSubscription(String requestor, String target) {
		User user = userService.findUserByEmail(requestor);
		User subscribedTo = userService.findUserByEmail(target);
		Subscription subscription = getSubscriptionEntity(user, subscribedTo);
		blockSubscription(subscription, user, subscribedTo);
	}

	public Subscription getSubscriptionEntity(User user, User subscribedTo) {
		return subscriptionRepository.findSubscriptionByUserAndSubscribedTo(user, subscribedTo);
	}

	private void blockSubscription(Subscription subscription, User user, User subscribedTo) {
		if (null == subscription) {
			subscription = new Subscription(user, subscribedTo, SubscriptionStatus.Block);
		} else {
			subscription.setStatus(SubscriptionStatus.Block);
		}
	}

	@Override
	public Set<String> getAllSubscription(String sender, String text) {
		Set<String> subscriptions = new HashSet<String>();
		subscriptions.addAll(extractEmailsfromTest(text));
		subscriptions.addAll(allActiveSubscriptions(sender));
		return subscriptions;
	}

	private List<String> allActiveSubscriptions(String email) {
		User user = userService.findUserByEmail(email);
		List<User> activeSubsciptions = subscriptionRepository.findAllUserSubscriptionByStatus(user,
		        SubscriptionStatus.Active);
		return activeSubsciptions.stream().map(subscriber -> subscriber.getEmail()).collect(Collectors.toList());
	}

	private List<String> extractEmailsfromTest(String text) {
		List<String> emails = new ArrayList<String>();
		Matcher m = Pattern.compile(AppConstants.EmailExtrationRegex).matcher(text);
		while (m.find()) {
			emails.add(m.group());
		}
		System.out.println(emails);
		return emails;
	}

}
