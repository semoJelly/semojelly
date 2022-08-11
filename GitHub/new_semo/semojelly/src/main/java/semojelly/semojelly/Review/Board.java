package semojelly.semojelly.Review;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import semojelly.semojelly.User.User;

import javax.persistence.*;

@Data
@Entity(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardId;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    /*
    @OneToMany(mappedBy = "board")
    private List<Reply> reply; */

    @ColumnDefault("0")
    private int count;

    public void setUser(User findUser) {
        user = findUser;
    }

    /*
    @CreationTimestamp
    private Timestamp createDate; */
}
