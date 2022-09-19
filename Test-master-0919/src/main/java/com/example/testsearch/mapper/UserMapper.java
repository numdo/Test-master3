package com.example.testsearch.mapper;

import com.example.testsearch.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /* 회원가입 */
    int addUser(UserDto userDto);

    /* 회원별 회원정보 조회 */
    public UserDto getUserInfoByEmail(String useremail);

    // 아이디 중복확인
    boolean isIdCheck(String id);

    // 전체 회원정보 조회
    public List<UserDto> getUserList();

    public String getUserCode(String codePattern, String tableName);



}
