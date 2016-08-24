package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.model.Tea;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(TeaRestController.TEA_REST_URL)
public class TeaRestController extends AbstractTeaController {
    static final String TEA_REST_URL = "/rest/user/teas";

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tea get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(value = "/{category}/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> getFilteredList(@PathVariable("category") String category, @PathVariable("country") String country) {
        return super.getFilteredList(category, country);
    }

    @Override
    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Tea> searchTeaByName(@PathVariable("name") String name) {
        return super.searchTeaByName(name);
    }
}
