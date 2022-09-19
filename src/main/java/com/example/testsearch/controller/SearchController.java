package com.example.testsearch.controller;

import com.example.testsearch.dto.Data;
import com.example.testsearch.mapper.SearchMapper;
import com.example.testsearch.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class SearchController {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchController.class);
    private SearchService searchService;
    private SearchMapper searchMapper;
    public SearchController(SearchService searchService, SearchMapper searchMapper){
        this.searchService = searchService;
        this.searchMapper = searchMapper;
    }


    /*자동완성 코드 컨트롤러부분*/
    @PostMapping("/insert")
    @ResponseBody
    public String getCode(){
        String autoIncreCode = searchMapper.getDataCode();
        logger.info(autoIncreCode);

        return autoIncreCode;
    }


    /* Ajax - 기관별 차트  en */
    @PostMapping("/totalStatistics")
    @ResponseBody
    public List<Map<String, Object>> totalStatistics(){

        List<Map<String, Object>> PICntList = searchMapper.getPICntList();

        return PICntList;

    }


    /* Ajax - 기관별 차트  ru */
    @PostMapping("/ruTotalStatistics")
    @ResponseBody
    public List<Map<String, Object>> ruTotalStatistics(){

        List<Map<String, Object>> ruPICntList = searchMapper.getPICntList_ru();

        return ruPICntList;

    }


    /* 팝업 - 기관별 차트  en */
    @GetMapping("/totalStatisticsPopup")
    public String totalStatisticsPopup(Model model){

        List<Map<String, Object>> PICntList = searchMapper.getPICntList();
        logger.info("PICntList에 담긴 값 : {}", PICntList);
        model.addAttribute("title", "Staticstical Info");
        model.addAttribute("PICntList", PICntList);

        return "en/test/totalStatisticsPopup";
    }



    /* 팝업 - 기관별 차트  ru */
    @GetMapping("/ru/totalStatisticsPopup")
    public String ruTotalStatisticsPopup(Model model){

        List<Map<String, Object>> ruPICntList = searchMapper.getPICntList_ru();
        logger.info("ruPICntList에 담긴 값 : {}", ruPICntList);
        model.addAttribute("title", "Статическая информация");
        model.addAttribute("ruPICntList", ruPICntList);

        return "ru/test/totalStatisticsPopup";
    }


    /* select box 선택별 data 검색 */
   /* @PostMapping("/searchBySelectList")
    @ResponseBody
    public List<Map<String, Object>> searchBySelectList(Model model
            ,@RequestParam (value = "searchKey", defaultValue = "Description") String searchKey
            ,@RequestParam (value = "searchValue", required = false) String searchValue
            ,@RequestParam (value = "Providing_Institution", required = false) String Providing_Institution
            ,@RequestParam (value = "Rights_Statement_Media", required = false) String Rights_Statement_Media
            ,@RequestParam (value = "Object_Type", required = false) String Object_Type
            ,@RequestParam (value = "Digital_Data_Type", required = false) String Digital_Data_Type
            ,@RequestParam (value = "File_Extension", required = false) String File_Extension){


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchKey", searchKey);
        paramMap.put("searchValue", searchValue);
        paramMap.put("Providing_Institution", Providing_Institution);
        paramMap.put("Rights_Statement_Media", Rights_Statement_Media);
        paramMap.put("Object_Type", Object_Type);
        paramMap.put("Digital_Data_Type", Digital_Data_Type);
        paramMap.put("File_Extension", File_Extension);

        List<Map<String, Object>> searchBySelectList = searchService.getSearchBySelectList(paramMap);

        return searchBySelectList;

    }*/


    /* select box 선택별 data 검색  - Ajax */
    @ResponseBody
    @RequestMapping("/searchBySelectList")
    public List<Data> searchBySelectList(Model model
            , @RequestParam (value = "providingInstitutionList[]", required = false) ArrayList<String> providingInstitutionList
            , @RequestParam (value = "rightsStatementMediaList[]", required = false) ArrayList<String> rightsStatementMediaList
            , @RequestParam (value = "objectTypeList[]", required = false) ArrayList<String> objectTypeList
            , @RequestParam (value = "digitalDateTypeList[]", required = false) ArrayList<String> digitalDateTypeList
            , @RequestParam (value = "fileExtensionList[]", required = false) ArrayList<String> fileExtensionList){


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("providingInstitutionList", providingInstitutionList);
        paramMap.put("rightsStatementMediaList", rightsStatementMediaList);
        paramMap.put("objectTypeList", objectTypeList);
        paramMap.put("digitalDateTypeList", digitalDateTypeList);
        paramMap.put("fileExtensionList", fileExtensionList);

        /*logger.info("providingInstitutionList 담긴 값 : {}", providingInstitutionList);*/

        List<Data> searchBySelectList = searchService.getSearchBySelectList(paramMap);
        /* logger.info("[TEST] searchBySelectList 담긴 값 : {}", searchBySelectList);*/
        //model.addAttribute("title", "작품 검색");

        model.addAttribute("dataSearchList", searchBySelectList);

        return searchBySelectList;

    }



    /* select box 선택별 data 검색  - Ajax ru */
    @ResponseBody
    @RequestMapping("/ruSearchBySelectList")
    public List<Data> ruSearchBySelectList(Model model
            , @RequestParam (value = "providingInstitutionList[]", required = false) ArrayList<String> providingInstitutionList
            , @RequestParam (value = "rightsStatementMediaList[]", required = false) ArrayList<String> rightsStatementMediaList
            , @RequestParam (value = "objectTypeList[]", required = false) ArrayList<String> objectTypeList
            , @RequestParam (value = "digitalDateTypeList[]", required = false) ArrayList<String> digitalDateTypeList
            , @RequestParam (value = "fileExtensionList[]", required = false) ArrayList<String> fileExtensionList){


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("providingInstitutionList", providingInstitutionList);
        paramMap.put("rightsStatementMediaList", rightsStatementMediaList);
        paramMap.put("objectTypeList", objectTypeList);
        paramMap.put("digitalDateTypeList", digitalDateTypeList);
        paramMap.put("fileExtensionList", fileExtensionList);

        //logger.info("providingInstitutionList 담긴 값 : {}", providingInstitutionList);

        List<Data> ruSearchBySelectList = searchService.getSearchBySelectList_ru(paramMap);
         //logger.info("[TEST] searchBySelectList의 갯수 : " + ruSearchBySelectList.size());
        //model.addAttribute("title", "작품 검색");

        model.addAttribute("dataSearchList", ruSearchBySelectList);

        return ruSearchBySelectList;

    }




    /* data 검색 - en */
    @GetMapping("/dataSearchResult")
    public String dataSeachResult(Model model
            ,@RequestParam (value = "searchKey", required = false) String searchKey
            ,@RequestParam (value = "searchValue", required = false) String searchValue) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchKey", searchKey);
        paramMap.put("searchValue", searchValue);

        List<Data> dataSearchList = searchService.getDataSearchList(paramMap);
        //logger.info("dataSearchList 담긴 값 : {}", dataSearchList);

        int countSearchData = searchService.countSearchData(paramMap);
        //logger.info("data 검색 개수 : {}", countSearchData);

        model.addAttribute("title", "작품 검색");
        model.addAttribute("dataSearchList", dataSearchList);
        model.addAttribute("countSearchData", countSearchData);

        return "en/test/dataSearchResult";

    }



        /* data 검색 - ru */
    @GetMapping("ru/dataSearchResult")
    public String ruDataSeachResult(Model model
            ,@RequestParam (value = "searchKey", required = false) String searchKey
            ,@RequestParam (value = "searchValue", required = false) String searchValue){

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchKey", searchKey);
        paramMap.put("searchValue", searchValue);

        List<Data> dataSearchList = searchService.getDataSearchList(paramMap);
        //logger.info("dataSearchList 담긴 값 : {}", dataSearchList);

        int countSearchData = searchService.countSearchData(paramMap);
        //logger.info("data 검색 개수 : {}", countSearchData);

        model.addAttribute("title", "작품 검색");
        model.addAttribute("dataSearchList", dataSearchList);
        model.addAttribute("countSearchData", countSearchData);

        return "ru/test/dataSearchResult";
    }
    @ResponseBody
    @PostMapping("/dataSearchResult")
    public List<Data> dataSearchResult(Model model
            , @RequestParam (value = "providingInstitutionList[]", required = false) ArrayList<String> providingInstitutionList
            , @RequestParam (value = "rightsStatementMediaList[]", required = false) ArrayList<String> rightsStatementMediaList
            , @RequestParam (value = "objectTypeList[]", required = false) ArrayList<String> objectTypeList
            , @RequestParam (value = "digitalDateTypeList[]", required = false) ArrayList<String> digitalDateTypeList
            , @RequestParam (value = "fileExtensionList[]", required = false) ArrayList<String> fileExtensionList){


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("providingInstitutionList", providingInstitutionList);
        paramMap.put("rightsStatementMediaList", rightsStatementMediaList);
        paramMap.put("objectTypeList", objectTypeList);
        paramMap.put("digitalDateTypeList", digitalDateTypeList);
        paramMap.put("fileExtensionList", fileExtensionList);

        /*logger.info("providingInstitutionList 담긴 값 : {}", providingInstitutionList);*/

        List<Data> dataSearchResult = searchService.getSearchBySelectList(paramMap);
        /* logger.info("[TEST] searchBySelectList 담긴 값 : {}", searchBySelectList);*/
        //model.addAttribute("title", "작품 검색");

        model.addAttribute("dataSearchList", dataSearchResult);

        return dataSearchResult;
    }
    @ResponseBody
    @PostMapping("ru/dataSearchResult")
    public List<Data> rudataSearchResult(Model model
            , @RequestParam (value = "providingInstitutionList[]", required = false) ArrayList<String> providingInstitutionList
            , @RequestParam (value = "rightsStatementMediaList[]", required = false) ArrayList<String> rightsStatementMediaList
            , @RequestParam (value = "objectTypeList[]", required = false) ArrayList<String> objectTypeList
            , @RequestParam (value = "digitalDateTypeList[]", required = false) ArrayList<String> digitalDateTypeList
            , @RequestParam (value = "fileExtensionList[]", required = false) ArrayList<String> fileExtensionList){


        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("providingInstitutionList", providingInstitutionList);
        paramMap.put("rightsStatementMediaList", rightsStatementMediaList);
        paramMap.put("objectTypeList", objectTypeList);
        paramMap.put("digitalDateTypeList", digitalDateTypeList);
        paramMap.put("fileExtensionList", fileExtensionList);

        /*logger.info("providingInstitutionList 담긴 값 : {}", providingInstitutionList);*/

        List<Data> rudataSearchResult = searchService.getSearchBySelectList_ru(paramMap);
        /* logger.info("[TEST] searchBySelectList 담긴 값 : {}", searchBySelectList);*/
        //model.addAttribute("title", "작품 검색");

        model.addAttribute("dataSearchList", rudataSearchResult);

        return rudataSearchResult;

    }


    /* Data_Code로 data 상세검색 - en */
    @GetMapping("/dataSearchDetail")
    public String dataSearchDetail( Model model
            ,@RequestParam(value = "Data_Code",required = false)String Data_Code
            ,@RequestParam(value = "filePath", required = false)String filePath) throws ParseException{

        logger.info("파일 주소 : " , filePath);

        Data data = searchService.getDataSearchDetailList(Data_Code);
        logger.info("data 담긴 값 : {} ", data);

        model.addAttribute("title","Data 검색 상세 화면");
        model.addAttribute("data",data);

        return "en/test/dataSearchDetail";


    }


    /* Data_Code로 data 상세검색 - ru */
    @GetMapping("ru/dataSearchDetail")
    public String ruDataSearchDetail( Model model
            ,@RequestParam(value = "Data_Code",required = false)String Data_Code
            ,@RequestParam(value = "filePath", required = false)String filePath) throws ParseException{

        logger.info("파일 주소 : " , filePath);

        Data data = searchService.getDataSearchDetailList(Data_Code);
        logger.info("data 담긴 값 : {} ", data);

        model.addAttribute("title","Data 검색 상세 화면");
        model.addAttribute("data",data);

        return "ru/test/dataSearchDetail";


    }




}
