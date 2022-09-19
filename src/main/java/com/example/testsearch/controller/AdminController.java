package com.example.testsearch.controller;

import com.example.testsearch.dto.Data;
import com.example.testsearch.dto.UserDto;
import com.example.testsearch.mapper.CommonMapper;
import com.example.testsearch.service.AdminService;
import com.example.testsearch.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchController.class);

    private UserService userService;
    private AdminService adminService;
    private CommonMapper commonMapper;


    public AdminController(UserService userService, AdminService adminService, CommonMapper commonMapper){
        this.userService = userService;
        this.adminService = adminService;
        this.commonMapper = commonMapper;
    }

    /* 전체 회원정보 조회 */
    @GetMapping("userList")
    public String getUserList(Model model){

        List<UserDto> userList = userService.getUserList();

        model.addAttribute("title", "전체 회원정보 목록");
        model.addAttribute("userList", userList);
        logger.info("userList : {}", userList);

        return "en/admin/userList";

    }


    //data 등록화면 - en
    @GetMapping("/insert")
    public String addImage(Model model, HttpSession session) {
        String sessionId = (String) session.getAttribute("SID");
        String sessionEmail = (String) session.getAttribute("SEMAIL");
        model.addAttribute("title", "작품 등록");
        model.addAttribute("SEMAIL",sessionEmail);
        model.addAttribute("SID",sessionId);

        return "en/admin/insert";
    }


    //data 등록화면 - ru
    @GetMapping("/ru/insert")
    public String ruAddImage(Model model, HttpSession session) {
        String sessionId = (String) session.getAttribute("SID");
        String sessionEmail = (String) session.getAttribute("SEMAIL");
        model.addAttribute("title", "작품 등록");
        model.addAttribute("SEMAIL",sessionEmail);
        model.addAttribute("SID",sessionId);

        return "ru/admin/insert";
    }


    //data 등록 처리 - en
    @PostMapping("/insert")
    public String addData(  Data data
            , HttpSession session
            , @RequestParam MultipartFile[] fileImage
            , HttpServletRequest request){

        String sessionEmail = (String) session.getAttribute("SEMAIL");
        String sessionId = (String) session.getAttribute("SID");

        //파일 업로드

        String serverName = request.getServerName();
        String fileRealPath = "";
        try {
            if("localhost".equals(serverName)) {
                fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
                //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
            }else {
                fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
            }
            // ...
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        logger.info("data 등록 폼에서 입력받은 데이터: {}", data);

        adminService.addData(data, sessionId, fileImage, fileRealPath);


        return "redirect:/test/dataSearchResult?searchValue=";

    }



    //data 등록 처리 - ru
    @PostMapping("/ru/insert")
    public String ruAddData(  Data data
            , HttpSession session
            , @RequestParam MultipartFile[] fileImage
            , HttpServletRequest request) {

        String sessionEmail = (String) session.getAttribute("SEMAIL");
        String sessionId = (String) session.getAttribute("SID");

        //파일 업로드
        String serverName = request.getServerName();
        String fileRealPath = "";
        if("localhost".equals(serverName)) {
            fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
            //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
        }else {
            fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
        }

        logger.info("data 등록 폼에서 입력받은 데이터: {}", data);

        adminService.addData(data, sessionId, fileImage, fileRealPath);


        return "redirect:/test/ru/dataSearchResult?searchValue=";

    }

}
