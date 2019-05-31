package dao;

import db_manager.DBManager;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpDAO implements UserDAO {

    private Connection connection;

    public UserImpDAO(){
        try {
            this.connection = DBManager.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User findUser(String email, String password) throws SQLException {
        User user = null;
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            int id = result.getInt("id");
            String email_ = result.getString("email");
            String password_ = result.getString("password");
            String role = result.getString("role");

            user = new User(id, email_, password_, role);
        }
        return user;
    }
}
