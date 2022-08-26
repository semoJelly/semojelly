package semojelly.semojelly.Review;

import org.springframework.aop.scope.ScopedProxyUtils;
import semojelly.semojelly.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardWriteService {
    private BoardRepository boardRepository;
    private UserRepository userRepository;
    HttpServletRequest request;

    public void reviewWrite(Board board, String user) {
     /*   User findUser = userRepository.findByUserId((String) request.getAttribute("userId"));
        System.out.println("Service에서의 get User" + board.getUser());
        board.setUser(findUser);
        boardRepository.save(board);*/
        // HttpSession httpSession = request.getSession(true);
        //board.setUserId(user);
        //board.setUserId(user);
        boardRepository.save(board);
        System.out.println(board);
    }
}
