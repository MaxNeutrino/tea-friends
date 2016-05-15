package org.glasma.teafriend.repository.mock;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.repository.TeaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryTeaRepositoryImpl implements TeaRepository {

    private Map<Integer, Tea> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Tea("Молочный оолонг", "Светлый улун", "Китай", "Очень вкусный"));
        save(new Tea("Тегуаньинь", "Светлый улун", "Китай", "Очень вкусный"));
        save(new Tea("Алишань улун", "Светлый улун", "Китай", "Очень вкусный"));
        save(new Tea("Дахунпао", "Темный улун", "Китай", "Очень вкусный"));
        save(new Tea("Белая обезьяна", "Белый", "Китай", "Очень вкусный"));
        save(new Tea("Мень Шань Э Ча", "Зеленый", "Китай", "Очень вкусный"));
        save(new Tea("Чжуецин", "Зеленый", "Китай", "Очень вкусный"));
        save(new Tea("Тайпин Хоукуй", "Зеленый", "Китай", "Очень вкусный"));
        save(new Tea("Маофен Хуан Шань", "Зеленый", "Китай", "Очень вкусный"));
        save(new Tea("Ассам Мангалам", "Черный", "Индия", "Очень вкусный"));
        save(new Tea("Ассам Диком", "Черный", "Индия", "Очень вкусный"));
        save(new Tea("Дарджилинг Гопалдхара", "Черный", "Индия", "Очень вкусный"));
        save(new Tea("Золотое руно Колхиды", "Черный", "Грузия", "Очень вкусный"));
        save(new Tea("Золото Тапробаны", "Черный", "Цейлон", "Очень вкусный"));
        save(new Tea("Поттотува", "Черный", "Цейлон", "Очень вкусный"));
        save(new Tea("Мэнхай Даи", "Шен Пуэр", "Китай", "Очень вкусный"));
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

    @Override
    public Collection<Tea> getByCategory(String category) {
        return getAll().stream()
                .filter(tea -> tea.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tea> getByCountry(Collection<Tea> teaList, String country) {
        return teaList.stream()
                .filter(tea -> tea.getCountry().equals(country))
                .collect(Collectors.toList());
    }
}
