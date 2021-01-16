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

	// all fields have to be filled that's why there nullable parameter used
	@Column(name = "userId", nullable = false)
	private int userId;

	@Column(name = "followerId", nullable = false)
	private int followerId;

	public Follower(int userId, int followerId) {
		super();
		this.userId = userId;
		this.followerId = followerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
}
