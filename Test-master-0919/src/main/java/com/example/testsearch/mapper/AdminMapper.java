package com.example.testsearch.mapper;

import com.example.testsearch.dto.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    /* Data 등록 처리 */
    public int addData(Data data);


}
