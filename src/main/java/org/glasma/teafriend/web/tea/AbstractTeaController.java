package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public abstract class AbstractTeaController {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractTeaController.class);

    @Autowired
    protected TeaService service;

    public Tea get(int id) {
        LOG.info("get tea {}", id);
        return service.get(id);
    }

    public Collection<Tea> getAll() {
        LOG.info("getAll teas {}");
        return service.getAll();
    }

    public void delete(int id) {
        LOG.info("delete tea {}", id);
        service.delete(id);
        //service.evictCache();
    }

    public void update(Tea tea) {
        LOG.info("update {}", tea);
        service.update(tea);
    }

    public Tea create(Tea tea) {
        LOG.info("create {}", tea);
        return service.save(tea);
    }

    public Collection<Tea> getFilteredList(String category, String country) {
        LOG.info("get teas {}", category, country);
        return service.getFilteredTeaList(category, country);
    }

    public Collection<Tea> searchTeaByName(String name) {
        LOG.info("get teas {}", name);
        return service.searchByName(name);
    }
}
