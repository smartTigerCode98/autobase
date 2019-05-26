package dao;

import model.Car;
import model.Driver;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;


public class DriverImplDAO implements DriverDAO {

    private Connection connection;

    public DriverImplDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public ArrayList<Driver> findAll() throws SQLException {
        ArrayList<Driver> drivers = new ArrayList<>();
        String SELECT_ALL_QUERY = "SELECT * FROM `drivers`";
        PreparedStatement getAll = this.connection.prepareStatement(SELECT_ALL_QUERY);
        ResultSet result = getAll.executeQuery();
        while(result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            String surname = result.getNString("surname");
            int id_car = result.getInt("id_car");
            boolean is_free = result.getBoolean("is_free");
            Driver driver = new Driver(id, name, surname, id_car, is_free);
            drivers.add(driver);
        }
        return drivers;
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
    public int getFreeCarDriver( ArrayList<Car> cars) {
        int id = 0;
        for (Car car: cars) {
            Driver driver = this.findByIdCar(car.getId());
            if(driver.isFree()){
                return driver.getId();
            }
        }
        return id;
    }

    @Override
    public ArrayList<Driver> getFreeDrivers(ArrayList<Car> cars){
        System.out.println('m');
        ArrayList<Driver> drivers = new ArrayList<>();
        for (Car car: cars) {
            System.out.println(car.getId());
            Driver driver = this.findByIdCar(car.getId());
            System.out.println(driver.getSurname());
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
