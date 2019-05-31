package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundCommand implements Command <Object> {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(404);
        return null;
    }
}
