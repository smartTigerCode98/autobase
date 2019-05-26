package command;

import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundCommand implements Command <Object> {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        response.setStatus(404);
        return null;
    }
}
