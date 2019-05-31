package dao;



import model.Flight;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FlightDAO {
    boolean createFlight(int id_order_val, int id_driver_val);
    Flight getFlightForDriver(int idDriver);
    boolean setStatusForFlight(int id, boolean status);
}
