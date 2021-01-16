package pl.wwsis.microblog.dao;

public interface FollowerDao {
	void followUser(long userId, long followerId);
	void removeFollower(long userId, long followerId);
	boolean isFollowing(long userId, long followerId);
}
