package com.sayantha.packageservicea.service.impl;


import com.sayantha.packageservicea.dto.Super_dto;
import com.sayantha.packageservicea.util.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends Super_dto,ID>{
    ResponseEntity<Response>  search(String id);

    ResponseEntity<Response>  save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response>   delete(String id);

    ResponseEntity<Response>   getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
