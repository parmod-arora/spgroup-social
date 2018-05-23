package com.spgroup.social.dao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * @author parmod
 *
 */
@Entity
@Table(name ="tbl_user_subscription")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="subscribed_to")
	private User subscribeTo;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private SubscriptionStatus status;
	
	@Column(name="created_on")
	private Date createdOn= new Date();
	
	@Column(name="updated_on")
	private Date updatedOn= new Date();
	
	@PreUpdate
	public void setLastUpdate() {  this.updatedOn = new Date(); }

	/**
	 * @param user
	 * @param subscribeTo
	 * @param status
	 */
	public Subscription(User user, User subscribeTo, SubscriptionStatus status) {
		this.user = user;
		this.subscribeTo = subscribeTo;
		this.status = status;
	}
	public Subscription() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the subscribeTo
	 */
	public User getSubscribeTo() {
		return subscribeTo;
	}

	/**
	 * @param subscribeTo the subscribeTo to set
	 */
	public void setSubscribeTo(User subscribeTo) {
		this.subscribeTo = subscribeTo;
	}

	/**
	 * @return the status
	 */
	public SubscriptionStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}
	
}
