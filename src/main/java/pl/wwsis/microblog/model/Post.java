package pl.wwsis.microblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // allows automatic generation of user ids

	// all fields have to be filled that's why there nullable parameter used
	@Column(name = "userId", nullable = false)
	private int userId;

	@Column(name = "post", nullable = false, length = 250)
	private String post;

	public Post(int userId, String post) {
		super();
		this.userId = userId;
		this.post = post;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
}
