package com.sayantha.us.service;


import com.sayantha.us.dto.superdto.SuperDTO;
import com.sayantha.us.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends SuperDTO, ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> getAll();

    ResponseEntity<Response>getUserByUserName(String userName, String password);


}
