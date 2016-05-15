package org.glasma.teafriend.web.User;

import org.glasma.teafriend.LoggedUser;
import org.glasma.teafriend.model.User;

import java.util.Collection;

public class ProfileRestController extends AbstractUserRestController{

    public Collection<User> getAll(){
        return super.getAll();
    }

    public User get(int id){
        return super.get(LoggedUser.id);
    }

    public void update(User user) {
        super.update(user, LoggedUser.id);
    }

    public void delete() {
        super.delete(LoggedUser.id);
    }
}
