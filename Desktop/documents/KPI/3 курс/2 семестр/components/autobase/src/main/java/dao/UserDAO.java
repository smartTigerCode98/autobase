package dao;

import model.User;

import java.sql.SQLException;

public interface UserDAO {
    public User findUser(String email, String password) throws SQLException;
}
