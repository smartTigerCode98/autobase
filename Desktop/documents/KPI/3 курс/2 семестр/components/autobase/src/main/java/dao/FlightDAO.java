package dao;



import model.Flight;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FlightDAO {
    public boolean createFlight(int id_order_val, int id_driver_val);
    public Flight getFlightForDriver(int idDriver);
    public boolean setStatusForFlight(int id, boolean status);
}
