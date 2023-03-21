package com.dao;

import com.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    //要完成：增删查
    //查
    List<Comment> getComment(@Param(value = "commentPostId") int commentPostId,
                             @Param(value = "pageIndex") int pageIndex);

    int getCommentsCountByPostId(@Param(value = "commentPostId") int commentPostId);

    //增
    int addComment(@Param(value = "commentPostId") int commentPostId,
                   @Param(value = "commentUserId") int commentUserId,
                   @Param(value = "commentContent") String commentContent);

    //删
    int deleteComment(@Param(value = "commentId") int commentId);

}
