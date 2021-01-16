package pl.wwsis.microblog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pl.wwsis.microblog.dao.PostDao;

@Transactional
public class PostDaoImpl implements PostDao {

	@PersistenceContext
	EntityManager entityManager;

	public List<?> getUserTimeline(long id) {
		String hql = "SELECT post FROM Posts WHERE userId = :id";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	public List getUserFullTimeline(long id) {
		String hql = "select post from posts where userid = :id OR posts.userid IN (select followers.followerid from followers where userid = :id)";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	public List getFullPublicTimeline() {
		String hql = "select post from posts";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

}
