package com.example.client.Controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description:
 *
 * @author: GMO_DuyDV
 * @version: 1.0
 * @since: 12/16/2021
 * Project_name: GMO_QuanLyTaiSan
 */
@RestController
public class ClientController {
    @Autowired
    private EurekaClient client;
    @Autowired
    private RestTemplateBuilder teaTemplateBuilder;
    @Value("${user.username}")
    private String username;
    @RequestMapping("/")
    public ResponseEntity<?> callApi(){
        System.out.println(username);
       InstanceInfo instanceInfo= client.getNextServerFromEureka("gateway-server",false);
       String url = instanceInfo.getHomePageUrl();
       RestTemplate restTemplate = teaTemplateBuilder.build();
       try {
           ResponseEntity<List<UserDto>> responseEntity=  restTemplate.exchange(url+"/user",HttpMethod.GET,
                   null,new ParameterizedTypeReference<List<UserDto>>() {});
//           ObjectMapper objectMapper = new ObjectMapper();
//           System.out.println(responseEntity);
           List<UserDto> userDtoList = responseEntity.getBody();
           System.out.println(userDtoList.get(0).getUsername());
           return ResponseEntity.ok(responseEntity.getBody());
       }catch (Exception e){
           System.out.println(HttpStatus.NOT_FOUND.value());
           System.out.println("lỗi rồi");
           e.printStackTrace();

       }
        return null;
    }
}
