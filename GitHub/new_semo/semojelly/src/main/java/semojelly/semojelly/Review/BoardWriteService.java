package semojelly.semojelly.Review;

import semojelly.semojelly.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardWriteService {
    private BoardRepository boardRepository;
    private UserRepository userRepository;
    public void write(Board board, User user){
        User findUser = userRepository.findByUserId(user.getUserId());
        board.setUser(findUser);
        boardRepository.save(board);
    }
}
