package service;

import dao.FlightImplDAO;
import model.Flight;

public class FlightService {

    private static FlightService flightService = null;

    public static FlightService getFlightService(){
        if(flightService == null){
            flightService = new FlightService();
        }

        return flightService;
    }

    private FlightImplDAO flightImplDAO;

    private FlightService(){
        flightImplDAO = new FlightImplDAO();
    }

    public boolean createFlight(int id_order, int id_driver){
        return this.flightImplDAO.createFlight(id_order, id_driver);
    }

    public boolean updateStatusFlight(int idFlight, boolean status, int idDriver){
        DriverService.getDriverService().updateStatusDriver(idDriver, true);
        return this.flightImplDAO.setStatusForFlight(idFlight, status);
    }

    public Flight getFlightForDriver(int idDriver){
        return this.flightImplDAO.getFlightForDriver(idDriver);
    }
}
