package ru.javawebinar.topjava.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Collection;
import java.util.EnumSet;

/**
 * User: javawebinar.topjava
 */
@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        user.setRoles(EnumSet.of(Role.ROLE_USER));
        if (user.getId() == 0) {
            super.create(user);
        } else {
            super.update(user, user.getId());
        }
        System.out.println();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        user.setRoles(super.get(user.getId()).getRoles());
        super.update(user, id);
    }

    @RequestMapping(value = "/active/{id}", method = RequestMethod.GET)
    public void changeActive(@PathVariable("id") int id) {
        User user = super.get(id);
        user.setEnabled(!user.isEnabled());
        super.update(user, id);
    }
}
