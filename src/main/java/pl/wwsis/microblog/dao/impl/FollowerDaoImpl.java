package pl.wwsis.microblog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import pl.wwsis.microblog.dao.FollowerDao;
import pl.wwsis.microblog.model.Follower;

@Transactional
public class FollowerDaoImpl implements FollowerDao {

	@PersistenceContext
	EntityManager entityManager;

	public void addFollowUser(long userId, long followerId) {
		entityManager.persist(new Follower(userId, followerId));
	}

	public int removeFollower(long userId, long followerId) {

		String hql = "DELETE FROM Follower WHERE userId = ? AND followerId = ?";
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, userId);
		query.setParameter(1, followerId);

		return query.executeUpdate();
	}

	public boolean isFollowing(long userId, long followerId) {
		String hql = "SELECT f FROM Follower f WHERE userId = ? AND followerId = ?";
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, userId);
		query.setParameter(1, followerId);
		List result = query.getResultList();

		// here we check if user is in our tracking list
		if (result.size() > 0) {
			return true;
		}

		return false;
	}

}
