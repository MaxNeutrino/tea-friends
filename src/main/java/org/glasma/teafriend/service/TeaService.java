package org.glasma.teafriend.service;

import org.glasma.teafriend.model.Tea;

import java.util.Collection;

public interface TeaService {

    Tea save(Tea tea);

    void delete(int id);

    Tea update(Tea tea);

    Tea get(int id);

    Collection<Tea> getAll();

    Collection<Tea> getFilteredTeaList(String category, String country);

    Collection<Tea> getTeaByCategory(String category);

    Collection<Tea> getTeaByCountry(Collection<Tea> teaList, String country);

}
