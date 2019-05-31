package dao;

import db_manager.DBManager;
import model.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightImplDAO implements FlightDAO {

    private Connection connection;

    public FlightImplDAO(){
        try {
            this.connection = DBManager.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean createFlight(int id_order_val, int id_driver_val) {
        String query = "INSERT INTO flights(`id_order`, `id_driver`)" + " VALUES(?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_order_val);
            preparedStatement.setInt(2, id_driver_val);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Flight getFlightForDriver(int idDriver) {
        Flight flight = null;
        String query = "SELECT * FROM flights WHERE id_driver = ? AND status = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDriver);
            preparedStatement.setBoolean(2, false);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                int id_order = result.getInt("id_order");
                int id_driver = result.getInt("id_driver");
                boolean status = result.getBoolean("status");
                flight = new Flight(id, id_order, id_driver, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public boolean setStatusForFlight(int id, boolean status){
        String query = "UPDATE flights SET status = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
