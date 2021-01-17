package pl.wwsis.microblog.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.wwsis.microblog.model.Post;
import pl.wwsis.microblog.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@Transactional
@Rollback(true)
public class TestPostDao {

	@Autowired
	PostDao<Post> postDao;

	@Autowired
	UserDao<User> userDao;

	@Before
	public void setUp() {

	}

	@Test
	public void getUserTimeline() {
		assertEquals(3, postDao.getUserTimeline(0).size());
		assertEquals(6, postDao.getUserTimeline(1).size());
		assertEquals(1, postDao.getUserTimeline(2).size());
		// id doesn't exists in db
		assertEquals(0, postDao.getUserTimeline(777).size());
	}

	@Test
	public void getUserFullTimeline() {
		assertEquals(10, postDao.getUserFullTimeline(0).size());
		assertEquals(0, postDao.getUserFullTimeline(0).get(0).getUserId());
		assertEquals("The financial arrangements soon proved inadequate.",
				postDao.getUserFullTimeline(0).get(0).getPost());

		assertEquals(6, postDao.getUserFullTimeline(1).size());
		assertEquals(1, postDao.getUserFullTimeline(1).get(0).getUserId());
		assertEquals("New York City is terminating contracts with the Trump Organization.",
				postDao.getUserFullTimeline(1).get(0).getPost());

		assertEquals(4, postDao.getUserFullTimeline(2).size());
		assertEquals(2, postDao.getUserFullTimeline(2).get(3).getUserId());
		assertEquals("The first wave of dockless systems were completely privatised.",
				postDao.getUserFullTimeline(2).get(3).getPost());
		// no followers
		assertEquals(0, postDao.getUserFullTimeline(3).size());
		// no user exists in DB, basically the same as above
		assertEquals(0, postDao.getUserFullTimeline(4).size());
	}

	@Test
	public void getFullPublicTimeline() {
		assertEquals(10, postDao.getFullPublicTimeline().size());
	}

}
