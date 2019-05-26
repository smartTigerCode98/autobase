package command;

import model.Driver;
import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDriver implements Command<Driver> {
    @Override
    public Driver execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        return service.getDriverById(Integer.parseInt(request.getParameter("idDriver")));
    }
}
