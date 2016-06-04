package org.glasma.teafriend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class UserComment extends BaseEntity {

    @Column(name = "created", columnDefinition = "timestamp default now()")
    private Date created;

    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tea tea;

    public UserComment() {}

    public UserComment(Integer id, String message) {
        super(id);
        this.message = message;
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

    @Override
    public String toString() {
        return "UserComment{" +
                "id=" + id +
                "created=" + created +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", tea=" + tea +
                '}';
    }
}
