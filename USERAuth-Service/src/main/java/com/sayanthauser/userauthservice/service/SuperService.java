package com.sayanthauser.userauthservice.service;


import com.sayanthauser.userauthservice.dto.superdto.SuperDTO;
import com.sayanthauser.userauthservice.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends SuperDTO, ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> getAll(T t);


}
