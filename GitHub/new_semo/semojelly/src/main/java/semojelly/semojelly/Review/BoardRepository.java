package semojelly.semojelly.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import semojelly.semojelly.User.User;
import semojelly.semojelly.User.UserRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, String>{

    List<Board> findAll();
}
