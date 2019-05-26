package command;

import model.Driver;
import service.AutoBaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetFreeDrivers implements Command <ArrayList<Driver>> {
    @Override
    public ArrayList<Driver> execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        String marka_auto = request.getParameter("markaAuto");
        String body_type = request.getParameter("bodyType");
        String count_of_sits = request.getParameter("countOfSits");
        return service.getFreeDrivers(marka_auto, body_type, count_of_sits);
    }
}
