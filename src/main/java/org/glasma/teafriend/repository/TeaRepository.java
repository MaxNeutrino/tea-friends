package org.glasma.teafriend.repository;

import org.glasma.teafriend.model.Tea;

import java.util.Collection;

public interface TeaRepository {

    Tea save(Tea tea);

    boolean delete(int id);

    Tea get(int id);

    Collection<Tea> getByName(String name);

    Collection<Tea> getAll();

    Collection<Tea> getByCategory(String category);

    Collection<Tea> getByCountry(Collection<Tea> teaList, String country);
}
