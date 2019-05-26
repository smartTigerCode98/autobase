package dao;

import model.Car;
import model.Driver;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverDAO {
    public ArrayList<Driver> findAll() throws SQLException;
    public Driver findByIdCar(int idCar);
    public Driver findById(int idDriver);
    public int getFreeCarDriver(ArrayList<Car> cars);
    public ArrayList<Driver> getFreeDrivers(ArrayList<Car> cars);
    public boolean updateStatusDriver(int id, boolean status);
}
