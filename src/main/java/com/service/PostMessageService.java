package com.service;

import com.entity.PostMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMessageService {

    List<PostMessage> getPostMessage(int pmUserId);

    int addPostMessage(int pmUserId, int pmPostId, int pmPostState);

    int deletePostMessage(int pmId);

}
