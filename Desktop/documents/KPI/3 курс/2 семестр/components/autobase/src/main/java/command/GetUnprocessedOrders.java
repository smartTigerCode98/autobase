package command;

import model.Order;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetUnprocessedOrders implements Command <List<Order>> {
    @Override
    public List<Order> execute(HttpServletRequest request, HttpServletResponse response) {
        OrderService orderService = OrderService.getOrderService();
        return orderService.getUnprocessedOrders();
    }
}
