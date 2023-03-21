package com.service;

import com.dao.PostMessageMapper;
import com.entity.PostMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostMessageServiceImpl implements PostMessageService{

    @Autowired
    private PostMessageMapper postMessageMapper;

    @Override
    public List<PostMessage> getPostMessage(int pmUserId) {
        return postMessageMapper.getPostMessage(pmUserId);
    }

    @Override
    public int addPostMessage(int pmUserId, int pmPostId, int pmPostState) {
        return postMessageMapper.addPostMessage(pmUserId,pmPostId,pmPostState);
    }

    @Override
    public int deletePostMessage(int pmId) {
        return postMessageMapper.deletePostMessage(pmId);
    }
}
