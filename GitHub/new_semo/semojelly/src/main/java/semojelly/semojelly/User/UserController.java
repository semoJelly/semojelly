package semojelly.semojelly.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j

public class UserController {
    @Autowired
    UserService userService;
    UserRepository userRepository;

    //로그인 성공
    @RequestMapping(value = "/login.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(User user, Model model) {

        User userVO = userService.loginUser(user.getUserId(), user.getUserPwd());
        System.out.println("User = " + userVO);

        //로그인 페이지 들어갔을때 다 null로 뜸 처리
        if (user.getUserId() == null) {
            return "login";
        }

        if (userVO == null) {
            model.addAttribute("loginMessage", "아이디나 비밀번호가 틀렸습니다.");
            return "login";
        }
        return "main";
    }

    @RequestMapping(value = "/signup.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String signup(User user, Model model) {

        if ((user.getUserId() == null) && user.getUserPwd() == null) {
            return "signup";
        }
        if ((user.getUserId() != "") && (user.getUserPwd() != "")
                && (user.getUserName() != "")) {
            userService.signupUser(user);
            return "login";
        }
        System.out.println(user);
        if(user.getUserId()==""){

            model.addAttribute("signupMessage", "아이디를 입력하세요");
            return "signup";

        }
        if(user.getUserName()==""){
            model.addAttribute("signupMessage","이름을 입력하시오.");
            return "signup";
        }
        if(user.getUserPwd()==""){
            model.addAttribute("signupMessage", "비밀번호를 입력하세요");
            return "signup";
        }

        return "signup";

    }
}