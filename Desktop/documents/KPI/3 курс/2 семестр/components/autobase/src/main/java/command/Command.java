package command;

import service.AutoBaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command <TResult>{
    public TResult execute(HttpServletRequest request, HttpServletResponse response, AutoBaseService service);
}
