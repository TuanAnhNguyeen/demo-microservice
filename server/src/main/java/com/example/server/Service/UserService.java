package com.example.server.Service;

import com.example.server.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: GMO_DuyDV
 * @version: 1.0
 * @since: 12/17/2021
 * Project_name: GMO_QuanLyTaiSan
 */
@Service
public class UserService {
    public List<UserDto> findAll(){
        List<UserDto> list = new ArrayList<>();
        list.add(new UserDto("abc","123"));
        list.add(new UserDto("abcd","1234"));
        return list;
    }
}
