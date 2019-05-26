package dao;


import model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarImplDAO implements CarDAO {
    private Connection connection;

    public CarImplDAO(Connection connection){
        this.connection = connection;
    }

    public ArrayList<Car> findCarsByCriteria(String marka, String body_type, String number_of_seats){

        ArrayList<Car> cars_set = new ArrayList<>();
        String query = "SELECT * FROM cars WHERE marka = ? AND type = ? AND number_of_seats = ? AND is_broke = false";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, marka);
            preparedStatement.setString(2, body_type);
            preparedStatement.setString(3, number_of_seats);
            ResultSet cars = preparedStatement.executeQuery();
            while (cars.next()) {
                int id = cars.getInt("id");
                String marka_ = cars.getNString("marka");
                String type = cars.getNString("type");
                String serial_number = cars.getNString("serial_number");
                int number_of_seats_ = cars.getInt("number_of_seats");
                boolean is_broke = cars.getBoolean("is_broke");

                Car car = new Car(id, marka_, type, serial_number, number_of_seats_, is_broke);
                cars_set.add(car);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars_set;
    }


    public boolean updateConditionCar(int id, boolean is_broke){
        String query = "UPDATE cars SET is_broke = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setBoolean(1, is_broke);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
