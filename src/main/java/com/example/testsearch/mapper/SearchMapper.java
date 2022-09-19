package com.example.testsearch.mapper;

import com.example.testsearch.dto.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {

    /* select box 선택별 data 검색 : en */
    public List<Data> getSearchBySelectList(Map<String, Object> paramMap);


 /* select box 선택별 data 검색 : ru */
    public List<Data> getSearchBySelectList_ru(Map<String, Object> paramMap);


    /* 통계 : Providing_Institution별 등록개수 */
    public List<Map<String, Object>> getPICntList();


    /* 통계 : Providing_Institution_Ru별 등록개수 */
    public List<Map<String, Object>> getPICntList_ru();


    /*자동증가 코드 : 쿼리문사용*/
    public String getDataCode();

    /*    pi 그래프 값 불러오기*/
    public List<Map<String, Object>> getRightCntList();

    /* Data_Code로 data 상세 검색 */
    public Data getDataSearchDetailList(String Data_Code);

    /* data 검색 개수 */
    int countSearchData(Map<String, Object> paramMap);

    /* data 검색 */
    List<Data> getDataSearchList(Map<String, Object> paramMap);

    /* data리스트 조회 */
    List<Data> getDataList();

}
