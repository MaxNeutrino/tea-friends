package org.glasma.teafriend.service.impl;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.model.UserComment;
import org.glasma.teafriend.repository.UserCommentRepository;
import org.glasma.teafriend.service.UserCommentService;
import org.glasma.teafriend.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService {

    @Autowired
    UserCommentRepository repository;

    @Override
    public UserComment get(int id) {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public List<UserComment> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    @Override
    public List<UserComment> getAllByTea(int teaId) {
        return repository.getAllByTea(teaId);
    }

    @Override
    public UserComment save(UserComment comment, int userId, int teaId) {
        return repository.save(comment,userId, teaId);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }
}
