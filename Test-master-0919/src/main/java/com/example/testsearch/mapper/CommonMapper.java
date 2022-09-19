package com.example.testsearch.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {

    //db의 pk컬럼명과 db의 테이블명으로 자동으로 증가하는 코드 생성
    public String getNewCode(String codePattern, String tableName);

}
