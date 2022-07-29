package semojelly.semojelly.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

  public void signupUser(User user) {

      userRepository.save(user);
      System.out.println("userService user=" +user);
    }

    public User loginUser(String userId, String userPwd) {

        User userVO = userRepository.selectUserInfo(userId, userPwd);
        return userVO;

  }


}
