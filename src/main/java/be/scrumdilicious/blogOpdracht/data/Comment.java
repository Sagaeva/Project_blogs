package be.scrumdilicious.blogOpdracht.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Long userId;
    @Column(columnDefinition = "text", nullable = false)
    private String message;
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void oneCreate() {
        this.createdDate = LocalDateTime.now();
    }

    public Comment() {
    }

    public Comment(Post post, String username, Long userId, String message, LocalDateTime createdDate) {
        this.post = post;
        this.username = username;
        this.userId = userId;
        this.message = message;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Comment{"+
                "Id="+Id+
                ", post="+post+
                ", username='"+username+'\''+
                ", userId="+userId+
                ", message='"+message+'\''+
                ", createdDate="+createdDate+
                '}';
    }
}
