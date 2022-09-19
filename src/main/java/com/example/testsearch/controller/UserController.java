package com.example.testsearch.controller;

import com.example.testsearch.dto.UserDto;
import com.example.testsearch.mapper.UserMapper;
import com.example.testsearch.service.SearchService;
import com.example.testsearch.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = (Logger) LogManager.getLogger(SearchController.class);

    private UserService userService;

    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /* 회원가입 화면 - en */
    @GetMapping("/join")
    public String addUser(Model model){

        model.addAttribute("title", "회원가입");

        return "en/user/join";
    }



    /* 회원가입 화면 - ru */
    @GetMapping("/ru/join")
    public String ruAddUser(Model model){

        model.addAttribute("title", "회원가입");

        return "ru/user/join";
    }



    /* 회원가입 처리 - en */
    @RequestMapping(value = "/join", method = {RequestMethod.POST})
    public String addUser(UserDto userDto){

        logger.info("회원가입폼에서 입력받은 데이터: {}", userDto);


        userService.addUser(userDto);

        return "redirect:/";
    }



    /* 회원가입 처리 - ru */
    @RequestMapping(value = "/ru/join", method = {RequestMethod.POST})
    public String ruAddUser(UserDto userDto){

        logger.info("회원가입폼에서 입력받은 데이터: {}", userDto);


        userService.addUser(userDto);

        return "redirect:/ru";
    }




    /* Ajax - 이메일 중복체크 */
    @PostMapping("/idCheck")
    @ResponseBody
    public boolean isIdCheck(@RequestParam(value = "useremail") String useremail){
        boolean idCheck = false;
        logger.info("이메일 중복체크 클릭시 요청받은 useremail의 값: {}", useremail);

        boolean result = userMapper.isIdCheck(useremail);
        if(result) idCheck = true;

        logger.info("이메일 중복체크 여부: {}", result);

        return idCheck;
    }




    /* 로그인 화면 - en */
    @GetMapping("/login")
    public String login( Model model
                        ,@RequestParam(value = "result", required = false) String result){

        model.addAttribute("title", "로그인");

        if(result != null) model.addAttribute("result", result);

        return "en/user/login";
    }


    /* 로그인 화면 - ru */
    @GetMapping("/ru/login")
    public String ruLogin( Model model
                        ,@RequestParam(value = "result", required = false) String result){

        model.addAttribute("title", "로그인");

        if(result != null) model.addAttribute("result", result);

        return "ru/user/login";
    }

    /* 로그인 처리 - en */
    @PostMapping("/login")
    public String login(UserDto userDto, HttpSession session, RedirectAttributes reAttr){
        String useremail = userDto.getUseremail();
        String userpw = userDto.getUserpw();

        UserDto checkUser = userService.getUserInfoByEmail(useremail);

        if(checkUser != null && checkUser.getUserpw() != null && userpw.equals(checkUser.getUserpw())){
            String sessionName = checkUser.getUsername();
            String sessionRole = checkUser.getEnabled();
            String sessionId = checkUser.getUserId();

            session.setAttribute("SEMAIL", useremail);
            session.setAttribute("SROLE", sessionRole);
            session.setAttribute("SNAME", sessionName);
            session.setAttribute("SID",sessionId);
            logger.info("로그인 성공");
            logger.info("SID",sessionId);
            return "redirect:/";
        }
        reAttr.addAttribute("result", "등록된 회원이 없습니다.");
        return "redirect:/en/user/login";
    }



    /* 로그인 처리 - ru */
    @PostMapping("/ru/login")
    public String ruLogin(UserDto userDto, HttpSession session, RedirectAttributes reAttr){
        String useremail = userDto.getUseremail();
        String userpw = userDto.getUserpw();

        UserDto checkUser = userService.getUserInfoByEmail(useremail);

        if(checkUser != null && checkUser.getUserpw() != null && userpw.equals(checkUser.getUserpw())){
            String sessionName = checkUser.getUsername();
            String sessionRole = checkUser.getEnabled();
            String sessionId = checkUser.getUserId();

            session.setAttribute("SEMAIL", useremail);
            session.setAttribute("SROLE", sessionRole);
            session.setAttribute("SNAME", sessionName);
            session.setAttribute("SID",sessionId);
            logger.info("로그인 성공");
            logger.info("SID",sessionId);
            return "redirect:/ru";
        }
        reAttr.addAttribute("result", "등록된 회원이 없습니다.");
        return "redirect:/ru/user/login";
    }


    /* 로그아웃 - en */
    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }


    /* 로그아웃 - ru */
    @GetMapping("/ru/logout")
    public String ruLogout(HttpSession session){

        session.invalidate();

        return "redirect:/ru";
    }

}
