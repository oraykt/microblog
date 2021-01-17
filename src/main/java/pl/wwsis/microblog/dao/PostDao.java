package pl.wwsis.microblog.dao;

import java.util.List;

public interface PostDao<Post> {
	List<Post> getUserTimeline(long id);

	List<Post> getUserFullTimeline(long id);

	List<Post> getFullPublicTimeline();
}
