package org.glasma.teafriend.repository;

import org.glasma.teafriend.model.UserComment;

import java.util.List;

public interface UserCommentRepository {

    UserComment get(int id);

    List<UserComment> getAllByUser(int userId);

    List<UserComment> getAllByTea(int teaId);

    UserComment save(UserComment comment, int userId, int teaId);

    boolean delete(int id);
}
