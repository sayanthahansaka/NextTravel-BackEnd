package com.sayantha.nexttravel.endpoints;

import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usr")
@CrossOrigin
public class DemoController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(path = "/get")
    public String demo() {
        return "Hello World";
    }
//    @GetMapping(path = {"/id"}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseUtil searchHotelByID(@PathVariable String id){
//        return new ResponseUtil(200, "Search", userDetailsService.(id));
//    }
}
