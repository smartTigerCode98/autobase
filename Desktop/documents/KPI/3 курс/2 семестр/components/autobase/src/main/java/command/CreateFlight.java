package command;

import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateFlight implements Command <Boolean>{
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        int idDriver = Integer.parseInt(request.getParameter("idDriver"));
        Boolean result = service.createFlight(idOrder, idDriver);
        if (result){
            service.updateStatusDriver(idDriver, false);
            service.markOrderAsProcessed(idOrder);
        }
        return result;
    }
}
