package com.spgroup.social;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author parmod
 *
 */
@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private String email;

	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(
		name = "tbl_user_friends",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName="id")
	)
	@JsonIgnore
	private Set<User> friends = new HashSet<User>();

	/**
	 * @param email
	 */
	public User(String email) {
		super();
		this.email = email;
	}

	public User() {
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the friends
	 */
	public Set<User> getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

}
