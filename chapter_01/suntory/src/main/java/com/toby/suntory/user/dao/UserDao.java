package com.toby.suntory.user.dao;

import com.toby.suntory.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao {

    public void add(User user) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into user(id, name, password) values (?, ?, ?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from user where id = ?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public abstract Connection getConnection() throws SQLException;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new NUserDao();

        User user = new User();
        user.setId("suntory2");
        user.setName("김세영");
        user.setPassword("pass");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
    }
}
