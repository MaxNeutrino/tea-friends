package org.glasma.teafriend.web.Tea;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class TeaRestController {

    private final LoggerWrapper LOG = LoggerWrapper.get(TeaRestController.class);

    @Autowired
    TeaService service;

    public Collection<Tea> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public Tea get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public Tea create(Tea tea) {
        tea.setId(null);
        LOG.info("create " + tea);
        return service.save(tea);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(Tea tea, int id) {
        tea.setId(id);
        LOG.info("update " + tea);
        service.update(tea);
    }

    public Collection<Tea> getFilteredTeaList(String category, String country) {
        LOG.info("get by category" + category + "& get by country:" + country);
        return service.getFilteredTeaList(category, country);
    }
}
