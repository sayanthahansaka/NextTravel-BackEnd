package com.sayantha.us.endpoints;

import com.sayantha.us.dto.UserDTO;
import com.sayantha.us.response.Response;
import com.sayantha.us.service.custom.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/getAuth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveAuth(@RequestBody @Valid UserDTO userDTO) {
        System.out.println(userDTO.toString());
        return userService.add(userDTO);
    }

    @PostMapping(path = "/uploadImage", params = "userId")
    public ResponseEntity<Response> uploadImage(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("userId") String userId) {
        ResponseEntity<Response> user = userService.search(userId);

        UserDTO userData = (UserDTO) user.getBody().getData();
        if (userData != null) {
            userData.setUserImageLocation(userService.handleUploads(imageFile));
            return userService.update(userData);
        }
        throw new RuntimeException("User not found!");
    }

    @GetMapping(path = "/getAdmin", produces = MediaType.APPLICATION_JSON_VALUE,params = {"userName","userPassword"})
    public ResponseEntity<Response> getAuthByUserName(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword) {
        System.out.println("=============================================");
        return userService.getUserByUserName(userName,userPassword);
    }
    @GetMapping(path = "/allID", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllID() {
        return userService.getAllId();
    }

}