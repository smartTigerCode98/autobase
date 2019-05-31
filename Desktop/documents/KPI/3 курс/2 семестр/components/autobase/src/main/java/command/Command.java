package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command <TResult>{
    TResult execute(HttpServletRequest request, HttpServletResponse response);
}
