package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domain.Comment;
import jakarta.persistence.EntityManager;
import repository.CommentRepository;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment,Long> implements CommentRepository {
    public CommentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
