package com.spgroup.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spgroup.social.dao.domain.Subscription;
import com.spgroup.social.dao.domain.SubscriptionStatus;
import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	@Query("select sub from Subscription sub where sub.user=:user and sub.subscribeTo=:subscribedTo")
	public Subscription findSubscriptionByUserAndSubscribedTo(@Param("user") User user,
	        @Param("subscribedTo") User subscribedTo);

	@Query("Select sub.subscribeTo from Subscription sub where sub.user=:user and sub.status=:status")
	public List<User> findAllUserSubscriptionByStatus(@Param("user") User user, @Param("status") SubscriptionStatus status);

}
