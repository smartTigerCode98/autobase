package service;

import dao.OrderImpDAO;
import model.Order;

import java.util.List;

public class OrderService {

    private static OrderService orderService = null;

    public static OrderService getOrderService(){
        if(orderService == null){
            orderService = new OrderService();
        }

        return  orderService;
    }

    private OrderImpDAO orderImpDAO;

    private OrderService(){
        orderImpDAO = new OrderImpDAO();
    }

    public List<Order> getUnprocessedOrders(){
        return this.orderImpDAO.getUnprocessedOrders();
    }

    public void markOrderAsProcessed(int id){
        this.orderImpDAO.markAsProcessed(id);
    }
}
