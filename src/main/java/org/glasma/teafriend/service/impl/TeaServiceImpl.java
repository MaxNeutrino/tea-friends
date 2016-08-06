package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.glasma.teafriend.service.TeaService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeaServiceImpl implements TeaService {

    @Autowired
    TeaRepository repository;

    @Override
    //@CacheEvict(value = "teas", allEntries = true)
    public Tea save(Tea tea) {
        return repository.save(tea);
    }

    @Override
    //@CacheEvict(value = "teas", allEntries = true)
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    //@CacheEvict(value = "teas", allEntries = true)
    public Tea update(Tea tea) {
        return repository.save(tea);
    }

    @Override
    public Tea get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public Collection<Tea> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    //@Cacheable("teas")
    public Collection<Tea> getAll() {
        return repository.getAll();
    }

    @Override
    public Collection<Tea> getFilteredTeaList(String category, String country) {
        Collection<Tea> teaList;
        if (category.equals("Все"))
            teaList = getAll();
        else
            teaList = getAll().stream()
                    .filter(t -> t.getCategory().equals(category))
                    .collect(Collectors.toList());

        if (!country.equals("Все"))
            teaList = teaList.stream()
                    .filter(t -> t.getCountry().equals(country))
                    .collect(Collectors.toList());
        return teaList;
    }

    @Override
    public Collection<Tea> searchByName(String name) {
        return getAll().stream()
                .filter(t -> t.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    //@CacheEvict(value = "teas", allEntries = true)
    public void evictCache() {

    }
}
