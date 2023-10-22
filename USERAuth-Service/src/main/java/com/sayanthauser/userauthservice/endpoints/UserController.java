package com.sayanthauser.userauthservice.endpoints;


import com.sayanthauser.userauthservice.response.Response;
import com.sayanthauser.userauthservice.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE, params = {"username","password"})
    public ResponseEntity<Response> getUserByUserName(@RequestParam("username") String username, @RequestParam("password")String password) {
        return userService.getUserByUserName(username,password);

    }

}
