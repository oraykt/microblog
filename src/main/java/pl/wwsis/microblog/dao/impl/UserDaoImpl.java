package pl.wwsis.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pl.wwsis.microblog.dao.UserDao;
import pl.wwsis.microblog.model.User;

@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;

	public User getUser(long id) {
		// use entityManger default method to find specific user
		return entityManager.find(User.class, id);

	}

	public void addNewUser(User user) {
		// use entityManger default method to add a new user
		entityManager.persist(user);
	}

}
