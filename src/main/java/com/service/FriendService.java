package com.service;

import com.entity.Friend;

import java.util.List;

public interface FriendService {

    int addFriend(int friendsUserId, int friendsFollowedId);

    int deleteFriend(int friendsUserId, int friendsFollowedId);

    int insureFollow(int friendsUserId, int friendsFollowedId);

    List<Friend> findFollow(int friendsUserId);

    List<Friend> findFan(int friendsFollowedId);

}
