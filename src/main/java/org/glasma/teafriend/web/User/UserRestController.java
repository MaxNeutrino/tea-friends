package org.glasma.teafriend.web.User;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class UserRestController {

    private final LoggerWrapper LOG = LoggerWrapper.get(UserRestController.class);

    @Autowired
    UserService service;

    public Collection<User> getAll(){
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id){
        LOG.info("get " + id);
        return service.get(id);
    }

    public User create(User user){
        user.setId(null);
        LOG.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        user.setId(id);
        LOG.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}
