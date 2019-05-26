package command;

import model.User;
import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUser implements Command <User> {
    @Override
    public User execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        return service.getUser(request.getParameter("email"), request.getParameter("password"));
    }
}
