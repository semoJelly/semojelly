package semojelly.semojelly.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
    List<User> findAll();
   @Query("select u from User u where u.userId=:userId and u.userPwd=:userPwd")
    User selectUserInfo(@Param("userId")String userId,@Param("userPwd")String userPwd);

}