package pl.wwsis.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.wwsis.microblog.dao.FollowerDao;

@Transactional
public class FollowerDaoImpl implements FollowerDao {

	@PersistenceContext
	EntityManager entityManager;

	public void followUser(long userId, long followerId) {
		String hql = "INSERT INTO Followers(userId, followerId) VALUES(?,?)";
		Query query = entityManager.createQuery(hql);
		query.executeUpdate();
	}

	public void removeFollower(long userId, long followerId) {
		String hql = "DELETE FROM Followers WHERE userId = :userId AND followerId = :followerId";
		Query query = entityManager.createQuery(hql);
		query.executeUpdate();
	}

	public boolean isFollowing(long userId, long followerId) {
		String hql = "SELECT * FROM Followers WHERE userId = :userId AND followerId = :followerId";
		Query query = entityManager.createQuery(hql);
		int result = query.getFirstResult();

		// here we check if user is our tracking list
		if (result > 0) {
			return true;
		}

		return false;
	}

}
