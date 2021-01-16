package pl.wwsis.microblog.dao;

import java.util.List;

public interface PostDao<T> {
	List<T> getUserTimeline(long id);
	List<T> getUserFullTimeline(long id);
	List<T> getFullPublicTimeline();
}
