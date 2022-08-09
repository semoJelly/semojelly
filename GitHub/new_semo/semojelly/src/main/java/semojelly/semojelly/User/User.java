package semojelly.semojelly.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "userTBL")
//@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPwd;

    @Builder
    public User(String userName, String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }
}*/
@Entity
@Table(name = "userTBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    private String userId;
    private String userName;
    private String userPwd;

    public User(String userId, String userName, String userPwd){
        this.userId = userId;
        this.userName = userName;
        this.userPwd =userPwd;

    }
    public static User signupUser(String userId, String userName,String userPwd){
        return new User(userId,userName, userPwd);
    }

}
