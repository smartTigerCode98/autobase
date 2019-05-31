package dao;

import model.Car;
import model.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DriverDAO {
    Driver findByIdCar(int idCar);
    Driver findById(int idDriver);
    List<Driver> getFreeDrivers(List<Car> cars);
    boolean updateStatusDriver(int id, boolean status);
}
