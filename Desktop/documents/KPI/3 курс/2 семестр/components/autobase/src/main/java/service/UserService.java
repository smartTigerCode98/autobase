package service;

import dao.UserImpDAO;
import model.User;

import java.sql.SQLException;

public class UserService {

    private static UserService userService = null;

    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }

        return userService;
    }

    private UserImpDAO userImpDAO;

    private UserService(){
        userImpDAO = new UserImpDAO();
    }

    public User getUser(String email, String password ){
        User user = null;
        try {
            user = this.userImpDAO.findUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
