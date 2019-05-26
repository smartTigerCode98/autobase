package command;

import service.AutoBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStatusFlight implements Command<Boolean> {
    @Override
    public Boolean execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service) {
        System.out.println(request.getParameter("idFlight"));
        System.out.println(request.getParameter("statusFlight"));
        return service.updateStatusFlight(Integer.parseInt(request.getParameter("idFlight")),
                Boolean.parseBoolean(request.getParameter("statusFlight")),
                Integer.parseInt(request.getParameter("idDriver")));
    }
}
