package controller;

import command.*;
import url_entry.URLEntry;
import util.ResponseWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet("/api/*")
public class AutoBaseServlet extends HttpServlet {
    private Map<URLEntry, Command> commands = new HashMap<>();
    private ResponseWriter responseWriter;

    @Override
    public void init(){
        this.responseWriter = new ResponseWriter();
        this.commands.put(new URLEntry("^/api/orders$", "GET"), new GetUnprocessedOrders());
        this.commands.put(new URLEntry("^/api/drivers$", "GET"), new GetFreeDrivers());
        this.commands.put(new URLEntry("^/api/drivers/(\\d+)$", "GET"), new GetDriver());
        this.commands.put(new URLEntry("^/api/flight$", "POST"), new CreateFlight());
        this.commands.put(new URLEntry("^/api/flight/(\\d+)$", "GET"), new GetFlight());
        this.commands.put(new URLEntry("^/api/verifyUser$", "POST"), new GetUser());
        this.commands.put(new URLEntry("^/api/flight/(\\d+)$", "PUT"), new UpdateStatusFlight());
        this.commands.put(new URLEntry("^/api/car$", "PUT"), new UpdateStatusCar());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
           throws IOException{
      processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        Command command = this.getCommand(request.getRequestURI(), request.getMethod());
        Object resultData = command.execute(request, response);
        this.responseWriter.write(response, resultData);
    }

    private Command getCommand(String uri, String method){
        for(URLEntry urlEntry : commands.keySet()){
            if(Pattern.matches(urlEntry.getUrlPattern(), uri) && urlEntry.getMethod().equals(method)){
                return commands.get(urlEntry);
            }
        }

        return new NotFoundCommand();
    }

}
