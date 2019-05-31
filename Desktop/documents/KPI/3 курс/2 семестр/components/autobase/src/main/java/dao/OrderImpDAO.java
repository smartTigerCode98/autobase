package dao;

import db_manager.DBManager;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderImpDAO implements OrderDAO {
    private Connection connection;
    public OrderImpDAO(){
        try {
            this.connection = DBManager.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Order> getUnprocessedOrders(){
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE processed = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setBoolean(1, false);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                Date when = result.getDate("when");
                String from_where = result.getNString("from_where");
                String where_ = result.getNString("where_");
                String mark_auto = result.getNString("mark_auto");
                String body_type = result.getNString("body_type");
                int count_of_sits = result.getInt("count_of_sits");
                boolean processed = false;

                Order order = new Order(id, when, from_where, where_, mark_auto, body_type, count_of_sits, processed);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  orders;
    }

    @Override
    public boolean markAsProcessed(int id){
        boolean result = false;
        String query = "UPDATE orders SET processed = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
