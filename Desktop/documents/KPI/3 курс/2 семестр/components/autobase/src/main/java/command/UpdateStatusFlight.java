package command;

import service.FlightService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatusFlight implements Command<Boolean> {
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response) {
        FlightService flightService = FlightService.getFlightService();
        return flightService.updateStatusFlight(Integer.parseInt(request.getParameter("idFlight")),
                Boolean.parseBoolean(request.getParameter("statusFlight")),
                Integer.parseInt(request.getParameter("idDriver")));
    }
}
