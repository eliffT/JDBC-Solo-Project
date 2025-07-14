package com.elif.dao;
import com.elif.user.User;

import java.util.List;

public interface UserDAO {
    void createTable();
    void save(User user);
    void delete(int id);
    void update(User user);
    List<User> findAll();
}
