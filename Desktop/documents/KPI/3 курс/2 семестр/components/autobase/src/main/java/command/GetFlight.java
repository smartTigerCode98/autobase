package command;

import model.Flight;
import service.FlightService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFlight implements Command<Flight> {
    @Override
    public Flight execute(HttpServletRequest request, HttpServletResponse response) {
        FlightService flightService = FlightService.getFlightService();
        return flightService.getFlightForDriver(Integer.parseInt(request.getParameter("idDriver")));
    }
}
