package com.example.test.controller;

import org.springframework.beans.factory.annotation.Value;
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

public class ServiceControllerTest {
    @Value("${service.instance.name}")
    private String instance;

    @RequestMapping("/")
    public String sayHelo(){
        return "Xin chào duy 1" +  instance;
    }
}
