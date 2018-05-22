package com.spgroup.social.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author parmod
 *
 */
@Repository
public interface UserRepositoryCustom {
	public List<Long> commonfriends(Long id, Long id2);
}
