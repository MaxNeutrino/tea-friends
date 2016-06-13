package org.glasma.teafriend.service;

import org.glasma.teafriend.model.TeaRate;

import java.util.List;

public interface TeaRateService {

    TeaRate setRate(TeaRate rate, int userId, int teaId);

    void delete(int id);

    void deleteAll(int teaId);

    List<TeaRate> getAllByTea(int teaId);
}
