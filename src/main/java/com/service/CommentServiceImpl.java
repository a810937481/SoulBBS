package com.service;

import com.dao.CommentMapper;
import com.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(int commentPostId, int pageIndex) {
        return commentMapper.getComment(commentPostId,pageIndex);
    }

    @Override
    public int getCommentsCountByPostId(int commentPostId) {
        return commentMapper.getCommentsCountByPostId(commentPostId);
    }

    @Override
    public int addComment(int commentPostId, int commentUserId, String commentContent) {
        return commentMapper.addComment(commentPostId,commentUserId,commentContent);
    }

    @Override
    public int deleteComment(int commentId) {
        return commentMapper.deleteComment(commentId);
    }
}
