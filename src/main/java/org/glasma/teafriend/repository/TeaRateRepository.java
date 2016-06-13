package org.glasma.teafriend.repository;

import org.glasma.teafriend.model.TeaRate;

import java.util.List;

public interface TeaRateRepository {

    TeaRate setRate(TeaRate rate, int userId, int teaId);

    boolean delete(int id);

    boolean deleteAll(int teaId);

    List<TeaRate> getAllByTea(int teaId);
}
