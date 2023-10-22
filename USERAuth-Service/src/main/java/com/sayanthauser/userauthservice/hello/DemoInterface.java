package com.sayanthauser.userauthservice.hello;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GUIDE-SERVICE")


public interface DemoInterface {
//
//    @PostMapping(path = "/test",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getGuide(@RequestBody  GuideDTO guideDTO);
    @GetMapping(path = "/hello",params = {"param1","param2"})
    public String paramTester(@RequestParam("param1") String param1,@RequestParam("param2") String param2);



}
