package dao;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderDAO {
    List<Order> getUnprocessedOrders();
    boolean markAsProcessed(int id);
}
