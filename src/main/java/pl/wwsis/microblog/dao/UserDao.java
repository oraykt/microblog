package pl.wwsis.microblog.dao;

import pl.wwsis.microblog.model.User;

public interface UserDao<T> {
	User getUser(long id);

	User addNewUser(String firstName, String lastName);
}
