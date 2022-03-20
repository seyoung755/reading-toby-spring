package com.toby.suntory.dao;

import com.toby.suntory.user.dao.DaoFactory;
import com.toby.suntory.user.dao.UserDao;
import com.toby.suntory.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    @Test
    void addAndGet() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("suntory");
        user.setName("산토리");
        user.setPassword("springno1");

        dao.deleteAll();
        assertThat(dao.getCount()).isZero();

        dao.add(user);
        assertThat(dao.getCount()).isEqualTo(1);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }
}
