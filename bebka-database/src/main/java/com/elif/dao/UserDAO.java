package com.elif.dao;
import com.elif.user.User;

public interface UserDAO {
    void createTable();
    void save(User user);
    void delete(int id);
    void update(User user);
    void findAll();
}
