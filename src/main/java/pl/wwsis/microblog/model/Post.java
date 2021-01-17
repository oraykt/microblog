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
	private long id;

	// all fields have to be filled that's why there nullable parameter is used
	@Column(name = "userId", nullable = false)
	private long userId;

	@Column(name = "post", nullable = false, length = 250)
	private String post;

	public Post() {
		super();
	}

	public Post(long userId, String post) {
		super();
		this.userId = userId;
		this.post = post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
