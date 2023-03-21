package com.service;

import com.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    //查
    List<Comment> getComment(int commentPostId, int pageIndex);

    int getCommentsCountByPostId(int commentPostId);

    //增
    int addComment(int commentPostId, int commentUserId, String commentContent);

    //删
    int deleteComment(int commentId);

}
