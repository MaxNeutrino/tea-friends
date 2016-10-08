package org.glasma.teafriend.web.user;

import org.glasma.teafriend.model.Role;
import org.glasma.teafriend.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserRestController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<User> getAll() { return super.getAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) { super.delete(id); }

    @RequestMapping(method = RequestMethod.POST)
    public void update(@RequestParam("id") int id,
                       @RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {
        User user = new User(id, name, email, password, Role.ROLE_USER);

        if (id == 0) {
            super.create(user);
        } else {
            super.update(user, id);
        }
    }
}
