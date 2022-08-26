package semojelly.semojelly.Review;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import semojelly.semojelly.User.User;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity(name = "boardTBL")
@DynamicInsert
public class Board {
/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardId;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User userId; //원래는 User userID;가 맞음 도저히 못하겟어서 바꿈~

    /*
    @OneToMany(mappedBy = "board")
    private List<Reply> reply; */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardId;

   // @ManyToOne
   // @JoinColumn(name = "userId")
    //TODO: JOIN 을 할 수 있도록 해야함
    private String userId;
    // @ManyToOne
    // @JoinColumn(name = "productId")
    // private String productId;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;
/*
    @Column
    @ColumnDefault("0")
    private Integer recommend;

    @Column
    @ColumnDefault("0")
    private Integer score;


    private String filename;
    private String fileOriName;
    private String fileURl;*/
/*
    /*public void setUser(User findUser) {
        user = findUser;
    }*/

    /*
    @CreationTimestamp
    private Timestamp createDate; */


}