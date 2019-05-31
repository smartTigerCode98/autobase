package dao;

import db_manager.DBManager;
import model.Car;
import model.Driver;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class DriverImplDAO implements DriverDAO {

    private Connection connection;

    public DriverImplDAO(){
        try {
            this.connection = DBManager.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Driver findByIdCar(int idCar){
        Driver driver = null;
        String query = "SELECT * FROM drivers WHERE id_car = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, idCar);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                int id_ = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getNString("surname");
                int id_car = result.getInt("id_car");
                boolean is_free = result.getBoolean("is_free");

                driver = new Driver(id_, name, surname, id_car, is_free);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public Driver findById(int idDriver) {
        Driver driver = null;
        String query = "SELECT * FROM drivers WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, idDriver);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                int id_ = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getNString("surname");
                int id_car = result.getInt("id_car");
                boolean is_free = result.getBoolean("is_free");

                driver = new Driver(id_, name, surname, id_car, is_free);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    @Override
    public List<Driver> getFreeDrivers(List<Car> cars){
        List<Driver> drivers = new ArrayList<>();
        for (Car car: cars) {
            Driver driver = this.findByIdCar(car.getId());
            if(driver.isFree()){
                drivers.add(driver);
            }
        }
        return drivers;
    }


    @Override
    public boolean updateStatusDriver(int id, boolean status){
        boolean result = false;
        String query = "UPDATE drivers SET is_free = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
