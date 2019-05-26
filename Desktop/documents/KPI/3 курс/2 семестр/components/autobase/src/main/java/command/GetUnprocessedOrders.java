package command;

import model.Order;
import service.AutoBaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class GetUnprocessedOrders implements Command <ArrayList<Order>> {
    @Override
    public ArrayList<Order> execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
      return service.getUnprocessedOrders();
    }
}
