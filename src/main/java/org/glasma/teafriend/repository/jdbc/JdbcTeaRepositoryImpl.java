package org.glasma.teafriend.repository.jdbc;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class JdbcTeaRepositoryImpl implements TeaRepository {

    @Override
    public Tea save(Tea tea) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Tea get(int id) {
        return null;
    }

    @Override
    public Collection<Tea> getAll() {
        return null;
    }

    @Override
    public Collection<Tea> getByCategory(String category) {
        return null;
    }

    @Override
    public Collection<Tea> getByCountry(Collection<Tea> teaList, String country) {
        return null;
    }
}
