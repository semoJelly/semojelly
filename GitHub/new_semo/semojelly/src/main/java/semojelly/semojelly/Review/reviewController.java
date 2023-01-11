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
        //Session 생성하는 코드 true-> 없으면 생성, false->없으면 걍 null
        HttpSession httpSession = request.getSession(true);
        
        //로그인 한 상태의 Session
        System.out.println("board의 session:" + httpSession.getId());

        //Session 으로부터 지금 로그인 한 ID 얻는 법(type은 object 여서 String으로 바꾸어 사용해야함)
        System.out.println("now login ID: " + httpSession.getAttribute("userId"));
        
        //Object 형태를 String으로 Cast해서 loginId에 저장
        String loginId = (String) httpSession.getAttribute("userId");
        
        board.setUserId(loginId);


        //페이지 접근 씩 null으로 뜨는 오류를 막아두는 코드
        if(board.getTitle()==null&&board.getContent()==null){
            return "reviewWrite";
        }
        
        if(board.getTitle()!=""){
            boardRepository.save(board);
            System.out.println("post를 한 후의 board 형태 : " + board);
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