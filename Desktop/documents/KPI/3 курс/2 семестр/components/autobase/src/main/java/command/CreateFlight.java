package command;


import service.DriverService;
import service.FlightService;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateFlight implements Command <Boolean>{
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response) {
        FlightService flightService = FlightService.getFlightService();
        DriverService driverService = DriverService.getDriverService();
        OrderService orderService = OrderService.getOrderService();
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        int idDriver = Integer.parseInt(request.getParameter("idDriver"));
        Boolean result = flightService.createFlight(idOrder, idDriver);
        if (result){
            driverService.updateStatusDriver(idDriver, false);
            orderService.markOrderAsProcessed(idOrder);
        }
        return result;
    }
}
