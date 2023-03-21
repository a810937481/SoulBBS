package com.service;

import com.dao.FriendMapper;
import com.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendServiceImpl implements FriendService{

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public int addFriend(int friendsUserId, int friendsFollowedId) {
        return friendMapper.addFriend(friendsUserId,friendsFollowedId);
    }

    @Override
    public int deleteFriend(int friendsUserId, int friendsFollowedId) {
        return friendMapper.deleteFriend(friendsUserId,friendsFollowedId);
    }

    @Override
    public int insureFollow(int friendsUserId, int friendsFollowedId) {
        return friendMapper.insureFollow(friendsUserId,friendsFollowedId);
    }

    @Override
    public List<Friend> findFollow(int friendsUserId) {
        return friendMapper.findFollow(friendsUserId);
    }

    @Override
    public List<Friend> findFan(int friendsFollowedId) {
        return friendMapper.findFan(friendsFollowedId);
    }
}
