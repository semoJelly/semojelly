package semojelly.semojelly.Review;

import org.springframework.web.bind.annotation.*;
import semojelly.semojelly.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
@Slf4j
public class reviewController {
    private BoardWriteService boardWriteService;
    UserRepository userRepository;
    BoardRepository boardRepository;
    // @GetMapping("/board_write")
    @RequestMapping(value = "/board_write", method = {RequestMethod.GET})
    public String BoardWriter(/*User user, Board board, Model model,*/Board board , HttpServletRequest request)
    // @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
    //        User user, Model model

    {
        HttpSession httpSession = request.getSession(true);
        System.out.println("now login ID: " + httpSession.getAttribute("userId"));
        System.out.println("board의 session:" + httpSession.getId());

        return "reviewCreate";
    }
    @RequestMapping(value = "/board_write", method = {RequestMethod.POST})
    public String BoardWriter(HttpServletRequest request, Board board){
        HttpSession httpSession = request.getSession(true);
        boardWriteService.reviewWrite(board, userRepository.findByUserId(httpSession.getId()));
        return "main";
    }

/*
     @RequestMapping(value = "/board_write", method = {RequestMethod.POST})
    public String BoardWriter(HttpServletRequest request, Board board, User user)
    //@ModelAttribute Board board, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
    //User user)
    {
        HttpSession httpSession = request.getSession(true);
        System.out.println("Controller에서의 get User" + board.getUser());
        boardWriteService.reviewWrite(board, board.getUser());
        return "main";

    }*/

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

   /* public void addUser(User user, Model model){
        if(user == null) {
            model.addAttribute("user", new User());
            return;
        }
        model.addAttribute("user", user);
        return;
    }*/
};