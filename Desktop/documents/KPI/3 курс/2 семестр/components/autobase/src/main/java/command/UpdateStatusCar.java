package command;

import service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatusCar implements Command<Boolean> {
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response) {
        CarService carService = CarService.getCarService();
        return carService.updateStatusCar(Integer.parseInt(request.getParameter("idCar")),
                Boolean.parseBoolean(request.getParameter("statusCar")));
    }
}
