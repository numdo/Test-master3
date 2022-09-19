package com.example.testsearch.controller;

import com.example.testsearch.dto.Data;
import com.example.testsearch.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = (Logger) LogManager.getLogger(MainController.class);

    private SearchService searchService;

    public MainController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/main")
    public String enMain(Model model){

        model.addAttribute("title", "검색");

        return "en/en_main";
    }
    @GetMapping("/ru")
    public String ruMain(Model model){

        model.addAttribute("title", "검색");

        return "ru/ru_main";
    }

    @GetMapping("/")
    public String Main(Model model){

        List<Data> dataList = searchService.getDataList();

        //logger.info("dataList에 담긴 값 :  {}", dataList);
        model.addAttribute("title", "Main");
        model.addAttribute("dataList", dataList);

        return "/main";
    }


}
