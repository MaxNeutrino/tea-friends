package org.glasma.teafriend.service;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.util.exception.NotFoundException;

import java.util.Collection;

public interface TeaService {

    Tea save(Tea tea);

    void delete(int id);

    Tea update(Tea tea);

    Tea get(int id) throws NotFoundException;

    Collection<Tea> getByName(String name);

    Collection<Tea> getAll();

    Collection<Tea> getFilteredTeaList(String category, String country);

    void evictCache();
}
