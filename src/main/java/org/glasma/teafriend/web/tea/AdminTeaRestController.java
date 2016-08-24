package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.model.Tea;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(AdminTeaRestController.ADMIN_TEA_REST_URL)
public class AdminTeaRestController extends AbstractTeaController {
    static final String ADMIN_TEA_REST_URL = "/rest/admin/teas";

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Tea tea, @PathVariable("id") int id) {
        super.update(tea);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tea> createWithLocation(@RequestBody Tea tea) {
        Tea created = super.create(tea);
        URI uriOfNewSource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ADMIN_TEA_REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewSource);

        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }
}
