package pl.wwsis.microblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // allows automatic generation of user ids
	private long id;
	// all fields have to be filled that's why there nullable parameter is used
	@Column(name = "userId", nullable = false)
	private long userId;

	@Column(name = "followerId", nullable = false)
	private long followerId;

	public Follower() {
		super();
	}

	public Follower(long userId, long followerId) {
		super();
		this.userId = userId;
		this.followerId = followerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(long followerId) {
		this.followerId = followerId;
	}
}
