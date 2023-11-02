package com.sayantha.ps.interfaces;

import com.sayantha.ps.util.ResponseUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("auth-server")
public interface UserInterface {
    @PostMapping(path = "api/v1/user/updatePId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"uId","pId"})
    ResponseEntity<ResponseUtil> updatePackageDetailsID(@RequestParam("uId") String uId, @RequestParam("pId") String pId);

}
