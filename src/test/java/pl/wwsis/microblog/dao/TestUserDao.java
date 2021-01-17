package pl.wwsis.microblog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.wwsis.microblog.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@Transactional
@Rollback(true)
public class TestUserDao {

	@Autowired
	UserDao<User> userDao;

	User User;

	@Before
	public void setUp() {

	}

	@Test
	public void getUser() {
		assertEquals(0, userDao.getUser(0L).getUserId());
		assertEquals("Neo", userDao.getUser(0L).getFirstName());
		assertEquals("Matrix", userDao.getUser(0L).getLastName());

		assertEquals(1, userDao.getUser(1L).getUserId());
		assertEquals(2, userDao.getUser(2L).getUserId());
		// no users with these ids
		assertNull(userDao.getUser(456L));
		assertNull(userDao.getUser(789L));
		assertNull(userDao.getUser(Long.MAX_VALUE));
	}

	@Test
	public void addNewUser() {
		userDao.addNewUser("One", "Two");
		assertEquals("Sample2", userDao.addNewUser("Sample1", "Sample2").getLastName());
		assertEquals("Sample3", userDao.addNewUser("Sample1", "Sample3").getLastName());
		assertEquals("Sample4", userDao.addNewUser("Sample1", "Sample4").getLastName());
		assertEquals("Sample5", userDao.addNewUser("Sample1", "Sample5").getLastName());
		// no such user exists
		assertNull(userDao.getUser(555L));
		assertNull(userDao.getUser(444L));
		assertNull(userDao.getUser(333L));
	}
}
