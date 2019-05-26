package command;

import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatusCar implements Command<Boolean> {
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        return service.updateStatusCar(Integer.parseInt(request.getParameter("idCar")),
                Boolean.parseBoolean(request.getParameter("statusCar")));
    }
}
