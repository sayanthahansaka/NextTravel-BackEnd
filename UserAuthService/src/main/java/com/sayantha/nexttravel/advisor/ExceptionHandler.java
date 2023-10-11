package com.sayantha.nexttravel.advisor;

import com.sayantha.nexttravel.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class ExceptionHandler {
    @Autowired
    private Response response;
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public Response handleExceptions(Exception exception ){
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Server threw an exception : "+exception.getLocalizedMessage());
        response.setData(null);
        return response;

    }
//https://github.com/sayanthahansaka/NextTravel-BackEnd.git

}
