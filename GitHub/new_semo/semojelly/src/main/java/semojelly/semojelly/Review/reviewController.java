package semojelly.semojelly.Review;

import semojelly.semojelly.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
@Slf4j
public class reviewController {
    private BoardWriteService boardWriteService;

    @GetMapping("/board_write")
    public String BoardWriter(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                    User user, Model model
    ){

        addUser(user, model);
        return "board_write";
    }

    @PostMapping("/board_write")
    public String BoardWriter(@ModelAttribute Board board, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            User user){

        boardWriteService.write(board, user);
        return "redirect:/";

    }

//    @GetMapping("/board_write")
//    public String BoardWriter(User user, Model model, HttpServletRequest request){
//
//        HttpSession session = request.getSession(false);
//        Member loginMember = (Member) session.getAttribute(SessionConst.Login_MEMBER);
//
//        addUser(user, model);
//        return "reviewCreate.html";
//    }

//    @PostMapping("/board_write")
//    public String BoardWriter(@ModelAttribute Board board, User user, HttpServletRequest request){
//
//        boardWriteService.write(board, user);
//        return "redirect:/";
//
//    }

    public void addUser(User user, Model model){
        if(user == null) {
            model.addAttribute("user", new User());
            return;
        }
        model.addAttribute("user", user);
        return;
    }
};