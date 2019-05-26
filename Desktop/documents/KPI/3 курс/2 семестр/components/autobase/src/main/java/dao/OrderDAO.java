package dao;

import model.Order;

import java.util.ArrayList;

public interface OrderDAO {
    public ArrayList<Order> getUnprocessedOrders();
    public boolean markAsProcessed(int id);
}
