package pl.wwsis.microblog.dao;

public interface FollowerDao {
	void addFollowUser(long userId, long followerId);

	int removeFollower(long userId, long followerId);

	boolean isFollowing(long userId, long followerId);
}
