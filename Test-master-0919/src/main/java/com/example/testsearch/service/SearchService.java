package com.example.testsearch.service;

import com.example.testsearch.dto.Data;
import com.example.testsearch.mapper.CommonMapper;
import com.example.testsearch.mapper.FileMapper;
import com.example.testsearch.mapper.SearchMapper;
import com.example.testsearch.util.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SearchService {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchService.class);
    private SearchMapper searchMapper;
    private CommonMapper commonMapper;
    private FileUtil fileUtil;
    private FileMapper fileMapper;

    @Autowired
    public SearchService(SearchMapper searchMapper, CommonMapper commonMapper, FileUtil fileUtil, FileMapper fileMapper){
        this.searchMapper = searchMapper;
        this.commonMapper = commonMapper;
        this.fileUtil = fileUtil;
        this.fileMapper = fileMapper;
    }


    /* select box 선택별 data 검색 : en */
    public List<Data> getSearchBySelectList(Map<String, Object> paramMap) {
        List<Data> dataSearchList = searchMapper.getSearchBySelectList(paramMap);

        return dataSearchList;
    }


    /* select box 선택별 data 검색 : ru */
    public List<Data> getSearchBySelectList_ru(Map<String, Object> paramMap) {
        List<Data> ruDataSearchList = searchMapper.getSearchBySelectList_ru(paramMap);

        return ruDataSearchList;
    }

    /* Data_Code로 상세 검색 */
    public Data getDataSearchDetailList(String Data_Code){

        return searchMapper.getDataSearchDetailList(Data_Code);

    }

    /* data 검색 개수 */
    public int countSearchData(Map<String, Object> paramMap){

        return searchMapper.countSearchData(paramMap);

    }

    /*  data 검색 */
    public  List<Data> getDataSearchList(Map<String, Object> paramMap){

        List<Data> dataSearchList = searchMapper.getDataSearchList(paramMap);
        return dataSearchList;
    }


    /* data리스트 조회 */
    public List<Data> getDataList(){

        List<Data> dataList = searchMapper.getDataList();

        return dataList;
    }

}
