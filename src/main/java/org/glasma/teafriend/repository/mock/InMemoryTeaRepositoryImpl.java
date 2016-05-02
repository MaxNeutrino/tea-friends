package org.glasma.teafriend.repository.mock;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryTeaRepositoryImpl implements TeaRepository {

    private Map<Integer, Tea> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Tea(1, "Молочный оолонг", "Светлый улун", "Китай", "Очень вкучный"));
        save(new Tea(2, "Дахунпао", "Темный улун", "Китай", "Очень вкучный"));
        save(new Tea(3, "Белая обезьяна", "Белый", "Китай", "Очень вкучный"));
        save(new Tea(4, "Ассам Мангалам", "Черный", "Индия", "Очень вкучный"));
        save(new Tea(5, "Мэнхай Даи", "Шен Пуэр", "Китай", "Очень вкучный"));
    }

    @Override
    public Tea save(Tea tea) {
        if (tea.isNew())
            tea.setId(counter.incrementAndGet());
        return repository.put(tea.getId(), tea);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Tea get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Tea> getAll() {
        return repository.values();
    }
}
