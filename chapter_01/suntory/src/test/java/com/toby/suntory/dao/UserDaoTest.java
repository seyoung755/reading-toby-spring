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

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        dao = context.getBean("userDao", UserDao.class);
    }

    @Test
    void addAndGet() throws SQLException {
        User user1 = new User("suntory", "산토리", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");

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
        User user1 = new User("user1", "유저1", "pw1");
        User user2 = new User("user2", "유저2", "pw2");
        User user3 = new User("user3", "유저3", "pw3");

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
