package command;

import model.Driver;
import service.DriverService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDriver implements Command<Driver> {
    @Override
    public Driver execute(HttpServletRequest request, HttpServletResponse response) {
        DriverService driverService = DriverService.getDriverService();
        return driverService.getDriverById(Integer.parseInt(request.getParameter("idDriver")));
    }
}
