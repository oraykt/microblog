package pl.wwsis.microblog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
public class TestFollowerDao {

	@Autowired
	FollowerDao followerDao;

	@Autowired
	UserDao<User> userDao;

	@Before
	public void setUp() {

	}

	@Test
	public void testAddFollowUser() {
		// add follower
		followerDao.addFollowUser(0L, 3L);
		followerDao.addFollowUser(1L, 6L);
		followerDao.addFollowUser(2L, 6L);
		// check max long value
		followerDao.addFollowUser(Long.MAX_VALUE, Long.MAX_VALUE);

		// and then check if this follower relation exists
		assertEquals(true, followerDao.isFollowing(0L, 3L));
		assertEquals(true, followerDao.isFollowing(1L, 6L));
		assertEquals(true, followerDao.isFollowing(2L, 6L));
		assertEquals(true, followerDao.isFollowing(Long.MAX_VALUE, Long.MAX_VALUE));
	}

	@Test
	public void testRemoveFollower() {
		// add followers
		followerDao.addFollowUser(0L, 3L);
		followerDao.addFollowUser(1L, 6L);
		followerDao.addFollowUser(Long.MAX_VALUE, Long.MAX_VALUE);
		
		// and then remove available followers
		assertEquals(1, followerDao.removeFollower(0L, 3L));
		assertEquals(1, followerDao.removeFollower(1L, 6L));
		assertEquals(1, followerDao.removeFollower(Long.MAX_VALUE, Long.MAX_VALUE));

		// remove not existing record
		assertEquals(0, followerDao.removeFollower(7L, 7L));
	}

	@Test
	public void testIsFollowing() {
		followerDao.addFollowUser(0L, 3L);
		// follower exists
		assertEquals(true, followerDao.isFollowing(0L, 3L));
		// no such relation exists
		assertEquals(false, followerDao.isFollowing(9L, 9L));
	}

}
