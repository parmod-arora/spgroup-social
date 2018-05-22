package com.spgroup.social.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spgroup.social.dao.domain.Subscription;
import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
@Transactional(readOnly=true)
@Service
public interface SubscriptionService {
	
	@Transactional(readOnly=false)
	public void addSubscription(String user, String subscribedTo);

	@Transactional(readOnly=false)
	public void blockSubscription(String requestor, String target);

	public Set<String> getAllSubscription(String sender, String text);
	
	public Subscription getSubscriptionEntity(User user, User subscribedTo);

}
