package semojelly.semojelly.Review;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;
    // @GetMapping("/board_write")
    @RequestMapping(value = "/review_write", method = {RequestMethod.GET,RequestMethod.POST})
    public String BoardWriter(Board board , HttpServletRequest request)
    {
        HttpSession httpSession = request.getSession(true);
        System.out.println("now login ID: " + httpSession.getAttribute("userId"));
        System.out.println("board의 session:" + httpSession.getId());
        String loginId = (String) httpSession.getAttribute("userId");
        board.setUserId(loginId);
        if(board.getTitle()==null&&board.getContent()==null){
            return "reviewWrite";
        }
        if(board.getTitle()!=""){
            boardRepository.save(board);
        }
        return "main";
    }
    /*@RequestMapping(value = "/review_write", method = {RequestMethod.POST})
    public String BoardWriter(HttpServletRequest request, Board board){
        HttpSession httpSession = request.getSession(true);
        System.out.println("board 작성 후 session:" + httpSession.getAttribute("userId"));
        String userSession = httpSession.getAttribute("userId").toString();
        System.out.println(userSession);
        String loginId = (String) httpSession.getAttribute("userId");
        boardWriteService.reviewWrite(board, loginId);
        return "login";
    }*/

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