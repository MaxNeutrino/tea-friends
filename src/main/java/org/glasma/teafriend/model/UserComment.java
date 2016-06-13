package org.glasma.teafriend.model;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = UserComment.GET, query = "SELECT c FROM UserComment c WHERE c.id=:id"),
        @NamedQuery(name = UserComment.DELETE, query = "DELETE FROM UserComment c WHERE c.id=:id"),
        @NamedQuery(name = UserComment.ALL_SORTED_BY_USER, query =
                "SELECT c FROM UserComment c WHERE c.user.id=:userId ORDER BY c.created DESC"),
        @NamedQuery(name = UserComment.ALL_SORTED_BY_TEA, query =
                "SELECT c FROM UserComment c WHERE c.tea.id=:teaId ORDER BY c.created DESC"),
})
@Entity
@Table(name = "comments")
public class UserComment extends BaseEntity {

    public static final String GET = "UserComment.get";
    public static final String DELETE = "UserComment.delete";
    public static final String ALL_SORTED_BY_USER = "UserComment.getAllByUser";
    public static final String ALL_SORTED_BY_TEA = "UserComment.getAllByTea";

    @Column(name = "created", columnDefinition = "timestamp default now()")
    protected Date created = new Date();

    @Column(name = "message")
    protected String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tea_id", nullable = false)
    protected Tea tea;

    public UserComment() {
    }

    public UserComment(String message) {
        this(null, message);
    }

    public UserComment(UserComment comment) {
        this(comment.getId(), comment.getMessage());
    }

    public UserComment(Integer id, String message) {
        super(id);
        this.message = message;
    }

    public UserComment(Integer id, String message, User user, Tea tea) {
        super(id);
        this.message = message;
        this.user = user;
        this.tea = tea;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public Tea getTea() {
        return tea;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                " id=" + id +
                ", created=" + created +
                ", message=" + message +
                ", user_id=" + user +
                ", tea_id=" + tea +
                '}';
    }
}
