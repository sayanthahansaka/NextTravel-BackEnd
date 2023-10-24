package com.sayantha.us.service.custom;


import com.sayantha.us.dto.UserDTO;
import com.sayantha.us.response.Response;
import com.sayantha.us.service.SuperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends SuperService<UserDTO,String> {
    ResponseEntity<Response> createAndSendResponse(int statusCode, String message, Object data);
    String  handleUploads(MultipartFile imageFile);
    ResponseEntity<Response>getUserByUserName(String username,String password);
    Boolean passwordValidator(String password,String hashedPassword);

}
