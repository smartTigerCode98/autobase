package command;

import model.Driver;
import service.DriverService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetFreeDrivers implements Command <List<Driver>> {
    @Override
    public List<Driver> execute(HttpServletRequest request, HttpServletResponse response) {
        DriverService driverService = DriverService.getDriverService();
        String markAuto = request.getParameter("markaAuto");
        String bodyType = request.getParameter("bodyType");
        String countOfSits = request.getParameter("countOfSits");
        return driverService.getFreeDriversByOrder(markAuto, bodyType, countOfSits);
    }
}
