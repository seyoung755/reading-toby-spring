package com.toby.suntory.user.dao;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DConnetionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
