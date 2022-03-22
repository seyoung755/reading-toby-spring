package com.toby.suntory.dao;

import com.toby.suntory.user.dao.DaoFactory;
import com.toby.suntory.user.dao.UserDao;
import com.toby.suntory.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserDaoTest {
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        user1 = new User("user1", "유저1", "pw1");
        user2 = new User("user2", "유저2", "pw2");
        user3 = new User("user3", "유저3", "pw3");
        dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    void addAndGet() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isZero();

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        User userget2 = dao.get(user2.getId());

        assertThat(user2.getName()).isEqualTo(user2.getName());
        assertThat(user2.getPassword()).isEqualTo(user2.getPassword());
    }

    @Test
    void count() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isZero();

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    void getUserFailure() throws SQLException {
        dao.deleteAll();

        assertThat(dao.getCount()).isZero();
        assertThrows(EmptyResultDataAccessException.class, () -> dao.get("unknown_id"));
    }
}
