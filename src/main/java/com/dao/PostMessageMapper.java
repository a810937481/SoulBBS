package com.dao;

import com.entity.PostMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PostMessageMapper {

    List<PostMessage> getPostMessage(@Param(value = "pmUserId") int pmUserId);

    int addPostMessage(@Param(value = "pmUserId") int pmUserId,
                       @Param(value = "pmPostId") int pmPostId,
                       @Param(value = "pmPostState") int pmPostState);

    int deletePostMessage(@Param(value = "pmId") int pmId);

}
