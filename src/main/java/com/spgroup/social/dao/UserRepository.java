package com.spgroup.social.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spgroup.social.dao.domain.User;

/**
 * @author parmod
 *
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
	public List<User> findAll();

	@Query("SELECT t FROM User t WHERE t.id in :ids")
    public List<User> findByIdsIn(@Param("ids") List<Long> ids);
	
	public Optional<User> findById(String email);

	public Optional<User> findByEmail(String email);

}
