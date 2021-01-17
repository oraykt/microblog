package pl.wwsis.microblog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.wwsis.microblog.dao.PostDao;
import pl.wwsis.microblog.model.Post;

@Transactional
public class PostDaoImpl implements PostDao<Post> {

	@PersistenceContext
	EntityManager entityManager;

	public List<Post> getUserTimeline(long id) {
		String hql = "SELECT post FROM Post WHERE userId = ?";
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, id);
		return query.getResultList();
	}

	public List<Post> getUserFullTimeline(long id) {
		String hql = "SELECT p FROM Post p WHERE p.userId = ? OR "
				+ "p.userId IN (SELECT f.followerId From Follower f where userId = ?)";
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, id);
		query.setParameter(1, id);
		return query.getResultList();
	}

	public List<Post> getFullPublicTimeline() {
		String hql = "SELECT post FROM Post";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

}
