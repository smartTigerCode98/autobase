package command;

import model.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUser implements Command <User> {
    @Override
    public User execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = UserService.getUserService();
        return userService.getUser(request.getParameter("email"), request.getParameter("password"));
    }
}
