package service;

import dao.DriverImplDAO;
import model.Car;
import model.Driver;

import java.util.List;

public class DriverService {

    private static DriverService driverService = null;

    public static DriverService getDriverService(){
        if(driverService == null){
            driverService = new DriverService();
        }

        return driverService;
    }

    private DriverImplDAO driverImplDAO;

    private DriverService(){
        driverImplDAO = new DriverImplDAO();
    }

    public Driver getDriverById(int idDriver){
        return this.driverImplDAO.findById(idDriver);
    }

    public void updateStatusDriver(int idDriver, boolean status){
        this.driverImplDAO.updateStatusDriver(idDriver, status);
    }

    public List<Driver> getFreeDriversByOrder(String mark, String body_type, String number_of_seats){
        List<Car> cars = CarService.getCarService().findCarsByOrder(mark, body_type, number_of_seats);
        return this.driverImplDAO.getFreeDrivers(cars);
    }
}
