package dao;

import model.User;

import java.sql.SQLException;

public interface UserDAO {
    User findUser(String email, String password) throws SQLException;
}
