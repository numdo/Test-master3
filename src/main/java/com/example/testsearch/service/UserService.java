package com.example.testsearch.service;


import com.example.testsearch.dto.UserDto;
import com.example.testsearch.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchService.class);

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /* 회원가입 */
    public int addUser(UserDto userDto){
        String code = userMapper.getUserCode("userId","user");
        userDto.setUserId(code);
        int result = userMapper.addUser(userDto);
        return result;
    }

    /* 회원별 정보조회 */
    public UserDto getUserInfoByEmail(String useremail){
        UserDto userDto = userMapper.getUserInfoByEmail(useremail);

        return userDto;
    }

    /* 전체 회원정보 조회 */
    public List<UserDto> getUserList(){

        List<UserDto> userList = userMapper.getUserList();

        return userList;
    }

}
