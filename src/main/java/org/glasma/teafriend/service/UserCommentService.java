package org.glasma.teafriend.service;

import org.glasma.teafriend.model.UserComment;

import java.util.List;

public interface UserCommentService {

    UserComment get(int id);

    List<UserComment> getAllByUser(int userId);

    List<UserComment> getAllByTea(int teaId);

    UserComment save(UserComment comment, int userId, int teaId);

    void delete(int id);
}
