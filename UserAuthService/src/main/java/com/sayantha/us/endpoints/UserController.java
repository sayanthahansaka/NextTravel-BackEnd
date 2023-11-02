package com.sayantha.us.endpoints;

import com.sayantha.us.dto.UserDTO;
import com.sayantha.us.response.Response;
import com.sayantha.us.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE, params = {"userName", "userPassword"})
    public ResponseEntity<Response> getUserByUserName(@RequestParam("userName") String username, @RequestParam("userPassword") String password) {
        return userService.getUserByUserName(username, password);
    }

    @PostMapping(path = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveUser(@RequestBody UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @PutMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateUser(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, params = {"userId"})
    public ResponseEntity<Response> deleteUser(@RequestParam("userId") String userId) {
        return userService.delete(userId);
    }
    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveUser() {
        return userService.getAll();
    }
}

