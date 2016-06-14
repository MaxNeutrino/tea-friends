package org.glasma.teafriend.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = TeaRate.GET, query = "SELECT r FROM TeaRate r WHERE r.tea.id=:teaId AND r.user.id=:userId"),
        @NamedQuery(name = TeaRate.DELETE, query = "DELETE FROM TeaRate r WHERE r.id=:id"),
        @NamedQuery(name = TeaRate.DELETE_ALL, query = "DELETE FROM TeaRate r WHERE r.tea.id=:teaId"),
        @NamedQuery(name = TeaRate.ALL_SORTED, query = "SELECT r FROM TeaRate r WHERE r.tea.id=:teaId ORDER BY r.rate DESC"),
})
@Entity
@Table(name = "tea_rate")
public class TeaRate extends BaseEntity {

    public static final String GET = "TeaRate.get";
    public static final String DELETE = "TeaRate.delete";
    public static final String DELETE_ALL = "TeaRate.deleteALL";
    public static final String ALL_SORTED = "TeaRate.getAllByTea";

    @Column(name = "rate")
    protected int rate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    protected User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tea_id")
    protected Tea tea;

    public TeaRate(){}

    public TeaRate(TeaRate tr){
        this(tr.getId(), tr.getRate(), tr.getUser(), tr.getTea());
    }

    public TeaRate(int rate) {
        this(null, rate);
    }

    public TeaRate (Integer id, int rate) {
        super(id);
        this.rate = rate;
    }

    public TeaRate (int rate, User user, Tea tea) {
        this(null, rate, user, tea);
    }

    public TeaRate (Integer id, int rate, User user, Tea tea) {
        super(id);
        this.rate = rate;
        this.user = user;
        this.tea = tea;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    @Override
    public String toString() {
        return "TeaRate{" +
                "rate=" + rate +
                ", user=" + user +
                ", tea=" + tea +
                '}';
    }
}
