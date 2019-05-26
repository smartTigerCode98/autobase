package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseWriter {
    private ObjectMapper converter;

    public ResponseWriter(){
        converter = new ObjectMapper();
    }
    public void write(HttpServletResponse response, Object responseData) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(serialize(responseData));

    }

    private String serialize(Object obj) throws JsonProcessingException {
        return converter.writeValueAsString(obj);
    }
}
