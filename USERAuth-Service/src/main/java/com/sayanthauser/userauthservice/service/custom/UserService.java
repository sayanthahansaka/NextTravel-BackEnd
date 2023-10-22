package com.sayanthauser.userauthservice.service.custom;


import com.sayanthauser.userauthservice.dto.UserDTO;
import com.sayanthauser.userauthservice.response.Response;
import com.sayanthauser.userauthservice.service.SuperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends SuperService<UserDTO,String> {
    ResponseEntity<Response> createAndSendResponse(int statusCode, String message, Object data);
    String  handleUploads(MultipartFile imageFile);
    ResponseEntity<Response>getUserByUserName(String username,String password);
    Boolean passwordValidator(String password,String hashedPassword);

}
