package com.spgroup.social.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

/**
 * @author parmod
 *
 */
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	private static final String COMMON_FRIENDS = "select u1.friend_id as id from tbl_user_friends u1"
	        + " inner join tbl_user_friends u2 ON u1.friend_id = u2.friend_id"
	        + " where (u1.user_id = :user1 and u2.user_id = :user2)";

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Long> commonfriends(Long user1, Long user2) {
		Query query = em.createNativeQuery(COMMON_FRIENDS);
		return query.unwrap(NativeQuery.class)
				.setParameter("user1", user1)
				.setParameter("user2", user2)
				.addScalar("id", new LongType())
				.list();
	}

}
