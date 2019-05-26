package command;

import model.Flight;
import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFlight implements Command<Flight> {
    @Override
    public Flight execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        return service.getFlightForDriver(Integer.parseInt(request.getParameter("idDriver")));
    }
}
