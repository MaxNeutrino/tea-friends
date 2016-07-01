package org.glasma.teafriend.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email"),
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends NamedEntity {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    protected String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6)
    protected String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    protected Set<Role> roles;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered;

    @ManyToMany
    @JoinTable(name = "user_wish_tea",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "tea_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tea> drunkTeaList;

    @ManyToMany
    @JoinTable(name = "user_drunk_tea",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tea_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tea> wishTeaList;

    public User(){}

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRoles());
    }

    public User(Integer id, String user, String email, String pass, Role role, Role... roles) {
        this(id, user, email, pass, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, Set<Role> roles){
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tea> getDrunkTeaList() {
        return drunkTeaList;
    }

    public void setDrunkTeaList(List<Tea> drinkedTea) {
        this.drunkTeaList = drinkedTea;
    }

    public List<Tea> getWishTeaList() {
        return wishTeaList;
    }

    public void setWishTeaList(List<Tea> wishTea) {
        this.wishTeaList = wishTea;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
