package org.glasma.teafriend.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class User extends NamedEntity{

    protected String email;

    protected String password;

    protected Set<Role> roles;

    protected Date registered;

    protected List<Tea> drinkedTea;

    protected List<Tea> wishTea;

    public User(){}

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRoles());
    }

    public User(int id, String name, String email, String password, Set<Role> roles){
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(int id, String user, String email, String pass, Role role, Role... roles) {
        this(id, user, email, pass, EnumSet.of(role, roles));
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

    public List<Tea> getDrinkedTea() {
        return drinkedTea;
    }

    public void setDrinkedTea(List<Tea> drinkedTea) {
        this.drinkedTea = drinkedTea;
    }

    public List<Tea> getWishTea() {
        return wishTea;
    }

    public void setWishTea(List<Tea> wishTea) {
        this.wishTea = wishTea;
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
