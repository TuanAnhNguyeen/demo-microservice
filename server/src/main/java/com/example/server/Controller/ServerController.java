package com.example.server.Controller;

import com.example.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: GMO_DuyDV
 * @version: 1.0
 * @since: 12/16/2021
 * Project_name: GMO_QuanLyTaiSan
 */

@RestController
public class ServerController {
    @Autowired
    UserService userService;
//    @Value("${service.instance.name}")
//    private String instance;
    @GetMapping("/user")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok(userService.findAll());
    }
}
