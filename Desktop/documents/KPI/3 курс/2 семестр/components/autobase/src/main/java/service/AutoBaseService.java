package service;

import dao.*;
import json_util.JSONUtil;
import model.*;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class AutoBaseService {

    private CarImplDAO carImplDAO;
    private DriverImplDAO driverImplDAO;
    private FlightImplDAO flightImplDAO;
    private OrderImpDAO orderImpDAO;
    private UserImpDAO userImpDAO;

    private Connection connection;

    public AutoBaseService(Connection connection){
        this.connection = connection;
        this.carImplDAO = new CarImplDAO(this.connection);
        this.driverImplDAO = new DriverImplDAO(this.connection);
        this.flightImplDAO = new FlightImplDAO(this.connection);
        this.orderImpDAO = new OrderImpDAO(this.connection);
        this.userImpDAO = new UserImpDAO(this.connection);
    }


    public  ArrayList<Order> getUnprocessedOrders(){
        return this.orderImpDAO.getUnprocessedOrders();
    }

    public void markOrderAsProcessed(int id){
        this.orderImpDAO.markAsProcessed(id);
    }


    public ArrayList<Driver> getFreeDrivers(String marka, String body_type, String number_of_seats){
        ArrayList<Car> cars = this.carImplDAO.findCarsByCriteria(marka, body_type, number_of_seats);
        return this.driverImplDAO.getFreeDrivers(cars);
    }

    public Driver getDriverById(int idDriver){
        return this.driverImplDAO.findById(idDriver);
    }

    public void updateStatusDriver(int idDriver, boolean status){
        this.driverImplDAO.updateStatusDriver(idDriver, status);
    }

    public boolean createFlight(int id_order, int id_driver){
        return this.flightImplDAO.createFlight(id_order, id_driver);
    }


    public boolean updateStatusFlight(int idFlight, boolean status, int idDriver){
        this.driverImplDAO.updateStatusDriver(idDriver, true);
        return this.flightImplDAO.setStatusForFlight(idFlight, status);
    }


    public Flight getFlightForDriver(int idDriver){
        return this.flightImplDAO.getFlightForDriver(idDriver);
    }

    public User getUser(String email, String password ){
        User user = null;
        try {
            user = this.userImpDAO.findUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateStatusCar(int idCar, boolean status){
        return this.carImplDAO.updateConditionCar(idCar, status);
    }

}
